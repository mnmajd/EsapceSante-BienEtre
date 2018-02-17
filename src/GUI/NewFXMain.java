/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author tarek
 */
public class NewFXMain extends Application {
    
//    @Override
//    public void start(Stage stage) {
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("interface_ajouter.fxml"));
//         
//            Scene scene = new Scene(root) ;
//            stage.setScene(scene);
//            stage.show();
    
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Interface_prestatére.fxml"));
         
            Scene scene = new Scene(root) ;
            stage.setScene(scene);
            stage.show();

            
        } catch (IOException e) {
            System.out.println(e);
        }
     
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
  
    
}
