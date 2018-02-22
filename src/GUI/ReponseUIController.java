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
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
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
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author majd
 */
public class ReponseUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextArea ContenuRep;

    @FXML
    private Label labelReponse;

    @FXML
    private Button btnRepondre;
     @FXML
    private ImageView img;

    @FXML
    private Text nomprenom;

    @FXML
    private Text sujet;

    @FXML
    private Text contenu;
    @FXML
    
    private ListView<Reponse> Reponselist;
    @FXML
    private Text dare;
     Button likeBtn,dislike ; 
    
   static int id_rep ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
        
         btnRepondre.setVisible(true);
         ContenuRep.setVisible(true);
         
            
        } catch (Exception e) {
            System.out.println(e);
        }
 
        
        Question q = QuestionService.SpecifiedQuestion(FXMain.id);
        contenu.setText(q.getContenu_question());
        sujet.setText(q.getSujet_question());
        nomprenom.setText(q.getNom()+" "+q.getPrenom());
        dare.setText(q.getDate_publication());
      
      Image  image  = new Image("https://scontent.ftun3-1.fna.fbcdn.net/v/t1.0-9/27541143_281014289095859_6804380293155361267_n.jpg?oh=9361e76214952e253b4e3df941501f91&oe=5B09A8E7", true); 
                            img.setImage(image);
                           
     // Remplissage de la lise qui suit
    
     ObservableList<Reponse> dataList = FXCollections.observableArrayList(ReponseService.getInstance().FiltredReponse(FXMain.id));

        Reponselist.getItems().addAll(dataList);
            // view of the list
            Reponselist.setCellFactory(new Callback<ListView<Reponse>, ListCell<Reponse>>() {
            @Override
            public ListCell<Reponse> call(ListView<Reponse> param) {
                return new ListCell<Reponse>()
                {
                    @Override
                    protected void updateItem(Reponse item, boolean empty) {
                        super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                     if ( item != null)
                     {
                       
                        id_rep = item.getId_rep();
                        Button edit = new Button("edit");  
                         Button delete = new Button("delete"); 
                         ToggleButton likeBtn = new ToggleButton();
                        
                      likeBtn.setOnMouseClicked((event) -> {
                        if (likeBtn.isSelected())  
                        {
                            try {
                                ReponseService.getInstance().LikeReponse(id_rep);
                            

                             
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                              
                         
             
                        }
                        else 
                        {
                           try {
                                ReponseService.getInstance().DislikeReponse(id_rep);
                             
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                             
                         
                        
            }
                        
                            
                      });
                         
                       edit.setOnAction((event) -> {
                           try {
                               
                               id_rep = item.getId_rep();
                           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditReponse.fxml"));
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
                       delete.setOnAction((event) -> {
                           try {
                                ReponseService.getInstance().DeleteReponse(item.getId_rep());
                           } catch (Exception e) {
                               System.out.println(e);
                           }
                           
                          
                           
                       });
                         
                     Circle c = new Circle();
                    c.setCenterX(50.0);
                    c.setCenterY(125.0);
                    c.setRadius(30.0);
                    c.setFill(Paint.valueOf("#097D99"));
                         Text text = new Text (String.valueOf(item.getNbr_aime_rep()));
                         StackPane stack = new StackPane();
                        stack.getChildren().addAll(c, text);

                        stack.setLayoutX(30);
                        stack.setLayoutY(30);
                      VBox vbox0 = new VBox(stack,new Text("Likes"));
                      
                     
                  
                      VBox btnBox = new VBox (likeBtn,edit,delete);
                     
                    
                         
                      btnBox.setSpacing(15);
                     
                           
                          
                    
                         VBox vBox = new VBox(
                                    new Text(item.getContenu_rep()), new Text(item.getDate_pub())
                       
                            );
                         
                            vBox.setSpacing(15);
                          
                            Image  image  = new Image("https://scontent.ftun3-1.fna.fbcdn.net/v/t1.0-9/27541143_281014289095859_6804380293155361267_n.jpg?oh=9361e76214952e253b4e3df941501f91&oe=5B09A8E7", true); 
                            ImageView imv =new ImageView(image);
                            imv.setFitHeight(130);
                            imv.setFitWidth(130);
                            
                             VBox  nbox2 = new VBox( imv , new Text(item.getNom()+" "+item.getPrenom()));
                            
                            HBox hBox = new HBox(nbox2, vBox,vbox0 ,btnBox);
                            hBox.setSpacing(250);
                            
                            setGraphic(hBox);
                     }
                        
                    }
                    
                };
          }
        });
                        
            
            
            
    }
    public void AddRep()
    {
        if(ContenuRep.getText().equals(""))
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setContentText("reponse vide");
           alert.showAndWait();        
        }
        else 
        {
            try {
                
            } catch (Exception e) {
            }
            Reponse r = new Reponse(ContenuRep.getText(),FXMain.id);
            ReponseService.getInstance().AddReponse(r);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Information");
           alert.setContentText("Votre reponse est ajoutée ");
           alert.showAndWait();
  
        
         
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
            
            
            
            
            
   
      
    

