/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Article;
import Entite.Blog;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author TAQWA
 */
public class Blog_Service {
    
      private final Connection ds ;
    private PreparedStatement ste ;
   // private static ResultSet b ;
    
    public Blog_Service() {
        ds = ConnexionBD.getInstance().getConnection();
        
        
    }
     public void insererBlog(Blog bg) {

        try {
        String req="INSERT INTO `blog`(`id_cat`, `id_article`,`nbr_like`) VALUES (?,?,?)";
    
        
       
            
       
          ste = ds.prepareStatement(req);
       
          
            ste.setInt(1,bg.getId_cat());
            ste.setInt(2, bg.getId_article());
            ste.setInt(3,bg.getNbr_like());
            
           
            ste.executeUpdate();
           
            
     
             
    }catch (SQLException ex) {
           System.out.println(ex);
     
    }}

      public void augmenterLike( Blog bg) throws SQLException {
ResultSet rs ;
PreparedStatement ps;
       
Statement statement = ds.createStatement();

 String req="UPDATE `blog` SET `nbr_like`= (SELECT (SUM(nbr_like) + 1)) WHERE id_cat = 77 and id_article = 3";

statement.executeUpdate(req);

     
    }
      
      
public void DimuDislike( Blog bg) throws SQLException {
ResultSet rs ;
PreparedStatement ps;
       
Statement statement = ds.createStatement();
String req="UPDATE `blog` SET `nbr_like`= (SELECT (SUM(nbr_like) - 1)) WHERE id_cat = 77 and id_article = 3";
          
statement.executeUpdate(req);

    }

}
