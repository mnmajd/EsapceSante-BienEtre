/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.NewFXMain.stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author majd
 */
public class AcceuilController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void GoToForum()
    {
            try {
                           
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ForumBasic.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));  
        stage.show();
        FXMain.stg.close();
        FXMain.stg = stage;
  } catch (Exception e) {
       System.out.println(e);
  }
      
    }
    public void GoToLogin ()
    {
    try {
                           
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));  
        stage.show();
        FXMain.stg.close();
        FXMain.stg = stage;
  } catch (Exception e) {
       System.out.println(e);
  }
    
    }
    public void GoToBlog()
    {
        try {
                           
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLmembreView.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));  
        stage.show();
        FXMain.stg.close();
        FXMain.stg = stage;
  } catch (Exception e) {
       System.out.println(e);
  }
    }
    public void GoToAds()
    {
        try {
                           
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interface_membre.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));  
        stage.show();
        FXMain.stg.close();
        FXMain.stg = stage;
  } catch (Exception e) {
       System.out.println(e);
  }
    }
}
