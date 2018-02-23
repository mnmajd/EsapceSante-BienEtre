/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import services.UserDAO;

/**
 * FXML Controller class
 *
 * @author said hmidi
 */
public class FXMLstatController implements Initializable {

    @FXML
    private PieChart PieChart1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
        
        PieChart1.setData(createPieChart().getData());
        PieChart1.setLabelsVisible(true);
                

    }    

    private PieChart createPieChart() {
        UserDAO service = new UserDAO();
        
                ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
             new PieChart.Data("Homme", service.statistiquehomme()),
             new PieChart.Data("Femme", service.statistiquefemme())
         );
        return new PieChart(pieChartData);
    }
    
}
