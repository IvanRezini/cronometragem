
package rezini.crono.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {

    public Connection getConnection() {
        try {
     
            return DriverManager.getConnection(
                    
                    "jdbc:mysql://127.0.0.1/rezinicrono", "root", "");
          
        } catch (SQLException e) {
       
            throw new RuntimeException(e);
            
           
        }
    }
}