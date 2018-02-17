/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Annonce;
import Annonce.AnnonceUser;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 * FXML Controller class
 *
 * @author tarek
 */
public class Interface_modifierController implements Initializable {

    @FXML
    private ComboBox<?> choix;

    @FXML
    private TextField titre;

    @FXML
    private TextField description;

    @FXML
    private DatePicker date;

    @FXML
    private TextField tel;

    @FXML
    private TextField adresse;

    @FXML
    private Button image;


    @FXML
    private TextField testimg;
    private String imageUrl;
    @FXML
    private Button handleOk;
    @FXML
    private Button handleCancel;
    @FXML
    private TextField id_annonce;

    
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
    private void showAnnonceDetails(Annonce Annonce) {

        if (Annonce != null) {
            id_annonce.setText(Integer.toString(Annonce.getId_annonce()));    
            choix.setPromptText(Annonce.getType_annonce());
            titre.setText(Annonce.getTitre_annonce());
            description.setText(Annonce.getDesc_annonce());
            date.setPromptText(Annonce.getDate_annonce());
            tel.setText(Integer.toString(Annonce.getTel_annonce()));
            adresse.setText(Annonce.getAddr_annonce());
            image.setText(Annonce.getImg_annonce());

        } else {
            
            choix.setPromptText("");
            titre.setText("");
            description.setText("");
            date.setPromptText("");
            tel.setText("");
            adresse.setText("");
            image.setText("");
        }

    }

    

    private void Modifier() {
        
     
         try {
            Annonce AN = new Annonce(id_annonce.getText(),choix.getSelectionModel().getSelectedItem().toString(), titre.getText(), date.getValue().toString(), description.getText(), adresse.getText(), Integer.parseInt(tel.getText()), testimg.getText(), 2);
             AnnonceUser.updateAnnonce(AN,id_annonce);

            System.out.println("tres bien");

        } catch (Exception e) {
            System.out.println(e);
        
        }
       
    }

    @FXML
    private void handleOk(ActionEvent event) {
    }

    @FXML
    private void handleCancel(ActionEvent event) {
    }

 
}
