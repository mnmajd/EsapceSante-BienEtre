/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Article;
import Entite.Blog;
import Service.Article_Service;
import Service.Blog_Service;
import Service.Categ_Service;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author TAQWA
 */
public class FXMLmembreViewController implements Initializable {
 static String t  ;
    @FXML
    private ListView<Article> list;
    @FXML
    private TextField txtrech;
   
static String tx ;
    @FXML
    private ComboBox<?> combofind;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         //  private ListView<Article> liste;
      Article_Service ss = new Article_Service();
      ObservableList<Article> data = FXCollections.observableArrayList();
       
         ObservableList<Article> serviceM = ss.afficherArticle();
     // data.addAll(new Article());
      
data.addAll(0, serviceM);   

        list.getItems().addAll(data);
        list.setCellFactory(new Callback<ListView<Article>, ListCell<Article>>() {

            @Override
            public ListCell<Article> call(ListView<Article> arg0) {
                return new ListCell<Article>() {

                    @Override
                    protected void updateItem(Article item, boolean bln) {
                        super.updateItem(item, bln);
                        if (item != null) {
      
                        VBox vBox = new VBox();
                        Text txt1 = new Text(item.getTitre_article());
                        t = item.getTitre_article() ;
                        txt1.setFont(Font.font ("Verdana", 20));
                        HBox hBoxT = new HBox();
                        Text txt2 = new Text(String.valueOf(item.getDate_pub()));
                        
                        
                        Image imgT = new Image("/image/calendar.png", 35, 35, false, false);
                        ImageView time = new ImageView(imgT);
                        
                        Text txt3 = new Text(item.getSujet_article());
                        txt3.setFont(Font.font ("Verdana", 20));
                    //    Text txt4 = new Text(item.getContenu_article());
 
                           
                                HBox hBox = new HBox(10);
                                
                               ImageView i = new ImageView();
                               Button fb = new Button();
                               Image imFB = new Image("/image/fb.png", 35, 35, false, false);
                              i.setImage(imFB);
                              fb.setGraphic(new ImageView(imFB));
                              fb.setOnMouseClicked(evt -> {
                                t = item.getTitre_article();
                              
                               
                     
                              } );
                          
                          
                          ImageView imga = new ImageView();
                          
                          ToggleButton like = new ToggleButton();
                          Image i3 = new Image("/image/dislike.png", 38, 38, false, false);
                          Image i4 = new Image("/image/like.png", 39, 36, false, false);
                          imga.setImage(i3);
                          like.setGraphic(new ImageView(i3));
                          
                          like.setOnMouseClicked(evt -> {
                              if (like.isSelected()) {
                                  imga.setImage(i4);
                                  like.setGraphic(new ImageView(i4));
                                  Blog bb1 = null ;
                                  Blog_Service bs = new Blog_Service();
                                  try {
                                      bs.augmenterLike(bb1);
                                  } catch (SQLException ex) {
                                      Logger.getLogger(FXMLmembreViewController.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                                  
                                  
                                  
                              }
                              else {
                                  imga.setImage(i3);
                                  like.setGraphic(new ImageView(i3));
                                  Blog bb2 = null ;
                                  Blog_Service bs = new Blog_Service();
                                  try {
                                      bs.DimuDislike(bb2);
                                  } catch (SQLException ex) {
                                      Logger.getLogger(FXMLmembreViewController.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                              }
                              
                              
                          });
                          
                          
                          
                          
                          
                          hBoxT.getChildren().add(time);
                          hBoxT.getChildren().add(txt2);
                          
                          vBox.getChildren().add(txt1);
                          vBox.getChildren().add(txt3);
                          
                          hBox.getChildren().add(like);
                          hBox.getChildren().add(fb);
                          HBox hBoxV = new HBox(vBox);
                          vBox.setPrefSize(50,50);
                          hBoxV.setPrefSize(50,50);
                          
                          VBox vBox1 = new VBox(hBoxT,hBox);
                          
                          HBox hBoxG = new HBox(vBox1,hBox,hBoxV);
                          hBoxG.setSpacing(30);
                          setGraphic(hBoxG);
                          
                      }
                    }
                    

                };
            }

        });
    
    list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Article>() {

       
            @Override
            public void changed(ObservableValue<? extends Article> observable, Article oldValue, Article newValue) {
                                try {
                                LST.s=newValue.getContenu_article();
                                LST.a=newValue.getTitre_article();
                               // LST.b=newValue.get
                                //LST.c=newValue.getDate_pub();
                                LST.d=newValue.getImg_artc();
                              //  LST.s=newValue.getc
                                
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLarticleView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
            LST.stg.close();
            LST.stg = stage;
    } catch(IOException e) {
      }
        
                
            }
        });  
        
//     @Override
//    public void init() {
//        this.searchInstruments.addAll(this.session.getInstruments());

        txtrech.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              ss.getBlogByCategorie(txtrech.getText());
              list.getItems().addAll(data);
            }
        });
    
    //
//     txtrech.onKeyPressedProperty()
//txtrech.textProperty().addListener((observable, oldValue, newValue) -> {
////            if (newValue.isEmpty()) {
////                
////                 Alert alert = new Alert(Alert.AlertType.ERROR);
////            alert.setTitle("Message de recherche ");
////            alert.setContentText(" Ce service n'existe pas  ");
////            alert.showAndWait();
////            list.getItems().addAll(data);
////            } else {
//                list.setItems(FXCollections.observableArrayList(ss.getBlogByCategorie(txtrech.getText())));
////            }
//        });
//    
    }

    @FXML
    private void reche(KeyEvent event) {
        Categ_Service servC = new Categ_Service();
        Blog_Service blog = new Blog_Service() ;
        list.getItems().clear();
        list.refresh();
      //  list.getItems().addAll(servC.
    }
    
    
    
     
}
        // TODO
    

