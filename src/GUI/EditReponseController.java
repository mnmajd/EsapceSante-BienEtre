/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.QuestionService;
import Service.ReponseService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author majd
 */
public class EditReponseController implements Initializable {

    /**
     * Initializes the controller class.
     */
       @FXML
    private TextArea contenu_rep;
       int id_rep = ReponseUIController.id_rep;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
        // TODO
        contenu_rep.setText(ReponseService.getInstance().GetContenuReponse(id_rep));
    } 
    public void EditReponse()
    {
        
        if(contenu_rep.getText().equals(""))
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
                  ReponseService.getInstance().UpdateReponse(contenu_rep.getText(),id_rep);
                 System.out.println("done");
             } catch (Exception e) {
                 System.out.println(e);
             }
            
         try {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Information");
          
           alert.setContentText("Votre champs a été bien mise a jour ");
           alert.showAndWait();
           
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReponseUI.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
            FXMain.stg.close();
            FXMain.stg = stage;
             
         } catch (Exception e) {
             System.out.println(e);
         }
//            
           
       

    }
    }
     public void cancel()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReponseUI.fxml"));
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
    

