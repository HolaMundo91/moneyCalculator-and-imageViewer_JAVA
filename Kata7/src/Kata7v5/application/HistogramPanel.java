package Kata7v5.application;

import Kata7v5.model.Histogram;
import Kata7v5.view.HistogramDisplay;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramPanel extends JPanel implements HistogramDisplay {

    private Histogram<String> histogram;

    public HistogramPanel() {
        super(new BorderLayout());
    }
    
    @Override
    public Histogram histogram() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void show(Histogram histogram) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart(null, 
                "",
                "Nº emails",
                dataSet,
                PlotOrientation.VERTICAL,
                false, false, false);
        return chart;
    }

    private DefaultCategoryDataset createDataset(Histogram histogram) {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (Object key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "", (Comparable) key);
        }
        return dataSet;

    }

    
}
