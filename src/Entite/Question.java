/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import Utils.ConnexionBD;

/**
 *
 * @author majd
 */
public class Question {
    
    private int id_question ; 
    private String contenu_question ;
    private static int id_catF = 2 ;
    private static int id_user = 3 ; 
    private static int nbr_rep = 15 ;
    static Question instance ; 

    public Question(int id_question, String contenu_question) {
        
        this.id_question = id_question;
        this.contenu_question = contenu_question;
    }

    private Question() {
    }

    public static int getNbr_rep() {
        return nbr_rep;
    }

    public static void setNbr_rep(int nbr_rep) {
        Question.nbr_rep = nbr_rep;
    }
    

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public String getContenu_question() {
        return contenu_question;
    }

    public void setContenu_question(String contenu_question) {
        this.contenu_question = contenu_question;
    }

    public static int getId_catF() {
        return id_catF;
    }

    public static void setId_catF(int id_catF) {
        Question.id_catF = id_catF;
    }

    public static int getId_user() {
        return id_user;
    }

    public static void setId_user(int id_user) {
        Question.id_user = id_user;
    }

    public static Question getInstance()
    {
        if(instance == null )
        {
            return instance = new Question();
        }
        return instance ;
    }

   
    
    
    
    
}
