package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.Image;

public interface ImageDisplay {
    void show(Image image);
    Image getImage();
}
