/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata3;

import javax.swing.JPanel;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author usuario
 */
public class HistogramDisplay extends ApplicationFrame{

    private Histogram<String> histogram;
    
    public HistogramDisplay( Histogram<String> histogram ) { //ventana
        super("Histograma"); //nombre ventana
        this.histogram = histogram;
        setContentPane( createPanel() ); //crear ventana
        pack(); //visualizar ventana
    }
    
    
    private JPanel createPanel(){ //panel
        ChartPanel chartPanel = new ChartPanel( createChart( createDataset() ) ); 
        chartPanel.setPreferredSize( new Dimension(500,400) ); //tamaño del panel
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart(
                "Trafico de correos", //titulo grafico
                "Dominios", //eje X titulo
                "Nº emails", //eje Y titulo
                dataset, 
                PlotOrientation.VERTICAL, //orientacion del grafico
                false, 
                true, //cuando pasamos el raton por encima de la barra del grafico salen los datos
                false);
        
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for( String key: histogram.keySet() ){
            dataset.addValue( histogram.get(key), "", key );
        }
        
        return dataset;
    }
    
    public void execute(){
        setVisible(true);
    }
    
}
