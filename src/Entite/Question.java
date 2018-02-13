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
    private String nom_catF ; 
    private static int id_user = 3 ; 
    private  int nbr_rep = 0 ;
    private String sujet_question ;
    private boolean approved_question = false ; 
    static Question instance ; 

    public Question( String sujet_question  ,String nom_catF,String contenu_question  ) {
        
        this.sujet_question = sujet_question;
        this.contenu_question = contenu_question;
        this.nom_catF =nom_catF;
    }

    private Question() {
    }

    public  int getNbr_rep() {
        return nbr_rep;
    }

    public  void setNbr_rep(int nbr_rep) {
        this.nbr_rep = nbr_rep;
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

    public String getNom_catF() {
        return nom_catF;
    }

    public void setNom_catF(String nom_catF) {
        this.nom_catF = nom_catF;
    }

   
    public static int getId_user() {
        return id_user;
    }

    public static void setId_user(int id_user) {
        Question.id_user = id_user;
    }

    public String getSujet_question() {
        return sujet_question;
    }

    public void setSujet_question(String sujet_question) {
        this.sujet_question = sujet_question;
    }

    public boolean isApproved_question() {
        return approved_question;
    }

    public void setApproved_question(boolean approved_question) {
        this.approved_question = approved_question;
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
