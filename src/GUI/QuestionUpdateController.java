/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.QuestionService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author majd
 */
public class QuestionUpdateController implements Initializable {

    /**
     * Initializes the controller class.
     */
  
    @FXML
    private TextArea contenu;
int id = ForumBasicController.id_question ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contenu.setText(QuestionService.getInstance().GetContenuQuestion(id));
           
        
        
        
        
        
    }    
    
    
    public void UpdateQuestion()
    {
     if(contenu.getText().equals(""))
     {
          Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Attention");
           alert.setHeaderText("Champs Vide");
           alert.setContentText("champs Manquant ");
           alert.showAndWait();
     }
     else 
     {
         try {
             QuestionService.getInstance().UpdateQuestion(contenu.getText(),id);
             contenu.clear();
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Information");
          
           alert.setContentText("Votre champs a été bien mise a jour ");
           alert.showAndWait();
           
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ForumBasic.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();

            FXMain.stg = stage;
           
         } catch (Exception e) {
             System.out.println(e);
         }

     }
         
    
    }
    public void cancel()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ForumBasic.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
            FXMain.stg.close();
            FXMain.stg = stage;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
           
    
}
