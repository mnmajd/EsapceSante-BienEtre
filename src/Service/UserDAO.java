/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Service;
import interfaces.IUserDAO;

import Entite.User;
import GUI.EspaceSanteBienEtre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Utils.ConnexionBD;


public class UserDAO implements IUserDAO{
    
    ConnexionBD Database;
    public UserDAO() {
        Database=ConnexionBD.getInstance(); 
            
    }
       
    @Override
    public User login(String login, String password) {
        User user = null;
        String sql = "SELECT * FROM `user` WHERE `login` = ? AND `password` = ?";

        try (PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {

            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("From login function: " + resultSet.getInt(1));
                user = findById(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

    @Override
    public void add(User user) {

        String sql = "INSERT INTO `user`(`role`, `login`, `password`, "
                + "`email`, `nom`, `prenom`, `adress`, `telephone`, "
                + "`status`,`avatar`, `sexe`, `CIN`, `age`, `specialite`,`date_naissance`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            int columnIndex = 0;
            statement.setString(++columnIndex, user.getRole());
            statement.setString(++columnIndex, user.getUsername());
            statement.setString(++columnIndex, user.getPassword());
            statement.setString(++columnIndex, user.getEmail());
            statement.setString(++columnIndex, user.getFirstname());
            statement.setString(++columnIndex, user.getLastname());
            statement.setString(++columnIndex, user.getAdress());
            statement.setString(++columnIndex, user.getTelephone());
            statement.setString(++columnIndex, user.getStatus());
            statement.setString(++columnIndex, user.getAvatar());
            statement.setString(++columnIndex, user.getSexe());
            statement.setString(++columnIndex, user.getCIN());
            statement.setInt(++columnIndex, user.getAge());
            statement.setString(++columnIndex, user.getSpecialite());
            statement.setDate(++columnIndex, user.getDateNaissance());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public void add2(User user) {

        String sql = "INSERT INTO `user`(`role`, `login`, `password`, "
                + "`email`, `nom`, `prenom`, `adress`, `telephone`, "
                + "`status`) VALUES (?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            int columnIndex = 0;
            statement.setString(++columnIndex, user.getRole());
            statement.setString(++columnIndex, user.getUsername());
            statement.setString(++columnIndex, user.getPassword());
            statement.setString(++columnIndex, user.getEmail());
            statement.setString(++columnIndex, user.getFirstname());
            statement.setString(++columnIndex, user.getLastname());
            statement.setString(++columnIndex, user.getAdress());
            statement.setString(++columnIndex, user.getTelephone());
            statement.setString(++columnIndex, user.getStatus());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
        @Override
    public void update(User user) {
        

        String sql = "UPDATE `user` SET "
                + "`login`= ?, "
                + "`password`= ?, "
                + "`email`= ?, "
                + "`nom`= ?, "
                + "`prenom`= ?, "
                + "`adress`= ?, "
                + "`telephone`= ?, "
                + "`role`= ?, "
                + "`status`= ? "
                + "WHERE `id_user`= ?";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {
            int columnIndex = 0;
            statement.setString(++columnIndex, user.getUsername());
            statement.setString(++columnIndex, user.getPassword());
            statement.setString(++columnIndex, user.getEmail());
            statement.setString(++columnIndex, user.getFirstname());
            statement.setString(++columnIndex, user.getLastname());
            statement.setString(++columnIndex, user.getAdress());
            statement.setString(++columnIndex, user.getTelephone());
            statement.setString(++columnIndex, user.getRole());
            statement.setString(++columnIndex, user.getStatus());
            statement.setInt(++columnIndex, user.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public void update2(User user) {
        

        String sql = "UPDATE `user` SET "
                + "`login`=?,"
                + "`password`=?,"
                + "`email`=?,"
                + "`nom`=?,"
                + "`prenom`=?,"
                + "`adress`=?,"
                + "`telephone`=?"              
                + "WHERE `id_user`= ?";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {
            int columnIndex = 0;
            statement.setString(++columnIndex, user.getUsername());
            statement.setString(++columnIndex, user.getPassword());
            statement.setString(++columnIndex, user.getEmail());
            statement.setString(++columnIndex, user.getFirstname());
            statement.setString(++columnIndex, user.getLastname());
            statement.setString(++columnIndex, user.getAdress());
            statement.setString(++columnIndex, user.getTelephone());
            statement.setInt(++columnIndex,EspaceSanteBienEtre.currentUser.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   


    
    
    @Override
    public void delete(User user) {
        String sql = "DELETE FROM `user` WHERE `id_user` = ?";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {
            statement.setInt(1, user.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM `user`";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id_user"));
                user.setUsername (resultSet.getString("login"));
                user.setPassword (resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                user.setEmail    (resultSet.getString("email"));
                user.setFirstname(resultSet.getString("nom"));
                user.setLastname (resultSet.getString("prenom"));
                user.setAdress   (resultSet.getString("adress"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setStatus   (resultSet.getString("status"));

                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }

    @Override
    public User findById(Integer id) {
        User user = new User();

        String sql = "SELECT * FROM `user` WHERE `id_user` = ? ";

        try (PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstname(resultSet.getString("nom"));
                user.setLastname(resultSet.getString("prenom"));
                user.setAdress(resultSet.getString("adress"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setStatus(resultSet.getString("status"));
                user.setAvatar(resultSet.getString("avatar"));
                user.setRole(resultSet.getString("role"));
            }
            return user;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return user;
    }
    
    public User findByEmail(String mail) {
        User user = new User();

        String sql = "SELECT * FROM `user` WHERE `email` = ? ";

        try (PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {

            statement.setString(1, mail);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                
                user.setId(resultSet.getInt("id_user"));
                user.setUsername(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstname(resultSet.getString("nom"));
                user.setLastname(resultSet.getString("prenom"));
                user.setAdress(resultSet.getString("adress"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setStatus(resultSet.getString("status"));
                user.setAvatar(resultSet.getString("avatar"));
            }
            return user;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return user;
    }

    @Override
    public User findByUsername(String login) {
        User user = new User();

        String sql = "SELECT * FROM `user` WHERE `login` = ? ";

        try (PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {

            statement.setString(1, login);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                user.setUsername(login);
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstname(resultSet.getString("nom"));
                user.setLastname(resultSet.getString("prenom"));
                user.setAdress(resultSet.getString("adress"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setStatus(resultSet.getString("status"));
            }
            return user;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return user;
    }

    @Override
    public void changeStatus(User user, String newStatus) {
        user.setStatus(newStatus);
        this.update(user);
    }


    @Override
    public boolean checkUsername(String login) {
        return checkUsername(login, null);
    }

    @Override
    public boolean checkUsername(String login, Integer id) {
        String sql = "SELECT count(*) FROM `user` "
                + "WHERE `login` = ?"
                + (id != null ? " AND `id_user` != ?" : "");

        boolean result = false;
        try (PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {

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
    
    
    
   
    public boolean checkUseremail(String email) {
        return checkUseremail(email, null);
    }
    
 
    public boolean checkUseremail(String email, Integer id) {
        String sql = "SELECT count(*) FROM `user` "
                + "WHERE `email` = ?"
                + (id != null ? " AND `id_user` != ?" : "");

        boolean result = false;
        try (PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {

            statement.setString(1, email);
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
    
     public ObservableList<User>findAll2(String login) {
        ObservableList<User> users=FXCollections.observableArrayList();

        String sql = "SELECT * FROM `user` WHERE login like '%"+login+"%'";
        try (PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id_user"));
                user.setUsername(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstname(resultSet.getString("nom"));
                user.setLastname(resultSet.getString("prenom"));
                user.setAdress(resultSet.getString("adress"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setStatus(resultSet.getString("status"));

                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }
     
     
     public void update_photo(String img, int id)
     {
         try {
             String req= " UPDATE `user` SET `avatar`=? WHERE `id_user`=?";
             PreparedStatement statement = Database.getConnection().prepareStatement(req);
             statement.setString(1,img);
             statement.setInt(2, id);
             statement.executeUpdate();


         } catch (Exception e) {
             System.out.println("erreur");
         }
        
         
     }
    
     public void confirmation(int id)
       {
    try {
             String req= "UPDATE `user` SET `status`='active' WHERE `id_user`=?";
             PreparedStatement statement = Database.getConnection().prepareStatement(req);
             statement.setInt(1,id);
           
             statement.executeUpdate();


         } catch (Exception e) {
         }
    
}
    
     
     
     
        
     
     public int statistiquehomme() {
        try {
            String req = "SELECT COUNT(*) AS hommes from user where sexe like 'Homme'";
            PreparedStatement statement = Database.getConnection().prepareStatement(req);
            ResultSet result=statement.executeQuery();
            while(result.next())
            {
                return result.getInt("hommes");    
            }
            
        } catch (Exception e) {
            System.out.println("Error on DB connection homme");
            System.out.println(e.getMessage());      
        }
        return -1;
    }

        public int statistiquefemme() {
        try {
            String req = "SELECT COUNT(*) AS femmes from user where sexe like 'Femme'";
            PreparedStatement statement = Database.getConnection().prepareStatement(req);
            ResultSet result=statement.executeQuery();
            while(result.next())
            {
                return result.getInt("femmes");
            }
            
        } catch (Exception e) {
            System.out.println("Error on DB connection femme");
            System.out.println(e.getMessage());      
        }
        return -1;
    }
    
}
