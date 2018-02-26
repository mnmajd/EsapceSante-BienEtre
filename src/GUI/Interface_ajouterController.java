/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Annonce;
import Service.AnnonceUser;
import static GUI.NewFXMain.stage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tarek
 */
public class Interface_ajouterController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField testimg;
    @FXML
    private ComboBox<?> choix;

    @FXML
    private TextField titre;

    @FXML
    private TextField description;

    private String imageUrl;
    @FXML
    private DatePicker date;

    @FXML
    private TextField adresse;

    @FXML
    private TextField tel;
    @FXML
    private Button image;
    @FXML
    private Button button;
    @FXML
    private Button retour;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList options
                = FXCollections.observableArrayList(
                        "Offres d'emplois",
                        "Evenements"
                );

        choix.setPromptText("Select Type annonce");
        choix.setItems(options);

    }


    
     @FXML
    private void ajouterimage(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try {
                imageUrl = file.toURI().toURL().toExternalForm();
                //Image image = new Image(imageUrl);
                //pic.setImage(image);
                testimg.setText(imageUrl);
                

            } catch (MalformedURLException ex) {
                throw new IllegalStateException(ex);

            }

        }
    }
       
  
    
    
    
    @FXML
    private void ajouter() {
         Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(tel.getText());
         if (titre.getText().equals("") )
        {
            
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Attention");
           alert.setHeaderText("Champs Vide");
           alert.setContentText("champs Manquant ");
           alert.showAndWait();
           
          }
        else if (tel.getText().equals("") )
        {
            
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Attention");
           alert.setHeaderText("Champs Vide");
           alert.setContentText("champs Manquant ");
           alert.showAndWait();
           
          }
        
         else if (!((m.find() && m.group().equals(tel.getText())) ))
        {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate Mobile Number");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid Mobile Number");
                alert.showAndWait();
           
          }
        else if (adresse.getText().equals("") )
        {
            
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Attention");
           alert.setHeaderText("Champs Vide");
           alert.setContentText("champs Manquant ");
           alert.showAndWait();
           
          }  else {

     AnnonceUser serv = new AnnonceUser();
        try {     Annonce pp=new Annonce (choix.getSelectionModel().getSelectedItem().toString(),titre.getText(),date.getValue().toString(),description.getText(),adresse.getText(),Integer.parseInt(tel.getText()),testimg.getText(),2);
               AnnonceUser.inserAnnonce(pp);
               
               System.out.println("tres bien");
               
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Votre Annonce");
                alert.setHeaderText(null);
                alert.setContentText("Annonce publiée");
                alert.showAndWait();
                
        } catch (Exception e)
        {
    System.out.println(e);
        }
       
                }
        
    }

    @FXML
    private void retour(ActionEvent event) {
        
               try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interface_prestatére.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            NewFXMain.stage.close();
            NewFXMain.stage = stage;

        } catch (IOException ex) {
            Logger.getLogger(Interface_afficher_offreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
   

}
