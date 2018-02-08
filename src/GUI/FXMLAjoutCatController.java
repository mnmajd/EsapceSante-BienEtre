/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.ServiceCategorieForum;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author majd
 */
public class FXMLAjoutCatController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btn;
     @FXML
    private TextField CatNom;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
          public  void AddCat()
        {
        if (CatNom.getText().equals(""))
        {
           Alert alert = new Alert(AlertType.ERROR);
           alert.setTitle("Champs  catégorie vide");
           alert.setHeaderText("Attention");
           alert.setContentText("Vous devez donner le nom du catégorie tout d'abord");
           alert.showAndWait();
           
          }
        
         else {
            
            ServiceCategorieForum.getInstance().AddCategorie(CatNom.getText());
            Alert alert = new Alert(AlertType.INFORMATION);
                  alert.setTitle("Information Dialog");
                  alert.setHeaderText(null);
                  alert.setContentText("Ajout cat effectué"); 
                  alert.showAndWait();
                  CatNom.clear();
             } 
        
    
}



}