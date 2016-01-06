package kata7;

import Kata7v5.application.HistogramPanel;
import Kata7v5.application.Toolbar;
import Kata7v5.control.CalculateCommand;
import Kata7v5.control.Command;
import Kata7v5.view.AttributeDialog;
import Kata7v5.view.HistogramDisplay;
import Kata7v5.view.PopulationDialog;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.PopupMenu;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Application extends JFrame  {

    private Map <String, Command> commands = new HashMap<>();
    private AttributeDialog attributeDialog;
    private PopulationDialog populationDialog;
    private HistogramDisplay histogramDisplay;
    
    public static void main(String[] args) {
        new Application().setVisible(true);
    }
    
    public Application (){
        this.deployUI();
        this.createCommand();
    }

    private void deployUI() {
        this.setTitle("Histograma viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMaximumSize(new Dimension(500,500));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(histogramPanel());
        this.getContentPane().add(toolbar(commands),BorderLayout.NORTH);
    }

    private void createCommand() {
        commands.put("calculate", new CalculateCommand(attributeDialog, populationDialog, histogramDisplay));
    }

    private HistogramPanel histogramPanel() {
        HistogramPanel panel = new HistogramPanel();
        this.histogramDisplay = panel;
        return panel;
    }

    private JPanel toolbar(Map<String, Command> commands) {
        Toolbar panel = new Toolbar(commands);
        this.attributeDialog= panel;
        this.populationDialog = panel;
        return panel;
    }
    
}











