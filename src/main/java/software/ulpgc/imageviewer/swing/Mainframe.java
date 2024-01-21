package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.Command;
import software.ulpgc.imageviewer.NextImageCommand;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Mainframe extends JFrame {

    private ImageDisplay imageDisplay;
    private final Map<String, Command> commands;

    public Mainframe(){
        this.commands = new HashMap<>();
        setTitle("ImageViewer");
//        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        this.setUndecorated(true);
        setLayout(new BorderLayout());
        add(imageDisplay());
        add(createButton("<"), BorderLayout.WEST);
        add(createButton(">"), BorderLayout.EAST);
    }

    private Component createButton(String s) {
        JButton button = new JButton(s);
        button.addActionListener(x->{commands.get(s).execute();});
        return button;
    }

    private Component imageDisplay() {
        SwingImageDisplay display = new SwingImageDisplay();
        this.imageDisplay = display;
        return display;
    }

    public ImageDisplay getImageDisplay(){
        return imageDisplay;
    }

    public void add(String name, Command command) {
        commands.put(name, command);
    }
}
