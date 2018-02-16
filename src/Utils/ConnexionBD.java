/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author majd
 */
public class ConnexionBD {
    Connection connection ;
   private   String url ="jdbc:mysql://localhost:3306/Espace_sante" ;
   private   String user ="root";
   private   String password ="";
    static ConnexionBD instance ;
    public ConnexionBD()  {
      
       try {
           connection = DriverManager.getConnection(url,user,password);
       } catch (SQLException ex) {
           Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("problem connection");
       }
    }

    public Connection getConnection() {
        return connection;
    }
    
   public static ConnexionBD getInstance()
    {
         if(instance == null )
        {
            return instance = new ConnexionBD();
        }
        return instance ;
    }
    
}
