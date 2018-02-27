/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Service_Medecin;
import Service.Service_service;
import impl.org.controlsfx.autocompletion.AutoCompletionTextFieldBinding;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.control.Rating;
import org.controlsfx.control.textfield.AutoCompletionBinding;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class FirstInterfaceController implements Initializable {

    @FXML
    private TextField rechspec;
    @FXML
    private TextField rechnom;
    @FXML
    private ListView<Service_Medecin> listviewmed;

    static String PRENOM;
    static String SPEC;
    static String DIPLOME;
    static String LANGUES;
    static String OUVERT;
    static String REG;
    static float TARIF;
    static String FERME;
    static String nom;
    static int ID;
    static int TEL;
    static String ADRS;
    static String MAIL;
    static String IMG;
    static String CNAM;
    static double LAT;
    static double LONGI;
    static Stage stg;
    @FXML
    private TextField rechadresse;
    private Rating rating;
    @FXML
    private Button retour;
    @FXML
    private Label msg;
    @FXML
    private ComboBox<String> spec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Service_service ss = new Service_service();
        System.out.println(ss.getVote(162));
        rechspec.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                //filterList((String) oldValue, (String) newValue);
                //listviewmed.refresh();
                
                 ObservableList specialités = FXCollections.observableArrayList(
            "Dentiste", "Cardiologue", "Dermatologue", "Généraliste", "Ophtalmologue", "Pédiatre");
                  spec.setItems(specialités);
            }
        });

        ObservableList<Service_Medecin> data = FXCollections.observableArrayList(ss.SelectServiceMED1("medecin"));

        listviewmed.getItems().addAll(data);
        listviewmed.setCellFactory(new Callback<ListView<Service_Medecin>, ListCell<Service_Medecin>>() {
            @Override
            public ListCell<Service_Medecin> call(ListView<Service_Medecin> param) {
                return new ListCell<Service_Medecin>() {
                    @Override
                    protected void updateItem(Service_Medecin item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            rating = new Rating();

                            rating.setOnMouseClicked((MouseEvent event) -> {
                                Service_service ss = new Service_service();
                                System.out.println("tttttt");
                            });

                            VBox vBox = new VBox(
                                    new Text(item.getNom()), new Text(item.getPrenom()),
                                    new Text(item.getSpecialite()), new Text(String.valueOf(item.getTarif())),
                                    new Text(item.getAdresse_etab()),
                                    new ToolBar(rating)
                            );

                            rating.ratingProperty().addListener(new ChangeListener<Number>() {
                                @Override
                                public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                                    msg.setText("Rating : " + t1);
                                    Service_service ss = new Service_service();
                                   
                                     List l= ss.Selectrat(163);
                                     for (int i = 0; i < l.size(); i++)
                                        System.out.println(l);
                                     
                                     //ss.setRating(163, 2, t1.intValue());
                                     //ss.updateRating( t1.intValue(), 2, 161);
                                     //ss.getVote(162);
                                     //System.out.println(ss.getVote(162));
                                }
                            });
                            vBox.setSpacing(4);
                            String IMAGE = item.getImage_serv();
                            Image image = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/" + IMAGE);

                            ImageView imv = new ImageView(image);
                            System.out.println(image);
                            imv.setFitHeight(130);
                            imv.setFitWidth(130);
                            HBox hBox = new HBox(imv, vBox);
                            hBox.setSpacing(10);

                            setGraphic(hBox);

                        }
                    }

                };

            }

        }
        );
        
        listviewmed.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Service_Medecin>() {
            @Override
            public void changed(ObservableValue<? extends Service_Medecin> observable, Service_Medecin oldValue, Service_Medecin newValue) {
                try {
                    FirstInterfaceController.ID = newValue.getId_service();
                    FirstInterfaceController.nom = newValue.getNom();
                    FirstInterfaceController.PRENOM = newValue.getPrenom();
                    FirstInterfaceController.SPEC = newValue.getSpecialite();
                    FirstInterfaceController.DIPLOME = newValue.getPromotion();
                    FirstInterfaceController.LANGUES = newValue.getLangues_parlees();
                    FirstInterfaceController.OUVERT = newValue.getHeure_ouverture();
                    FirstInterfaceController.FERME = newValue.getHeure_fermeture();
                    FirstInterfaceController.REG = newValue.getModes_de_reglement();
                    FirstInterfaceController.TARIF = newValue.getTarif();
                    FirstInterfaceController.TEL = newValue.getTel_service();
                    FirstInterfaceController.ADRS = newValue.getAdresse_etab();
                    FirstInterfaceController.MAIL = newValue.getE_mail();
                    FirstInterfaceController.CNAM = newValue.getAssurance_maladie();
                    FirstInterfaceController.IMG = newValue.getImage_serv();
                    FirstInterfaceController.LAT = newValue.getLatitude();
                    FirstInterfaceController.LONGI = newValue.getLongitude();

                    System.out.println(newValue.getImage_serv());

                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConsulterServiceMED.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();

//            FXMain.stg.close();
//            FXMain.stg = stage;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        new AutoCompletionTextFieldBinding(rechnom, new Callback<AutoCompletionBinding.ISuggestionRequest, Collection>() {
            // rechercher howa esm el text field mte3i
            @Override
            public Collection call(AutoCompletionBinding.ISuggestionRequest param) {

                List<String> nom = new ArrayList<>();
                Service_service ss = new Service_service();
                ObservableList<Service_Medecin> data = FXCollections.observableArrayList(ss.findmedbynom(rechnom.getText()));
                // khoudh el texte eli fl texte field w naba3tthou fi argument fi methode rechercher

                for (Service_Medecin s : data) {
                    nom.add(s.getNom());
                }
                return nom;

                //nom hiya el liste de string eli bch tektabli ml louta
            }

        });

        rechnom.textProperty().addListener((observable, oldValue, newValue) -> {

            listviewmed.setItems(FXCollections.observableArrayList(ss.findmedbynom(rechnom.getText())));
//            listviewmed.refresh();

listviewmed.setCellFactory(new Callback<ListView<Service_Medecin>, ListCell<Service_Medecin>>() {
            @Override
            public ListCell<Service_Medecin> call(ListView<Service_Medecin> param) {
                return new ListCell<Service_Medecin>() {
                    @Override
                    protected void updateItem(Service_Medecin item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            rating = new Rating();

                            rating.setOnMouseClicked((MouseEvent event) -> {

                                System.out.println("tttttt");
                            });

                            VBox vBox = new VBox(
                                    new Text(item.getNom()), new Text(item.getPrenom()),
                                    new Text(item.getSpecialite()), new Text(String.valueOf(item.getTarif())),
                                    new Text(item.getAdresse_etab()),
                                    new ToolBar(rating)
                            );

                            rating.ratingProperty().addListener(new ChangeListener<Number>() {
                                @Override
                                public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                                    msg.setText("Rating : " + t1.toString());

                                }
                            });

                            vBox.setSpacing(4);
                            String IMAGE = item.getImage_serv();
                            Image image = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/" + IMAGE);

                            ImageView imv = new ImageView(image);
                            System.out.println(image);
                            imv.setFitHeight(130);
                            imv.setFitWidth(130);
                            HBox hBox = new HBox(imv, vBox);
                            hBox.setSpacing(10);

                            setGraphic(hBox);

                        }
                    }

                };

            }

       } );
        });
        
        
    new AutoCompletionTextFieldBinding(rechadresse, new Callback<AutoCompletionBinding.ISuggestionRequest, Collection>() {
            // rechercher howa esm el text field mte3i
            @Override
            public Collection call(AutoCompletionBinding.ISuggestionRequest param) {

                List<String> adresse = new ArrayList<>();
                Service_service ss = new Service_service();
                ObservableList<Service_Medecin> data = FXCollections.observableArrayList(ss.findmedbyadresse(rechadresse.getText()));
                // khoudh el texte eli fl texte field w naba3tthou fi argument fi methode rechercher

                for (Service_Medecin s : data) {
                    adresse.add(s.getAdresse_etab());
                }
                return adresse;
            }

        });

        rechadresse.textProperty().addListener((observable, oldValue, newValue) -> {

            listviewmed.setItems(FXCollections.observableArrayList(ss.findmedbyadresse(rechadresse.getText())));
listviewmed.setCellFactory(new Callback<ListView<Service_Medecin>, ListCell<Service_Medecin>>() {
            @Override
            public ListCell<Service_Medecin> call(ListView<Service_Medecin> param) {
                return new ListCell<Service_Medecin>() {
                    @Override
                    protected void updateItem(Service_Medecin item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            rating = new Rating();

                            rating.setOnMouseClicked((MouseEvent event) -> {

                                System.out.println("tttttt");
                            });

                            VBox vBox = new VBox(
                                    new Text(item.getNom()), new Text(item.getPrenom()),
                                    new Text(item.getSpecialite()), new Text(String.valueOf(item.getTarif())),
                                    new Text(item.getAdresse_etab()),
                                    new ToolBar(rating)
                            );

                            rating.ratingProperty().addListener(new ChangeListener<Number>() {
                                @Override
                                public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                                    msg.setText("Rating : " + t1.toString());

                                }
                            });

                            vBox.setSpacing(4);
                            String IMAGE = item.getImage_serv();
                            Image image = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/" + IMAGE);

                            ImageView imv = new ImageView(image);
                            System.out.println(image);
                            imv.setFitHeight(130);
                            imv.setFitWidth(130);
                            HBox hBox = new HBox(imv, vBox);
                            hBox.setSpacing(10);

                            setGraphic(hBox);

                        }
                    }

                };

            }

       } );
        });
        
        
