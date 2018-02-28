/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Service;
import Entite.Service_Medecin;
import static GUI.MapController.k;
import Service.Service_service;
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
import java.awt.image.BufferedImage;
//import com.sun.org.apache.xerces.internal.util.URI;
//import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import static java.awt.PageAttributes.MediaType.A;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

import java.net.URL;
import java.sql.Date;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import static javafx.scene.control.Alert.AlertType.ERROR;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class AjoutServiceMedController implements Initializable, MapComponentInitializedListener {

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField mail;

    @FXML
    private TextField tel;

    @FXML
    private TextField adr;

    @FXML
    private ComboBox<String> spec;

    @FXML
    private Button imf;
    @FXML
    private CheckBox espece;

    @FXML
    private CheckBox cheque;

    @FXML
    private CheckBox carte;

    @FXML
    private TextField ouvert;

    @FXML
    private TextField ferme;

    @FXML
    private TextField tarif;

    @FXML
    private TextArea promo;

    @FXML
    private Label lab;
    @FXML
    private ImageView idimg;
    @FXML
    private Button valider_btn;
    @FXML
    private Button resetbtn;
    @FXML
    private CheckBox anglais;
    @FXML
    private CheckBox francais;
    @FXML
    private CheckBox arabe;
    @FXML
    private CheckBox yes;
    @FXML
    private CheckBox No;

    
    static int ID;
    static String NON;
    static String PRENOM;
    static String SPEC;
    static String DIPLOME;
    static String LANGUES;
    static String OUVERT;
    static String REG;
    static float TARIF;
    static String FERME;
    static String ASS;
    static int TEL;
    static String ADRS;
    static String MAIL;
    static Stage stg;
    static double LAN;
    static double LONGI;
    public String  imageUrl;
    
    int file = 0;
    int c ;
     File pDir ;
     File pfile ;
      String lien ;
    @FXML
    private ImageView img;
//    @FXML
//    private TextField lat;
//    @FXML
//    private TextField longi;
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
    private TextField recherche;
    
         private void choisirimage(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();

    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
        try {
            imageUrl = file.toURI().toURL().toExternalForm();
            lab.setText(imageUrl);
            
        } catch (MalformedURLException ex) {
            throw new IllegalStateException(ex);
            
        }
    }
   
            }  
            
 @FXML
    public void max8(KeyEvent event) {
        int maxCharacters = 8;
        if (tel.getText().length() > maxCharacters) {
            event.consume();
        }

    }

    ObservableList specialités = FXCollections.observableArrayList(
            "Dentiste", "Cardiologue", "Dermatologue", "Généraliste", "Ophtalmologue", "Pédiatre");

    public String getPromotion() {
        return promo.getText();
    }
//
//    public String getLangues_parlees() {
//        return CheckBox.;
//    }
//
//    public String getAssurance_maladie() {
//        return yes.getText();
//    }
//
    public String getModes_de_reglement1() {
        return carte.getText();
    }
public String getModes_de_reglement() {
        return cheque.getText();
        
    }
