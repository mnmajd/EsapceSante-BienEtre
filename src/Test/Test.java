/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entite.Article;
import Entite.Blog;
import Entite.CategorieArticle;
import Service.Article_Service;
import Service.Blog_Service;
import Service.Categ_Service;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author TAQWA
 */
public class Test {
    
     public static void main(String[] args) throws SQLException  {
          System.out.println("coucou !!! ");
        
        
       
//       DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
//         Date dateobj = new Date();
//      // System.out.println(dateobj);
       
       /* insert to Article / Select / Update / */
       Article_Service a= new Article_Service();
       Blog_Service b = new Blog_Service();
//      // Blog b2 = new Blog();
//       Blog b2 = null  ;
//      // Article a2 ; 
//    //  b.augmenterLike(b2);
//     Article a2 = new Article("ti2","suj2","contenua","ima",2,3);
//      
//        Article a3 = new Article("t","s","c","ima",2,3);
//      a.insererArticle(a2);
//      a.insererArticle(a3);
//       //a.getDateNow(3);
//       a.afficherArticle();
//      //a.updateArticle(a2,3);
//  a.deleteArticle(3);
//        a.getArticleUser(2);
       
   // b.augmenterLike(b2);
 
      // a.getBlogByC(3);
      
    // a.afficherArticle();
               
       List<Article> list = a.afficherArticle();
      for (Article element : list)
      {
          System.out.println(element.getId_cat());
      }
               
      //  insert to Categorie article/ delete / update 
       
//       Categ_Service c = new  Categ_Service() ;
//       c.GetNameGateg(9);
//       c.GetIDGateg("Sport");
//       
       
//      List<Article> list = a.getBlogByCategorie("zerzr");
//      for (Article element : list)
//      {
//          System.out.println(element);
//      }
     //  c.GetIDGateg("Sport")
     /*  CategorieArticle c1 ;
       //c1 =new CategorieArticle("categ loula2");
      // c.ajoutreCateg(c1);
      //c.deleteCateg(4);
      //c1 =new CategorieArticle("categ 5");
      //c.updateCategorie(c1,6);
      c.afficherCateg();
       
       */
   

      
             
             
             
          
             
             
       


    }

    

}
