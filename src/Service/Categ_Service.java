/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Article;
import Entite.CategorieArticle;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TAQWA
 */
public class Categ_Service {
    
     private final Connection ds ;
    private PreparedStatement ste ;
   // private static ResultSet b ;
    
    public Categ_Service() {
        ds = ConnexionBD.getInstance().getConnection();
        
        
    }
//     public void ajoutreCateg(CategorieArticle c) {
//    
//    
//        try {
//        String req="INSERT INTO categorie_article "
//                + "(nom_cat) VALUES (?)";
//   
//            ste = ds.prepareStatement(req);
//      
//            ste.setString(1,c.getNom_cat());
//            ste.executeUpdate();
//            
//     
//             
//    }catch (SQLException ex) {
//           System.out.println(ex);
//     
//    }}
//     
     
     
//     public void deleteCateg(int id_cat) {
//        String req = "DELETE FROM `categorie_article` WHERE id_cat="+id_cat ;
//        try {
//           ste = ds.prepareStatement(req);
//
//            ste.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(Article_Service.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//     
//       public void updateCategorie(CategorieArticle ca,int id_cat) {
//
//        String req = "UPDATE `categorie_article` SET `nom_cat`=? WHERE id_cat="+id_cat;
//
//        try {
//            ste = ds.prepareStatement(req);
//            
//            ste.setString(1, ca.getNom_cat());
//          
//            ste.executeUpdate();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Categ_Service.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//       
       
       public List<String> afficherCateg() {
        
   // CategorieArticle C = new CategorieArticle();
        List<String> listeCateg = new ArrayList<>();
        ResultSet rs ;
        
        String req = "SELECT * FROM categorie_article ";
      
       
       try {
          Statement statement = ds.createStatement();
            rs = statement.executeQuery(req);
     
       
         while (rs.next()) {
             
         
         listeCateg.add(
	 rs.getString("nom_cat"));
      
            
         } 
         
       } catch (SQLException ex) {
           Logger.getLogger(Categ_Service.class.getName()).log(Level.SEVERE, null, ex);
         
       }
       return listeCateg ;
       } 
    
       
       
        public String GetNameGateg(int id_cat) {
        
   // CategorieArticle C = new CategorieArticle();
      // String listeCateg = new String ;
        ResultSet rs ;
        String NomC ;
        String req = "SELECT nom_cat FROM `categorie_article` WHERE id_cat = "+id_cat ;
      
       
       try {
          Statement statement = ds.createStatement();
            rs = statement.executeQuery(req);
     
       
         while (rs.next()) {
             
         
	  NomC = rs.getString("nom_cat");
             System.out.println(NomC);
      return NomC ;
            
         } 
         
       } catch (SQLException ex) {
           Logger.getLogger(Categ_Service.class.getName()).log(Level.SEVERE, null, ex);
         
       } return null ;
         
         
        }
        
    
        
        public String GetIDGateg(String nom_cat) {
        
   // CategorieArticle C = new CategorieArticle();
      // String listeCateg = new String ;
        ResultSet rs ;
        String IdC ;
        String req = "SELECT id_cat FROM `categorie_article` WHERE nom_cat  = '"+nom_cat+"'" ;
      
       
       try {
          Statement statement = ds.createStatement();
            rs = statement.executeQuery(req);
     
       
         while (rs.next()) {
             
         
	  IdC = rs.getString("id_cat");
             System.out.println(IdC);
      return IdC ;
            
         } 
         
       } catch (SQLException ex) {
           Logger.getLogger(Categ_Service.class.getName()).log(Level.SEVERE, null, ex);
         
       } return null ;
         
         
        }
        

}
