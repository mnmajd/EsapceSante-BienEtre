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
 
/**
 *
 * @author majd
 */
public class QuestionService {
    
    static QuestionService instance ;
    
    
    
    
    public static void AddQuestion( Question q)
    {
        
        String req = "INSERT INTO question (id_question,contenu_quest,nbr_rep,id_catF,id_user) VALUES(?,?,?,?,?)";
      
        try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setInt(1, q.getId_question());
             ste.setString(2, q.getContenu_question());
             ste.setInt(3, q.getNbr_rep());
             ste.setInt(4,q.getId_catF());
             ste.setInt(5,q.getId_user());
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
    public static void ReadQuestion()
    {
        String req = "Select * from question";
        // List<Question> p = new ArrayList<>();
         try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ResultSet result = ste.executeQuery();
              
            int count = 1;
 
             while (result.next()){
              int id_question = result.getInt(1);
               String contenu_quest = result.getString(2);
               String Date = result.getTimestamp(3).toString();
                int nbr_rep = result.getInt(4);
                 int id_catF = result.getInt(5);
                 int id_user = result.getInt(6);
                 String output = "Question #%d:  id_user : %s  contenu_question: %s date_publication : %s nbr_rep : %s   ,id_catF : %s id_user:  %s";
                   System.out.println(String.format(output, count++, id_question, contenu_quest,Date,nbr_rep, id_catF, id_user));
}
             
            /* while(result.next())
             {
                 p.add(
                 new Question(result.getInt("id_question"),result.getString("contenu_quest"))
                 );
                 

             }*/
             
        } catch (SQLException ex) {
             System.out.println(ex);
        }
         /* for ( Question e : p) {
                System.out.println(e);
          }*/
    }
         public static void UpdateQuestion(Question q , int id)
         {
             String req = "UPDATE question SET contenu_quest =? WHERE id_question =?";
         try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setString(1, q.getContenu_question());
             ste.setInt(2, id);
             ste.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex);
        }
         }
         
         
         
          public static void FilterByCat(int  id)
            
               {
                   
                   String req = "Select * from question where id_catF =?";
        // List<Question> p = new ArrayList<>();
         try {
            
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setInt(1, id);
             ResultSet result = ste.executeQuery();
             
             
            int count = 1;
 
             while (result.next()){
              int id_question = result.getInt(1);
               String contenu_quest = result.getString(2);
               String Date = result.getTimestamp(3).toString();
                int nbr_rep = result.getInt(4);
                 int id_catF = result.getInt(5);
                 int id_user = result.getInt(6);
                 String output = "Question #%d:  id_user : %s  contenu_question: %s date_publication : %s nbr_rep : %s   ,id_catF : %s id_user:  %s";
                   System.out.println(String.format(output, count++, id_question, contenu_quest,Date,nbr_rep, id_catF, id_user));
}
             
            /* while(result.next())
             {
                 p.add(
                 new Question(result.getInt("id_question"),result.getString("contenu_quest"))
                 );
                 

             }*/
             
        } catch (SQLException ex) {
             System.out.println(ex);
        }
                
                
        
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
