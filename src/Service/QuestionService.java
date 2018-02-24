/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Utils.ConnexionBD;
import Entite.Question;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entite.Question;

 
/**
 *
 * @author majd
 */
public class QuestionService {
    
    static QuestionService instance ;
    
    
    
    
    public static void AddQuestion(Question q)
    {
        
        String req = "INSERT INTO question (contenu_quest,Approved_Question ,Sujet_Question ,nbr_rep, id_user ,nom_catF) VALUES(?,?,?,?,?,?)";
      
        try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setString(1, q.getContenu_question());
             ste.setBoolean(2, q.isApproved_question());
             ste.setString(3, q.getSujet_question());
             ste.setInt(4, q.getNbr_rep());
             ste.setInt(5,q.getId_user());
             ste.setString(6,q.getNom_catF());
             ste.executeUpdate();
             System.out.println("ajout effectue");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    
    
    public static void DeleteQuestion(int id)
    {
        String req =" DELETE FROM question where id_question=?";
        try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setInt(1, id);
             ste.executeUpdate();
             System.out.println("supprission effectue");
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
    }
    
    public static String GetContenuQuestion( int id )
    {
        String res ="" ;
        String req =" select contenu_quest from question where id_question = ?";
        try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
              ste.setInt(1, id);
            ResultSet result = ste.executeQuery();
            while (result.next())
            {
                res = result.getString("contenu_quest");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }
    
    
    
    
    
    
    public static List<Question> ReadQuestion()
    {
        String req = "SELECT u.id_user ,q.id_question ,u.nom , u.prenom , q.contenu_quest, q.Sujet_Question , q.Approved_Question from question q join user u on q.id_user = u.id_user where q.Approved_Question=0 ";
         List<Question> p = new ArrayList<>();
         try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ResultSet result = ste.executeQuery();

              while(result.next())
             {
                 p.add(
                 new Question(result.getInt("u.id_user"),result.getInt("q.id_question"),result.getString("u.nom") 
                         ,result.getString("u.prenom"), result.getString("q.contenu_quest")
                         ,result.getString("q.Sujet_Question"), result.getBoolean("q.Approved_Question"))
                 );
             }
        } catch (SQLException ex) {
             System.out.println(ex);
        }
         /* for ( Question e : p) {
                System.out.println(e);
          }*/
         return p ;
    }
         public static void UpdateQuestion(String s , int id)
         {
             String req = "UPDATE question SET contenu_quest =? WHERE id_question =?";
         try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setString(1, s);
             ste.setInt(2, id);
             ste.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex);
        }
         }
         
         
         
          public static List<Question> FilterByCat(String  cat)
            
               {
                   
                   String req = "Select c.id_question ,c.contenu_quest, c.Sujet_Question, c.Date_publication, c.nbr_rep , u.nom , u.prenom from question c join user u on c.id_user = u.id_user where nom_catF=? ORDER BY c.Date_publication DESC";
         List<Question> p = new ArrayList<>();
         try {
            
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setString(1, cat);
             ResultSet result = ste.executeQuery();
             
             
            
 
             while (result.next()){
                  p.add(
                 new Question(result.getInt("id_question"), result.getString("contenu_quest"),result.getString("sujet_question") 
                         ,result.getTimestamp("Date_publication").toString(), result.getInt("nbr_rep")
                         , result.getString("nom"),result.getString("prenom")
                  )
                 );
             
             
             
             }
             
           
             
        } catch (SQLException ex) {
             System.out.println(ex);
        }
                
                return p ;
        
                }
          
          public static List<Question> FilterByTopic(String  sujet)
            
               {
                   
                   String req = "Select c.id_question ,c.contenu_quest, c.Sujet_Question, c.Date_publication, c.nbr_rep , u.nom , u.prenom from question c join user u on c.id_user = u.id_user where Sujet_Question=?  ORDER BY c.Date_publication DESC";
         List<Question> p = new ArrayList<>();
         try {
            
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setString(1, sujet);
             ResultSet result = ste.executeQuery();
             
             
            
 
             while (result.next()){
                  p.add(
                 new Question(result.getInt("id_question"), result.getString("contenu_quest"),result.getString("sujet_question") 
                         ,result.getTimestamp("Date_publication").toString(), result.getInt("nbr_rep")
                         , result.getString("nom"),result.getString("prenom")
                  )
                 );
             
             
             
             }
             
           
             
        } catch (SQLException ex) {
             System.out.println(ex);
        }
                
                return p ;
        
                }
          
          
          
          
          
          
          
         
         public static Question SpecifiedQuestion ( int id )
         {
         
             Question q = null;
            String req = " Select c.contenu_quest, c.Sujet_Question, c.Date_publication, c.nbr_rep , u.nom , u.prenom from question c join user u on c.id_user = u.id_user where c.id_question=?";
             try {
                 PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setInt(1, id);
             ResultSet result = ste.executeQuery();
             while (result.next())
             {
                  q = new Question ( result.getString("contenu_quest"),result.getString("sujet_question") 
                         ,result.getTimestamp("Date_publication").toString(), result.getInt("nbr_rep")
                         , result.getString("nom"),result.getString("prenom"));
             }
             } catch (Exception e) {
                 System.out.println(e);
             }
        
             return q ;
         }
         
         
         public void UpdateLikes()
         {
           
             String req =" UPDATE question q SET nbr_rep = (select COUNT(*) FROM reponse WHERE id_question = q.id_question ) WHERE 1";
             try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req); 
              ste.executeUpdate();

             } catch (Exception ex) {
                 System.out.println(ex);
             }
         }
         
         public void ApproveQuestion( int id )
         {
             String req="UPDATE question SET Approved_Question = 1 WHERE id_question = ?";
             try {
             
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req); 
             ste.setInt(1, id);
             ste.executeUpdate();
             
                 
             } catch (Exception e) {
             }
            
         }
         
         public static int GetPhoneNumber(int id)
         {
             int x =0 ;
             String req="SELECT tel from user where id_user = ?";
             try {
                 PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req); 
             ste.setInt(1, id);
                ResultSet result = ste.executeQuery();
                while (result.next())
                {
                    x= result.getInt("tel");
                }
             } catch (Exception e) {
             }
             return x ;
         }
         
         
         
         public static String GetCredential(int id )
         {
             String nom ="";
             String prenom="";
             
             String req="SELECT nom , prenom from user where id_user = ?";
             try {
                 PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req); 
              ste.setInt(1, id);
              ResultSet result = ste.executeQuery();
               while (result.next())
                {
                    nom= result.getString("nom");
                    prenom = result.getString("prenom");
                }
             } catch (Exception e) {
                 
                 
                 System.out.println(e);
             }
              return nom+" "+prenom ;   
         }
         
         
         
         
         
         
         
         
         public static QuestionService getInstance()
    {
         if(instance == null )
        {
            return instance = new QuestionService();
        }
        return instance ;
    }
         
    
}
