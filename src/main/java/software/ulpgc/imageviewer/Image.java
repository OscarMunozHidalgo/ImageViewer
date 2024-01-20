package software.ulpgc.imageviewer;

public interface Image {
    String path();
    Image next();
    Image prev();
}
