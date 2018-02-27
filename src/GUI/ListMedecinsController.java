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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class ListMedecinsController implements Initializable {

  @FXML
    private AnchorPane search;

    @FXML
    private ComboBox<?> specialite;

    @FXML
    private ComboBox<?> nom;

    @FXML
    private Button Search;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}