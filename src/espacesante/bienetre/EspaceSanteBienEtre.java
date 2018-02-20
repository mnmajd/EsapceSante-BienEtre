/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacesante.bienetre;
import Entite.User;
import Entite.Membre;
//import Entite.Prestataire;
import Service.ServiceMembre;
import Service.ServiceUser;
//import Service.ServicePrestataire;
import java.sql.Date;
import utile.ConnectionBD;
/**
 *
 * @author majd
 */
public class EspaceSanteBienEtre {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /// test admin //
      // User m = new Membre("homme", 12, 133, "said","hmidi","saidhha","2121", "d", 12, "tunis", "xxxx");
      
        //ServiceMembre membre= new ServiceMembre();
       // membre.insererMembre((Membre) m);
       // membre.signupMembre((Membre) m);
       //membre.selectMembre();
       // System.out.println(m);
        
      //Membre m= new Membre("homme", 0, 0,"said","hmidi","said.hmidi@esprit.tn", 0,"hhh", 0,"lll",new Date(2017-1990 , 9-1 , 27));
        //ServiceMembre.insererMembre((Membre) us);
        // ServiceMembre.DeleteMembre("homme");
        //ServiceMembre.selectMemebre().forEach(System.out::println);
        //ServiceMembre.UpdateMembre(new Membre("ms",55,888,"membre", "said", "hmidi", "said.hmidi",777,"hhh",22,"bbb", "jjjj", new Date(2017_03_01)),23);
            
            
            /// test user ///
            
        // User us = new User("prestatiare","mmmm","lllll","saidhmidi96@gmail.com","saidii","aaaa",8898,"tunis",new Date(2017-1900 , 9-1 , 27));
        /// ServiceUser myuser = new ServiceUser();
        
          //ServiceUser.UpdateUser(new User("role","bbbb","mmm","ddqsd",555,"qd",88,"ttt",new Date(2017-1990 , 9-1 , 27)),29);
      //  myuser.selectUser().forEach(System.out::println);
        //ServiceUser.DeleteUser(us);
      
       //myuser.UpdateUser(us, 29);
        //myuser.selectUser();
      // myuser.insererUser(us);
       //myuser.signup(us);
      // myuser.checkUsername("saidhmidi96@gmail.com", 32);
       
       
      
      
      
      
        //// test prestataire ///
       // Prestataire p = new Prestataire("string", "string0", "string1", 0, 0, "string2", "string3", new Date(2017-1990 , 9-1,27), "string4", "string5", 0, 0," string6");
        //ServicePrestataire.insererPrestataire(p);
        //ServicePrestataire.selectPrestataire(p);
    }
    
}
