package GUI;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import com.itextpdf.text.Document;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
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
//import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Interface_detail_offreController implements Initializable {

    @FXML
    private Label titre;
    @FXML
    private Label Description;
    @FXML
    private Label date;
    @FXML
    private Label adresse;
  
    @FXML
    private Button telecharger;
    @FXML
    private Label tel;
    @FXML
    private Button retour2;
    @FXML
    private ImageView logo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
   ImageView img = new ImageView(Main_offre.chimg);
//        img.setFitHeight(130);
//        img.setFitWidth(120);
//        File F = new File ("C:\\Users\\tarek\\Desktop\\OmarLarnaout\\Pidev\\EsapceSante-BienEtre\\image");
//        //logo.setImage.decodeBase64("file:/C:/Users/tarek/Desktop/22405481_1642856965737868_2504216914193461441_n.jpg");
//        Image image = new Image(F.toURI().toString());
//        logo.setImage(image);
        titre.setText(Main_offre.chtitre);
        
        Description.setText(Main_offre.chdescription);
        date.setText(Main_offre.chdate);
        tel.setText(Main_offre.chtel);
        adresse.setText(Main_offre.chadress);
        //logo.setText(Main_offre.chimg);
       

    }

    @FXML
    private void telecharger(ActionEvent event) {
        try {

            Document doc = new Document(PageSize.A4, 50, 50, 50, 50);
            try {
                PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("C:\\pdf java\\annonce.pdf"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Interface_afficher_offreController.class.getName()).log(Level.SEVERE, null, ex);
            }

            doc.open();

            String titre1 = titre.getText();
            String titre2 = Description.getText();
            String titre3 = date.getText();
            String titre4 = tel.getText();
            String titre5 = adresse.getText();
         //   String titre6 = logo.getText();

            Anchor anchorTarget = new Anchor("test field.");

            String P1 = ("titre de l'offre : " + titre1);
            P1 += "\n";
            String P2 = ("description de l'offre : " + titre2);
            P2 += "\n";
            String P3 = ("la date de l'offre: " + titre3);
            P3 += "\n";
            String P4 = ("numero de téléphone : " + titre4);
            P4 += "\n";
            String P5 = ("l'adresse du local : " + titre5);
            P5 += "\n";
          //  String P6 = ("logo : " + titre6);

            anchorTarget.setName("BackToTop");

            Paragraph paragraph1 = new Paragraph();
            Paragraph paragraph2 = new Paragraph();
            Paragraph paragraph3 = new Paragraph();
            Paragraph paragraph4 = new Paragraph();
            Paragraph paragraph5 = new Paragraph();
            Paragraph paragraph6 = new Paragraph();

            paragraph1.setSpacingBefore(50);
            paragraph2.setSpacingBefore(50);
            paragraph3.setSpacingBefore(50);
            paragraph4.setSpacingBefore(50);
            paragraph5.setSpacingBefore(50);
            paragraph6.setSpacingBefore(50);

            paragraph1.add(P1);
            paragraph1.add(P2);
            paragraph1.add(P3);
            paragraph1.add(P4);
            paragraph1.add(P5);
           // paragraph1.add(P6);

            doc.add(paragraph1);
            doc.add(paragraph2);
            doc.add(paragraph3);
            doc.add(paragraph4);
            doc.add(paragraph5);
            doc.add(paragraph6);

            doc.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Pdf saved");
            Optional<ButtonType> result = alert.showAndWait();

        } catch (DocumentException ex) {
            Logger.getLogger(Interface_afficher_offreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void retour2(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interface_afficher_offre.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            NewFXMain.stage.close();
            NewFXMain.stage = stage;
            Main_offre.stage.close();

        } catch (IOException ex) {
            Logger.getLogger(Interface_afficher_offreController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
