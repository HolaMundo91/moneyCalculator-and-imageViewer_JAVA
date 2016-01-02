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

    public HistogramDisplay() { //ventana
        super("Histograma"); //nombre ventana
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
        dataset.addValue(17, "ENERO", "gmail.com");
        dataset.addValue(20, "FEBRERO", "gmail.com");
        dataset.addValue(10, "ENERO", "ulpgc.es");
        dataset.addValue(7, "FEBRERO", "ulpgc.es");
        dataset.addValue(6, "ENERO", "hotmail.com");
        dataset.addValue(4, "FEBRERO", "hotmail.com");
        
        return dataset;
    }
    
    public void execute(){
        setVisible(true);
    }
    
}
