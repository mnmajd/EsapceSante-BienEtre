/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.User;
import Utils.AnimationGenerator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author majd
 */
public class FXMain extends Application {
   public static Stage stg;
    static int id;
     public static Stage stage;
    public static AnchorPane loginWindow;
    public static Parent signupWindow;
    public static Scene loginScene;
    public static Scene signupScene;
    
    public static User currentUser;
  

    static Stage stageprim, stage1, stage2, stage4, stage3, stage5, stage6,stage7;
    public String clinicName = "";
    @Override
    public void start(Stage stage)  {
       
        try {
             this.stg=stage;
                Parent root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
            Scene scene = new Scene(root);
       
            stg.setScene(scene);
            stg.show();
        } catch (IOException ex) {
                
            System.out.println(ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void loginWindow() {
        try {
            currentUser = null;
            loginWindow = FXMLLoader.load(getClass().getResource("Login.fxml"));

            loginScene = new Scene(loginWindow);
            stg.getIcons().add(new Image("/GUI/Images/doc.png"));
            stg.setScene(loginScene);
            stg.setMinHeight(770);
            stg.setMaxHeight(770);
            
            stg.setMinWidth(1370);
            stg.setMaxWidth(1370);
            stg.centerOnScreen();
            stg.setTitle("Espace Sante Bien etre");
           // stage.setFullScreen(true);
            stg.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public static void logout() 
     {
        AnimationGenerator animationGenerator = new AnimationGenerator();
        animationGenerator.applyFadeAnimationOn(stg.getScene().getRoot(), 500, 1.0f, 0f, event -> {
            try {
                FXMain.currentUser = null;
                loginWindow = FXMLLoader.load(FXMain.class.getResource("Login.fxml"));
                loginScene = new Scene(loginWindow);
                FXMain.stg.setScene(loginScene);
                stg.centerOnScreen();
                FXMain.loginWindow.setOpacity(1f);
                animationGenerator.applyFadeAnimationOn(FXMain.loginWindow, 500, 0f, 1.0f, null);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
    }
    
}
