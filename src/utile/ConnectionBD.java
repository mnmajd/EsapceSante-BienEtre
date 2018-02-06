/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author said hmidi
 */
public class ConnectionBD {
    Connection connection ;
   private   String url ="jdbc:mysql://localhost:3306/espace_sante" ;
   private   String user ="root";
   private   String password ="";
    static ConnectionBD instance ;
    public ConnectionBD()  {
      
       try {
           connection = DriverManager.getConnection(url,user,password);
       } catch (SQLException ex) {
           Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("problem connection");
       }
    }

    public Connection getConnection() {
        return connection;
    }
    
   public static ConnectionBD getInstance()
    {
         if(instance == null )
        {
            return instance = new ConnectionBD();
        }
        return instance ;
    }
    
}
