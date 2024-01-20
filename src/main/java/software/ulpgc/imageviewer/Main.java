package software.ulpgc.imageviewer;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Mainframe mainframe = new Mainframe();
        mainframe.setVisible(true);
        FolderPathImageLoader loader = new FolderPathImageLoader(new File("C:/Users/Usuario/Pictures/Camera Roll"));
        System.out.println(loader.filesToString());
    }

}
