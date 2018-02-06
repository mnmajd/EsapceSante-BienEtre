/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author said hmidi
 */
public class Membre extends User{
    
    private String sexe ;
    private int age ; 
    private int cin ;

    public Membre(String sexe, int age, int cin,String role, String nom, String prenom, String login, int password, String image, int telephone, String titre, String adresse, Date date_naiss) {
        super(role, nom, prenom, login, password, image, telephone, titre, adresse, date_naiss);
        this.sexe = sexe;
        this.age = age;
        this.cin = cin;
    }

   

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

//    public Membre(String sexe, int age, int cin, int id_user, String role, String nom, String prenom, String login, int password, String image, int telephone, String titre, String adresse, Date date_naiss, String specialte) {
//        super(id_user, role, nom, prenom, login, password, image, telephone, titre, adresse, date_naiss /*, specialte*/);
//        this.sexe = sexe;
//        this.age = age;
//        this.cin = cin;
//    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Membre other = (Membre) obj;
        if (this.cin != other.cin) {
            return false;
        }
        if (!Objects.equals(this.sexe, other.sexe)) {
            return false;
        }
        if (!Objects.equals(this.age, other.age)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Membre{" + "sexe=" + sexe + ", age=" + age + ", cin=" + cin + '}';
    }
    
    
    
    
    
}
