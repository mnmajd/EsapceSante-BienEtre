/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Article;
import Entite.CategorieArticle;

import Service.Article_Service;
import Service.Categ_Service;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author TAQWA
 */
public class FXMLmodifController implements Initializable {

    @FXML
    private Button idimageM;
    @FXML
    private TextField idtitre;
    @FXML
    private TextField idsujet;
    @FXML
    private TextArea idcontenu;
    @FXML
     private ComboBox<?>  choixM;
     private String imageUrl;
    @FXML
    private Button btnModif;
    int id = AjouBlogController.x ;
    
    String tx1 = AjouBlogController.t ;
     String tx2 = AjouBlogController.t2 ;
      String tx3 = AjouBlogController.t3 ;
      String choix = AjouBlogController.choix ;
       ListView<Article> liste = AjouBlogController.list ;
//    String tx2 = AjouBlogController.tx2 ;
//    String tx3 = AjouBlogController.tx3 ; 
//    String tx4 = AjouBlogController.tx4 ;
//    String im5 = AjouBlogController.im5 ;
    
    
    
    
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   idtitre.setText(tx1);
    idsujet.setText(tx2);
   idcontenu.setText(tx3);

       
           //setText(tx1);
      
//      idsujet.setText(tx3);
//      idcontenu.setText(tx4); 
//      
      
         CategorieArticle C = new CategorieArticle();
       Categ_Service caa = new Categ_Service();
       List<String> listeCateg = caa.afficherCateg();
       ObservableList catego = FXCollections.observableArrayList(
        listeCateg 
        );
   
       choixM.setItems(catego);
       
        // TODO
    }    

    @FXML
    private void ajoutimgM(ActionEvent event) {
       
        FileChooser fileChooser = new FileChooser();

    //Set extension filter


    //Show open file dialog
    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
        try {
            imageUrl = file.toURI().toURL().toExternalForm();
            //Image image = new Image(imageUrl);
            //pic.setImage(image);
            System.out.println("image "+imageUrl);
            
        } catch (MalformedURLException ex) {
            throw new IllegalStateException(ex);
            
        }
    }

    }

    @FXML
    private void ModifArticle(ActionEvent event) throws IOException {
      
       
      
         Article_Service serv = new Article_Service() ;
      
      GridPane grid = new GridPane();
      ImageView img = new ImageView(imageUrl);

      grid.add(img,0 ,0);
      
    
      
       String  titre = idtitre.getText();
     String  sujet = idsujet.getText();
     String contenu = idcontenu.getText();
     //String img  
     String choix =  (String) choixM.getValue();
     Categ_Service cs = new Categ_Service();
     int id_categ = Integer.parseInt(cs.GetIDGateg(choix));
        
        if ("".equals(titre) || "".equals(sujet) || "".equals(contenu)
                || imageUrl == null || "".equals(choix)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(" Alert ");
            alert.setContentText("Remplir les champs ");
            alert.showAndWait();

        }
        else {
         
              //   ObservableList<Article> data = FXCollections.observableArrayList();
       
        
           
           
            Article article = new Article(titre,sujet,contenu,imageUrl,2,id_categ);
            serv.updateArticle(article,id);
              
   //   ObservableList<Article> serviceM = serv.getArticleUser(2);
    
         
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("FXMain.fxml")));
            stage.setScene(scene);
            stage.show();

//    
//list.getItems().clear();
//      list.getItems().addAll(serv.getArticleUser(2));
////                     
//                                list.refresh();
 liste.getItems().clear();
      liste.getItems().addAll(serv.getArticleUser(2));
//                         data.addAll(0, serviceM);
                       // data.addAll(FXCollections.observableArrayList(ss.getArticleUser(2)));
                                liste.refresh();
     
                   }
                                
            System.out.println(id);
           
    }
    
}
