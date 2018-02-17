/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Annonce.AnnonceUser;
import Entite.Annonce;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static Annonce.AnnonceUser.deleteAnnonce;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Interface_afficherController implements Initializable {

    @FXML
    private TableView<Annonce> tableV;
    @FXML
    private TableColumn<Annonce, String> tableC;
    @FXML
    private TableColumn<Annonce, String> tableCid;
    @FXML
    private Label titre;
    @FXML
    private Label description;
    @FXML
    private Label date;
    @FXML
    private Label tel;
    @FXML
    private Label add;
    @FXML
    private Label image;
    @FXML
    private Label choix;
    @FXML
    private Button modifier;

    private void showAnnonceDetails(Annonce Annonce) {

        if (Annonce != null) {
            Annonce.getId_annonce();
            choix.setText(Annonce.getType_annonce());
            titre.setText(Annonce.getTitre_annonce());
            description.setText(Annonce.getDesc_annonce());
            date.setText(Annonce.getDate_annonce());
            tel.setText(Integer.toString(Annonce.getTel_annonce()));
            add.setText(Annonce.getAddr_annonce());
            image.setText(Annonce.getImg_annonce());

        } else {

            choix.setText("");
            titre.setText("");
            description.setText("");
            date.setText("");
            tel.setText("");
            add.setText("");
            image.setText("");
        }

    }

    private ObservableList<Annonce> title = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }

    @FXML
    private void modifierAnnonce(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interface_modifier.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

}
