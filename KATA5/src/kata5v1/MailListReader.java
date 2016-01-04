package kata5v1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MailListReader {

    public static ArrayList<String> read () throws FileNotFoundException, IOException, SQLException, ClassNotFoundException{
        
        ArrayList<String> mailList = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection cn = DriverManager.getConnection("jdbc:sqlite:KATABDB");
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT mail FROM MAILS");

        while(rs.next()){
            String mail = rs.getString("mail");
            if( ! mail.contains("@") ){
                continue;
            }
            mailList.add(mail);
        }
        
        return mailList;
        
    }

}
