package software.ulpgc.imageviewer;

import software.ulpgc.imageviewer.swing.ImageDisplay;

public class NextImageCommand implements Command{

    private final ImageDisplay imageDisplay;

    public NextImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        System.out.println(imageDisplay.getImage().next().path());
        imageDisplay.show(imageDisplay.getImage().next());
    }
}
