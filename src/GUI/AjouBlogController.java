/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Article;
import Entite.Blog;
import Entite.CategorieArticle;
import Service.Article_Service;
import Service.Blog_Service;
import Service.Categ_Service;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import static java.nio.file.Files.delete;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import static javax.management.Query.value;



/**
 * FXML Controller class
 *
 * @author TAQWA
 */
public class AjouBlogController implements Initializable {

    @FXML
    private TextField idtitre;
    @FXML
    private TextField idsujet;
    @FXML
    private TextArea idcontenu;
    @FXML
    private ComboBox<?> idchoix;
    @FXML
    private Button btnadd;
    @FXML
    private Button idimage;
    
    @FXML
    private Text titr ;
    private String imageUrl;
    @FXML
    private Text txt1;
    private Text txt2;
    private Text txt4;
    @FXML
    private TabPane tabpane;
    @FXML
    private Tab tab1;
    @FXML
    private Tab tab2;
    @FXML
     private ListView<Article> liste;
   static  ListView<Article> list;
  
    static int x ;
    static String t ;
    static String t2 ;
    static String t3 ;
    static String choix;
//ListView<Article> liste;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       CategorieArticle C = new CategorieArticle();
       Categ_Service caa = new Categ_Service();
       List<String> listeCateg = caa.afficherCateg();
       ObservableList catego = FXCollections.observableArrayList(
        listeCateg 
        );
   
       idchoix.setItems(catego);
        //Categ_Service
          //      CategorieArticle.Categ_Service.
//          Categ_Service cat = new Categ_Service() ;
//          CategorieArticle catar = new CategorieArticle() ;
          
          //List<String> c = CategorieArticle.Categ_Service
         
      //  private ListView<Article> liste;
      Article_Service ss = new Article_Service();
      Blog_Service bg = new Blog_Service();
      ObservableList<Article> data = FXCollections.observableArrayList();
       
         ObservableList<Article> serviceM = ss.getArticleUser(2);
     // data.addAll(new Article());
      
data.addAll(0, serviceM);
      
        
       
        
            

