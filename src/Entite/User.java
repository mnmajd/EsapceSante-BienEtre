package Entite;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import utile.ConnectionBD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author said hmidi
 */
public class User {
    static User instance ;

    public int id_user ;
    public String role ;
    public String nom ;
    public String prenom ;
    public String login ;
    public int password ;
    public String image ;
    public int telephone ;
    public String titre ;
    public String adresse ;
   public Date date_naiss ;
    //public String specialte ;

    public User(String role, String nom, String prenom, String login, int password, String image, int telephone, String titre, String adresse, Date date_naiss) {
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.image = image;
        this.telephone = telephone;
        this.titre = titre;
        this.adresse = adresse;
        this.date_naiss = date_naiss;
    }

    public User(int id_user, String role, String nom, String prenom, String login, int password, String image,int telephone, String titre, String adresse, Date date_naiss /*, String specialte*/) {
        this.id_user = id_user;
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.image = image;
        this.telephone=telephone;
        this.titre = titre;
        this.adresse = adresse;
        this.date_naiss = date_naiss;
        //this.specialte = specialte;
    }

    public User() {
    }

  




    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(Date date_naiss) {
        this.date_naiss = date_naiss;
    }

    /*public String getSpecialte() {
        return specialte;
    }

    public void setSpecialte(String specialte) {
        this.specialte = specialte;
    }*/

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
        final User other = (User) obj;
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.password != other.password) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
       /* if (!Objects.equals(this.specialte, other.specialte)) {
            return false;
        }*/
       if (!Objects.equals(this.date_naiss, other.date_naiss)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "user{" + "id_user=" + id_user + ", role=" + role + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password + ", image=" + image + ", titre=" + titre + ", adresse=" + adresse  + ", date_naiss=" + date_naiss +/* ", specialte=" + specialte + */'}';
    }

   
    
       
    
    
    
    
}
