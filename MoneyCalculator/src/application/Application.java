package application;


import controller.ExchangeOperation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.CurrencySet;
import model.DatabaseConnection;
import swing.ApplicationFrame;


public class Application {
    public static void main(String[] args) throws SQLException {
        
        Connection connection = createConnection("DATA\\DB.db");
        DatabaseConnection dbSQlite = new DatabaseConnection(connection);
        
        final CurrencySet currencySet = dbSQlite.loadCurrency();
        final ApplicationFrame frame = new ApplicationFrame(currencySet);
        
        frame.register("Calculate", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new ExchangeOperation(frame.getDialog()).execute(dbSQlite);
            }
            
        });
        
    }

    private static Connection createConnection(String dbPath) throws SQLException {
        DriverManager.registerDriver(new org.sqlite.JDBC());
        return DriverManager.getConnection("jdbc:sqlite:" + dbPath);
    }
    
}
