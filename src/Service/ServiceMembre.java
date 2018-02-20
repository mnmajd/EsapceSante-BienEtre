/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entite.Forum;
import Entite.Membre;
import Entite.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utile.ConnectionBD;
import Entite.User;
import java.sql.Date;
/**
 *
 * @author said hmidi
 */

import utile.ConnectionBD;
public class ServiceMembre  {
    
    
    
 
                public  void insererMembre( Membre m) 
    {
        try {
              String req = " insert into user ( role , nom , prenom ,login,password,img,tel,adresse,date_naiss,sexe,age,cin) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);
        
       
           ste.setString(1,"membre");     
           ste.setString(2,m.getNom());
           ste.setString(3,m.getPrenom());
           ste.setString(4,m.getLogin());
           ste.setString(5,m.getPassword());
           ste.setString(6,m.getImage());
           ste.setInt(7,m.getTelephone());      
           ste.setString(8,m.getAdresse());
           ste.setString(9,m.getDate_naiss());
           ste.setString(10,m.getSexe());
           ste.setInt(11,m.getAge());
           ste.setInt(12,m.getCin());  
         ste.executeUpdate();
        } catch (SQLException ex) {
              Logger.getLogger(Forum.class.getName()).log(Level.SEVERE,null , ex);
        }
}       
   public  void DeleteMembre( String t)
    {
    
    
      try {
              String req="DELETE FROM `user` WHERE  sexe=? ";
         PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);
       
       
          ste.setString(1,t);
                     ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    }
   
  public  List<Membre> selectMembre() {
        List<Membre> list = new ArrayList<>();
        try {
            String req = "select * from user ";

           PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);

            ResultSet resultat = ste.executeQuery();
            while (resultat.next()) {
               list.add(new Membre(
                        resultat.getString("sexe"),
                        resultat.getInt("age"),
                        resultat.getInt("cin"),
                        resultat.getString("nom"),
                        resultat.getString("prenom"),
                        resultat.getString("login"),
                        resultat.getString("password"),
                        resultat.getString("img"),
                        resultat.getInt("tel"),
                        resultat.getString("adresse"),
                        resultat.getString("date_naiss")
                         
                ));
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
   
   
   
   
   
   
     public void UpdateMembre(Membre m, int id)
    {
    
      
     try {
              String req="UPDATE `user` SET nom=?,prenom=?,login=?,password=?,img=?,tel=?,titre=?,adresse=? WHERE id_user=?";
        PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);
         ste.setString(1,m.getRole());
         ste.setString(2,m.getNom());
         ste.setString(3,m.getPrenom());
         ste.setString(4,m.getLogin());
         ste.setString(5,m.getPassword());
         ste.setString(6,m.getImage());
     
         ste.setString(9,m.getAdresse());
         //ste.setString(10,s.getSpecialte());
        ste.setInt(10,id);

      
            ste.executeUpdate();
        } catch (SQLException ex) {
              Logger.getLogger(Forum.class.getName()).log(Level.SEVERE,null , ex);
        }
    
    }
      
             public  void signupMembre(Membre membre) {
        

                     String req= " insert into user ( role , nom , prenom ,login,password,img,tel,adresse,date_naiss,sexe,age,cin) values(?,?,?,?,?,?,?,?,?,?,?,?)";
      try (PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req)) {
         ste.setString(1,"membre");     
           ste.setString(2,membre.getNom());
           ste.setString(3,membre.getPrenom());
           ste.setString(4,membre.getLogin());
           ste.setString(5,membre.getPassword());
           ste.setString(6,membre.getImage());
           ste.setInt(7,membre.getTelephone());      
           ste.setString(8,membre.getAdresse());
           ste.setString(9,membre.getDate_naiss());
           ste.setString(10,membre.getSexe());
           ste.setInt(11,membre.getAge());
           ste.setInt(12,membre.getCin());  
         
        
            
            

            ste.executeUpdate();

            ResultSet resultSet = ste.getGeneratedKeys();
            if (resultSet.next()) {
                membre.setId(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
          
    

    
}