public String getModes_de_reglement3() {
        return espece.getText();
    }
    public float getTarif() {
        return Float.parseFloat(tarif.getText());
    }

    public String getNom() {
        return nom.getText();
    }

    public String getPrenom() {
        return prenom.getText();
    }

    public String getSpecialite() {
        return spec.getValue();
    }

    public String getE_mail() {
        return mail.getText();
    }

    public int getTel_service() {
        return Integer.parseInt(tel.getText());
    }

    public String getAdresse_etab() {
        return adr.getText();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        file = 0;
         toTextField.setVisible(false);
        fromTextField.setVisible(false);     
        
        mapView.addMapInializedListener(this);

        address.bind(recherche.textProperty());
        
        lab.setVisible(false);
        spec.setItems(specialités);
         c = (int)( Math.random()*( 300000 - 2 + 1 ) ) + 2; 
             pDir = new File("src/GUI/Images/objet"+c+".jpg");
                lien = "Images/objet"+c+".jpg" ;
                System.out.println(LAN= MapController.k);
                 System.out.println(LAN= MapController.l);
//                lat.setText(String.valueOf(LAN= MapController.k));
//                longi.setText(String.valueOf(LONGI = MapController.l));
//                adr.setText(MapController.ADR);
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

            map = mapView.createMap(mapOptions);

            map.addMouseEventHandler(UIEventType.click, (GMapMouseEvent event) -> {
                LatLong latLong = event.getLatLong();
                fromTextField.setText(String.valueOf(latLong.getLatitude()));
                toTextField.setText(String.valueOf(latLong.getLongitude()));
                
                markerOptions1.position(latLong)
                        .visible(true)
                        .title("helllo");
                m.setOptions(markerOptions1);

                map.addMarker(m);
            });
        }

    }
    

    @FXML
    public void reset() {
        promo.clear();
//spec.setValue("Precisez votre specialité");
        tarif.clear();
        ouvert.clear();
        ferme.clear();
        mail.clear();
        adr.clear();
        tel.clear();
        spec.getSelectionModel().clearSelection();
        arabe.setSelected(false);
        anglais.setSelected(false);
        francais.setSelected(false);
        espece.setSelected(false);
        cheque.setSelected(false);
        carte.setSelected(false);
        yes.setSelected(false);
        No.setSelected(false);
        nom.clear();
        prenom.clear();
      img.setImage(null);

        spec.getSelectionModel().clearSelection();

    }

    @FXML
    void addMed(ActionEvent event) throws IOException {
    file = 0;
        Service_service s = new Service_service();

        if ( validateFields()& validatenom()& validateEmaill()& validateprenom()& validatetarif()& validateMobileNo()& validateouvert()&validateferme())
       
        
        {

            String x = "";
            if (anglais.isSelected()) {
                x += anglais.getText() + "\n";
            }
            if (francais.isSelected()) {
                x += francais.getText() + "\n";
            }
            if (arabe.isSelected()) {
                x += arabe.getText() + "\n";
            }

            String a = "";
            if (espece.isSelected()) {
                a += espece.getText() + "\n";
            }
            if (cheque.isSelected()) {
                a += cheque.getText() + "\n";
            }
            if (carte.isSelected()) {
                a += carte.getText() + "\n";
            }
            
            if ((file == 0)) {
            File m = new File("C:\\Users\\chayma\\Documents\\NetBeansProjects\\EsapceSante-BienEtre\\src\\Interfaces\\images\\not.png");
            copier( m,pDir) ;
            Service_Medecin sm = new Service_Medecin(ouvert.getText(), ferme.getText(), promo.getText(), Float.parseFloat(tarif.getText()),
                    mail.getText(), adr.getText(), Integer.parseInt(tel.getText()), lien, x, a,
                    b,
                    nom.getText(), prenom.getText(), spec.getSelectionModel().getSelectedItem(),Double.parseDouble(fromTextField.getText()),Double.parseDouble(toTextField.getText()));
           
            s.addserviceMed(sm);
              saveAlert(sm);
            reset();
            }
             else if ((file == 1)) {
                  copier( pfile,pDir) ;
            Service_Medecin sm = new Service_Medecin(ouvert.getText(), ferme.getText(), promo.getText(), Float.parseFloat(tarif.getText()),
                    mail.getText(), adr.getText(), Integer.parseInt(tel.getText()), lien, x, a,
                    b,
                    nom.getText(), prenom.getText(), spec.getSelectionModel().getSelectedItem(),Double.parseDouble(fromTextField.getText()),Double.parseDouble(toTextField.getText()));
           
            s.addserviceMed(sm);
               
            PRENOM=prenom.getText();
            SPEC=spec.getSelectionModel().getSelectedItem();
            ADRS=adr.getText();
            MAIL=mail.getText();
            OUVERT=ouvert.getText();
            FERME=ferme.getText();
            DIPLOME=promo.getText();
            REG=a;
            LANGUES=b;
            TARIF=Float.parseFloat(tarif.getText());
            TEL=Integer.parseInt(tel.getText());
            imageUrl=lab.getText();
            ASS=x;
            
            saveAlert(sm);
            reset();
             }
//              FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConsulterMonService.fxml"));
//            Parent root = (Parent) fxmlLoader.load();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));  
//            stage.show();
            
            
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("ConsulterMonService.fxml")));
            stage.setScene(scene);
            stage.show();
        }
       
    }

    public static boolean copier(File source, File dest) {
        try (InputStream sourceFile = new java.io.FileInputStream(source);
                OutputStream destinationFile = new FileOutputStream(dest)) {
            // Lecture par segment de 0.5Mo  
            byte buffer[] = new byte[512 * 1024];
            int nbLecture;
            while ((nbLecture = sourceFile.read(buffer)) != -1) {
                destinationFile.write(buffer, 0, nbLecture);
            }
        } catch (IOException e) {
            e.printStackTrace();
           
        }
        return true; // Résultat OK   
    }

    private void saveAlert(Service_Medecin sm) {

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Service saved successfully.");
        alert.setHeaderText(null);
        alert.setContentText("The service of  " + sm.getSpecialite() + " has been created");
        alert.showAndWait();
    }

    
    
    private void updateAlert(Service_Medecin sm) {

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Service updated successfully.");
        alert.setHeaderText(null);
        alert.setContentText("Your service has been updated.");
        alert.showAndWait();
    }

    private void validationAlert(String field, boolean empty) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        if (field.equals("modes_de_reglement") || field.equals("langues_parlees") || field.equals("specialite")) {
            alert.setContentText("Please Select " + field);
        } else {
            if (empty) {
                alert.setContentText("Please Enter " + field);
               // FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ajout.fxml"));
            } else {
                alert.setContentText("Please Enter Valid " + field);
            }
        }
        alert.showAndWait();
    }

    private boolean emptyValidation(String field, boolean empty) {
        if (!empty) {
            return true;
        } else {
            validationAlert(field, true);
            return false;
        }
    }

    private boolean validatetarif(){
        Pattern p = Pattern.compile("[0-9]*\\.?[0-9]+");
        Matcher m = p.matcher(tarif.getText());
        if(m.find() && m.group().equals(tarif.getText())){
            return true;
        }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate Number");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid tarif");
                alert.showAndWait();
            
            return false;            
        }
    }
     private boolean validateouvert(){
        Pattern p = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
        Matcher m = p.matcher(ouvert.getText());
        if(m.find() && m.group().equals(ouvert.getText())){
            return true;
        }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate Number");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid Date d'ouverture");
                alert.showAndWait();
            
            return false;            
        }
    }
     
      private boolean validateferme(){
        Pattern p = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
        Matcher m = p.matcher(ferme.getText());
        if(m.find() && m.group().equals(ferme.getText())){
            return true;
        }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate Number");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid Date de fermeture");
                alert.showAndWait();
            
            return false;            
        }
    }
    
    private boolean validatenom(){
    Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(nom.getText());
        if(m.find() && m.group().equals(nom.getText())){
            return true;
        }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate nom");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid First Name");
                alert.showAndWait();
            
            return false;            
        }
    }
        private boolean validateprenom(){
    Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(prenom.getText());
        if(m.find() && m.group().equals(prenom.getText())){
            return true;
        }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate prenom");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid First Name");
                alert.showAndWait();
            
            return false;            
        }
    }
        
       private boolean validateEmaill(){
             List<Service_Medecin> list;
   list=Service_service.findmedbymail(mail.getText());
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(mail.getText());
        if(m.find() && m.group().equals(mail.getText())&& (list.isEmpty())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validate Email");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid Email");
                alert.showAndWait();
            
            return false;            
        }
    }
        
        private boolean validateFields(){
        if( adr.getText().isEmpty()){
            
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate Fields");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Into The Fields");
                alert.showAndWait();
                
                return false;
        }
        if(ouvert.getText().isEmpty()){
            
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate Fields");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter The Date d'ouverture");
                alert.showAndWait();
                
                return false;
        }
        if(ferme.getText().isEmpty()){
            
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate Fields");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter The Date de fermeture");
                alert.showAndWait();
                
                return false;
        }
        
         if(promo.getText().isEmpty()){
            
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate Fields");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter The Diplome");
                alert.showAndWait();
                
                return false;
        }
        if(!(arabe.isSelected() | francais.isSelected() | anglais.isSelected())){
            
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate Fields");
                alert.setHeaderText(null);
                alert.setContentText("Please choose a language");
                alert.showAndWait();
                
                return false;
        }
         if(!(espece.isSelected() | carte.isSelected() | cheque.isSelected())){
            
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate Fields");
                alert.setHeaderText(null);
                alert.setContentText("Please choose mode de réglement");
                alert.showAndWait();
                
                return false;
        }
        if(!(yes.isSelected() | No.isSelected())){
            
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate Fields");
                alert.setHeaderText(null);
                alert.setContentText("Please Select yes or no ");
                alert.showAndWait();
                
                return false;
        }
        
         if(lien.isEmpty()){
            
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate Fields");
                alert.setHeaderText(null);
                alert.setContentText("Please choose an image");
                alert.showAndWait();
                
                return false;
        }
         if((spec.getSelectionModel().isEmpty())){
            
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Validate Fields");
                alert.setHeaderText(null);
                alert.setContentText("Please Select specialité ");
                alert.showAndWait();
                
                return false;
        }
        
        return true;
    }
        
        private boolean validateMobileNo(){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(tel.getText());
        if(m.find() && m.group().equals(tel.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validate Mobile Number");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid Mobile Number");
                alert.showAndWait();
            
            return false;            
        }
    }
    
        
        
        
        
        
    private boolean validate(String field, String value, String pattern) {
        if (!value.isEmpty()) {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(value);
            if (m.find() && m.group().equals(value)) {
                return true;
            } else {
                validationAlert(field, false);
                return false;
                
            }
            
        } else {
            validationAlert(field, true);
            return false;
        }
        
    }

    String b = "";

    @FXML

    private void YesBox(ActionEvent event) {

        if (yes.isSelected()) {
            b = yes.getText();
            No.setSelected(false);
        }

    }

    @FXML
    private void NoBox(ActionEvent event) {
        if (No.isSelected()) {
            b = No.getText();
            yes.setSelected(false);
        }

    }

 
    
    
     @FXML
    private void choose(ActionEvent event) throws MalformedURLException {
        
         FileChooser fileChooser = new FileChooser();
fileChooser.setTitle( "Choisir image" );
    
/* - get saved directory - or get user`s home dir */

/* - set filters */
    
fileChooser.getExtensionFilters().addAll(
  new FileChooser.ExtensionFilter( "JPG", "*.jpg" ),
  new FileChooser.ExtensionFilter( "PNG", "*.png" ),
  new FileChooser.ExtensionFilter( "BMP", "*.bmp" )
);
    
/* - open dialog */
    
        Window stage = null;
        pfile = fileChooser.showOpenDialog(stage);

/* - draw image */
    
if ( pfile != null )
{      
      
  /* -- read image */
    
    imf.setText("image sélectionné");
      
  Image image = new Image( pfile.toURI().toURL().toExternalForm() );
        img.setImage(image);

        
    }

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
   adr.setText(String.valueOf(recherche.getText()));
        });
    }

 

}