/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class ConsulterServiceMEDController implements Initializable, MapComponentInitializedListener {

    @FXML
    private ImageView image;
    @FXML
    private Label nom;
    @FXML
    private Label spec;
    @FXML
    private Label cnam;
    @FXML
    private Label tarif;
    @FXML
    private Label langue;
    @FXML
    private Label dip;
    @FXML
    private Label ouvert;
    @FXML
    private Label ferme;

    @FXML
    private Label mail;
    @FXML
    private Label tel;
    @FXML
    private Label reg;
    static String PRENOM;
    static String SPEC;
    static String DIPLOME;
    static String LANGUES;
    static String OUVERT;
    static String REG;
    static float TARIF;
    static String FERME;
    static String NOM;
    static int ID;
    static int TEL;
    static String ADRS;
    static String MAIL;
    static String IMG;
    static String CNAM;
    static double k;
    static double l;
    static Stage stg;
    private GoogleMap map;
    private GeocodingService geocodingService;
    @FXML
    private GoogleMapView mapView;
    @FXML
    private TextField altitude;
    @FXML
    private TextField longitude;
    @FXML
    private ImageView cnam1;
    String lien;
    @FXML
    private ImageView espece;
    @FXML
    private ImageView carteb;
    @FXML
    private ImageView cheq;
    @FXML
    private Label pren;
    @FXML
    private ImageView curs;
    @FXML
    private ImageView ou;
    @FXML
    private ImageView xx;
    @FXML
    private ImageView uh;
    @FXML
    private ImageView c;
    @FXML
    private ImageView t;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        altitude.setVisible(false);
        longitude.setVisible(false);
        // dip.setEditable(false);
        mapView.addMapInializedListener(this);

        nom.setText(NOM = FirstInterfaceController.nom);
        pren.setText(PRENOM= FirstInterfaceController.PRENOM);
        spec.setText(SPEC = FirstInterfaceController.SPEC);
        dip.setText(DIPLOME = FirstInterfaceController.DIPLOME);
        langue.setText(LANGUES = FirstInterfaceController.LANGUES);
        ouvert.setText(OUVERT = FirstInterfaceController.OUVERT);
        ferme.setText(FERME = FirstInterfaceController.FERME);
        reg.setText(REG = FirstInterfaceController.REG);
        if (REG.equals("Espéce")) {
            ImageView regg = new ImageView();
            Image regimg = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/images/monnaie.png", 250, 250, false, false);
            espece.setImage(regimg);
        } else if (REG.equals("EspéceChéque")) {
          
            Image regimg1 = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/images/monnaie.png", 250, 250, false, false);
            espece.setImage(regimg1);

            Image regimg2 = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/images/cheque-icon.png", 250, 250, false, false);
            cheq.setImage(regimg2);
        } else if (REG.equals("EspéceChéqueCarte bancaire")){
          
            Image regimg3 = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/images/monnaie.png", 250, 250, false, false);
            carteb.setImage(regimg3);
            
            Image regimg4 = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/images/cheque-icon.png", 250, 250, false, false);
            cheq.setImage(regimg4);
            
            Image regimg5 = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/images/payment-cb.png", 250, 250, false, false);
            cheq.setImage(regimg5);
        }
        else if (REG.equals("Chéque")) {
          
            Image regimg6 = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/images/cheque-icon.png", 250, 250, false, false);
            espece.setImage(regimg6);
            
        } else if (REG.equals("ChéqueCarte bancaire")){
          
            Image regimg7 = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/images/cheque-icon.png", 250, 250, false, false);
            carteb.setImage(regimg7);
            
            Image regimg8 = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/images/payment-cb.png", 250, 250, false, false);
            cheq.setImage(regimg8);
            
        }
        else if (REG.equals("Carte bancaire")) {
          
            Image regimg9 = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/images/payment-cb.png", 250, 250, false, false);
            espece.setImage(regimg9);
            
        } else if (REG.equals("EspéceCarte bancaire")){
          
            Image regimg10 = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/images/monnaie.png", 250, 250, false, false);
            carteb.setImage(regimg10);
            
            Image regimg11 = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/images/payment-cb.png", 250, 250, false, false);
            cheq.setImage(regimg11);
            
        }

        tarif.setText(String.valueOf(TARIF = FirstInterfaceController.TARIF));
        tel.setText(String.valueOf(TEL = FirstInterfaceController.TEL));
        altitude.setText(String.valueOf(l = FirstInterfaceController.LAT));
        longitude.setText(String.valueOf(k = FirstInterfaceController.LONGI));
        mail.setText(MAIL = FirstInterfaceController.MAIL);
        cnam.setText(CNAM = FirstInterfaceController.CNAM);
        cnam.setVisible(false);
        if (CNAM.equals("Oui")) {
            ImageView cna = new ImageView();
            Image cnamimg = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/images/cnam2.png", 250, 250, false, false);
            cnam1.setImage(cnamimg);
        } else {
            // ImageView cna = new ImageView();
            Image cnamimgg = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/images/cc.png", 40, 40, false, false);
            cnam1.setImage(cnamimgg);
        }
//            lien="src/Interfaces/images/cnaam.jpg";
//            cnam1.setImage(lien);
        // Image i= new Image("src/Interfaces/images/cnaam.jpg");
        // Image cnam1=new Image(lien);

        String IMAGE = FirstInterfaceController.IMG;
        //final URL imageURL = getClass().getResource(IMG = FirstInterfaceController.IMG);
        Image image1 = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/" + IMAGE);
        image.setImage(image1);

    }

    @Override
    public void mapInitialized() {

        //geocodingService = new GeocodingService();
        MapOptions mapOptions = new MapOptions();
        LatLong Location = new LatLong(l, k);
        MarkerOptions markerOptions1 = new MarkerOptions();
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
        map = mapView.createMap(mapOptions);
        map.addMouseEventHandler(UIEventType.click, (GMapMouseEvent event) -> {
            markerOptions1.position(Location)
                    .visible(true)
                    .title(NOM);
            m.setOptions(markerOptions1);

            map.addMarker(m);
        });
    }

}