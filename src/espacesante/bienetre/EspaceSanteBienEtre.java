/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacesante.bienetre;

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
//   Question q = new Question ("Medecine" ,"pharmacie" ,"je peut pas dormir tres bien ");
//      QuestionService.getInstance().AddQuestion(q);
//    List<Question> p = new ArrayList<>() ; 
//    p=   QuestionService.getInstance().ReadQuestion();
//    
//        for ( Question e : p) {
//            System.out.println(" {");
//                System.out.print(e.getContenu_question());
//                System.out.print( e.getSujet_question());
//                System.out.print(e.getNbr_rep());
//                System.out.print(e.getDate_publication());
//                System.out.println("} /n");
//          }
        
//       Question q = QuestionService.SpecifiedQuestion(31);
//        System.out.println(q.getContenu_question());

        
//            System.out.println(QuestionService.GetPhoneNumber(3));
//            System.out.println(QuestionService.getInstance().GetCredential(3));


        ReponseService.getInstance().DeleteLikedQuestion(4,3);




        
    }
    
}
