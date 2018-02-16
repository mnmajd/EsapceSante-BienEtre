/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Question;
import Service.QuestionService;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.Color;
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
                      @SuppressWarnings("empty-statement")
                      protected void updateItem(Question item, boolean empty) {
                          super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                       if ( item != null)
                       {
                                
                
                   Circle c = new Circle();
    
                    c.setCenterX(50.0);
                    c.setCenterY(125.0);
                    c.setRadius(30.0);
                  
                    c.setCache(true);
                    VBox vBox1 = new VBox(c);
                    
                         VBox vBox = new VBox(
                                    new Text(item.getSujet_question()), new Text(item.getContenu_question())
                                          , new Text(item.getDate_publication()), new Text(String.valueOf(item.getNbr_rep()))
                            );
                            vBox.setSpacing(15);
                          
                            Image  image  = new Image("https://scontent.ftun3-1.fna.fbcdn.net/v/t1.0-9/27541143_281014289095859_6804380293155361267_n.jpg?oh=9361e76214952e253b4e3df941501f91&oe=5B09A8E7", true); 
                            ImageView imv =new ImageView(image);
                            imv.setFitHeight(130);
                            imv.setFitWidth(130);
                             VBox  nbox2 = new VBox( imv , new Text(item.getNom()+" "+item.getPrenom()));
                            
                            HBox hBox = new HBox(nbox2, vBox ,vBox1);
                            hBox.setSpacing(30);
                            
                            setGraphic(hBox);
                       
                       }
                      }
                     
                  };
              }
                    
                  }
          );
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
                           
                   Circle c = new Circle();
    
                    c.setCenterX(50.0);
                    c.setCenterY(125.0);
                    c.setRadius(30.0);
                  
                    c.setCache(true);
                    VBox vBox1 = new VBox(c);
                    
                         VBox vBox = new VBox(
                                    new Text(item.getSujet_question()),
                                          new Text(item.getDate_publication()),
                                          new Text()
                            );
                            vBox.setSpacing(4);
                      
                        
                            Image  image  = new Image("https://scontent.ftun3-1.fna.fbcdn.net/v/t1.0-9/27541143_281014289095859_6804380293155361267_n.jpg?oh=9361e76214952e253b4e3df941501f91&oe=5B09A8E7", true); 
                            ImageView imv =new ImageView(image);
                            imv.setFitHeight(130);
                            imv.setFitWidth(130);
                            VBox  nbox2 = new VBox( imv , new Text(item.getNom()+" "+item.getPrenom()));
                            
                            HBox hBox = new HBox(nbox2, vBox,vBox1);
                            hBox.setSpacing(15);
                            
                            
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
   list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Question> () {
                  @Override
                  public void changed(ObservableValue<? extends Question> observable, Question oldValue, Question newValue) {
                       try {
                           FXMain.id = newValue.getId_question();
                           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReponseUI.fxml"));
                            Parent root = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));  
                            stage.show();
                            FXMain.stg.close();
                            FXMain.stg = stage;
                      } catch (Exception e) {
                      }
                  }
              });
   
   
   
    }

                       
  
    }


    
    

