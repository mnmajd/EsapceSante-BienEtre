/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Reponse;
import Utils.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author majd
 */
public class ReponseService {
    
    
    
    
    
     public static void AddReponse( Reponse p )
     {
     String req = "INSERT INTO reponse (id_rep,contenu_rep,nbr_aime_rep,id_question,id_user) VALUES(?,?,?,?,?)";
     
     try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setInt(1, p.getId_rep());
             ste.setString(2,p.getContenu_rep());
             ste.setInt(3,p.getNbr_aime_rep());
             ste.setInt(4,p.getId_question());
             ste.setInt(5,p.getId_user());
             
             ste.executeUpdate();
             System.out.println("ajout effectue");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
     
     
     }
    
}
