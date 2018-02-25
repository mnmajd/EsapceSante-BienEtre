/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Question;
import Entite.Reponse;
import Service.QuestionService;
import Service.ReponseService;

import java.net.URL;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
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
    private TextField rechecherTxt;
    @FXML
    private ListView<Question> list;
     @FXML
    private TabPane TabeCat;
    @FXML
    private Button Questionbtn;
    static int id_question;// pour recupurer l'id du question a modifié

    @Override
   
    public void initialize(URL url, ResourceBundle rb) {
        QuestionService.getInstance().UpdateLikes();
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
          
          rechecherTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
               
                list.getItems().addAll(data);
            } else {
                list.setItems(FXCollections.observableArrayList(QuestionService.getInstance().FilterByTopic(rechecherTxt.getText())));
            }
        });
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
                 ImageView editIcon = new ImageView();
                   Image editimg = new Image("/GUI/Images/edit.png") ;
                   editIcon.setImage(editimg);
                   
                   ImageView deleteicon = new ImageView();
                   Image deleteimg = new Image("/GUI/Images/rubbish.png") ;
                   deleteicon.setImage(deleteimg);
                   
                              
                    
    
                    c.setCenterX(50.0);
                    c.setCenterY(125.0);
                    c.setRadius(30.0);
                    c.setFill(Paint.valueOf("#097D99"));
                    
                         Text text = new Text (String.valueOf(item.getNbr_rep()));
                         StackPane stack = new StackPane();
                        stack.getChildren().addAll(c, text);
                         Button edit = new Button();  
                         Button delete = new Button();  
                        stack.setLayoutX(30);
                        stack.setLayoutY(30);
                        
                        edit.setGraphic(editIcon);
                        delete.setGraphic(deleteicon);
                        
                      VBox vbox0 = new VBox(stack , new Text("Reponse"),edit,delete);
                      vbox0.setSpacing(8);
                           delete.setOnAction((event) -> {
                          
                          
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert.setTitle("Information");
                                     alert.setContentText("Vous Voulez Vraiment supprimer cette question?  ");
                                   Optional<ButtonType> result = alert.showAndWait();
                                    if (result.get() == ButtonType.OK){
                               
                                    DeleteQuestion(item.getId_question());
                                }  
                         
                      });
                      
                      edit.setOnAction((event) -> {
                          try {
                              id_question = item.getId_question();
                           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("QuestionUpdate.fxml"));
                            Parent root = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));  
                            stage.show();
                            
                            FXMain.stg = stage;
                      } catch (Exception e) {
                           System.out.println(e);
                      }
                          
                          
                      });
                      
                         VBox vBox = new VBox(
                                    new Text(item.getSujet_question())
                                          , new Text(item.getDate_publication())
                            );
                            vBox.setSpacing(15);
                          
                            Image  image  = new Image("https://scontent.ftun3-1.fna.fbcdn.net/v/t1.0-9/27541143_281014289095859_6804380293155361267_n.jpg?oh=9361e76214952e253b4e3df941501f91&oe=5B09A8E7", true); 
                            ImageView imv =new ImageView(image);
                            imv.setFitHeight(130);
                            imv.setFitWidth(130);
                             VBox  nbox2 = new VBox( imv , new Text(item.getNom()+" "+item.getPrenom()));
                            HBox hbox = new HBox (nbox2,vBox);
                            hbox.setSpacing(10);
                            HBox hBox = new HBox(hbox ,vbox0);
                            hBox.setSpacing(700);
                            
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
                 ImageView editIcon = new ImageView();
                   Image editimg = new Image("/GUI/Images/edit.png") ;
                   editIcon.setImage(editimg);
                   
                   ImageView deleteicon = new ImageView();
                   Image deleteimg = new Image("/GUI/Images/rubbish.png") ;
                   deleteicon.setImage(deleteimg);
                   
                              
                    
    
                    c.setCenterX(50.0);
                    c.setCenterY(125.0);
                    c.setRadius(30.0);
                    c.setFill(Paint.valueOf("#097D99"));
                    
                         Text text = new Text (String.valueOf(item.getNbr_rep()));
                         StackPane stack = new StackPane();
                        stack.getChildren().addAll(c, text);
                         Button edit = new Button();  
                         Button delete = new Button();  
                        stack.setLayoutX(30);
                        stack.setLayoutY(30);
                        
                        edit.setGraphic(editIcon);
                        delete.setGraphic(deleteicon);
                    
                      VBox vbox0 = new VBox(stack , new Text("Reponse"),edit,delete);
                      vbox0.setSpacing(8);
                      
                         delete.setOnAction((event) -> {
                          
                          
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert.setTitle("Information");
                                     alert.setContentText("Vous Voulez Vraiment supprimer cette question?  ");
                                   Optional<ButtonType> result = alert.showAndWait();
                                    if (result.get() == ButtonType.OK){
                               
                                    DeleteQuestion(item.getId_question());
                                }  
                         
                      });
                      
                      edit.setOnAction((event) -> {
                         try {
                             id_question = item.getId_question();
                           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("QuestionUpdate.fxml"));
                            Parent root = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));  
                            stage.show();
                            FXMain.stg.close();
                            FXMain.stg = stage;
                      } catch (Exception e) {
                           System.out.println(e);
                      }
                          
                      });
                         VBox vBox = new VBox(
                                    new Text(item.getSujet_question())
                                          , new Text(item.getDate_publication())
                            );
                            vBox.setSpacing(15);
                          
                          Image  image  = new Image("https://scontent.ftun3-1.fna.fbcdn.net/v/t1.0-9/27541143_281014289095859_6804380293155361267_n.jpg?oh=9361e76214952e253b4e3df941501f91&oe=5B09A8E7", true); 
                            ImageView imv =new ImageView(image);
                            imv.setFitHeight(130);
                            imv.setFitWidth(130);
                             VBox  nbox2 = new VBox( imv , new Text(item.getNom()+" "+item.getPrenom()));
                            HBox hbox = new HBox (nbox2,vBox);
                            hbox.setSpacing(10);
                            HBox hBox = new HBox(hbox ,vbox0);
                            hBox.setSpacing(700);
                            
                            setGraphic(hBox);
//*UPDATE question q SET nbr_rep = (select COUNT(*) FROM reponse WHERE id_question = q.id_question ) WHERE 1

                       
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
                           System.out.println(e);
                      }
                  }
              });
   
   
   
    }
     public void GoToQuestion()
     {
         try {
                           
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddQuestion.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));  
        stage.show();
        FXMain.stg.close();
        FXMain.stg = stage;
  } catch (Exception e) {
       System.out.println(e);
  }
         
     };
     
     
 public void DeleteQuestion( int id)
 {
     try {
         QuestionService.getInstance().DeleteQuestion(id);
         
     } catch (Exception e) {
         System.out.println(e);
     }
     try {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Delete Question");
              alert.setHeaderText("Votre question est supprimé");
           
              alert.showAndWait();
     } catch (Exception e) {
     }
     try {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("forumBasic.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));  
        stage.show();
//        FXMain.stg.close();
        FXMain.stg = stage;
         
     } catch (Exception e) {
     }
 }
     
     public void List()
     {
         ObservableList<Question> data = FXCollections.observableArrayList(
             QuestionService.getInstance().FilterByCat(TabeCat.getSelectionModel().getSelectedItem().getText())
                  
            
          );
            
          list.getItems().addAll(data);
     }
  
    }




    
    

