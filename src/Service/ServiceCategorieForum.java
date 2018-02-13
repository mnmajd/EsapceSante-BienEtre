/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.CategorieForum;
import Entite.Reponse;
import static Service.ReponseService.instance;
import Utils.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author majd
 */
public class ServiceCategorieForum {
    
    static ServiceCategorieForum instance ;
    
    
         public static void AddCategorie( String c )
     {
         
     String req = "INSERT INTO categorie_forum (nom_catF) VALUES(?)";
     
     try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             
             ste.setString(1,c);
             ste.executeUpdate();
             System.out.println("ajout effectue");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
     
     }
       
  
     public static void DeleteCategorie(String s  )
     
     {
           String req =" DELETE FROM categorie_forum where nom_catF=?";
        try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setString(1,s);
             ste.executeUpdate();
             System.out.println("supprission effectue");
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
         
     }
    
    public static List<String> ReadCategorie ()
    {
         String req = "Select nom_catF from categorie_forum";
         List<String> p = new ArrayList<>();
         try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ResultSet result = ste.executeQuery();
             while(result.next())
             {
                 p.add(
                 result.getString("nom_catF"));
                 
             }
        } catch (SQLException ex) {
             System.out.println(ex);
        }
          return p;    
        
    }
          public static ServiceCategorieForum getInstance()
    {
         if(instance == null )
        {
            return instance = new ServiceCategorieForum();
        }
        return instance ;
    }
          
    
          
          
          
          
    
    
    
    
    
    
}
