/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Article;

import connexionUtil.ConnexionDB;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author TAQWA
 */
public class Article_Service {
    static  int id ;
 
    private final Connection ds ;
    private PreparedStatement ste ;
   // private static ResultSet b ;
    
    public Article_Service() {
        ds = ConnexionDB.getInstance().getConnection();
        
        
    }

    public int insererArticle(Article b) throws SQLException {
       String[] returnId = { "BATCHID" };
        try {
        String req="INSERT INTO article "
                + "(id_article,titre_article,sujet_article,contenu_article,img_artc,id_user,id_cat) VALUES (?,?,?,?,?,?,?)";
    
        
       
            
       
          ste = ds.prepareStatement(req,returnId);
       
           ste.setInt(1,b.getId_article());
            ste.setString(2,b.getTitre_article());
            ste.setString(3, b.getSujet_article());
            ste.setString(4, b.getContenu_article());

            ste.setString(5, b.getImg_artc());
            
            ste.setInt(6, b.getId_user());
            ste.setInt(7, b.getId_cat());
            
           int affectedRows = ste.executeUpdate();
//            ste.executeUpdate();
//           int id = ste.getGeneratedKeys().getInt(1);
//            System.out.println(id);
            if (affectedRows == 0) {
               throw new SQLException("Creating user failed, no rows affected.");
        }

        try (ResultSet generatedKeys = ste.getGeneratedKeys()) {
            if (generatedKeys.next()) {
            id = generatedKeys.getInt(1);
                System.out.println(generatedKeys.getInt(1));
               
            }
            else {
               throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
       
     
             
    }catch (SQLException ex) {
           System.out.println(ex);
     
    }return id ;}

       

    /**
     *
     * @param a
     * @return
     */

 

    public  ObservableList<Article> afficherArticle() {
      
        ObservableList<Article> data = FXCollections.observableArrayList();
        
    
        
       ResultSet rs ;
        
        String req = "SELECT * FROM article";
       PreparedStatement ps;
       
       try {
                  Statement statement = ds.createStatement();
                  rs = statement.executeQuery(req);

          
//          Statement statement = ds.createStatement();
//            rs = statement.executeQuery(req);
     
       
         while (rs.next()) {
             
         Article a = new Article(
                 rs.getInt("id_article"),
                 rs.getString("titre_article"),
                 rs.getString("sujet_article"),
                                 rs.getString("contenu_article"),
                                 rs.getDate("date_pub"),
                              rs.getString("img_artc"),
                               rs.getInt("id_user"),
                               rs.getInt("id_cat"));
                  data.add(a);
        
      
           
         } return data ;
       } catch (SQLException ex) {
           Logger.getLogger(Article_Service.class.getName()).log(Level.SEVERE, null, ex);
         
       }
        return null;
     
    }
     public ObservableList<Article> getArticleUser(int id_user) {
        
     
     //  data.addAll(new Article
       
        ObservableList<Article> data = FXCollections.observableArrayList();
        
       ResultSet rs ;
        
        String req = "SELECT * FROM article where id_user="+id_user;
       PreparedStatement ps;
       
       try {
          
                  Statement statement = ds.createStatement();
            rs = statement.executeQuery(req);


       
         while (rs.next()) {
             
         Article a = new Article(
                 rs.getInt("id_article"),
                 rs.getString("titre_article"),
                 rs.getString("sujet_article"),
                 rs.getString("contenu_article"),
                 rs.getDate("date_pub"),
                 rs.getString("img_artc"));
                                 
       data.add(a);
         
       
         
           
         } 
          return data ;
       } catch (SQLException ex) {
           Logger.getLogger(Article_Service.class.getName()).log(Level.SEVERE, null, ex);
         
       }
        return null;
     
    }

    
    
    public void deleteArticle(int id_article) {
        String req = "DELETE FROM `article` WHERE id_article="+id_article ;
        try {
           ste = ds.prepareStatement(req);

            ste.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(Article_Service.class.getName()).log(Level.SEVERE, null, ex);
        } }
    
    
    
    public void updateArticle(Article a,int id_article) {

        String req = "UPDATE `article` SET `titre_article`=?,`sujet_article`=?,"
                + "`contenu_article`=?,`img_artc`=?,"
                + "`id_user`=?,`id_cat`=? WHERE id_article="+id_article;

        try {
            ste = ds.prepareStatement(req);
            
            ste.setString(1, a.getTitre_article());
            ste.setString(2, a.getSujet_article());
            ste.setString(3, a.getContenu_article());
            ste.setString(4, a.getImg_artc());
          
            ste.setInt(5,a.getId_user());
            ste.setInt(6,a.getId_cat());
            
          
            
            ste.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Article_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    
    
    
   
    
   
    
    public Date getDateNow(int id_article) {
        
    
        
        ResultSet rs ;
        
        String req = "SELECT date_pub FROM article where id_article="+id_article;
      
       
       try {
          Statement statement = ds.createStatement();
            rs = statement.executeQuery(req);
     
       
         while (rs.next()) {
             
         //Article A = new Article();
         
//	int userid = rs.getInt("id_article");
//	String titre_article = rs.getString("titre_article");
//        String sujet_article = rs.getString("sujet_article");
//        String contenu_article = rs.getString("contenu_article");
        Date date_pub = rs.getDate("date_pub");
//        String img_artc = rs.getString("img_artc");
//        int id_cat = rs.getInt("id_cat");
//      
        
        System.out.println(" this :::: "+date_pub);
        return date_pub ;
         }  
       
       } catch (SQLException ex) {
           Logger.getLogger(Article_Service.class.getName()).log(Level.SEVERE, null, ex);
         
       }
        return null;
    
    
}
    public Article getBlogByC(int id_article) {
        
    
        
       ResultSet rs ;
        
        String req = "SELECT * FROM article where id_article="+id_article ;
       PreparedStatement ps;
       
       try {
                  Statement statement = ds.createStatement();
                  rs = statement.executeQuery(req);

          
//          Statement statement = ds.createStatement();
//            rs = statement.executeQuery(req);
     
       
         while (rs.next()) {
             
         Article a = new Article(
                 rs.getInt("id_article"),
                 rs.getString("titre_article"),
                 rs.getString("sujet_article"),
                                 rs.getString("contenu_article"),
                                 rs.getDate("date_pub"),
                              rs.getString("img_artc"));
                                 
       
         System.out.println("***");
           System.out.println(rs.getString("date_pub"));
           return a ;
           
         } 
       } catch (SQLException ex) {
           Logger.getLogger(Article_Service.class.getName()).log(Level.SEVERE, null, ex);
         
       }
        return null;
     
    }
       
 public List<Article> getBlogByTitre(String tittre) {
        
    
        List<Article> data = new ArrayList<>();
     
        
      
       
       try {
             
       ResultSet rs ;
        
        String req = "SELECT * FROM article where titre_article LIKE ? " ;
       PreparedStatement ps;
     
                  PreparedStatement ste= ds.prepareStatement(req);
                  ste.setString(1, "%"+tittre.toLowerCase()+"%");
                  
            rs = ste.executeQuery();
            


       
         while (rs.next()) {
             
         data.add(new Article(
                 rs.getInt("id_article"),
                 rs.getString("titre_article"),
                 rs.getString("sujet_article"),
                 rs.getString("contenu_article"),
                 rs.getDate("date_pub"),
                 rs.getString("img_artc")));
         }
       } catch (SQLException ex) {
           Logger.getLogger(Article_Service.class.getName()).log(Level.SEVERE, null, ex);
         
       }
        return data ;
     
    }
 
 
 public List<Article> getBlogByCategorie(int categ) {
        
    
        List<Article> data = new ArrayList<>();
     
        
      
       
       try {
             
       ResultSet rs ;
        
        String req = "SELECT * FROM article where id_cat LIKE ? " ;
       PreparedStatement ps;
     
                  PreparedStatement ste= ds.prepareStatement(req);
                  
                  
            rs = ste.executeQuery();
            


       
         while (rs.next()) {
             
         data.add(new Article(
                 rs.getInt("id_article"),
                 rs.getString("titre_article"),
                 rs.getString("sujet_article"),
                 rs.getString("contenu_article"),
                 rs.getDate("date_pub"),
                 rs.getString("img_artc"),
                  rs.getInt("id_user"),
                rs.getInt("id_cat"))
         
         );
         }
       } catch (SQLException ex) {
           Logger.getLogger(Article_Service.class.getName()).log(Level.SEVERE, null, ex);
         
       }
        return data ;
     
    }

}

   
