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
import java.sql.SQLException;

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
       
  
     public static void DeleteCategorie( int id)
     
     {
           String req =" DELETE FROM categorie_forum where id_catF=?";
        try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setInt(1,id);
             ste.executeUpdate();
             System.out.println("supprission effectue");
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
         
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
