/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.interfaces;

import Entite.User;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author said hmidi
 */
public class FXMain extends Application {
        public static Stage stage;
    public static AnchorPane loginWindow;
    public static Parent signupWindow;
    public static Scene loginScene;
    public static Scene signupScene;

    public static User currentUser;
     
    @Override
    public void start(Stage stage) {
      
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
           //Parent root = FXMLLoader.load(getClass().getResource("Affichage.fxml"));
           //Parent root = FXMLLoader.load(getClass().getResource("ManageUser.fxml"));
            Scene scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
           // loginWindow();
            
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        
        
    }
    
    
    
//    11111111111111111111
    
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
