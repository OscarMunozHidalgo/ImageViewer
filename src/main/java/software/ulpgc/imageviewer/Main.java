package software.ulpgc.imageviewer;

import software.ulpgc.imageviewer.swing.Mainframe;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Mainframe mainframe = new Mainframe();
        FolderPathImageLoader loader = new FolderPathImageLoader(new File("C:/Users/Usuario/Pictures/Camera Roll"));
        Image image = loader.load();
        mainframe.getImageDisplay().show(image);
//        System.out.println(loader.filesToString());
//        System.out.println(loader.filesToString2());
        mainframe.setVisible(true);
    }

}
