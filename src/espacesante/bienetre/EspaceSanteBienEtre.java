/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacesante.bienetre;


import Entite.Service;
import Entite.Service_Medecin;
import Entite.Service_Pharmacie;
import Entite.Service_SalleDeSport;
import Service.Service_service;
import Utile.ConnexionBD;
import java.sql.Date;
import java.util.List;
//import Service.Service_Pharmacie;
=======
import Entite.CategorieForum;
import Entite.Question;
import Entite.Reponse;
import Utils.ConnexionBD;
import Service.QuestionService;
import Service.ReponseService;
import Service.ServiceCategorieForum;
import java.util.ArrayList;
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


        //******************************AJOUTER MEDECIN
        //Service_Medecin m1= new Service_Medecin(new Date (2017-01-01), "arabe", "CNAM", "espece", 550,"9h", "18h", "dd.dd@esprit.tn", "eeee", 11245554, "C:\\Users\\chayma\\Desktop\\testweb",1);
//Service_service.addserviceMed(m1); 
//**********************************************
        // **************************************************************************AJOUTER SALLE DE SPORT
        //Service_SalleDeSport sp1= new Service_SalleDeSport("gym","jeune","lalalala",new Date (2009-01-01),"6h","20h","ttttt","manar",46545645,"rrrr",1);
//Service_service.addserviceSport(sp1);
        //Service_service.addservice(m1); 
        //************************************************
        //***************************************Ajouter Pharmacie
        // Service_Pharmacie ph1 = new Service_Pharmacie("Jour", new Date(2012 - 01 - 11), "5h", "6h", "tttttttt", "hjhl", 999999, "yyyy", 1);
        //Service_service.addservicePharmacie(ph1);
        //************************************************
        //******************************SUPPRIMER SERVICE
        //Service_service.DeleteService(10);
        //************************************************
        //******************************Afficher MEDECIN
//         List<Service_Medecin> list= Service_service.SelectServiceMED("medecin");
//          for ( Service_Medecin element : list)
//         {    System.out.println(element.getE_mail());
//        }
        //************************************************
        //******************************Afficher SALLE DE SPORT
        /* List<Service_SalleDeSport> list= Service_service.SelectServiceSPORT("Salle-De_Sport");
          for ( Service_SalleDeSport element : list)
        {    System.out.println(element.getE_mail());
        }*/
        //************************************************
        //******************************Afficher PHARMACIE
        /*List<Service_Pharmacie> list= Service_service.SelectServicePHARMACIE("Pharmacie");
          for ( Service_Pharmacie element : list)
        {    System.out.println(element.getType_pharm());
        }*/
        //************************************************
        
        
        //******************************MODIFIER MEDECIN
//        Service_Medecin m1 = new Service_Medecin(new Date(2017 - 01 - 01), "espagnol", "CNAM", "espece", 450, "9h", "18h", "dd.dd@esprit.tn", "eeee", 11245554, "C:\\Users\\chayma\\Desktop\\testweb", 1);
//
//        m1.setLangues_parlees("espangol");
//        m1.setModes_de_reglement("fffff");
//        m1.setLangues_parlees("aaaaa");
//        Service_service.updateServiceMED(m1, 4);
        //************************************************
        
         //******************************MODIFIER PHARMACIE
//         Service_Pharmacie ph1= new Service_Pharmacie("Nuit", new Date(2012 - 01 - 11), "9h", "6h", "hhhhhh", "hjhl", 45555, "yyyy", 1);
//        ph1.setType_pharm("garde");
//        ph1.setHeure_fermeture("16h");
//        ph1.setAdresse_etab("rererer");
//       
//        Service_service.updateServicePHARM(ph1,17);
        //************************************************

        
          //******************************MODIFIER SALLE DE SPORT
          
         Service_SalleDeSport s1 = new Service_SalleDeSport();
                 s1.setActivite("hello");
       
        Service_service.updateServiceSPORT(s1,18);
        //************************************************

        
        
        
        
        
//Service s = new Service();
        /*Service s= new Service_Medecin(promotion, langues_parlees, assurance_maladie, modes_de_reglement, 0, 0, type_service, heure_ouverture, heure_fermeture, e_mail, adresse_etab, 0, image_serv, 0);
       Service m1= new Service("2012-01-01","francais","cnam","espece",100,1,"medecin","2013-01-01 00:00:00","2013-01-01 00:00:00","ch.ch@esprit.tn", "gggg", 1453,"C:\\Users\\chayma\\Desktop\\testweb",1);
        Service_service.addserviceMed(m1);*/
=======
        
        // TODO code application logic here
    
// Question p2 = new Question(2,"quelle est le nom de maladie");
// Question p3= new Question(3,"g une question ");
//Question p6 = new Question(25," mardi ++ ");
//
//  QuestionService.getInstance().DeleteQuestion(p6);
  
  //QuestionService.getInstance().AddQuestion(p6);
   
//       
// Reponse p = new Reponse (" je pense que c la crooection") ;
// Reponse p1 =new Reponse (" faux ou vrai  ? ") ;
// //ReponseService.getInstance().AddReponse(p);
// //ReponseService.getInstance().AddReponse(p1);
// //ReponseService.getInstance().ReadQuestion();
//       p.setContenu_rep(" c le changement");
// ReponseService.getInstance().UpdateReponse(p, 4);
   
       // ReponseService.getInstance().DeleteReponse(p1);
       
//  CategorieForum c = new CategorieForum("dentaire")    ;
//        ServiceCategorieForum.getInstance().AddCategorie(c);
//        Question q = new Question(15,"g mal au dents");
//        QuestionService.getInstance().AddQuestion(q);
   Question q = new Question ("Medecine" ,"pharmacie" ,"je peut pas dormir tres bien ");
      QuestionService.getInstance().AddQuestion(q);
        
       







        
    }
    //*******************************************************
}
