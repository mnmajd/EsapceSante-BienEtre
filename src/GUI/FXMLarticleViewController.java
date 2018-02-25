/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author TAQWA
 */
public class FXMLarticleViewController implements Initializable {

    @FXML
    private Text conten;
    @FXML
    private Text titrev;
    @FXML
    private Text categv;
    @FXML
    private Text sujetv;
    @FXML
    private Text datev;
    @FXML
    private ImageView imgv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titrev.setText(LST.a);
       // categv.setText(LST.);
      //  sujetv.setText(LST.);
      //  datev.setText(LST)
         conten.setText(LST.s);
         imgv.setImage(LST.f);
    }    
    
}
