/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.membre;

import com.jfoenix.controls.JFXTextField;
import com.twilio.type.Client;
import entites.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import services.UserDAO;
import espacesante.bienetre.EspaceSanteBienEtre;
import utile.Mail;


public class ModifierController implements Initializable {

    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXTextField tel;
    @FXML
    private JFXTextField password;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField password2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         nom.setText(EspaceSanteBienEtre.currentUser.getFirstname());
        prenom.setText(EspaceSanteBienEtre.currentUser.getLastname());
        mail.setText(EspaceSanteBienEtre.currentUser.getEmail());
        tel.setText(EspaceSanteBienEtre.currentUser.getTelephone());
        password.setText(EspaceSanteBienEtre.currentUser.getPassword());
        password2.setText(EspaceSanteBienEtre.currentUser.getPassword());
      
        System.out.println(EspaceSanteBienEtre.currentUser.getAvatar());
  
    }    

    @FXML
    private void modifier(MouseEvent event) {
         
            User user = new User();
            UserDAO userDAO=new UserDAO();
            System.out.println(EspaceSanteBienEtre.currentUser.getRole());

            user.setId(EspaceSanteBienEtre.currentUser.getId());
            user.setUsername(EspaceSanteBienEtre.currentUser.getUsername());
            user.setPassword(password.getText());
            user.setEmail(mail.getText());
            user.setFirstname(nom.getText());
            user.setLastname(prenom.getText());
            user.setAdress(EspaceSanteBienEtre.currentUser.getAdress());
            user.setTelephone(tel.getText());
            user.setStatus(EspaceSanteBienEtre.currentUser.getStatus());

            userDAO.update(user);
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
