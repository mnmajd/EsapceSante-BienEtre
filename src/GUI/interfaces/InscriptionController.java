/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.interfaces;

import Entite.Membre;
//import Entite.Prestataire;
import Entite.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javax.mail.Service;
import Service.ServiceUser;
import Service.ServiceMembre;
import java.io.IOException;
import java.util.Random;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import utile.Mail;
import utile.Status;
import static GUI.interfaces.FXMain.loginScene;
import static GUI.interfaces.FXMain.loginWindow;
import java.io.File;
import java.net.MalformedURLException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;
import org.omg.CORBA.SystemException;
/**
 * FXML Controller class
 *
 * @author said hmidi
 */
public class InscriptionController implements Initializable {

    ServiceUser UserS = new ServiceUser();
  
  
    @FXML
    private TextField prenom;

    @FXML
    private TextField nom;

    @FXML
    private TextField login;

    @FXML
    private TextField telephone;

    @FXML
    private TextField adresse;

    @FXML
    private Button inscrire;

    @FXML
    private PasswordField password;

    @FXML
    private Button btnImage;

    @FXML
    private DatePicker date_naiss;
    

    @FXML
    private TextField cin;

    @FXML
    private TextField age;

        @FXML
    private ComboBox<?> sexe;
   private String ImageUrl;
    
  @FXML
    private TextField testimg;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
      ObservableList options = FXCollections.observableArrayList(
      
              "Homme",
              "femme"
      );
      sexe.setPromptText("Choisir le sexe");
      sexe.setItems(options);
       
      
        
    }

   
    @FXML
   public void signupMembre()
   {
       int tel =Integer.parseInt(telephone.getText());
       int ag = Integer.parseInt(age.getText());
       int c = Integer.parseInt(cin.getText());
        //String date = date_naiss.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
     
       // membre.signupMembre((Membre) m);
        try {
               User m = new Membre(sexe.getSelectionModel().getSelectedItem().toString(),ag,c, nom.getText(), prenom.getText(), login.getText(), password.getText(),testimg.getText(), tel, adresse.getText(),date_naiss.getValue().toString());
       ServiceMembre membre= new ServiceMembre();
      
       membre.signupMembre((Membre) m);
            System.out.println("tres bien");
           
       } catch (Exception e) {
            System.out.println(e);
       }
   }
   
   
   @FXML
    private void ajouterimage() {

        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try {
                ImageUrl = file.toURI().toURL().toExternalForm();
                //Image image = new Image(imageUrl);
                //pic.setImage(image);
                testimg.setText(ImageUrl);
                

            } catch (MalformedURLException ex) {
                throw new IllegalStateException(ex);

            }

        }

    }
   

    
    
}