//        new AutoShowComboBoxHelper(ComboBox<String> spec, new Callback<String, String> textBuilder) {
//        final ObservableList<String> items = FXCollections.observableArrayList(spec.getItems());
//
//        comboBox.getEditor().textProperty().addListener((ov, o, n) -> {
//            if (n.equals(comboBox.getSelectionModel().getSelectedItem())) {
//                return;
//            }
//
//            comboBox.hide();
//            final FilteredList<String> filtered = items.filtered(s -> textBuilder.call(s).toLowerCase().contains(n.toLowerCase()));
//            if (filtered.isEmpty()) {
//                comboBox.getItems().setAll(items);
//            } else {
//                comboBox.getItems().setAll(filtered);
//                comboBox.show();
//            }
//        });
   }



    public void refreshListe() {
        listviewmed.getItems().clear();
        listviewmed.getItems().addAll(Service_service.SelectServiceMED1("medecin"));
        listviewmed.refresh();
    }

//            listviewmed.setCellFactory(new Callback<ListView<Service_Medecin>, ListCell<Service_Medecin>>() {
//            @Override
//            public ListCell<Service_Medecin> call(ListView<Service_Medecin> param) {
//                return new ListCell<Service_Medecin>() {
//                    @Override
//                    protected void updateItem(Service_Medecin item, boolean empty) {
//                        super.updateItem(item, empty); 
//                        if (item != null) {
//                         rating= new Rating();
//                            rating.setPartialRating(true);
//                            rating.setOnMouseClicked((MouseEvent event)->{
//                                rating.setDisable(true);
//                            
//                                System.out.println("tttttt");});
//                            
//                            VBox vBox = new VBox(
//                                    
//                                    new Text(item.getNom()), new Text(item.getPrenom()),
//                                     new Text(item.getSpecialite()), new Text(String.valueOf(item.getTarif())),
//                                             new Text(item.getAdresse_etab()),
//                            new ToolBar(rating)
//                            );
//                            
//              
////		
////		rating.ratingProperty().addListener(new ChangeListener<Number>() {
////            @Override public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
////              msg.setText("Rating : "+ t1.toString());
////            }
////        });
//                    
//                            vBox.setSpacing(15);
//                        String IMAGE=item.getImage_serv();
//                            //final URL imageURL= getClass().getResource(item.getImage_serv());
//                           Image image = new Image("file:///C:/users/chayma/Documents/NetBeansProjects/EsapceSante-BienEtre/src/Interfaces/"+IMAGE);
//
//                            ImageView imv = new ImageView(image);
//                            imv.setFitHeight(160);
//                            imv.setFitWidth(160);
//                            HBox hBox = new HBox(imv, vBox);
//                            hBox.setSpacing(30);
//
//                            setGraphic(hBox);
//
//                        }
//                    }
//
//                };
//
//            }
//
//        }
//        );
//       }
//        };

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("ConsulterMonService.fxml")));
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void tfSearch(KeyEvent event) {

//        listviewmed.getItems().clear();
//        listviewmed.refresh();
//        listviewmed.getItems().addAll(Service_service.findmedbynom(rechnom.getText()));
    }
}
