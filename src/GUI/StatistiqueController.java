/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.AnnonceUser;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tarek
 */
public class StatistiqueController implements Initializable {

    @FXML
    private PieChart Chart;  
    @FXML
    private Button retour;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        
         //retourner en arriére
        Image image = new Image("\\image\\arrow-previous-icon.png");
         ImageView iv1 = new ImageView();
         iv1.setImage(image);
         retour.setGraphic(iv1);
         iv1.setFitWidth(30);
         iv1.setPreserveRatio(true);
         iv1.setSmooth(true);
         iv1.setCache(true);
        
        
    
    
   
       Chart.setData(createPieChart().getData());
       Chart.setLabelsVisible(true); 
    }
   
    private PieChart createPieChart() {
        AnnonceUser annonce = new AnnonceUser();
        
                ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
             new PieChart.Data("Offre", annonce.statistiqueOffre()),
             new PieChart.Data("Evenement", annonce.statistiqueEvenement())
         );
       // PieChart1.setData(pieChartData);
       
        
         return new PieChart(pieChartData);
    }


    @FXML
    private void retour(ActionEvent event) {
           try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interface_prestatére.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            NewFXMain.stage.close();
            NewFXMain.stage = stage;

        } catch (IOException ex) {
            Logger.getLogger(Interface_afficher_offreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
