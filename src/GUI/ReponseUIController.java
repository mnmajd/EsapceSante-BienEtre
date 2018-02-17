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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
                          Rating rating = new Rating(5);
                    
                         VBox vBox = new VBox(
                                    new Text(item.getContenu_rep()), new Text(item.getDate_pub())
                                          , new Text(String.valueOf(item.getNbr_aime_rep())
                            ),rating);
                         
                            vBox.setSpacing(15);
                          
                            Image  image  = new Image("https://scontent.ftun3-1.fna.fbcdn.net/v/t1.0-9/27541143_281014289095859_6804380293155361267_n.jpg?oh=9361e76214952e253b4e3df941501f91&oe=5B09A8E7", true); 
                            ImageView imv =new ImageView(image);
                            imv.setFitHeight(130);
                            imv.setFitWidth(130);
                            
                             VBox  nbox2 = new VBox( imv , new Text(item.getNom()+" "+item.getPrenom()));
                            
                            HBox hBox = new HBox(nbox2, vBox );
                            hBox.setSpacing(30);
                            
                            setGraphic(hBox);
                     }
                        
                    }
                    
                };
          }
        });
    }
}
            
            
            
            
            
   
      
    

