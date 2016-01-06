package Kata7v5.control;

import Kata7v5.model.Histogram;
import Kata7v5.view.AttributeDialog;
import Kata7v5.view.HistogramBuilder;
import Kata7v5.view.HistogramDisplay;
import Kata7v5.view.PopulationDialog;

public class CalculateCommand implements Command {
    
    private final AttributeDialog attributeDialog;
    private final PopulationDialog populationDialog;
    private final HistogramDisplay display;

    public CalculateCommand(AttributeDialog attributeDialog, PopulationDialog populationDialog, HistogramDisplay display) {
        this.attributeDialog = attributeDialog;
        this.populationDialog = populationDialog;
        this.display = display;
    }
    
    @Override
    public void execute() {
        Histogram histogram = new HistogramBuilder (populationDialog.population()).build(attributeDialog.attribute());
        display.show(histogram);
    }
    
}
