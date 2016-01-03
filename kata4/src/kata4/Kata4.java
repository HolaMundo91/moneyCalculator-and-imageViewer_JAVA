package kata4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Kata4 {

    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        String name = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\kata4\\DATA\\emails.txt";
        ArrayList<String> mailArray = MailListReader.read(name);
        System.out.println( mailArray.size() );
        
    }
}
