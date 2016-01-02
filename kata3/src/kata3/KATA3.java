package kata3;

import java.io.BufferedReader;
import java.io.FileReader;

public class KATA3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Histogram<String> histo = new Histogram<>();
        String pathName = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\kata3\\Data\\emailFile.txt"; //ruta del fichero
        
        //tratamiento del fichero
        try {
            
            BufferedReader fileIn = new BufferedReader( new FileReader(pathName) );
            
            String mail;
            
            while( (mail = fileIn.readLine()) != null ){
                if( ! mail.contains("@") )
                    continue;
            }
            histo.increment( mail.split("@")[1].toLowerCase() );
            
        } catch (Exception e) {
            System.out.println("El fichero no existe");
        }
        
        HistogramDisplay histoDisplay = new HistogramDisplay(histo);
        histoDisplay.execute();
        
    }
}
