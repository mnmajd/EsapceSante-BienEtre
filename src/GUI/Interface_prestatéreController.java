/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.NewFXMain.stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tarek
 */
public class Interface_prestatéreController implements Initializable {

    @FXML
    private Button ajouterannonce;
    @FXML
    private Button consulterannonce;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterannonce(ActionEvent event) throws IOException {
        
        
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interface_ajouter.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show(); 
             NewFXMain.stage.close();
             NewFXMain.stage=stage;
    }

    @FXML
    private void consulterannonce(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interface_afficher.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show(); 
             NewFXMain.stage.close();
             NewFXMain.stage=stage;
    }
    
}
