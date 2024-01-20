package software.ulpgc.imageviewer.swing;

import javax.swing.*;
import java.awt.*;

public class Mainframe extends JFrame {

    private ImageDisplay imageDisplay;

    public Mainframe(){
        setTitle("ImageViewer");
//        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        this.setUndecorated(true);
        setLayout(new BorderLayout());
        add(imageDisplay());
    }

    private Component imageDisplay() {
        SwingImageDisplay display = new SwingImageDisplay();
        this.imageDisplay = display;
        return display;
    }

    public ImageDisplay getImageDisplay(){
        return imageDisplay;
    }
}
