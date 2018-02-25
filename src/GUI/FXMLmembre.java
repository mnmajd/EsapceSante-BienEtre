/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author TAQWA
 */

    
    
public class FXMLmembre extends Application {
   
  static Stage stg;
    static String s;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stg=stage;
          
        Parent root = FXMLLoader.load(getClass().getResource("FXMLmembreView.fxml"));
        
      
      
    // new Image(url)

         
        Scene scene = new Scene(root);
          stage.setTitle("Affiche Blog");
             stage.setResizable(false);
              stage.setHeight(600);
              stage.setWidth(900);
              

              
              

//            
            
        stage.setScene(scene);
       // stage.getIcons().add(new Image("/image/health.jpg"));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
