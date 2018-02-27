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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author chayma
 */
public class FXMAINC extends Application {
    static Stage stg;
    
//    @Override
//    public void start(Stage stage) throws IOException {
//    Parent root = FXMLLoader.load(getClass().getResource("ConsulterMonService.fxml"));
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    
    
//        @Override
//    public void start(Stage stage) throws IOException {
//    Parent root = FXMLLoader.load(getClass().getResource("AjoutServiceMed.fxml"));
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//       
//        stage.show();
//       
//    }
     @Override
    public void start(Stage stage) throws IOException {
         try {
                this.stg = stage ;
    Parent root = FXMLLoader.load(getClass().getResource("AjoutServiceMed.fxml"));
        Scene scene = new Scene(root);
        stage.setHeight(600);
        stage.setWidth(900);
        stage.setScene(scene);
        stage.show();
         } catch (Exception e) {
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