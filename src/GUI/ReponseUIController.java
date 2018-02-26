


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
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Callback;


/**
 * FXML Controller class
 *
 * @author majd
 */
public class ReponseUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    static int current_user_id = 3 ; 
    @FXML
    private TextArea ContenuRep;

    @FXML
    private Label labelReponse;

    @FXML
    private Button btnRepondre;
     @FXML
    private VBox UpBox;
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
        System.out.println(ForumBasicController.CurrentActiveTab);
        UpBox.setSpacing(10);
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
        dare.setText(q.getDate_publication().substring(0, 16));
      
      Image  image  = new Image("https://scontent.ftun3-1.fna.fbcdn.net/v/t1.0-9/27541143_281014289095859_6804380293155361267_n.jpg?oh=9361e76214952e253b4e3df941501f91&oe=5B09A8E7", true); 
                            img.setImage(image);
                              img.setFitHeight(200);
                            img.setFitWidth(700);
                           
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
                         
                         ImageView likeicon = new ImageView();
                   Image likeimg = new Image("/GUI/Images/like.png") ;
                   likeicon.setImage(likeimg);
                   ImageView dislikeicon = new ImageView();
                   Image dislikeimg = new Image("/GUI/Images/dislike.png") ;
                   dislikeicon.setImage(dislikeimg);
                   
                   ImageView editIcon = new ImageView();
                   Image editimg = new Image("/GUI/Images/edit.png") ;
                   editIcon.setImage(editimg);
                   
                   ImageView deleteicon = new ImageView();
                   Image deleteimg = new Image("/GUI/Images/rubbish.png") ;
                   deleteicon.setImage(deleteimg);
                        id_rep = item.getId_rep();
                        Button edit = new Button();  
                         Button delete = new Button(); 
                         ToggleButton likeBtn = new ToggleButton();
                         likeBtn.setGraphic(likeicon);
                         edit.setGraphic(editIcon);
                         delete.setGraphic(deleteicon);
             
              likeBtn.setGraphic(likeicon);   
              
      
//                      
//              if (likeBtn.isSelected())
//              {
//               likeBtn.setGraphic(dislikeicon);   
//              }
//              else if (likeBtn.isSelected() == false)
//              {
//                  likeBtn.setGraphic(likeicon);   
//                       
                      
              
              
              
              
              
              
              
                     Circle c = new Circle();
                    c.setCenterX(50.0);
                    c.setCenterY(125.0);
                    c.setRadius(30.0);
                    c.setFill(Paint.valueOf("#097D99"));
                         Text text = new Text (String.valueOf(item.getNbr_aime_rep()));
                         text.setTextAlignment(TextAlignment.CENTER);
                         StackPane stack = new StackPane();
                        stack.setLayoutX(30);
                        stack.setLayoutY(30);
                        stack.getChildren().addAll(c, text);

                      
   
                            Image  image  = new Image("https://scontent.ftun3-1.fna.fbcdn.net/v/t1.0-9/27541143_281014289095859_6804380293155361267_n.jpg?oh=9361e76214952e253b4e3df941501f91&oe=5B09A8E7", true); 
                            ImageView imv =new ImageView(image);
                            imv.setFitHeight(130);
                            imv.setFitWidth(130);   
                   

                         
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
                                   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert.setTitle("Information");
                                     alert.setContentText("Vous Voulez Vraiment supprimer cette reponse?  ");
                                   Optional<ButtonType> result = alert.showAndWait();
                                    if (result.get() == ButtonType.OK){
                                         ReponseService.getInstance().DeleteReponse(item.getId_rep());
                                Reponselist.getItems().clear();
                                 ObservableList<Reponse> dataList = FXCollections.observableArrayList(ReponseService.getInstance().FiltredReponse(FXMain.id));
                                 Reponselist.getItems().addAll(dataList);
  
                                } else {
                                            
                                                }
                                     
                               
                                
                                
                           } catch (Exception e) {
                               System.out.println(e);
                           }
                           
                          
                           
                       });
                    Text NP = new Text(item.getNom()+" "+item.getPrenom());
               
                   NP.setTextOrigin(VPos.CENTER);
                  VBox vbox1 = new VBox(imv , NP);
                  vbox1.setAlignment(Pos.CENTER);
                  vbox1.setSpacing(8);
                  Text contenu = new Text(item.getContenu_rep());
                  contenu.setLayoutX(20);
                  contenu.setWrappingWidth(750);
                 
                  VBox vbox2 = new VBox(contenu,new Text(item.getDate_pub().substring(0, 16)));
                  
                  
                  vbox2.setSpacing(25);
                  
                  VBox vbox3 = new VBox(likeBtn,edit,delete);
                  vbox3.setSpacing(10);
                 Text likes =  new Text("Likes");
                 
                 likes.setTextAlignment(TextAlignment.CENTER);
                  VBox vbox4 = new VBox(stack,likes); 
                  vbox4.setAlignment(Pos.CENTER);
                  vbox4.setSpacing(8);
                  
                  HBox ImgTxt = new HBox(vbox1,vbox2);  
                  ImgTxt.setSpacing(15);
                    HBox LikeButtons = new HBox(vbox3,vbox4);     
                    LikeButtons.setSpacing(10);
                  HBox principale = new HBox(ImgTxt,LikeButtons);
                  principale.setSpacing(300);
                    setGraphic(principale);
                     likeBtn.setSelected(ReponseService.CurrentUserLikedReponse(id_rep, current_user_id));
                       likeBtn.setOnMouseClicked((event) -> {
                        if (likeBtn.isSelected())  
                        {
                            try {
                                
                                ReponseService.getInstance().LikeReponse(item.getId_rep());
                              ReponseService.getInstance().AddLikedQuestion(item.getId_rep(),current_user_id);
                                     Reponselist.getItems().clear();
                                 ObservableList<Reponse> dataList = FXCollections.observableArrayList(ReponseService.getInstance().FiltredReponse(FXMain.id));
                                    Reponselist.getItems().addAll(dataList);
                                  
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                        else 
                        {
                           try {
                               
                                ReponseService.getInstance().DislikeReponse(item.getId_rep());
                              ReponseService.getInstance().DeleteLikedQuestion(item.getId_rep(),current_user_id);
                                       Reponselist.getItems().clear();
                                        ObservableList<Reponse> dataList = FXCollections.observableArrayList(ReponseService.getInstance().FiltredReponse(FXMain.id));
                                      Reponselist.getItems().addAll(dataList);
                                
                                 
                                 
                            } catch (Exception e) {
                                System.out.println(e);
                            }                                      
                        }                                  
                      });
              
     
                            

                            
                            
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
        
           Reponselist.getItems().clear();
        ObservableList<Reponse> dataList = FXCollections.observableArrayList(ReponseService.getInstance().FiltredReponse(FXMain.id));
        Reponselist.getItems().addAll(dataList);
  
        
         
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
            
            
            
            
            
   
      
    

