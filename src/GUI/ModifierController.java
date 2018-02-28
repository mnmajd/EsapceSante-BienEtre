/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Entite.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import Service.UserDAO;
import GUI.FXMain;
import Utils.Mail;
import javafx.scene.control.TextField;


public class ModifierController implements Initializable {

    @FXML
    private TextField prenom;
    @FXML
    private TextField mail;
    @FXML
    private TextField tel;
    @FXML
    private TextField password;
    @FXML
    private TextField nom;
    @FXML
    private TextField password2;
    public static int CurrentuserId ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserDAO UserDAO =  new UserDAO();
//         nom.setText(EspaceSanteBienEtre.currentUser.getFirstname());
//        prenom.setText(EspaceSanteBienEtre.currentUser.getLastname());
//        mail.setText(EspaceSanteBienEtre.currentUser.getEmail());
//        tel.setText(EspaceSanteBienEtre.currentUser.getTelephone());
//        password.setText(EspaceSanteBienEtre.currentUser.getPassword());
//        password2.setText(EspaceSanteBienEtre.currentUser.getPassword());
        CurrentuserId=FXMain.currentUser.getId();
       User u =  UserDAO.findById(CurrentuserId);
       nom.setText(u.getFirstname());
        prenom.setText(u.getLastname());
        mail.setText(u.getEmail());
        tel.setText(u.getTelephone());
        password.setText(u.getPassword());
        password2.setText(u.getPassword());
        System.out.println(u.getAvatar());
 
    }    

    @FXML
    private void modifier(MouseEvent event) {
         
            User user = new User();
            UserDAO userDAO=new UserDAO();
            System.out.println(FXMain.currentUser.getRole());

            user.setId(FXMain.currentUser.getId());
            user.setUsername(FXMain.currentUser.getUsername());
            user.setPassword(password.getText());
            user.setEmail(mail.getText());
            user.setFirstname(nom.getText());
            user.setLastname(prenom.getText());
            user.setAdress(FXMain.currentUser.getAdress());
            user.setTelephone(tel.getText());
            user.setStatus(FXMain.currentUser.getStatus());
            userDAO.update2(user);
            
            
            System.out.println(user.getEmail());
          
                Mail.sendMail(user.getEmail(), "Compte Espace sante", "Votre compte en tant que"+user.getRole()+" chez Espace sante a été modifier avec succsée: " 
                      +"\n votre nouveau statut est: "+ user.getStatus()
                      +"\n votre nouveau adresse est: "  +user.getAdress()
                      +"\n votre nouveau nom est: "  +user.getFirstname()
                      +"\n votre nouveau prenom est: "  +user.getLastname()
                      +"\n votre nouveau mot de passe est: " +user.getPassword()
                      +"\n votre nouveau numero de telephone est: "  +user.getTelephone()
                      );
           

           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success!");
            alert.setContentText("Utilisateur modifier avec success!");
            alert.showAndWait();
        }
    
 
    
    
}
