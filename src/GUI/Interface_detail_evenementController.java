/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.Interface_afficher_evenementController.chdate;
import static GUI.Interface_afficher_evenementController.chadress;
import static GUI.Interface_afficher_evenementController.chdescription;
import static GUI.Interface_afficher_evenementController.chimg;
import static GUI.Interface_afficher_evenementController.chtel;
import static GUI.Interface_afficher_evenementController.chtitre;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

 

public class Interface_detail_evenementController implements Initializable {

    @FXML
    private Button retour2E;
    @FXML
    private Label titre;
    @FXML
    private Label Description;
    @FXML
    private Label date;
    @FXML
    private Label adresse;
    @FXML
    private Label tel;
    @FXML
    private ImageView logo;
    @FXML
    private Button telechargerE;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          Image img = new Image("/GUI/Images/majdpic.jpg",true);
        logo.setImage(img);
        logo.setFitHeight(130);
        logo.setFitWidth(120);
        
        titre.setText(chtitre);
        Description.setText(chdescription);
        date.setText(chdate);
        tel.setText(chtel);
        adresse.setText(chadress);
        
    }    


   @FXML
    private void telechargerE(ActionEvent event) {
//        
//  try {
//
//            Document doc = new Document(PageSize.A4, 50, 50, 50, 50);
//            try {
//                PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("//home/majd/Desktop/pIDEv/annonce.pdf"));
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(Interface_afficher_offreController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            doc.open();
//
//            String titre1 = titre.getText();
//            String titre2 = Description.getText();
//            String titre3 = date.getText();
//            String titre4 = tel.getText();
//            String titre5 = adresse.getText();
//            Image titre6 = logo.getImage();
//
//            Anchor anchorTarget = new Anchor("test field.");
//
//            String P1 = ("titre de l'offre : " + titre1);
//            P1 += "\n";
//            String P2 = ("description de l'offre : " + titre2);
//            P2 += "\n";
//            String P3 = ("la date de l'offre: " + titre3);
//            P3 += "\n";
//            String P4 = ("numero de téléphone : " + titre4);
//            P4 += "\n";
//            String P5 = ("l'adresse du local : " + titre5);
//            P5 += "\n";
//            String P6 = ("logo : " + titre6);
//
//            anchorTarget.setName("BackToTop");
//
//            Paragraph paragraph1 = new Paragraph();
//            Paragraph paragraph2 = new Paragraph();
//            Paragraph paragraph3 = new Paragraph();
//            Paragraph paragraph4 = new Paragraph();
//            Paragraph paragraph5 = new Paragraph();
//            Paragraph paragraph6 = new Paragraph();
//
//            paragraph1.setSpacingBefore(50);
//            paragraph2.setSpacingBefore(50);
//            paragraph3.setSpacingBefore(50);
//            paragraph4.setSpacingBefore(50);
//            paragraph5.setSpacingBefore(50);
//            paragraph6.setSpacingBefore(50);
//
//            paragraph1.add(P1);
//            paragraph1.add(P2);
//            paragraph1.add(P3);
//            paragraph1.add(P4);
//            paragraph1.add(P5);
//            paragraph1.add(P6);
//
//            doc.add(paragraph1);
//            doc.add(paragraph2);
//            doc.add(paragraph3);
//            doc.add(paragraph4);
//            doc.add(paragraph5);
//            doc.add(paragraph6);
//
//            doc.close();
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setHeaderText("Pdf saved");
//            Optional<ButtonType> result = alert.showAndWait();
//
//        } catch (DocumentException ex) {
//            Logger.getLogger(Interface_afficher_offreController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
        
     @FXML
    private void retour2E(ActionEvent event) {
    try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interface_afficher_evenement.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
             FXMain.stg.close();
             FXMain.stg = stage;

        } catch (IOException ex) {
            Logger.getLogger(Interface_afficher_offreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    }
    

