/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import Service.UserDAO;

/**
 * FXML Controller class
 *
 * @author said hmidi
 */
public class FXMLstatController implements Initializable {

    @FXML
    private PieChart PieChart1;
 @FXML
    private Label status;
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
       // PieChart1.setData(pieChartData);
        for(final PieChart.Data data : PieChart1.getData() )
        {
        data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                status.setText(data.getPieValue()+"%");
               
                
                
                 ObservableList<PieChart.Data> pieChartData = 
                FXCollections.observableArrayList();
        PieChart1.setTitle("");
        PieChart1.setData(pieChartData);
            }
        
        
        });
        }
         return new PieChart(pieChartData);
    }

}
