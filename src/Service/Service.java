/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Forum;
import Entite.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utile.ConnectionBD;

/**
 *
 * @author said hmidi
 */
import utile.ConnectionBD;
public class Service {
    
       public static void insererUser(User s) 
    {
        try {
              String req="INSERT INTO user(id_user,role,nom,prenom,login,password,img,tel,titre,adresse,date_naiss,specialte) VALUES (?,?,?,?,?,?,?,?,?,?,?,NULL)";
        PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);
        ste.setInt(1,s.getId_user());
        ste.setString(2,s.getRole());
        ste.setString(3,s.getNom());
         ste.setString(4,s.getPrenom());
         ste.setString(5,s.getLogin());
         ste.setInt(6,s.getPassword());
         ste.setString(7,s.getImage());
         ste.setInt(8,s.getTelephone());
         ste.setString(9,s.getTitre());
         
         ste.setString(10, s.getAdresse());
        ste.setDate(11,s.getDate_naiss());
        // ste.setString(12, s.getSpecialte());
         ste.executeUpdate();
        } catch (SQLException ex) {
              Logger.getLogger(Forum.class.getName()).log(Level.SEVERE,null , ex);
        }

   

}  
    
       
       public static void DeleteUser( User s)
    {
    
    
      try {
              String req="DELETE FROM `user` WHERE id_user = ?";
         PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);
       
       
          ste.setInt(1,s.getId_user());
                     ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    }
       
       
      public static List<User> selectUser() {
        List<User> list = new ArrayList<>();
        try {
            String req = "select * from user ";

           PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);

            ResultSet resultat = ste.executeQuery();
            while (resultat.next()) {

                list.add(new User(resultat.getInt("id_user"),
                        resultat.getString("Role"),
                        resultat.getString("Nom"),
                        resultat.getString("Prenom"),
                        resultat.getString("Login"),
                        resultat.getInt("password"),
                        resultat.getString("img"),
                        resultat.getInt("tel"),
                        resultat.getString("titre"),
                        resultat.getString("adresse"),
                        resultat.getDate("date_naiss")/*,
                        resultat.getString("specialte"))*/));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
       
       
       
       
      
          public static void UpdateUser(User s, int id)
    {
    
      
     try {
              String req="UPDATE `user` SET role=?,nom=?,prenom=?,login=?,password=?,img=?,tel=?,titre=?,adresse=? WHERE id_user=?";
        PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);
         ste.setString(1,s.getRole());
         ste.setString(2,s.getNom());
         ste.setString(3,s.getPrenom());
         ste.setString(4,s.getLogin());
         ste.setInt(5,s.getPassword());
         ste.setString(6,s.getImage());
         ste.setInt(7,s.getTelephone());
         ste.setString(8,s.getTitre());
         ste.setString(9,s.getAdresse());
         //ste.setString(10,s.getSpecialte());
        ste.setInt(10,id);

      
            ste.executeUpdate();
        } catch (SQLException ex) {
              Logger.getLogger(Forum.class.getName()).log(Level.SEVERE,null , ex);
        }
    
    }
      
      
          
    
}
