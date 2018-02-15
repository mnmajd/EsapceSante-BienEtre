/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Question;
import Service.QuestionService;
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
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author majd
 */
 
public class ForumBasicController implements Initializable {

    /**
     * 
     * Initializes the controller class.
     */
    @FXML
    private ListView<Question> list;
     @FXML
    private TabPane TabeCat;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              List<String> p  =  Service.ServiceCategorieForum.ReadCategorie();

        ObservableList CategorieForum  = FXCollections.observableArrayList (
        
        p
        
        );
        for (Object cat : CategorieForum) {
        TabeCat.getTabs().add(new Tab((String) cat));
                    }
//        System.out.println(TabeCat.getSelectionModel().getSelectedItem().getText());
        
//        ObservableList<Question> data = FXCollections.observableArrayList(
//             QuestionService.getInstance().FilterByCat(TabeCat.getSelectionModel().getSelectedItem().getText())
//                  
//            
//          );
//          list.getItems().addAll(data);
//          list.setCellFactory(new Callback<ListView<Question>, ListCell<Question>>()
//                  {
//              @Override
//              public ListCell<Question> call(ListView<Question> param) {
//                  return new ListCell<Question>()
//                  {
//                      @Override
//                      protected void updateItem(Question item, boolean empty) {
//                          super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
//                       if ( item != null)
//                       {
//                         VBox vBox = new VBox(
//                                    new Text(item.getSujet_question()), new Text(item.getContenu_question())
//                                          , new Text(item.getDate_publication()), new Text(String.valueOf(item.getNbr_rep()))
//                            );
//                            vBox.setSpacing(4);
//                          
//                            Image  image  = new Image("https://scontent.ftun3-1.fna.fbcdn.net/v/t1.0-9/27541143_281014289095859_6804380293155361267_n.jpg?oh=9361e76214952e253b4e3df941501f91&oe=5B09A8E7", true); 
//                            ImageView imv =new ImageView(image);
//                            imv.setFitHeight(130);
//                            imv.setFitWidth(130);
//                            HBox hBox = new HBox(imv, vBox);
//                            hBox.setSpacing(10);
//                            
//                            
//                            setGraphic(hBox);
//                       
//                       }
//                      }
//                     
//                  };
//              }
//                    
//                  }
//          );
   TabeCat.getSelectionModel().selectedItemProperty().addListener(
    new ChangeListener<Tab>() {
        @Override
        public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
               list.getItems().clear();
              ObservableList<Question> data = FXCollections.observableArrayList(
             QuestionService.getInstance().FilterByCat(TabeCat.getSelectionModel().getSelectedItem().getText())
                  
            
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
                                          , new Text(item.getDate_publication()), new Circle()
                            );
                            vBox.setSpacing(5);
                          
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
              }
                    
                  }
          );
        }

                  
    }
);
    }

                       
  
    }


    
    

