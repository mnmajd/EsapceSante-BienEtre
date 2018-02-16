/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entite.Service_Medecin;
import Service.Service_service;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class FirstInterfaceController implements Initializable {

    @FXML
    private TextField rechspec;
    @FXML
    private TextField rechnom;
    @FXML
    private ListView<Service_Medecin> listviewmed;
//public static Service_Medecin mdc;
    static String NON;
    static String PRENOM;
    static String SPEC;
    static String DIPLOME;
    static String LANGUES;
    static String OUVERT;
    static String FERME;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<Service_Medecin> data = FXCollections.observableArrayList();
Service_service ss = new Service_service();
 List<Service_Medecin> serviceM = ss.SelectServiceMED("medecin");
       
       data.addAll(0,serviceM);
        listviewmed.getItems().addAll(data);
        listviewmed.setCellFactory(new Callback<ListView<Service_Medecin>, ListCell<Service_Medecin>>() {
            @Override
            public ListCell<Service_Medecin> call(ListView<Service_Medecin> param) {
                return new ListCell<Service_Medecin>() {
                    @Override
                    protected void updateItem(Service_Medecin item, boolean empty) {
                        super.updateItem(item, empty); 
                        if (item != null) {
                            VBox vBox = new VBox(
                                    new Text(item.getNom()), new Text(item.getPrenom()),
                                     new Text(item.getSpecialite()), new Text(String.valueOf(item.getTarif())),new Text(item.getModes_de_reglement()),
                                             new Text(item.getAdresse_etab()));
                    
                            vBox.setSpacing(6);

                            Image image = new Image("https://www.codeproject.com/KB/GDI-plus/ImageProcessing2/img.jpg", true);
                            ImageView imv = new ImageView(image);
                            imv.setFitHeight(130);
                            imv.setFitWidth(130);
                            HBox hBox = new HBox(imv, vBox);
                            hBox.setSpacing(10);

                            setGraphic(hBox);

                        }
                    }

                };

            }

        }
        );
        
        listviewmed.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Service_Medecin>(){
         @Override
            public void changed(ObservableValue<? extends Service_Medecin> observable, Service_Medecin oldValue, Service_Medecin newValue) {
                                try {
                                     FXMain.nom=newValue.getNom();
                                   //NON=newValue.getNom();
                                          System.out.println(NON);
                                    
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConsulterMonService.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
            FXMain.stg.close();
            FXMain.stg = stage;
    } catch(Exception e) {
       e.printStackTrace();
      }
        
                
            }
        });  
    }

}
