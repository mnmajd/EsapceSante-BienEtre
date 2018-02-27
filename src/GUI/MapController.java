/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Service_Medecin;
import Service.Service_service;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author chayma
 */
public class MapController implements Initializable, MapComponentInitializedListener {

    static double k;
    static double l;
    static String ADR;
    private GoogleMap map;
    private GeocodingService geocodingService;
    @FXML
    private GoogleMapView mapView;
    @FXML
    private TextField fromTextField;
    @FXML
    private TextField toTextField;
    @FXML
    private Button enregistrer;
    @FXML
    private TextField recherche;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toTextField.setVisible(true);
        fromTextField.setVisible(true);     
        
        mapView.addMapInializedListener(this);

        address.bind(recherche.textProperty());
    }

    @Override
    public void mapInitialized() {

        geocodingService = new GeocodingService();
        MapOptions mapOptions = new MapOptions();
        Service_service C = new Service_service();
        List<Service_Medecin> p = null;
        p = C.SelectServiceMED1("medecin");
        for (int i = 0; i < p.size(); i++) {
            LatLong Location = new LatLong(p.get(i).getLongitude(), p.get(i).getLatitude());
            MarkerOptions markerOptions1 = new MarkerOptions();
            //LatLong x = new LatLong(36.898392,10.189732);
            Marker m = new Marker(markerOptions1);
            System.out.println(Location);
            mapOptions.center(Location)
                    .mapType(MapTypeIdEnum.ROADMAP)
                    .overviewMapControl(false)
                    .panControl(false)
                    .rotateControl(false)
                    .scaleControl(false)
                    .streetViewControl(false)
                    .zoomControl(false)
                    .zoom(12);
//            double lat=36.898392;
//double lng=10.189732;
//  MarkerOptions markerOptions1 = new MarkerOptions();
//                markerOptions1.position(x)
//                        .visible(true)
//                        .title("helllo");
            //    Marker joeSmithMarker = new Marker(markerOptions1);
            //    map.addMarker(joeSmithMarker);

            map = mapView.createMap(mapOptions);

            map.addMouseEventHandler(UIEventType.click, (GMapMouseEvent event) -> {
                LatLong latLong = event.getLatLong();
                fromTextField.setText(String.valueOf(latLong.getLatitude()));
                toTextField.setText(String.valueOf(latLong.getLongitude()));
                //ADR= recherche.getText();
                markerOptions1.position(latLong)
                        .visible(true)
                        .title("helllo");
                m.setOptions(markerOptions1);

                map.addMarker(m);
            });
        }
//

//            List<Service_Medecin> Lis = null;
//            Lis = C.SelectServiceMED("medecin");
//            for (int i = 0; i < Lis.size(); i++) {
//                LatLong Location = new LatLong(Lis.get(i).getLongitude(), Lis.get(i).getLatitude());
//                MarkerOptions markerOptions1 = new MarkerOptions();
//                markerOptions1.position(Location)
//                        .visible(true)
//                        .title(Lis.get(i).getNom());
//                Marker joeSmithMarker = new Marker(markerOptions1);
//                map.addMarker(joeSmithMarker);
//           }
//
//
//           }
    }

    @FXML
    private void Enregistrer(ActionEvent event) throws SQLException, IOException {
        Service_service C = new Service_service();
        k = (Double.valueOf(fromTextField.getText()));
        l = (Double.valueOf(toTextField.getText()));
        ADR = recherche.getText();

        Service_Medecin p = new Service_Medecin();
        // Service_Medecin p = new Service_Medecin(5, "test", Double.parseDouble(fromTextField.getText()), Double.parseDouble(toTextField.getText()), 5, "no", "no", "no");
        //C.updateTest(p);

//            Stage stage = (Stage) enregistrer.getScene().getWindow();
//             //do what you have to do
//            stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjoutServiceMed.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Ajout Service");
        stage.show();
    }
    private StringProperty address = new SimpleStringProperty();

    @FXML
    private void search(ActionEvent event) {
        geocodingService.geocode(address.get(), (GeocodingResult[] results, GeocoderStatus status) -> {

            LatLong latLong = null;

            if (status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                alert.show();
                return;
            } else if (results.length > 1) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            }

            map.setCenter(latLong);

        });
    }

}