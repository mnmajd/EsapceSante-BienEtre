/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Service_Medecin;
import Service.Service_service;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class ConsulterMonServiceController implements Initializable {

    @FXML
    private Label nom;

    @FXML
    private Label prenom;

    @FXML
    private ImageView image;

    @FXML
    private Label spec;

    @FXML
    private Label promotion;

    @FXML
    private Label lang;

    @FXML
    private Label ferme;

    @FXML
    private Label reglement;

    @FXML
    private Label tel;

    @FXML
    private Label adr;

    @FXML
    private Label mail;

    @FXML
    private Label tarif;

    @FXML
    private Button modif;
    @FXML
    private Button delete;
    @FXML
    private Button consulte;
    @FXML
    private Label ouvet;
     @FXML
    private Label cnam;
       
    
    static int ID;
    static Service_Medecin service_med;
    @FXML
    private TextField id;
    
    static String PRENOM;
    static String SPEC;
    static String DIPL;
    static String LANGUE;
    static String OUVERT;
    static String MODE;
    static float TARIF;
    static String FERME;
     static String NOM;
     static int TEL;
     static String ADR;
     static String MAIL;
     static String IMG;
     static String CNAM;
     static String IMAGE;
     static double LAT;
     static double LONGI;
    static Stage stg;
    @FXML
    private Button retour;
   
    @FXML
    void consulterservice(ActionEvent event) throws IOException {
         
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("FirstInterface.fxml")));
            stage.setScene(scene);
            stage.show();

    }

    @FXML
    void deleteservice(ActionEvent event) throws IOException {
      
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("DELETE");
        alert.setTitle("Confirmation");
     alert.initModality(Modality.APPLICATION_MODAL);
      alert.setContentText("Voulez-vous vraiment supprimer votre service " + " ? \n" +
                "Cette action est irreversible!");

        Button exitButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        exitButton.setText("Oui");
        Optional<ButtonType> resu = alert.showAndWait();
          if (ButtonType.OK.equals(resu.get())) {
        Service_service s= new Service_service();
        
       s.DeleteService(ID);
             Alert alertt = new Alert(Alert.AlertType.INFORMATION);
        alertt.setTitle("Retirer Service");
        alertt.setHeaderText(null);
        alertt.setContentText("Votre service n'est plus accessible");
        alertt.showAndWait();
          Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("FirstInterface.fxml")));
            stage.setScene(scene);
            stage.show();
            
          }
        

          }

    @FXML
    void modifierservice(ActionEvent event) throws IOException {
         ID = ConsulterMonServiceController.ID;
         NOM = ConsulterMonServiceController.NOM;
         PRENOM = ConsulterMonServiceController.PRENOM;
         MAIL = ConsulterMonServiceController.MAIL;
         ADR = ConsulterMonServiceController.ADR;
         LANGUE = ConsulterMonServiceController.LANGUE;
         DIPL = ConsulterMonServiceController.DIPL;
         MODE = ConsulterMonServiceController.MODE;
         TARIF = ConsulterMonServiceController.TARIF;
         TEL = ConsulterMonServiceController.TEL;
         FERME = ConsulterMonServiceController.FERME;
         OUVERT = ConsulterMonServiceController.OUVERT;
         CNAM=ConsulterMonServiceController.CNAM;
         IMG=ConsulterMonServiceController.IMAGE;
         LAT=ConsulterMonServiceController.LAT;
         LONGI= ConsulterMonServiceController.LONGI;
         
         System.out.println(IMG);

            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("ModifierMonService.fxml")));
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    void retour(ActionEvent event) throws IOException {
         Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("FirstInterface.fxml")));
            stage.setScene(scene);
            stage.show();

    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Service_service ss = new Service_service();
 List<Service_Medecin> serviceM = ss.findmedbyiduser(3);
      
 
  ID=serviceM.get(0).getId_service();
        id.setText(String.valueOf(ID));
        id.setVisible(false);
        
         NOM=serviceM.get(0).getNom();
        nom.setText(NOM);
        
          PRENOM=serviceM.get(0).getPrenom();
        prenom.setText(PRENOM);
        
         SPEC=serviceM.get(0).getSpecialite();
        spec.setText(SPEC);
        
          DIPL=serviceM.get(0).getPromotion();
        promotion.setText(DIPL);
          LANGUE=serviceM.get(0).getLangues_parlees();
        lang.setText(LANGUE);
        
         OUVERT=serviceM.get(0).getHeure_ouverture();
        ouvet.setText(OUVERT);
        
        FERME=serviceM.get(0).getHeure_fermeture();
        ferme.setText(FERME);
        
         MODE=serviceM.get(0).getModes_de_reglement();
        reglement.setText(MODE);
        
         TARIF=serviceM.get(0).getTarif();
        tarif.setText(String.valueOf(TARIF));
        
         CNAM=serviceM.get(0).getAssurance_maladie();
        cnam.setText(CNAM);
        
         TEL=serviceM.get(0).getTel_service();
        tel.setText(String.valueOf(TEL));
        
         ADR=serviceM.get(0).getAdresse_etab();
        adr.setText(ADR);
        
        LAT=serviceM.get(0).getLatitude();
        
        LONGI=serviceM.get(0).getLongitude();
        MAIL=serviceM.get(0).getE_mail();
        mail.setText(MAIL);
        
         IMAGE=serviceM.get(0).getImage_serv();
        System.out.println(IMAGE);
        /*final URL imageURL= getClass().getResource(IMAGE);
        final Image imag= new Image(imageURL.toExternalForm());
        System.out.println(IMAGE);*/
        Image imag = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/"+IMAGE);
        System.out.println();
        image.setImage(imag);
        
        
        


    }

}