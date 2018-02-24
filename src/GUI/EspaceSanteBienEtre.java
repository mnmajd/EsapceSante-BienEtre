//EspaceSanteBienEtre 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package GUI;
import Entite.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Locale;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import Utils.AnimationGenerator;




public class EspaceSanteBienEtre  extends Application {
    public static Stage stage;
    public static AnchorPane loginWindow;
    public static Parent signupWindow;
    public static Scene loginScene;
    public static Scene signupScene;
    
    public static User currentUser;

    static Stage stageprim, stage1, stage2, stage4, stage3, stage5, stage6,stage7;
    public String clinicName = "";

    @Override
    public void start(Stage primaryStage) throws Exception {
//        this.stage = primaryStage;
//        splashWindow();
        this.stage = primaryStage;
        loginWindow();
    }
     public void loginWindow() {
        try {
            currentUser = null;
            loginWindow = FXMLLoader.load(getClass().getResource("Login.fxml"));

            loginScene = new Scene(loginWindow);
            stage.getIcons().add(new Image("/GUI/Images/doc.png"));
            stage.setScene(loginScene);
            stage.setMinHeight(770);
            stage.setMaxHeight(770);
            
            stage.setMinWidth(1370);
            stage.setMaxWidth(1370);
            stage.centerOnScreen();
            stage.setTitle("Espace Sante Bien etre");
           // stage.setFullScreen(true);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public static void logout() 
     {
        AnimationGenerator animationGenerator = new AnimationGenerator();
        animationGenerator.applyFadeAnimationOn(stage.getScene().getRoot(), 500, 1.0f, 0f, event -> {
            try {
                EspaceSanteBienEtre.currentUser = null;
                loginWindow = FXMLLoader.load(EspaceSanteBienEtre.class.getResource("Login.fxml"));
                loginScene = new Scene(loginWindow);
                EspaceSanteBienEtre.stage.setScene(loginScene);
                stage.centerOnScreen();
                EspaceSanteBienEtre.loginWindow.setOpacity(1f);
                animationGenerator.applyFadeAnimationOn(EspaceSanteBienEtre.loginWindow, 500, 0f, 1.0f, null);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
    }
        
    
         
  
     
    
     
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //   Client c=new Client(2,3,"mimi","momo","w=alha","balhaaaaaa","loulou.123");
      // GestionUser gs=new GestionUser();
//       // gs.add_client(c);
//        System.out.println("succses");
//            gs.lister().forEach(System.out::println);
//System.out.println(c1.getLogin());
//
//           System.out.println(c1.getPassword());
// //System.out.println(gs.verif_C(c1.getPassword(),c1.getLogin())); 
// boolean ok=gs.verif_Client(c1.getLogin(),c1.getPassword());
//        if (ok) {
//            System.out.println("okk");}
//  else{
//            System.out.println("not ok");}
//        
//              Client c1=new Client("loooool","bbbbb");
//                GestionClients gs1 = new GestionClients();
//                gs1.update_client(c1,1);
//        gs.delete_client(4);
        
//        Boutique b=new Boutique(5,"zara");
//        
//        
//        ChefBoutique ch=new ChefBoutique(2,1,"xxx","raed","bouteraa","ooo@gmail.com","kjnjkn","nkjnkj","jkbhjb",b);
//        gs.add_chef_boutique(ch);
//        boolean x= gs.verif_C(c.getLogin(),c.getPassword());
//        if (x==true) {
//            System.out.println("okk");}
//            else{
//            System.out.println("not ok");}
            
       
                Locale.setDefault(new Locale("en", "US"));


 
                 launch(args);
//       GestionClients gs1= new GestionClients();
//        System.out.println(gs1.add_solde("1234", 2));
// try {
//                        String host = "localhost";
//                        int port = 9500;
//                        String username = "admin";
//                        String password = "abc123";
//
//                        MyOzSmsClient osc = new MyOzSmsClient(host, port);
//                        osc.login(username, password);
//
//                        
//                        String line = "Hello World";
//
//                        System.out.println("SMS message:");
//
//                        if(osc.isLoggedIn()) {
//                                osc.sendMessage("+21627170090", line);
//                                osc.logout();
//                        }
//
//
//                } catch (IOException e) {
//                        System.out.println(e.toString());
//                        e.printStackTrace();
//                } catch (InterruptedException e) {
//                        System.out.println(e.toString());
//                        e.printStackTrace();
//                }
    }   
}

