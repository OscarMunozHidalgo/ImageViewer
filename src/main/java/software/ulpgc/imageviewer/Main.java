package software.ulpgc.imageviewer;

import software.ulpgc.imageviewer.swing.Mainframe;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Mainframe mainframe = new Mainframe();
        FolderPathImageLoader loader = new FolderPathImageLoader(new File("C:/Users/Usuario/Pictures/Screenshots"));
        Image image = loader.load();

        mainframe.getImageDisplay().show(image);
        mainframe.add(">", new NextImageCommand(mainframe.getImageDisplay()));
        mainframe.add("<", new PrevImageCommand(mainframe.getImageDisplay()));

        mainframe.setVisible(true);
    }

}
