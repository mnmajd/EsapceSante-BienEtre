/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main_offre extends Application {


    static String chtitre;
    static String chdescription;
    static String chtel;
    static String chdate;
    static String chimg;
    static String chadress;
    static Stage stage;
  

    @Override
    public void start(Stage stage) throws Exception{
       
            this.stage = stage;
            Parent root = FXMLLoader.load(getClass().getResource("interface_detail_offre.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } 
    

    public static void main(String[] args) {
        launch(args);
    }
}
