/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.AnnonceUser;
import Entite.Annonce;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tarek
 */
public class Interface_afficher_evenementController implements Initializable {

    @FXML
    private ListView<Annonce> listviewE;
    @FXML
    private Button retourE;
    @FXML
    private TextField rechercher;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<Annonce> data = FXCollections.observableArrayList();

        List<Annonce> serviceOffre = AnnonceUser.selectAnnonce3();
        data.addAll(0, serviceOffre);
        listviewE.getItems().addAll(data);

        listviewE.setCellFactory((ListView<Annonce> param) -> new ListCell<Annonce>() {
            @Override
            protected void updateItem(Annonce item, boolean empty) {
                super.updateItem(item, empty); 
                if (item != null) {
                    // Text text = new Text ("eeee");

                    ImageView img = new ImageView(item.getImg_annonce());
                    img.setFitHeight(130);
                    img.setFitWidth(120);
                    
                    Text text1 = new Text("Nom de l'evenement :                 "+item.getTitre_annonce());
                    Text text2 = new Text("Date de l'evenement :        "+item.getDate_annonce());
                    Text text3 = new Text(item.getAddr_annonce());
                    Text text4 = new Text(item.getDesc_annonce());
                    String val = Integer.toString(item.getTel_annonce());
                    Text text5 = new Text(val);
                    Text text6 = new Text(item.getImg_annonce());

                    VBox vbox = new VBox(text1, text2);
                    vbox.setAlignment(Pos.CENTER);
                    vbox.setSpacing(20);
                    HBox h = new HBox(img, vbox);
                    h.setSpacing(100);
                    setGraphic(h);

                }
            }
        ;
        });
    
        listviewE.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Annonce>() {
            @Override
            public void changed(ObservableValue<? extends Annonce> observable, Annonce oldValue, Annonce newValue) {

                try {
                    Main_evenement.chtitre = newValue.getTitre_annonce();
                    Main_evenement.chdescription = newValue.getDesc_annonce();
                    Main_evenement.chdate = newValue.getDate_annonce();
                    Main_evenement.chadress = newValue.getAddr_annonce();
                    String val2 = Integer.toString(newValue.getTel_annonce());
                    Main_evenement.chtel = val2;
                    Main_evenement.chimg = newValue.getImg_annonce();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interface_detail_evenement.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                    NewFXMain.stage.close();
                    NewFXMain.stage = stage;
                    Main_evenement.st = stage;

                } catch (IOException ex) {
                    Logger.getLogger(Interface_afficher_offreController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    @FXML
    private void retourE(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interface_membre.fxml"));
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


    @FXML
    private void rechercher(javafx.scene.input.KeyEvent event) {
          try {
            listviewE.getItems().clear();
            listviewE.refresh();
            listviewE.getItems().addAll(AnnonceUser.rech(rechercher.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(Interface_afficher_evenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
   



  