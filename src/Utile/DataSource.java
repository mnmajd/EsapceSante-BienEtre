
package Utile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataSource {

    private String url="jdbc:mysql://localhost:3306/espace_sante";
    private String user="root";
    private String password="";
    private Connection connection;
    
    static DataSource instance;
    private DataSource(){
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static DataSource getInstance(){
        if(instance==null) 
            return instance= new DataSource();
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }

}
