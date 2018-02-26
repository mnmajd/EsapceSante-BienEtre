/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author tarek
 */
public class NewFXMain extends Application {
    
static Stage stage;
    
    @Override
    public void start(Stage stage) {
        try {
            this.stage=stage;
            Parent root = FXMLLoader.load(getClass().getResource("interface_prestatére.fxml"));
            Scene scene = new Scene(root) ;
            stage.setScene(scene);
            stage.show();       
        } catch (IOException e) {
            System.out.println(e);
        }
  
        
        
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("interface_membre.fxml"));
//            Scene scene = new Scene(root) ;
//            stage.setScene(scene);
//            stage.show();       
//        } catch (IOException e) {
//            System.out.println(e);
//        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
  
    
}
