/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.User;
import Utils.Upload;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import Service.UserDAO;
import GUI.EspaceSanteBienEtre;
import static GUI.EspaceSanteBienEtre.loginScene;
import static GUI.EspaceSanteBienEtre.loginWindow;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import Utils.AnimationGenerator;
import Utils.UserStatus;



public class SingupController implements Initializable {
UserDAO userDAO=new UserDAO();
   

    File  selectedfile;
    String path_img;
    public Upload up =new Upload();
    
    @FXML
    TextField cin;
    
    @FXML
    TextField age;
    @FXML
    GridPane gridpane;

    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    ComboBox<String> role;
    @FXML
    ComboBox<String> sexe;
    @FXML
    ComboBox<String> specialite;
    @FXML
    Label specialiteLabel;
    @FXML
    TextField firstname;
    @FXML
    TextField lastname;
    @FXML
    TextField email;
    @FXML
    TextArea address;
    @FXML
    TextField telephone;
    @FXML
    DatePicker dateNaissance;
    Label boutiqueNameLabel = new Label("Nom ");
   //  TextField boutiqueNameTextField;
  //  ComboBox<Boutique> boutiqueNameComboBox;
    //Label storeNameTextLabel;

    Separator separator1 = new Separator();
    Separator separator2 = new Separator();

    AnimationGenerator animationGenerator;
    @FXML
    private Button button;
    @FXML
    private Button button1;
    private ListView listviewimg;
    @FXML
    private Button btnimage;
    AnchorPane AnchorPane;
    static int code;
    
    
    
    
    private FileChooser.ExtensionFilter extFilterJPG;
    private FileChooser.ExtensionFilter extFilterjpg;
    private FileChooser.ExtensionFilter extFilterJPEG;
    private FileChooser.ExtensionFilter extFilterjpeg;
    private FileChooser.ExtensionFilter extFilterPNG;
    private FileChooser.ExtensionFilter extFilterpng;
    //private Upload up;
    //private File file = new File("");
    @FXML
    private ImageView myphoto;
        File file;
    @FXML
    private PasswordField rePassword;
    //sendMessageCode message= new sendMessageCode();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        specialiteLabel.setVisible(false);
        specialite.setVisible(false);
       // GestionBoutique boutique = new GestionBoutique();
          ObservableList roleList = FXCollections.observableArrayList(
                "Choisissez un role...",
                "Prestataire",
                "Membre"
        );
          
        ObservableList specList = FXCollections.observableArrayList(
                "coach salle de sport",
                "medecin"
        );
        ObservableList sexeList = FXCollections.observableArrayList(
                "Homme",
                "Femme"
        );
        role.setItems(roleList);
        role.setValue("Choisissez un role...");
        
        sexe.setItems(sexeList);
        specialite.setItems(specList);

