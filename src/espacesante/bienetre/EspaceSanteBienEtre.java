/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacesante.bienetre;

import Entite.Question;
import Entite.Reponse;
import Utils.ConnexionBD;
import Service.QuestionService;
import Service.ReponseService;
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
// Question p4 = new Question(8," est ce que c vrai");
// 
//   QuestionService.ReadQuestion();
       Reponse r1 = new Reponse (1,"je suis la preimier reponse du question");
       
       ReponseService.AddReponse(r1);
   
        
    }
    
}
