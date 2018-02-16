/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entite.Service_Medecin;
import Service.Service_service;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class ModifServiceController implements Initializable {

    @FXML
    private TableView<Service_Medecin> TableMedecins;

    @FXML
    private TableColumn<Service_Medecin, String> photo;
    @FXML
    private TableColumn<Service_Medecin, String> nom;
    @FXML
    private TableColumn<Service_Medecin, String> prenom;
    @FXML
    private TableColumn<Service_Medecin, String> specialite;
    @FXML
    private TableColumn<Service_Medecin, String> adresse;
    @FXML
    private TableColumn<Service_Medecin, String> prix;
    @FXML
    private TableColumn<Service_Medecin, String> mode;
    @FXML
    private TableColumn<Service_Medecin, String> id;

    @FXML
    private TextField rech;
    @FXML
    private TextField rechnom;
    private ObservableList<Service_Medecin> MedDATA = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Service_service ss = new Service_service();
        TableMedecins.getItems().clear();
        List<Service_Medecin> serviceM = ss.SelectServiceMED("medecin");
        //serviceM.forEach(u->System.out.println(String.valueOf(u.getSpecialite())));
        MedDATA.addAll(0, serviceM);
        //id.setVisible(false);

        photo.setCellValueFactory(new PropertyValueFactory<>("image_serv"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        specialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse_etab"));
        prix.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        mode.setCellValueFactory(new PropertyValueFactory<>("modes_de_reglement"));
        id.setCellValueFactory(new PropertyValueFactory<>("id_service"));
       // System.out.println(id);
        TableMedecins.setItems(MedDATA);
        photo.setCellFactory(tc -> {
       TableCell<Service_Medecin, String> cell = new TableCell<Service_Medecin, String>() {
             @Override
             protected void updateItem(String item, boolean empty) {
                 
                  super.updateItem(item, empty);
                  if (item == null || empty) {
                        setText("pas d'image");
                  } 
                  else if(item.startsWith("a")){ setText("pas ");}
                  else {
                      
                      
                        final URL imageURL = getClass().getResource(item); 
        final Image image = new Image(imageURL.toExternalForm()); 
        final ImageView imageView = new ImageView(image); 
   
                        StackPane stackPane = new StackPane(imageView);
                        setGraphic(stackPane);
                  }
             }
       };
       return cell;
});          
                // TODO

    

        
        rech.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                TableMedecins.setItems(MedDATA);
            } else {
                TableMedecins.setItems(FXCollections.observableArrayList(ss.findmedbyspec(rech.getText())));
            }
        });
        rechnom.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                TableMedecins.setItems(MedDATA);
            } else {
                TableMedecins.setItems(FXCollections.observableArrayList(ss.findmedbynom(rech.getText())));
            }
        });

    }

    @FXML
    void get_selected_item(MouseEvent event) {
        nom.setText(TableMedecins.getSelectionModel().getSelectedItem().getNom());
        prenom.setText(TableMedecins.getSelectionModel().getSelectedItem().getPrenom());
        nom.setText(TableMedecins.getSelectionModel().getSelectedItem().getNom());
        id.setText(String.valueOf(TableMedecins.getSelectionModel().getSelectedItem().getId_service()));
        specialite.setText(String.valueOf(TableMedecins.getSelectionModel().getSelectedItem().getSpecialite()));
        adresse.setText(TableMedecins.getSelectionModel().getSelectedItem().getAdresse_etab());
        prix.setText(String.valueOf(TableMedecins.getSelectionModel().getSelectedItem().getTarif()));
        mode.setText(TableMedecins.getSelectionModel().getSelectedItem().getModes_de_reglement());

    }
}
