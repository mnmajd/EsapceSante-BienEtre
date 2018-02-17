/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Annonce;
import Annonce.AnnonceUser;
import java.awt.Insets;
import java.io.File;
import static java.lang.Integer.parseInt;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.sql.Date;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

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
    
        } catch (Exception e)
        {
    System.out.println(e);
        }
                }
    }
   

}
