/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;

/**
 *
 * @author TAQWA
 */
public class FXMain extends Application {
   
    
    @Override
    public void start(Stage stage) throws Exception {
        
          
        Parent root = FXMLLoader.load(getClass().getResource("AjouBlog.fxml"));
        
      
      
    // new Image(url)

         
        Scene scene = new Scene(root);
          stage.setTitle("Ajouter Blog");
             stage.setResizable(false);
              stage.setHeight(600);
              stage.setWidth(900);
              
        // scene.getStylesheets().add("/GUI/styleli.css");
          // String image = getClass().getResource(STYLESHEET_MODENA).toExternalForm();
              String image = getClass().getResource("/image/health.jpg").toExternalForm();
              
              
              
root.setStyle("-fx-background-image: url('" + image + "'); " +
        "-fx-background-size: cover ;"+
        "-fx-background-size: 900 600;"+
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
//            
            
        stage.setScene(scene);
       // stage.getIcons().add(new Image("/image/health.jpg"));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
