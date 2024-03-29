package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SwingImageDisplay extends JPanel implements ImageDisplay{
    private Image image;
    private BufferedImage bitmap;

    @Override
    public void show(Image image) {
        this.image = image;
        this.bitmap = read(image.path());
        this.repaint();
    }

    private BufferedImage read(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        BufferedImage resizedImage = null;

        int[] resizedSize = getResizedSize();
        try {
            resizedImage = resizeImage(bitmap, resizedSize[0], resizedSize[1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int x = (this.getWidth() - resizedImage.getWidth()) / 2;
        int y = (this.getHeight() - resizedImage.getHeight()) / 2;

        g.drawImage(resizedImage,x,y,null);
        g.dispose();
    }

    private int[] getResizedSize() {
        int[] size = new int[]{0,0};

        double scale = getScale();

        size[0] = (int) (bitmap.getWidth()*scale);
        size[1] = (int) (bitmap.getHeight()*scale);
        return size;
    }

    private double getScale() {
        return Math.min(
                ((double) this.getWidth()/(double) bitmap.getWidth()),
                (((double) this.getHeight()/(double) bitmap.getHeight())
                ));
    }

    public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);

        Graphics graphics = resizedImage.createGraphics();
        graphics.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
//        graphics.dispose();

        return resizedImage;
    }
}
