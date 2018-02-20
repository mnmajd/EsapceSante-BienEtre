/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

//package Service;

import Entite.Forum;
import Entite.Membre;
//import Entite.Prestataire;
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


/*
public class ServicePrestataire {
    
    
     public static void insererPrestataire( Prestataire p) 
    {
        try {
              String req="INSERT INTO user(role,nom,prenom,login,password,img,tel,adresse,date_naiss,specialte,sexe,age,cin,fonctionnalite) VALUES (NULL,?,?,?,?,?,?,?,?,NULL,?,?,?,?,?,?,?)";
        PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);
        
        ste.setString(1,p.getRole());
        ste.setString(2,p.getNom());
         ste.setString(3,p.getPrenom());
         ste.setString(4,p.getLogin());
         ste.setInt(5,p.getPassword());
         ste.setString(6,p.getImage());
         ste.setInt(7,p.getTelephone()); 
         ste.setString(8,p.getAdresse());
         ste.setDate(9,new Date(2017-1900 , 9-1 , 27));
         ste.setString(10,p.getSpecialite());
         ste.setString(11,p.getSexe());
         ste.setInt(12,p.getAge());
         ste.setInt(13,p.getCin());
         ste.setString(14,p.getFonctionnalite());
         ste.executeUpdate();
        } catch (SQLException ex) {
              Logger.getLogger(Forum.class.getName()).log(Level.SEVERE,null , ex);
        }
}       
    
        public static void DeletePrestataire( Prestataire p)
    {
    
    
      try {
              String req="DELETE FROM `user` WHERE id_user = ?";
         PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);
       
       
          ste.setInt(1,p.getId());
                     ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    }
        
        
         public static List<Prestataire> selectPrestataire() {
        List<Prestataire> list = new ArrayList<>();
        try {
            String req = "select * from user ";

           PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);

            ResultSet resultat = ste.executeQuery();
            while (resultat.next()) {

                list.add(new Prestataire(
                       //resultat.getString("role"),
                        resultat.getString("nom"),
                        resultat.getString("prenom"),
                        resultat.getString("login"),
                        resultat.getInt("password"),
                        resultat.getInt("tel"),
                        resultat.getString("img"),
                        resultat.getString("adresse"),
                        resultat.getDate("date_naiss"),
                        resultat.getString("specialte"),
                        resultat.getString("sexe"),
                        resultat.getInt("age"),
                        resultat.getInt("cin"),
                        resultat.getString("fonctionnalite")));
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
       
     
         public static void UpdatePrestataire(Prestataire p, int id)
    {
    
      
     try {
              String req="UPDATE `user` SET role=?,nom=?,prenom=?,login=?,password=?,img=?,tel=?,titre=?,adresse=?,specialte=?,sexe=?,age=?,cin=?,fonctionnalite=? WHERE id_user=?";
        PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);
         ste.setString(1,p.getRole());
         ste.setString(2,p.getNom());
         ste.setString(3,p.getPrenom());
         ste.setString(4,p.getLogin());
         ste.setInt(5,p.getPassword());
         ste.setString(6,p.getImage());
         ste.setString(7,p.getAdresse());
         ste.setString(8,p.getSpecialite());
         ste.setString(9,p.getSexe());
         ste.setInt(10,p.getAge());
         ste.setInt(11,p.getCin());
         ste.setString(12,p.getFonctionnalite());
        ste.setInt(13,id);

      
            ste.executeUpdate();
        } catch (SQLException ex) {
              Logger.getLogger(Forum.class.getName()).log(Level.SEVERE,null , ex);
        }
    
    }

  
      
      
        
           public User findById(Integer id) {
        User user = null;

        String sql = "SELECT * FROM `user` WHERE `id_user` = ? ";

        try (PreparedStatement statement = ConnectionBD.getInstance().getConnection().prepareStatement(sql)){

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                switch (resultSet.getString("role").toLowerCase()) {
                    case "admin":
                        user = new User();
                        user.setId(resultSet.getInt("id_user"));
                        break;
                    case "Membre":
                        user = new Membre();
                        user.setId(resultSet.getInt("id_user"));
                       
                         break;
                    case "Prestataire":
                        //user = new Prestataire();
                        user.setId(resultSet.getInt("id_user"));

                        break;
                }

                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getInt("password"));
                
                user.setNom(resultSet.getString("nom"));
                user.setPrenom(resultSet.getString("prenom"));
                user.setAdresse(resultSet.getString("adresse"));
                user.setTelephone(resultSet.getInt("telephone"));
                
            }
            return user;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return user;
    }
   
         
         
        public User login(String login, String password) {
        User user = null;
        String req = "SELECT * FROM `user` WHERE `login` = ? AND `password` = ?";

        try (PreparedStatement statement = ConnectionBD.getInstance().getConnection().prepareStatement(req)){

            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = findById(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }
        
        
        
        
}*/
