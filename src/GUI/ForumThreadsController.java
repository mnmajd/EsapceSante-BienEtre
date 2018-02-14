/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Question;
import Service.QuestionService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author majd
 */
public class ForumThreadsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ListView<Question> list;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
//          l = QuestionService.getInstance().ReadQuestion();
          
          ObservableList<Question> data = FXCollections.observableArrayList(
             QuestionService.getInstance().ReadQuestion()
                  
            
          );
          list.getItems().addAll(data);
          list.setCellFactory(new Callback<ListView<Question>, ListCell<Question>>()
                  {
              @Override
              public ListCell<Question> call(ListView<Question> param) {
                  return new ListCell<Question>()
                  {
                      @Override
                      protected void updateItem(Question item, boolean empty) {
                          super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                       if ( item != null)
                       {
                         VBox vBox = new VBox(
                                    new Text(item.getSujet_question()), new Text(item.getContenu_question())
                                          , new Text(item.getDate_publication()), new Text(String.valueOf(item.getNbr_rep()))
                            );
                            vBox.setSpacing(4);
                          
                            Image  image  = new Image("https://scontent.ftun3-1.fna.fbcdn.net/v/t1.0-9/27541143_281014289095859_6804380293155361267_n.jpg?oh=9361e76214952e253b4e3df941501f91&oe=5B09A8E7", true); 
                            ImageView imv =new ImageView(image);
                            imv.setFitHeight(130);
                            imv.setFitWidth(130);
                            HBox hBox = new HBox(imv, vBox);
                            hBox.setSpacing(10);
                            
                            
                            setGraphic(hBox);
                       
                       }
                      }
                     
                  };
                  



//To change body of generated methods, choose Tools | Templates.
              }
                      
                      
                  
                  
                  
                  
                  }
          
          
          
          
          
          
          
          );
        
        // TODO
    }    
    
}
