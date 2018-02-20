/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Admin;
import Entite.Forum;
import Entite.Membre;
//import Entite.Prestataire;
//import Entite.Prestataire;
///import Entite.Prestataire;
import Entite.User;
import java.sql.Date;
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
public class ServiceUser {
   
    
    
    
    
       public  void insererUser(User s) 
    {
        try {
              String req="INSERT INTO `user`(`role`, `nom`, `prenom`, `login`, `password`, `img`, `tel`, `adresse`, `date_naiss`, `specialte`, `sexe`, `age`, `cin`, `fonctionnalite`, `status`) "
                      + "VALUES (?,?,?,?,?,?,?,?,?,'medecin','homme',1,2,'jjj','lll')";
        PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);
       
         ste.setString(1,s.getRole());
         ste.setString(2,s.getNom());
         ste.setString(3,s.getPrenom());
         ste.setString(4,s.getLogin());
         ste.setString(5,s.getPassword());
         ste.setString(6,s.getImage());
         ste.setInt(7,s.getTelephone());      
         ste.setString(8,s.getAdresse());
         ste.setString(9,s.getDate_naiss());
        
         ste.executeUpdate();
        } catch (SQLException ex) {
              Logger.getLogger(Forum.class.getName()).log(Level.SEVERE,null , ex);
        }

   

}  
    
       
       public  void DeleteUser( User s)
    {
    
    
      try {
              String req="DELETE FROM `user` WHERE id_user = ?";
         PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);
       
       
                     ste.setInt(1,s.getId());
                     ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    }
       
       
      public  List<User> selectUser() {
        List<User> list = new ArrayList<>();
        try {
            String req = "select * from user ";

           PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);

            ResultSet resultat = ste.executeQuery();
            while (resultat.next()) {

                list.add(new User(
                        resultat.getString("Role"),
                        resultat.getString("Nom"),
                        resultat.getString("Prenom"),
                        resultat.getString("Login"),
                        resultat.getString("password"),
                        resultat.getString("img"),
                        resultat.getInt("tel"),
                        resultat.getString("adresse"),
                        resultat.getString("date_naiss")));
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
       
       
       
       
      
          public  void UpdateUser(User s ,int id)
    {
    
      
     try {
              String req="UPDATE `user` SET role=?,nom=?,prenom=?,login=?,password=?,img=?,tel=?,adresse=? WHERE  id_user=?";
        PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req);
         ste.setString(1,s.getRole());
         ste.setString(2,s.getNom());
         ste.setString(3,s.getPrenom());
         ste.setString(4,s.getLogin());
         ste.setString(5,s.getPassword());
         ste.setString(6,s.getImage());
         ste.setInt(7,s.getTelephone());
         ste.setString(8,s.getAdresse());
        
         ste.setInt(9,id);
         

      
               ste.executeUpdate();
        } catch (SQLException ex) {
              Logger.getLogger(Forum.class.getName()).log(Level.SEVERE,null , ex);
        }
    
    }
          ////login
          
          
          
          
          
           public  User login(String login, String password) {
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

  
              public  void signup(User user) {
        String role = "";
        String roles="";
        if (user instanceof Membre) {
            role = "Membre";
            roles="a:1:{i:0;s:6:\"Membre\";}";
        
        } /*else if (user instanceof Prestataire) {
            role = "Prestataire";
        }*/

                     String req="INSERT INTO `user`(`role`, `nom`, `prenom`, `login`, `password`, `img`, `tel`, `adresse`, `date_naiss`, `specialte`, `sexe`, `age`, `cin`, `fonctionnalite`, `status`) "
                      + "VALUES (?,?,?,?,?,?,?,?,?,NULL,NULL,NULL,NULL,'jjj','lll')";
      try (PreparedStatement ste = ConnectionBD.getInstance().getConnection().prepareStatement(req)) {
           ste.setString(1,user.getRole());
        ste.setString(2,user.getNom());
         ste.setString(3,user.getPrenom());
         ste.setString(4,user.getLogin());
         ste.setString(5,user.getPassword());
         ste.setString(6,user.getImage());
         ste.setInt(7,user.getTelephone()); 
         ste.setString(8,user.getAdresse());
         ste.setString(9,user.getDate_naiss());
         
        
            
            

            ste.executeUpdate();

            ResultSet resultSet = ste.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
           public List<User> findAll() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM `user`";
        try (PreparedStatement statement = ConnectionBD.getInstance().getConnection().prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = null;
                switch (resultSet.getString("role").toLowerCase()) {
                    case "admin":
                        user = new Admin();
                        break;
                    case "Membre":
                        user = new Membre();
                        break;
                    case "Prestataire":
                       // user = new Prestataire();
                        break;
                    
                }

                user.setRole(resultSet.getString("Role"));
                user.setNom(resultSet.getString("nom"));
                user.setPassword(resultSet.getString("password"));
                user.setLogin(resultSet.getString("login"));               
                user.setPrenom(resultSet.getString("prenom"));
                user.setAdresse(resultSet.getString("adresse"));
                user.setTelephone(resultSet.getInt("telephone"));
               

                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return users;
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
                      //  user = new Prestataire();
                        user.setId(resultSet.getInt("id_user"));

                        break;
                }

                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                
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
   
           
            
            
            
             public User findByEmail(String login) {
        User user = new User();

        String sql = "SELECT * FROM `user` WHERE `login` = ? ";

        try (PreparedStatement statement = ConnectionBD.getInstance().getConnection().prepareStatement(sql)) {

            statement.setString(1, login);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                switch (resultSet.getString("role").toLowerCase()) {
                    case "admin":
                        user = new User();
                        user.setId(resultSet.getInt("id_user"));
                        break;
                    case "Memebre":
                        user = new Membre();
                        user.setId(resultSet.getInt("id_user"));
                      

                         break;
                    case "Prestataire":
                       // user = new Prestataire();
                        user.setId(resultSet.getInt("id_user"));

                        break;
                    
                }

                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
              
                user.setNom(resultSet.getString("nom"));
                user.setPrenom(resultSet.getString("prenom"));
                user.setAdresse(resultSet.getString("adress"));
                user.setTelephone(resultSet.getInt("telephone"));
                user.setImage(resultSet.getString("img"));
            }
            return user;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return user;
    }

            
            
             
    public   boolean checkUsername(String login) {
        return checkUsername(login, null);
    }
           
           
   public boolean checkUsername(String login, Integer id) {
        String sql = "SELECT count(*) FROM `user` "
                + "WHERE `login` = ?"
                + (id != null ? " AND `id_user` != ?" : "");

        boolean result = false;
        try (PreparedStatement statement = ConnectionBD.getInstance().getConnection().prepareStatement(sql)) {

            statement.setString(1, login);
            if (id != null) {
                statement.setInt(2, id);
            }
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getInt(1) > 0) {
                    result = true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }
    
 

     public void update_photo(String img, int id)
     {
         try {
             String req= " UPDATE `user` SET `img`=? WHERE `id_user`=?";
            PreparedStatement statement = ConnectionBD.getInstance().getConnection().prepareStatement(req);
             statement.setString(1,img);
             statement.setInt(2, id);
             statement.executeUpdate();


         } catch (Exception e) {
         }
        
         
     }
     
     
     public void confirmation(int id)
       {
    try {
             String req= "UPDATE `user` SET `status`='active' WHERE `id_user`=?";
              PreparedStatement statement = ConnectionBD.getInstance().getConnection().prepareStatement(req);
             statement.setInt(1,id);
           
             statement.executeUpdate();


         } catch (Exception e) {
         }
    
}
     
     
     
}
