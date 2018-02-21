/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package GUI.admin;


import entites.User;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import services.*;


public class StatistiqueViewController implements Initializable {

    @FXML
    private PieChart PieChart1;
    private UserDAO userDAO= new UserDAO();
   
    @FXML
    private PieChart PieChart11;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         List<User> ls =userDAO.findAll();
         List<User> ls2=userDAO.findAllClients();
         List<Newsletter> ls3= news.findAll();
         int nb_Membre =ls2.size();
         int nb_Prestataire= ls.size()-ls2.size()-1;
         int nb_abonné=nb_Membre-ls3.size();
        
         ObservableList<PieChart.Data> pieChartData =FXCollections.observableArrayList();
         pieChartData.add(new PieChart.Data("Membre",nb_Membre));
         pieChartData.add(new PieChart.Data("Prestataire",nb_Prestataire));
         PieChart1.setData(pieChartData);
         PieChart1.setTitle("Disponnibilité des users");
//         
//         ObservableList<PieChart.Data> pieChartData2 =FXCollections.observableArrayList();
//         pieChartData2.add(new PieChart.Data("Abonnée",nb_abonné));
//         pieChartData2.add(new PieChart.Data("non abonnée",nb_client-1));
//         PieChart11.setData(pieChartData);
//         PieChart11.setTitle("ABONNEE");
    }    

   
    
}
*/