/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.AnnonceUser;
import Entite.Annonce;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class Interface_afficherController implements Initializable {

    static int id;
    @FXML
    private TableView<Annonce> tableV;

    @FXML
    private TableColumn<Annonce, String> tableC;

    @FXML
    private TableColumn<Annonce, String> tableCid;

    @FXML
    private Button modifier;

    @FXML
    private TextField image;

    @FXML
    private Button img;

    @FXML
    private TextField add;

    @FXML
    private TextField tel;

    @FXML
    private TextField description;

    @FXML
    private TextField titre;

    @FXML
    private DatePicker date;

    @FXML
    private ComboBox<String> choix;


  private String imageUrl;
    @FXML
    private Button retour;

    
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
                image.setText(imageUrl);
                

            } catch (MalformedURLException ex) {
                throw new IllegalStateException(ex);

            }

        }

    }
//    
    private void showAnnonceDetails(Annonce Annonce) {

        if (Annonce != null) {
            Annonce.getId_annonce();
            choix.setPromptText(Annonce.getType_annonce());
            titre.setText(Annonce.getTitre_annonce());
            description.setText(Annonce.getDesc_annonce());
            date.setPromptText(Annonce.getDate_annonce());
            add.setText(Annonce.getAddr_annonce());
            tel.setText(Integer.toString(Annonce.getTel_annonce()));
            image.setText(Annonce.getImg_annonce());

        } else {

            choix.setPromptText("");
            titre.setText("");
            description.setText("");
            date.setPromptText("dd-MM-yyyy");       
            add.setText("");
            tel.setText("");
            image.setText("");
        }

    }

    private ObservableList<Annonce> title = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ObservableList options
                = FXCollections.observableArrayList(
                        "Offres d'emplois",
                        "Evenements"
                );

        choix.setPromptText("Select Type annonce");
        choix.setItems(options);
        

        tableV.getItems().clear();
        List<Annonce> annc = AnnonceUser.selectAnnonce1();
        title.addAll(0, annc);
        tableC.setCellValueFactory(new PropertyValueFactory<>("titre_annonce"));
        tableCid.setCellValueFactory(new PropertyValueFactory<>("Id_annonce"));
        tableCid.setVisible(false);
        tableV.setItems(title);

        //System.out.println(MedDATA);
      showAnnonceDetails(null);

        tableV.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAnnonceDetails(newValue));

    }

    
    @FXML
    private void handleDeleteAnnonce(ActionEvent event) throws IOException {

        int id = tableV.getSelectionModel().getSelectedIndex();
        if (id >= 0) {

            AnnonceUser.deleteAnnonce(tableV.getSelectionModel().getSelectedItem().getId_annonce());
            tableV.getItems().remove(id);
            Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Votre Annonce");
                alert.setHeaderText(null);
                alert.setContentText("Annonce Supprimée");
                alert.showAndWait();
        } else {
            
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }

    
    @FXML
    public void modifierAnnonce()  {
        try {
            
            id = tableV.getSelectionModel().getSelectedItem().getId_annonce();
               System.out.println(id);
      Annonce AN = new Annonce(choix.getSelectionModel().getSelectedItem(),titre.getText(),description.getText(),date.getValue().toString(),add.getText(),Integer.parseInt(tel.getText()),image.getText());
           
       AnnonceUser.updateAnnonce(AN, id);
        
       Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Votre Annonce");
                alert.setHeaderText(null);
                alert.setContentText("votre annonce a été modifié avec succés");
                alert.showAndWait();
        } catch (Exception e) {
            System.out.println(e);
       // System.out.println(id);

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
