/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.CategorieForum;
import Entite.Question;
import Service.QuestionService;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author majd
 */
public class AddQuestionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField Subject;

     @FXML
    private ComboBox<?> ListCat;

    @FXML
    private TextArea contenutext;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      List<String> p =  Service.ServiceCategorieForum.ReadCategorie();

        ObservableList specialités  = FXCollections.observableArrayList (
        
        p
        
        );
        

        ListCat.setItems(specialités);
        
    }    
    
     public void AddQuestion ()
     {
          if (Subject.getText().equals("") )
        {
            
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Attention");
           alert.setHeaderText("Champs Vide");
           alert.setContentText("champs Manquant ");
           alert.showAndWait();
           
          }
        
          else if ( ListCat.getSelectionModel().getSelectedItem().equals(""))
          {

         Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Attention");
           alert.setHeaderText("Champs Vide");
           alert.setContentText("categorie manquente");
           alert.showAndWait();               
           }
          
          else if (contenutext.getText().equals(""))
          {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setTitle("Attention");
                  alert.setHeaderText("Champs Vide");
                  alert.setContentText("contenu manquente");
                         alert.showAndWait();  
          }
          else {
              Question q = new Question (Subject.getText(), ListCat.getSelectionModel().getSelectedItem().toString(),contenutext.getText());
              QuestionService.AddQuestion(q);
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Question En cours de traitement");
              alert.setHeaderText("Question traite");
              alert.setContentText("Aaaaa ");
              alert.showAndWait(); 
              contenutext.clear();
              Subject.clear();
              }
         
          
}
     public void BackToForum()
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
