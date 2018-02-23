/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import GUI.*;
import utils.*;
import test.*;
import entites.*;
import espacesante.bienetre.EspaceSanteBienEtre;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.management.Notification;
import javax.swing.text.Position;
import org.controlsfx.control.Notifications;

import services.UserDAO;
import static espacesante.bienetre.EspaceSanteBienEtre.stage;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utile.AnimationGenerator;
import utile.FacebookController;
import utile.UserStatus;



public class LoginController implements Initializable {

    @FXML
    private JFXTextField usernameTextField;
    @FXML
    private JFXPasswordField passwordTextField;
    @FXML
    private Button loginButton;
    AnchorPane AnchorPane;
   private AnimationGenerator animationGenerator;
    @FXML
    private Button SinginButton;
    @FXML
    private JFXButton mdpOublie;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   animationGenerator = new AnimationGenerator();
//   mdpOublie.setOnMouseClicked((MouseEvent event) -> {
//         try {
//             
//             Stage stage = new Stage();
//             Stage stageprev = (Stage) mdpOublie.getScene().getWindow();
//             
//             FXMLLoader loader = new FXMLLoader(getClass().getResource("ForgetPassword.fxml"));
//             Parent parent = loader.load();
//             
//             Stage stagep = new Stage();
//             Scene scene = new Scene(parent);
//             stage.setScene(scene);
//             stage.setResizable(false);
//             stage.show();
//             stageprev.close();
//         } catch (IOException ex) {
//             Logger.getLogger(ForgetPasswordController.class.getName()).log(Level.SEVERE, null, ex);
//         }
//        });

    }   
    
    public void login() {
        UserDAO userDAO = new UserDAO();
        try {

            User user = userDAO.login(usernameTextField.getText(), passwordTextField.getText());
            if (user != null) {
                if (user.getStatus().equals(UserStatus.PENDING)) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Votre demande n'est encore traite par l'administrateur");
                    alert.showAndWait();
                   
                    return;
                }
                if (user.getStatus().equals(UserStatus.REFUSED)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Votre demande et refuser");
                    alert.showAndWait();
                    return;
                }
                if (user.getStatus().equals(UserStatus.DELETED)
                        || user.getStatus().equals(UserStatus.BLOCKED)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Votre compte et soit blocquer ou sumpprier par l'administrateur!");
                    alert.showAndWait();
                    return;
                }
                
                    
       
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Welcome to Espace sante");
                alert.setHeaderText("Welcome!");
                EspaceSanteBienEtre.currentUser = user;
                System.out.println("Current logged in user role: " + EspaceSanteBienEtre.currentUser.getRole());
                    animateWhenLoginSuccess();
              
             //  Notifications  notification=Notifications.create()
                                   // .graphic(new ImageView(image))
//                                    .title("Sign in complete ")
//                                    .text(usernameTextField.getText() +" has loged in")
//                                    .hideAfter(Duration.seconds(3))
//                                    .position(Pos.BOTTOM_RIGHT);                           
     //                      notification.showInformation();
         
               

            } else {
                animateWhenBadLogin();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
      private void animateWhenBadLogin() {
        try {
            ImageView imageView = new ImageView(new Image("images/Delete-50.png"));
            Label wrong = new Label("Invalide Nom d'utilisateur/Mot de passe");
            VBox temp = new VBox(imageView, wrong);
            temp.setAlignment(Pos.CENTER);

            animationGenerator.applyFadeAnimationOn(EspaceSanteBienEtre.loginWindow, 500, 1.0f, 0f, event -> {
                temp.setOpacity(0f);

                double oldWidth = EspaceSanteBienEtre.stage.getWidth();
                double oldHeight = EspaceSanteBienEtre.stage.getHeight();

                EspaceSanteBienEtre.stage.setScene(new Scene(temp, oldWidth , oldHeight));
                animationGenerator.applyFadeAnimationOn(temp, 1000, 0f, 1.0f, event1 -> {
                    animationGenerator.applyFadeAnimationOn(temp, 1000, 1, 0f, null);
                    EspaceSanteBienEtre.loginWindow.setOpacity(0f);
                    PauseTransition pause = new PauseTransition(Duration.millis(2000));
                    pause.setOnFinished(ev -> {
                        EspaceSanteBienEtre.stage.setScene(EspaceSanteBienEtre.loginScene);
                        animationGenerator.applyFadeAnimationOn(EspaceSanteBienEtre.loginWindow, 500, 0f, 1.0f, null);
                    });
                    pause.play();
                });
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
       public  void animateWhenLoginSuccess() {
        try {
            final Parent dashboard;

            switch (EspaceSanteBienEtre.currentUser.getRole().toLowerCase()) {
                case "admin":
                    
                    dashboard = FXMLLoader.load(getClass().getResource("/GUI/admin/DashboardView.fxml"));
                    break;
                case "prestataire":
                    dashboard = FXMLLoader.load(getClass().getResource("/GUI/membre/MembreView.fxml"));
                    break;
                
                case "membre":
                    dashboard = FXMLLoader.load(getClass().getResource("/GUI/membre/MembreView.fxml"));
                    break;
                default:
                    throw new AssertionError();
            }
            ImageView imageView = new ImageView(new Image("/images/Checkmark-50.png"));
            Label welcome = new Label("Bienvenue chez Notre Espace sante");
            welcome.setFont(new Font("BebasNeueRegular", 24));
            VBox temp = new VBox(imageView, welcome);
            temp.setAlignment(Pos.CENTER);

            animationGenerator.applyFadeAnimationOn(AnchorPane, 1000, 1.0f, 0f, event -> {
                temp.setOpacity(0);
                double oldWidth = EspaceSanteBienEtre.stage.getWidth();
                double oldHeight = EspaceSanteBienEtre.stage.getHeight();

                EspaceSanteBienEtre.stage.setScene(new Scene(temp, oldWidth, oldHeight));
                animationGenerator.applyFadeAnimationOn(temp, 1000, 0f, 1.0f, event1 -> {
                    animationGenerator.applyFadeAnimationOn(temp, 1000, 1.0f, 0f, event2 -> {
                        EspaceSanteBienEtre.stage.setScene(new Scene(dashboard, 1400, 850));
                       EspaceSanteBienEtre.stage.centerOnScreen();
                      // Pidev.stage.setFullScreen(true);

                        animationGenerator.applyFadeAnimationOn(dashboard, 1000, 0f, 1.0f, null);
                    });
                });
            });
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        TrayNotification tray = new TrayNotification("Login avec Succés !", "", NotificationType.SUCCESS);
    //   tray.position(Pos.TOP_RIGHT);
        tray.showAndWait();
        
    }
//        public void keypress(KeyEvent keyEvent) {
//        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
//            login();
//        }
//    }

  public void signup() throws IOException {
        EspaceSanteBienEtre.signupWindow = FXMLLoader.load(getClass().getResource("/GUI/singin/singup.fxml"));

        animationGenerator.applyTranslateAnimationOn(EspaceSanteBienEtre.loginWindow, 1000, 0, -1000);
        animationGenerator.applyFadeAnimationOn(EspaceSanteBienEtre.loginWindow, 500, 1.0f, 0f, event -> {
            double oldWidth = EspaceSanteBienEtre.stage.getWidth();
            double minHeight = EspaceSanteBienEtre.stage.getHeight();
            EspaceSanteBienEtre.signupScene = new Scene(EspaceSanteBienEtre.signupWindow, oldWidth - 20, minHeight);
            EspaceSanteBienEtre.stage.setScene(EspaceSanteBienEtre.signupScene);
            EspaceSanteBienEtre.stage.setMinHeight(minHeight);
            EspaceSanteBienEtre.stage.setMinHeight(800);
            EspaceSanteBienEtre.stage.centerOnScreen();
            
            EspaceSanteBienEtre.signupWindow.setOpacity(1f);
            EspaceSanteBienEtre.signupWindow.setTranslateX(1000);

            EspaceSanteBienEtre.loginWindow.toBack();
            EspaceSanteBienEtre.signupWindow.toFront();

            animationGenerator.applyTranslateAnimationOn(EspaceSanteBienEtre.signupWindow, 500, 1000, 0);
            animationGenerator.applyFadeAnimationOn(EspaceSanteBienEtre.signupWindow, 500, 0f, 1.0f, null);
        });

    }

    

    @FXML
    private void loginButtoAnction(ActionEvent event) {
         login();
         

        
//         Image i=new Image("images/Delete-50.png");
//                    mimi.notificationDeConfirmation(event, i);
//         if(usernameTextField.getText().isEmpty()&&(passwordTextField.getText().isEmpty()))
//                {
//                    
//                }else
//         {Client c =new Client();
//        c.setUsername(usernameTextField.getText());
//        System.out.println(usernameTextField.getText());
//        
//        c.setPassword(passwordTextField.getText());
//        System.out.println(passwordTextField.getText());
//       
//        
//        
//     Image i= new Image("/images/Checkmark-50");
//     mimi.notificationDeConfirmation(event , i);
//         }
    }

    @FXML
    private void SinginButtonAction(ActionEvent event) throws IOException {
        signup();
        
    }

    @FXML
    private void forgetpass(MouseEvent event) throws IOException {
         final Parent dashboard;
        dashboard = FXMLLoader.load(getClass().getResource("/GUI/ForgetPassword.fxml"));

         animationGenerator.applyFadeAnimationOn(AnchorPane, 1000, 1.0f, 0f, event1 -> {
                double oldWidth = EspaceSanteBienEtre.stage.getWidth();
                double oldHeight = EspaceSanteBienEtre.stage.getHeight();

               
                        EspaceSanteBienEtre.stage.setScene(new Scene(dashboard, 1350, 750));
                        EspaceSanteBienEtre.stage.centerOnScreen();
                      // Pidev.stage.setFullScreen(true);

                        animationGenerator.applyFadeAnimationOn(dashboard, 1000, 0f, 1.0f, null);
                    });
           

        
    }
    
    

    
}