        animationGenerator = new AnimationGenerator();
    }    

    @FXML
    private void onRoleChange(ActionEvent event) {
        if("Prestataire".equals(role.getSelectionModel().getSelectedItem())){
            specialiteLabel.setVisible(true);
            specialite.setVisible(true);
        }else{
            specialiteLabel.setVisible(false);
            specialite.setVisible(false);
        }
    }
    
    
    
    public void signup() throws IOException {       
        int solde=0;
        User user = new User(username.getText(), password.getText(), email.getText(), firstname.getText(), lastname.getText(), address.getText(), telephone.getText(), UserStatus.PENDING,solde,"");
        user.setCIN(cin.getText());
        user.setSexe(sexe.getValue());
        user.setAge(Integer.parseInt(age.getText()));
        user.setRole(role.getValue());
        user.setDateNaissance(Date.valueOf(dateNaissance.getValue()));
        System.out.println(user.getRole());
        boolean verif;

        if (userDAO.checkUsername(username.getText())) {
            PseudoClass pseudoClass = PseudoClass.getPseudoClass("error");
            username.pseudoClassStateChanged(pseudoClass, true);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Utilisateur existe deja!");
            alert.setHeaderText(username.getText());
            alert.setContentText("Ce nom d'utilisateur existe deja");
            alert.showAndWait();

            return;
        }
        if(userDAO.checkUseremail(email.getText()))
        {
        PseudoClass pseudoClass = PseudoClass.getPseudoClass("error");
            username.pseudoClassStateChanged(pseudoClass, true);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Eamil existe deja!");
            alert.setHeaderText(username.getText());
            alert.setContentText("Ce mail d'utilisateur existe deja");
            alert.showAndWait();

            return;
        }
        
        if(user.getDateNaissance().after(Date.valueOf("2006-01-01"))){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(username.getText());
            alert.setContentText("Vous devez avoir au moins 12 ans!");
            alert.showAndWait();

            return;
        }
        
        
        //controle de saisie
        
         password.setOnMouseClicked((MouseEvent event1) -> {
                password.setStyle("-fx-text-box-border: transparent;");
                rePassword.setStyle("-fx-text-box-border: transparent;");
                password.clear();
                rePassword.clear();
         });
        
        email.setOnMouseClicked((MouseEvent event1) -> {
                email.setStyle("-fx-text-box-border: transparent;");
                email.clear();
            });
        
        if (        email.getText().isEmpty() 
                        || !email.getText().contains("@") 
                        || !email.getText().contains(".") 
                      //  || email.getText().indexOf("@", 0) > email.getText().indexOf(".", 0) 
                        || email.getText().indexOf("#", 0) >= 0
                        || email.getText().indexOf("&", 0) >= 0
                        || email.getText().indexOf("(", 0) >= 0
                        || email.getText().length() - email.getText().replace("@", "").length() > 1
                    //    || email.getText().length() - email.getText().replace(".", "").length() > 1
                        || email.getText().indexOf("Â§", 0) >= 0
                        || email.getText().indexOf("!", 0) >= 0
                        || email.getText().indexOf("Ã§", 0) >= 0
                        || email.getText().indexOf("Ã ", 0) >= 0
                        || email.getText().indexOf("Ã©", 0) >= 0
                        || email.getText().indexOf(")", 0) >= 0
                        || email.getText().indexOf("{", 0) >= 0
                        || email.getText().indexOf("}", 0) >= 0
                        || email.getText().indexOf("|", 0) >= 0
                        || email.getText().indexOf("$", 0) >= 0
                        || email.getText().indexOf("*", 0) >= 0
                        || email.getText().indexOf("â‚¬", 0) >= 0
                        || email.getText().indexOf("`", 0) >= 0
                        || email.getText().indexOf("\'", 0) >= 0
                        || email.getText().indexOf("\"", 0) >= 0
                        || email.getText().indexOf("%", 0) >= 0
                        || email.getText().indexOf("+", 0) >= 0
                        || email.getText().indexOf("=", 0) >= 0
                        || email.getText().indexOf("/", 0) >= 0
                        || email.getText().indexOf("\\", 0) >= 0
                        || email.getText().indexOf(":", 0) >= 0
                        || email.getText().indexOf(",", 0) >= 0
                        || email.getText().indexOf("?", 0) >= 0
                        || email.getText().indexOf(";", 0) >= 0
                        || email.getText().indexOf("Â°", 0) >= 0
                        || email.getText().indexOf("<", 0) >= 0
                        || email.getText().indexOf(">", 0) >= 0) 
                {
                    email.setStyle("-fx-text-box-border: #f44336;");
                    verif = false;
                }
        
                 if (rePassword.getText().equals(password.getText()) == false || password.getText().isEmpty()) {
                    password.setStyle("-fx-text-box-border: #f44336;");
                    rePassword.setStyle("-fx-text-box-border: #f44336;");
                    verif = false;
                }
        
          if( firstname.getText().isEmpty() ){
                    firstname.setStyle("-fx-text-box-border: #f44336;");
                    verif = false;
                }
         if( lastname.getText().isEmpty() ){
                    lastname.setStyle("-fx-text-box-border: #f44336;");
                    verif = false;
                }
        
        
        
        switch (role.getValue()) {
            case "Membre":
                break;
            case "Prestataire":
               if(specialite.isVisible() == true)
                    user.setSpecialite(specialite.getValue());
                break;
            default:
                PseudoClass pseudoClass = PseudoClass.getPseudoClass("error");
                role.pseudoClassStateChanged(pseudoClass, true);
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erreur");
                alert.setContentText("Vous devez selectionnez un role");
                alert.showAndWait();
                return;
        }

        if (user != null) 
        {

            EspaceSanteBienEtre.currentUser=user;
        
        Files.copy(selectedfile.toPath(), 
                Paths.get("C:\\Users\\said hmidi\\Desktop\\Piedev\\EspaceSante&BienEtre\\image\\" + selectedfile.getName()));
           user.setAvatar(selectedfile.getName());
            userDAO.add(user);
           TrayNotification tray = new TrayNotification("Felicitation!",
                   "Votre demande a ete envoyer au administrateur", NotificationType.SUCCESS);
           tray.showAndWait();
           cancel();
            
        }
    }
    
   

    public  void cancel() throws IOException {
        username.clear();
        password.clear();
        role.setValue("Choisissez un role...");
        firstname.clear();
        lastname.clear();
        email.clear();
        address.clear();
        telephone.clear();
        loginWindow = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml"));

        animationGenerator.applyTranslateAnimationOn(EspaceSanteBienEtre.signupWindow, 1000, 0, 1000);
        animationGenerator.applyFadeAnimationOn(EspaceSanteBienEtre.signupWindow, 500, 1.0f, 0f, event -> {
            loginScene = new Scene(loginWindow);
            EspaceSanteBienEtre.stage.setScene(loginScene);

            EspaceSanteBienEtre.loginWindow.setOpacity(1f);
            EspaceSanteBienEtre.loginWindow.setTranslateX(-1000);

            EspaceSanteBienEtre.signupWindow.toBack();
            EspaceSanteBienEtre.loginWindow.toFront();

            animationGenerator.applyTranslateAnimationOn(EspaceSanteBienEtre.loginWindow, 500, -1000, 0);
            animationGenerator.applyFadeAnimationOn(EspaceSanteBienEtre.loginWindow, 500, 0f, 1.0f, null);
        });
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        signup();
       
    }

    @FXML
    private void AnnulerButtonAction(ActionEvent event) throws IOException {
        cancel();
    }

@FXML
    private void loadimage(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", "*.jpg","*.png")
             
        );
         selectedfile = fc.showOpenDialog(null);
        if(selectedfile != null){
            System.out.println("aaaaaaaaaa");
            path_img= selectedfile.getAbsolutePath();
            System.out.println("sssssssssssssssss");
            System.out.println(path_img);
        }else{
            System.out.println("FICHIER erroné");
                    }

 
    }
    }

    

