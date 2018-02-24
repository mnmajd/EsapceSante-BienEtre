
package utile;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DataSource {
    
    
    private static DataSource instance; //sanglotemps
   String url="jdbc:mysql://localhost:3306/espace_sante" ;
   String username="root";
   String password="";
   private Connection connection;

    public Connection getConnection() {
        return connection;
    }
   

//public DataSource()
//{
//       try {
//           connection = DriverManager.getConnection(url, username, password);
//       } catch (SQLException ex) {
//           Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
//       }
//}
   
   
   private  DataSource()
{
       try {
           connection = DriverManager.getConnection(url, username, password);
       } catch (SQLException ex) {
           Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
       }
}
   
   public static DataSource getInstance()
   {
       if (instance==null) 
           instance= new DataSource();
           return instance;
           
       
   }
    
}



