/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private TabPane pane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    List<String> p =  Service.ServiceCategorieForum.ReadCategorie();

        for (String Categorie : p) {
             pane.getTabs().add(new Tab(Categorie));
            } 

        // TODO
    }
//    public void Reposnelead(Stage stage  )
//    {
//        
//           try {
//               Parent root = FXMLLoader.load(getClass().getResource("AddQuestion.fxml"));
//            Scene scene = new Scene(root);
//            
//            stage.setScene(scene);
//            stage.show();
//        } catch (Exception e) {
//               System.out.println(e);
//        }
          
 
    }


    
    

