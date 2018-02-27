/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.AnnonceUser;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author tarek
 */
public class StatistiqueController implements Initializable {

    @FXML
    private PieChart Chart;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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

}
