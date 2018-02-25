/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Article;
import Service.Article_Service;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author TAQWA
 */
public class BlogFXMLController implements Initializable {

    @FXML
    private Text txt1;
    @FXML
    private Text area;
    @FXML
    private Text txt2;
    @FXML
    private ImageView imgblog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           Article a ;
           Article_Service serv = new Article_Service() ;
//           Article x =  serv.getArticleUser(2);
//        // x.getSujet_article();
//         txt1.setText(x.getSujet_article());
//         txt2.setText(x.getTitre_article());
//         area.setText(x.getContenu_article());
//         
//         
//        System.out.println(x.getSujet_article());
//      
          
         Article x =  (Article) serv.getArticleUser(2);
         txt1.setText(x.getSujet_article());
        
         
           
        
       // getArticleUser
       /*
       data.addAll(0, serviceM);
idlist.getItems().addAll(data);
       */
    }    
    
}