        liste.getItems().addAll(data);
        liste.setCellFactory(new Callback<ListView<Article>, ListCell<Article>>() {

            @Override
            public ListCell<Article> call(ListView<Article> arg0) {
                return new ListCell<Article>() {

                    @Override
                    protected void updateItem(Article item, boolean bln) {
                        super.updateItem(item, bln);
                        if (item != null) {
                            
                           //Image imageDecline = new Image(getClass().getResourceAsStream());
                     

                           // VBox vBox;
                        VBox vBox = new VBox();
                        Text txt1 = new Text(item.getTitre_article());
                        
                        HBox hBoxT = new HBox();
                        Text txt2 = new Text(String.valueOf(item.getDate_pub()));
                        
                        
                        Image imgT = new Image("/image/calendar.png", 35, 35, false, false);
                        ImageView time = new ImageView(imgT);
                        
                        Text txt3 = new Text(item.getSujet_article());
                        Text txt4 = new Text(item.getContenu_article());
                       // Text img  = new Text(item.getImg_artc());
                        Image  image  = new Image(item.getImg_artc(), true); 
                           ImageView imv =new ImageView(image);
                           imv.setFitHeight(300);
                           imv.setFitWidth(300);
                        
                    


                                HBox hBox = new HBox(10);
                                
                         ImageView imga = new ImageView();
                         
                                Button appBtn = new Button();
                                
                                Image i3 = new Image("/image/delet.png", 35, 35, false, false);
                  
                      imga.setImage(i3);
                 
                      appBtn.setGraphic(new ImageView(i3));
                              //  Image appBtn = new Image();
                           // appBtn.setStyle("-fx-background-color:green");
                          // appBtn.setText("Supprimer");
//                      Image imageDecline = new Image(getClass().getResourceAsStream("/image/delet.png"));
//                    imga.setImage(imageDecline);
//                  
//                    imga.setFitHeight(0.1);
//                            imga.setFitWidth(0.2);
//                   
//                     // appBtn.setMaxSize(10, 10);
//                       appBtn.setGraphic(new ImageView(imageDecline));
                     
                          //  appBtn.setTranslateX(150);
                           // setGraphic(hBox2);
                            appBtn.setOnMouseClicked(e -> {
                                
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(" Alert ");
            alert.setContentText("Voulez-vous supprimer le Blog ? ");
            ButtonType buttonTypeYes = new ButtonType("Supprimer");
            ButtonType buttonTypeCancel = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeCancel);
           // alert.showAndWait();
                 Optional<ButtonType> result = alert.showAndWait();
                   if (result.get() == buttonTypeYes){
                        ss.deleteArticle(item.getId_article());
                        
                         //ObservableList<Article> serviceM = ss.getArticleUser(2);
//     // data.addAll(new Article());
      liste.getItems().clear();
      liste.getItems().addAll(ss.getArticleUser(2));
//                         data.addAll(0, serviceM);
                       // data.addAll(FXCollections.observableArrayList(ss.getArticleUser(2)));
                                liste.refresh();
                   }
                               
  

   });
                                
                                ImageView imga2 = new ImageView();
                                imga2.setFitHeight(10);
                                imga2.setFitWidth(10);
                         
                                Button appBtn2 = new Button();
                              //  Image appBtn = new Image();
                           // appBtn.setStyle("-fx-background-color:green");
                          // appBtn.setText("Supprimer");
                         Image i2 = new Image("/image/upd.png", 35, 35, false, false);
                    //Image imageDecline2 = new Image(getClass().getResourceAsStream("/image/upd.png"));
                  //  Image imageDecline2 = new Image(getClass().getResourceAsStream(i2));
                      imga2.setImage(i2);
                   // imga2.setImage(imageDecline2);
                  
                                
                                
                    
                   
                     // appBtn.setMaxSize(10, 10);
                       //appBtn2.setGraphic(new ImageView(imageDecline2));
                      appBtn2.setGraphic(new ImageView(i2));
                            //appBtn2.setTranslateX(150);
                           // setGraphic(hBox2);
                           
                            appBtn2.setOnMouseClicked(e -> {
                               t = item.getTitre_article();
                               t2 = item.getSujet_article();
                               t3  = item.getContenu_article();
                               x =  item.getId_article();
                            
                               Categ_Service cs = new Categ_Service() ;
                                int idcat = item.getId_cat() ;
                               choix = cs.GetNameGateg(idcat);
       

                               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLmodif.fxml"));
            Parent root;
                            try {
                                
                                root = (Parent) fxmlLoader.load();
                                Stage stage = new Stage();
             
            stage.setScene(new Scene(root));  
            stage.show();
 
           
                            } catch (IOException ex) {
                                Logger.getLogger(AjouBlogController.class.getName()).log(Level.SEVERE, null, ex);
                            }
            
            
      
                            //  root = fxmlLoader.setLocation(getClass().getResource("FXMLmodif.fxml"));
        
                                //root = FXMLLoader.load(getClass().getClassLoader().getResource("path/to/other/view.fxml"), resources);
             
                                
                               // ss.updateArticle(item, item.getId_article());
                             
                               
                                
//                                data.addAll(FXCollections.observableArrayList(ss.getArticleUser(2)));
//                                liste.refresh();
                               
                            });
//
//                                 );
//
//                           
//
//                                   
//                            vBox.setSpacing(10);
//                            
//                          
//                            Image  image  = new Image(item.getImg_artc(), true); 
//                            ImageView imv =new ImageView(image);
//                            imv.setFitHeight(130);
//                            imv.setFitWidth(130);
//                            HBox hBox = new HBox(imv,vBox);
//                            hBox.setSpacing(10);
//                          
//                            
        hBoxT.getChildren().add(time);
        hBoxT.getChildren().add(txt2);
        
        vBox.getChildren().add(txt1); 
        vBox.getChildren().add(txt3);
        vBox.getChildren().add(txt4);
        vBox.getChildren().add(imv);
        
         //vBox.getChildren().add(hBoxT);
        // vBox.getChildren().add(hBox);
         hBox.getChildren().add(appBtn);
         hBox.getChildren().add(appBtn2);
               
                HBox hBoxV = new HBox(vBox);
               vBox.setPrefSize(50,50);
              hBoxV.setPrefSize(50,50);
                
               
               VBox vBox1 = new VBox(hBoxT,hBox);

                   HBox hBoxG = new HBox(vBox1,hBoxV);  
                   hBoxG.setSpacing(30);
                   setGraphic(hBoxG);
                   
                        
                
                        } else {
                            setGraphic(null);
                        }
                    }

                };
            }

        });}
    
    
