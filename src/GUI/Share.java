/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.FXMLmembreViewController;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import com.restfb.types.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author TAQWA
 */
public class Share implements Initializable {
   String t = FXMLmembreViewController.t ;
   


      
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
         
        String accessToken = "EAACEdEose0cBABFFUTn5gZCVZAVKMa76pXTh45mvCZAqc5ACI3vlDAEfDUb7zsK7SXhZCHmKJqPRZC9aLUBJeWs6kwDgcZArYrdUSVmQZBNqQTjzPkLN1ZBd1Y0PtZB4YbzjeYQvQRgSFHlXP3zb8Jlq4CAItUOXf7tagcHqmlPbmoEZBYM0aOAmVuJGSL7HNIJMnjaVy6ry5ztQZDZD";
        // TODO code application logic here
      
        FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_5);
      //  User me = fbClient.fetchObject("me", User.class);
        //System.out.println(me.getName());
       // System.out.println(me.getLanguages());
       
     // FacebookType response =  fbClient.publish("me/feed", FacebookType.class,com.restfb.Parameter.with("message", "JAVA Graph API Test"));
      FacebookType response = fbClient.publish("me/feed",FacebookType.class,com.restfb.Parameter.with("message", t));
        System.out.println("fb.com/"+response.getId());

    }
    
}
