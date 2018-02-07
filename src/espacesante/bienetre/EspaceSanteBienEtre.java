/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacesante.bienetre;
import Entite.User;
import Entite.Membre;
import Service.ServiceMembre;
import Service.Service;
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
             
       Membre m= new Membre("homme", 55, 77777, "membre", "jk", "kk,", "kjjj", 888, "ddd", 777, "rrrr", "eeee", new Date(2018_02_03));
        //ServiceMembre.insererMembre(m);
         ServiceMembre.DeleteMembre(m);
            
            
            /// test user ///
            
         // User us = new User(11,"role","nom","prenom","saidjhsd@shsgfs",555,"img",8898,"titre","adresse",new Date(2017-1900 , 9-1 , 27)/*,"specialte"*/);
        // Service.insererUser(us);
       //Service.UpdateUser(new User("role","bbbb","mmm","ddqsd",555,"qd",88,"ttt","qsdqd",new Date(2017-1990 , 9-1 , 27)),1);
        //Service.selectUser().forEach(System.out::println);
        //Service.DeleteUser(us);

        
        // TODO code application logic here
       ConnexionBD $d = new ConnexionBD();
        
    }
    
}
