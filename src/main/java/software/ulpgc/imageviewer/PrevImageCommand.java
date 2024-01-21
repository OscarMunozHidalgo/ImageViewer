package software.ulpgc.imageviewer;

import software.ulpgc.imageviewer.swing.ImageDisplay;

public class PrevImageCommand implements Command{
    private final ImageDisplay imageDisplay;

    public PrevImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        System.out.println(imageDisplay.getImage().prev().path());
        imageDisplay.show(imageDisplay.getImage().prev());
    }
}
