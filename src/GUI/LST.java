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
import javafx.stage.Stage;

/**
 *
 * @author me
 */
public class LST extends Application {
    static Stage stg;
    static String t;
     static String d;
      static String sujet;
       static String c;
       static String b;
        // static Image f;
           static String catr;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stg=stage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLarticleView.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
