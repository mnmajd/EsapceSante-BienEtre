/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Question;
import Entite.Reponse;
import static Service.QuestionService.instance;
import Utils.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author majd
 */
public class ReponseService {
    
    static ReponseService instance ;
    
    
   
     public static void AddReponse( Reponse p )
     {
         
     String req = "INSERT INTO reponse (contenu_rep,nbr_aime_rep,id_question,id_user) VALUES(?,?,?,?)";
     
     try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             
             ste.setString(1,p.getContenu_rep());
             ste.setInt(2,p.getNbr_aime_rep());
             ste.setInt(3,p.getId_question());
             ste.setInt(4,p.getId_user());
             
             ste.executeUpdate();
             System.out.println("ajout effectue");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
     
     }
     
     
      public static void ReadReponse()
      {
          String req = "Select * from reponse";
         
        
         try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ResultSet result = ste.executeQuery();
              
            int count = 1;
 
             while (result.next()){
              int id_rep = result.getInt(1);
               String contenu_rep = result.getString(2);
               int nbr_aime_rep = result.getInt(3);
                int id_question = result.getInt(4);
                 int id_user = result.getInt(5);
                 
                 String output = "Reponse #%d:  id_rep : %s  contenu_rep: %s nbr_aime_rep : %s ,id_question : %s id_user:  %s";
                   System.out.println(String.format(output, count++, id_rep, contenu_rep,nbr_aime_rep,id_question, id_user));
                                }
             
        } catch (SQLException ex) {
             System.out.println(ex);
        }
          
      }
      
      
      
      
      
     
     public static void DeleteReponse(int id )
     
     {
           String req =" DELETE FROM reponse where id_rep=?";
        try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setInt(1, id);
             ste.executeUpdate();
             System.out.println("supprission effectue");
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
         
     }
     public static void UpdateReponse(String s , int id)
         {
             String req = "UPDATE reponse SET contenu_rep =? WHERE id_rep =?";
         try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setString(1, s);
             ste.setInt(2, id);
             ste.executeUpdate();
        } catch (SQLException ex) {
             System.out.println(ex);
        }
         }
        
    
     
     public static void LikeReponse( int id )
     {
        
             String req = "UPDATE reponse SET nbr_aime_rep =nbr_aime_rep+1 WHERE id_rep =?";
         try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setInt(1, id);
             ste.executeUpdate();
             System.out.println(" you liked a reponse"+id);
        } catch (SQLException ex) {
             System.out.println(ex);
        }
         }
      public static void DislikeReponse( int id )
     {
        
             String req = "UPDATE reponse SET nbr_aime_rep =nbr_aime_rep-1 WHERE id_rep =?";
         try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setInt(1, id);
             ste.executeUpdate();
             System.out.println(" you disliked a reponse a reponse"+id);
        } catch (SQLException ex) {
             System.out.println(ex);
        }
         }
         
         
     
 public static List<Reponse> FiltredReponse( int id)
      {
          List<Reponse> p = new ArrayList<>();
          String req = "SELECT r.id_rep,r.contenu_rep , r.Date_publication ,r.nbr_aime_rep , u.nom , u.prenom from reponse r join user u ON r.id_user = u.id_user join question q on r.id_question = q.id_question where q.id_question=? order by r.Date_publication desc"
                  + "  ";
         
        
         try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setInt(1, id);
             ResultSet result = ste.executeQuery();
             
             while (result.next()){
                 p.add(
                         new Reponse(result.getInt("r.id_rep"),result.getString("r.contenu_rep"),result.getTimestamp("r.Date_publication").toString()
                                 ,result.getInt("r.nbr_aime_rep"),result.getString("u.nom"),result.getString("u.prenom"))
                 );
              
                               }
             
        } catch (SQLException ex) {
             System.out.println(ex);
        }
         return p ;
          
      }
     
       public static String GetContenuReponse( int id )
    {
        String res ="" ;
        String req =" select contenu_rep from reponse where id_rep = ?";
        try {
             PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
              ste.setInt(1, id);
            ResultSet result = ste.executeQuery();
            while (result.next())
            {
                res = result.getString("contenu_rep");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }       
             
      public  static Boolean CurrentUserLikedReponse(int id_rep , int id_user)      
      {
          Boolean exist =true;
          String req = "SELECT COUNT(*) FROM `Liked_question` WHERE id_liked_reponse = ? and id_user = ?";
          try {
              PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
              ste.setInt(1, id_rep);
              ste.setInt(2, id_user);
             ResultSet result = ste.executeQuery();
              while (result.next())
              {
                if (  result.getInt("COUNT(*)")  == 1) 
                    exist = true;
              
                else 
                     exist = false ;
              }
          } catch (Exception e) {
              System.out.println(e);
          }
       
          return exist;
      }
      public static void AddLikedQuestion( int id_rep , int id_user)
      {
          String req ="INSERT INTO Liked_question(id_liked_reponse, id_user) VALUES (?,?)" ;
          try {
              PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setInt(1,id_rep);
             ste.setInt(2,id_user);
             ste.executeUpdate();
              
          } catch (Exception e) {
              System.out.println(e);
          }
          
      }
      public static void DeleteLikedQuestion(int id_rep,int id_user)
      {
             String req ="DELETE FROM Liked_question WHERE id_liked_reponse = ? AND id_user = ? " ;
          try {
              PreparedStatement  ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
             ste.setInt(1,id_rep);
             ste.setInt(2,id_user);
             ste.executeUpdate();
              
          } catch (Exception e) {
              System.out.println(e);
          }
      }
             
             
             
             
             
          public static ReponseService getInstance()
    {
         if(instance == null )
        {
            return instance = new ReponseService();
        }
        return instance ;
    }
    
}
