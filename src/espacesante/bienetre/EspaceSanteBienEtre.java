/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacesante.bienetre;

import Entite.Service;
import Entite.Service_Medecin;
import Service.Service_service;
import Utile.ConnexionBD;
import java.sql.Date;
import java.util.List;


/**
 *
 * @author majd
 */
public class EspaceSanteBienEtre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 Service_Medecin m1= new Service_Medecin(new Date (2017-01-01), "arabe", "CNAM", "espece", 550, 4,"9h", "18h", "dd.dd@esprit.tn", "eeee", 11245554, "C:\\Users\\chayma\\Desktop\\testweb",1);
        //Service_service.addservice(m1); 
        //Service s = new Service();
                /*Service s= new Service_Medecin(promotion, langues_parlees, assurance_maladie, modes_de_reglement, 0, 0, type_service, heure_ouverture, heure_fermeture, e_mail, adresse_etab, 0, image_serv, 0);
       Service m1= new Service("2012-01-01","francais","cnam","espece",100,1,"medecin","2013-01-01 00:00:00","2013-01-01 00:00:00","ch.ch@esprit.tn", "gggg", 1453,"C:\\Users\\chayma\\Desktop\\testweb",1);
        Service_service.addservice(m1);*/
      //Service_Medecin m1= new Service_Medecin(new Date (2017-01-01), "francais", "CNAM", "espece", 450, 10,"9h", "18h", "dd.dd@esprit.tn", "eeee", 11245554, "C:\\Users\\chayma\\Desktop\\testweb",1);
      //Service_service.DeleteService(1);
      //m1.setLangues_parlees("espangol");
             // m1.setModes_de_reglement("fffff");
             // m1.setLangues_parlees("aaaaa");
     //Service_service.updateService(m1,4);
        List<Service_Medecin> list= Service_service.SelectServiceMED("medecin");
          for ( Service_Medecin element : list)
         {    System.out.println(element.getE_mail());

     
         }
      
      
    }
    
}
