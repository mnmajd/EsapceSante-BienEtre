/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Question;
import Service.QuestionService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author majd
 */
public class MyQuestionsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ListView<Question> mylist;

    @FXML
    private TextField sujet;

    @FXML
    private ComboBox<String> choix;

    @FXML
    private TextArea contenu;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Question> data = FXCollections.observableArrayList(
             QuestionService.getInstance().ReadQuestion()
                  
            
          );
        
    }    
    
}
