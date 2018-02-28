/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class Interface_membreController implements Initializable {

    @FXML
    private Label offre;
   
    @FXML
    private Label evnt;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }

    @FXML
    private void Evenements(MouseEvent event) {
        
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interface_afficher_evenement.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            NewFXMain.stage.close();
            NewFXMain.stage = stage;
        } catch (IOException ex) {
            Logger.getLogger(Interface_membreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Offres_emplois(MouseEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interface_afficher_offre.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            NewFXMain.stage.close();
            NewFXMain.stage = stage;
        } catch (IOException ex) {
            Logger.getLogger(Interface_membreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
