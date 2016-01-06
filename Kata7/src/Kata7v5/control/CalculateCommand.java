package kata7v5.control;

import kata7v5.model.Histogram;
import kata7v5.view.AttributeDialog;
import kata7v5.view.HistogramBuilder;
import kata7v5.view.HistogramDisplay;
import kata7v5.view.PopulationDialog;

public class CalculateCommand implements Command{

    private final AttributeDialog attributeDialog;
    private final PopulationDialog populationDialog;
    private final HistogramDisplay display;

    @Override
    public void execute() {
        Histogram histogram = new HistogramBuilder(populationDialog.population()).build(attributeDialog.attribute());
        display.show(histogram);
    }

    public CalculateCommand(AttributeDialog attributeDialog, PopulationDialog populationDialog, HistogramDisplay display) {
        this.attributeDialog = attributeDialog;
        this.populationDialog = populationDialog;
        this.display = display;
    }
}