//      liste.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Article>() {
//
//       
//            @Override
//            public void changed(ObservableValue<? extends Article> observable, Article oldValue, Article newValue) {
//                                try {
//                                    
//                                    
//    
//    } catch(Exception e) {
//       e.printStackTrace();
//      }
//        
//                
//            }
//        });  
        
        
    
   
 

//txt1.setText("coucou !! ");
    
//     txt2.setText("salem !!!");
////        txt3.setText(imageUrl);
//      
//        // String x = "coucou " ;
//       
////        paneB.setText(x);
//      //  paneB.setContent(new Text(x));
//        
//        
//        ChoiceBox<String> choiceBox = new ChoiceBox();
//      
//        
//      //  tp.setContent(txt1);
//  
// 
//      
//        choiceBox.getItems().add("Choice 1");
//        choiceBox.getItems().add("Choice 2");
//        choiceBox.getItems().add("Choice 3");
//        choiceBox.setValue("Choice 1");
//        
//      //  tp.getChildren().addAll(txt1,txt2,txt3);
//        // p.getChildren().add(txt2);
//        
//       
//        // TODO

    

       
    
    
    @FXML
    private void ajoutimg(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();

    //Set extension filter


    //Show open file dialog
    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
        try {
            imageUrl = file.toURI().toURL().toExternalForm();
            //Image image = new Image(imageUrl);
            //pic.setImage(image);
         
        } catch (MalformedURLException ex) {
            throw new IllegalStateException(ex);
            
        }
    }

        
        
    }
    @FXML
    private void insererArticle(ActionEvent event) throws SQLException {
        Article_Service serv = new Article_Service() ;
        Blog_Service bs = new Blog_Service();
        Categ_Service cs = new Categ_Service() ;
      
      GridPane grid = new GridPane();
      ImageView img = new ImageView(imageUrl);

      grid.add(img,0 ,0);
       
       String  titre = idtitre.getText();
     String  sujet = idsujet.getText();
     String contenu = idcontenu.getText();
     //String img  
     String choix = (String) idchoix.getValue();
        int  id_cat = Integer.parseInt(cs.GetIDGateg(choix));

     
        
        if ("".equals(titre) || "".equals(sujet) || "".equals(contenu)
                || imageUrl == null ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(" Alert ");
            alert.setContentText("Remplir les champs ");
            alert.showAndWait();

        }
        else {
            Article article = new Article(titre,sujet,contenu,imageUrl,2,id_cat);
            
         
            
            serv.insererArticle(article);
          int xx = serv.insererArticle(article);
           
            Blog lg = new Blog(id_cat,xx);
           
            bs.insererBlog(lg);
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Blog");
            alert.setContentText("Bien publié ! ");
            alert.showAndWait();
             liste.getItems().clear();
            liste.getItems().addAll(0,serv.getArticleUser(2));
                       // data.addAll(0, serviceM);
                       // data.addAll(FXCollections.observableArrayList(ss.getArticleUser(2)));
                                liste.refresh();
           
           //serv.getDateNow(7);
            
           
           
          
           // String = 
            //serv.afficherArticle();
            
           
            //paneB.setText(sujet);
          
            
 
            
            
        
            
           
 
            
        /*
     String  titre = idtitre.getText();
     String  sujet = idsujet.getText();
     String contenu = idcontenu.getText();
     //String img  = 
     String choix = idchoix.getValue();
     */
      System.out.println("titre === "+titre);
            
        /*
    
*/
    
        
    }
//        //@FXML
//       Public void AfficherArticle() {
//        Article titre;
//                //  paneB.setText(v.getTitre_article());
//                //txt1.setText(v.getTitre_article());
//            titre = serv.afficherArticle().get(2);
//    }
        
    }


    private String suppArticle(ActionEvent event) {
        Article_Service serv = new Article_Service();
       Article a ;
       serv.deleteArticle(2);
     
       return "supp";
        
    }
//    
//    public void refreshListe() {
//        listviewmed.getItems().clear();
//        listviewmed.getItems().addAll(Service_service.SelectServiceMED1("medecin"));
//        listviewmed.refresh();
//    }
//    
    }
    
    
    

    
     


