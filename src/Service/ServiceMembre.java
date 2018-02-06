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

/**
 *
 * @author said hmidi
 */

import utile.ConnectionBD;
public class ServiceMembre  {
    
    
    
 
                public static void insererMembre( Membre m) 
    {
        try {
              String req="INSERT INTO user(id_user,role,nom,prenom,login,password,img,tel,titre,adresse,date_naiss,specialte,sexe,age,cin) VALUES (?,?,?,?,?,?,?,?,?,?,?,NULL,?,?,?)";
        PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);
        ste.setInt(1,m.getId_user());
        ste.setString(2,m.getRole());
        ste.setString(3,m.getNom());
         ste.setString(4,m.getPrenom());
         ste.setString(5,m.getLogin());
         ste.setInt(6,m.getPassword());
         ste.setString(7,m.getImage());
         ste.setInt(8,m.getTelephone());
         ste.setString(9,m.getTitre());
         ste.setString(10,m.getAdresse());
         ste.setDate(11,m.getDate_naiss());
         ste.setString(12,m.getSexe());
         ste.setInt(13,m.getAge());
         ste.setInt(14,m.getCin());
         ste.executeUpdate();
        } catch (SQLException ex) {
              Logger.getLogger(Forum.class.getName()).log(Level.SEVERE,null , ex);
        }
}       
   public static void DeleteMembre( String t)
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
   
   
     /* public static List<Membre> selectMemebre() {
        List<Membre> list = new ArrayList<>();
        try {
            String req = "select * from user ";

           PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);

            ResultSet resultat = ste.executeQuery();
            while (resultat.next()) {
//"homme", 55, 77777, "membre", "jk", "kk,", "kjjj", 888, "ddd", 777, "rrrr", "eeee", new Date(2018_02_03)
                list.add(new Membre(resultat.getInt("id_user"),
                        resultat.getString("Role"),
                        resultat.getString("Nom"),
                        resultat.getString("Prenom"),
                        resultat.getString("Login"),
                        resultat.getInt("password"),
                        resultat.getString("img"),
                        resultat.getInt("tel"),
                        resultat.getString("titre"),
                        resultat.getString("adresse"),
                        resultat.getString("sexe"),
                        resultat.getInt("age"),
                        resultat.getInt("cin")));
                                            
                       
            }
        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
   
   
   
   */
   
   
     public static void UpdateMembre(Membre m, int id)
    {
    
      
     try {
              String req="UPDATE `user` SET role=?,nom=?,prenom=?,login=?,password=?,img=?,tel=?,titre=?,adresse=? WHERE id_user=?";
        PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);
         ste.setString(1,m.getRole());
         ste.setString(2,m.getNom());
         ste.setString(3,m.getPrenom());
         ste.setString(4,m.getLogin());
         ste.setInt(5,m.getPassword());
         ste.setString(6,m.getImage());
         ste.setInt(7,m.getTelephone());
         ste.setString(8,m.getTitre());
         ste.setString(9,m.getAdresse());
         //ste.setString(10,s.getSpecialte());
        ste.setInt(10,id);

      
            ste.executeUpdate();
        } catch (SQLException ex) {
              Logger.getLogger(Forum.class.getName()).log(Level.SEVERE,null , ex);
        }
    
    }
      
      
          
    

    
}
