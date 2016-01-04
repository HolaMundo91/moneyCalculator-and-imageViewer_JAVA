package kata5v1;

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

public class KATA5V1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {

        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:KATABDB");
        System.out.println("Opened database successfully");

        Statement stmt = c.createStatement();
        String filename = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\KATA5V1\\DATA\\mail.txt";
        BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
        
        String mail;
        
        while(( mail=reader.readLine()) != null ){
            String query = "INSERT INTO MAILS (MAIL) VALUES ('" + mail + "')";
            stmt.executeUpdate(query);
        }
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM PEOPLE");
        
        while(rs.next()){
            System.out.println("ID = " + rs.getInt("ID"));
            System.out.println("NAME = " + rs.getString("NAME"));
        }
                
        rs.close();
        stmt.close();
        c.close();
    }
}
