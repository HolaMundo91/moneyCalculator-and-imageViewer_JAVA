package kata6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Kata4 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String name = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata6\\DATA\\emails.txt";
       
        ArrayList <Person> arrayMail = MailListReader.read(name);
        System.out.println(arrayMail.size());
     
        HistogramBuilder<Person> builder = new HistogramBuilder<>(arrayMail); 
        
        Histogram<String> domains = builder.build(new Attribute<Person, String>(){
            @Override
            public String get(Person item) {
                return item.getMail().split("@")[1];
            }        
        });
        
        Histogram<Character> letters = builder.build(new Attribute<Person, Character>() {

            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        });
        
        new HistogramDisplay(domains, "DOMINIOS").execute();
        new HistogramDisplay(letters, "CARACTER").execute();
        System.out.println("FIN");
        
    }
}
