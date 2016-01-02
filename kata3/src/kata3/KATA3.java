package kata3;

public class KATA3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        Histogram<String> histo = new Histogram<>();
        histo.increment("gmail.com");
        histo.increment("gmail.com");
        histo.increment("gmail.com");
        histo.increment("gmail.com");
        histo.increment("gmail.com");
        histo.increment("gmail.com");
        
        histo.increment("ulpgc.es");
        histo.increment("ulpgc.es");
        histo.increment("ulpgc.es");
        histo.increment("ulpgc.es");
        histo.increment("ulpgc.es");
        histo.increment("ulpgc.es");
        histo.increment("ulpgc.es");
        
        histo.increment("hotmail.com");
        histo.increment("hotmail.com");
        histo.increment("hotmail.com");
        histo.increment("hotmail.com");
        
        HistogramDisplay histoDisplay = new HistogramDisplay(histo);
        histoDisplay.execute();
        
    }
}
