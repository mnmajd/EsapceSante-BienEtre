/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Question;
import Entite.Reponse;
import Service.QuestionService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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
    private ImageView img;

    @FXML
    private Text nomprenom;

    @FXML
    private Text sujet;

    @FXML
    private Text contenu;
    private ListView<Reponse> Reponselist;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Question q = QuestionService.SpecifiedQuestion(FXMain.id);
        contenu.setText(q.getContenu_question());
        sujet.setText(q.getSujet_question());
        nomprenom.setText(q.getNom()+""+q.getPrenom());
      Image  image  = new Image("https://scontent.ftun3-1.fna.fbcdn.net/v/t1.0-9/27541143_281014289095859_6804380293155361267_n.jpg?oh=9361e76214952e253b4e3df941501f91&oe=5B09A8E7", true); 
                            img.setImage(image);
           //             imv.setFitHeight(130);
//                            imv.setFitWidth(130);
//                            VBox  nbox2 = new VBox( imv ,q.getNom()+""+q.getPrenom());
//              
//          VBox textbox = new VBox(label,text2 ) ; 
//          textbox.setSpacing(10);
//        HBox QuestionBox = new HBox(nbox2,textbox);
//        
    }    
    
}
