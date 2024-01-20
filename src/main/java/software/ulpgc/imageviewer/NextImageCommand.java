package software.ulpgc.imageviewer;

import software.ulpgc.imageviewer.swing.ImageDisplay;

public class NextImageCommand implements Command{

    private final ImageDisplay imageDisplay;

    public NextImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.getImage().next());
    }
}
