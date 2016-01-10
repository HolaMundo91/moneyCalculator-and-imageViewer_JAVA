
package imageviewer;

import imageviewer.control.Command;
import imageviewer.control.NextImageCommand;
import imageviewer.control.PrevImageCommand;
import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Application extends JFrame {
    
    private final Map<String,Command> commands = new HashMap<>();
    
    public static void main(String[] args) {
        new Application().setVisible(true);
    }
    
    private ImageDisplay imageDisplay;

    public Application() {
        this.deployUI();
        this.createCommands();
    }

    private void deployUI() {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imagePanel());
        this.getContentPane().add(toolbar(),BorderLayout.SOUTH);
    }

    private void createCommands() {
        commands.put("next", new NextImageCommand(imageDisplay));
        commands.put("prev", new PrevImageCommand(imageDisplay));
    }

    private ImagePanel imagePanel() {
        ImagePanel imagePanel = new ImagePanel(image());
        imageDisplay = imagePanel;
        return imagePanel;
    }

    private Image image() {
        return new FileImageReader("C:\\Users\\Admin\\Pictures\\Fondos").read();
    }    

    private Component toolbar() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }

    private JButton nextButton() {
        JButton button = new JButton("Siguiente");
        button.addActionListener(doCommand("next"));
        return button;
    }

    private JButton prevButton() {
        JButton button = new JButton("Anterior");
        button.addActionListener(doCommand("prev"));
        return button;
    }

    private ActionListener doCommand(final String operation) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(operation).execute();
            }
        };
    }
}
