/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import static Entite.Question.instance;
import java.util.Objects;

/**
 *
 * @author majd
 */
public class Reponse {
    private int id_rep ; 
    private String contenu_rep ;
    private static int nbr_aime_rep =20 ; 

    private static int id_question = 2;
    private static int  id_user  = 3;
    static Reponse instance ; 

    public Reponse( String contenu_rep) {
        
        this.contenu_rep = contenu_rep;
    }
    public Reponse ()
    {
        
    }

    public int getId_rep() {
        return id_rep;
    }

    public void setId_rep(int id_rep) {
        this.id_rep = id_rep;
    }

    public String getContenu_rep() {
        return contenu_rep;
    }

    public void setContenu_rep(String contenu_rep) {
        this.contenu_rep = contenu_rep;
    }

    public int getNbr_aime_rep() {
        return nbr_aime_rep;
    }

    public void setNbr_aime_rep(int nbr_aime_rep) {
        this.nbr_aime_rep = nbr_aime_rep;
    }


    public static int getId_question() {
        return id_question;
    }

    public static void setId_question(int id_question) {
        Reponse.id_question = id_question;
    }

    public static int getId_user() {
        return id_user;
    }

    public static void setId_user(int id_user) {
        Reponse.id_user = id_user;
    }

    public static Reponse getInstance() {
           if(instance == null )
        {
            return instance = new Reponse();
        }
        return instance ;  
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id_rep;
        hash = 59 * hash + Objects.hashCode(this.contenu_rep);
        hash = 59 * hash + this.nbr_aime_rep;
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reponse other = (Reponse) obj;
        if (this.id_rep != other.id_rep) {
            return false;
        }
        if (this.nbr_aime_rep != other.nbr_aime_rep) {
            return false;
        }
       
        if (!Objects.equals(this.contenu_rep, other.contenu_rep)) {
            return false;
        }
        return true;
    }
    
    
    
    
        
        

    
    
    
    
    
}
