package Entite;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
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

    public Integer id ;
    public String role ;
    public String nom ;
    public String prenom ;
    public String login ;
    public String password ;
    public String image ;
    public int telephone ;
   // public String titre ;
    public String adresse ;
   public String date_naiss ;
   //public String specialte ;
   private String status;

  

    
   

    public User(String role, String nom, String prenom, String login, String password, String image, int telephone, String adresse, String date_naiss, String status) {
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.image = image;
        this.telephone = telephone;
        this.adresse = adresse;
        this.date_naiss = date_naiss;
        this.status = status;
    }

     
   
    public User(String role, String nom, String prenom, String login, String password, String image, int telephone, String adresse, String date_naiss) {
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.image = image;
        this.telephone = telephone;
        
        this.adresse = adresse;
        this.date_naiss = date_naiss;
        
    }
    

    public User(Integer id, String role, String nom, String prenom, String login, String password, String image,int telephone,String adresse, String date_naiss ) {
        this.id = id;
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.image = image;
        this.telephone=telephone;
       
        this.adresse = adresse;
        this.date_naiss = date_naiss;
        
    }

    public User(String nom, String prenom, String login, String password, String image, int telephone, String adresse, String date_naiss) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.image = image;
        this.telephone = telephone;
        this.adresse = adresse;
        this.date_naiss = date_naiss;
    }
    

    public User() {
    }

  




    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getRole(){
        if(this instanceof Admin){
            return "Admin";
        }
        if(this instanceof Membre){
            return "Responsable Membre";
        }
       
        return "Prestataire";
    }
   /* public String getRole() {
        return role;
    }*/

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

  

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
 
    
    //transient
    
    
    
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
        if (this.id != other.id) {
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
      
        
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
       /* if (!Objects.equals(this.specialte, other.specialte)) {
            return false;
        }*/
       if (!Objects.equals(this.date_naiss, other.date_naiss)) {
            return false;
        }
       if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", role=" + role + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password + ", image=" + image + ", telephone=" + telephone + ", adresse=" + adresse + ", date_naiss=" + date_naiss + ", status=" + status + '}';
    }

    
    

   
    
       
    
    
    
    
}
