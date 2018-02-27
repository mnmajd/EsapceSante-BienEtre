/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;


import java.util.Date;
import java.util.Objects;

/**
 *
 * @author chayma
 */
public class Service {
    static Service instance;
    protected int id_service;
    protected String type_service;
    protected String heure_ouverture;
    protected String heure_fermeture;
    protected String e_mail;
    protected String adresse_etab;
    protected int tel_service;
    protected String image_serv;
    protected int id_user;
    protected String nom;
    protected String prenom;

    public Service() {
    }

    public Service(String adresse_etab, String image_serv, String nom, String prenom) {
        this.adresse_etab = adresse_etab;
        this.image_serv = image_serv;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Service(int id_service, String adresse_etab, String image_serv, String nom, String prenom) {
        this.id_service = id_service;
        this.adresse_etab = adresse_etab;
        this.image_serv = image_serv;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Service(String heure_ouverture, String heure_fermeture, String e_mail, int tel_service, String image_serv, int id_user, String nom, String prenom) {
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;
        this.e_mail = e_mail;
        this.tel_service = tel_service;
        this.image_serv = image_serv;
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
    }
    

    public Service(int id_service, String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, int id_user,String nom,String prenom) {
        this.id_service = id_service;
       // this.type_service = type_service;
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;
        this.e_mail = e_mail;
        this.adresse_etab = adresse_etab;
        this.tel_service = tel_service;
        this.image_serv = image_serv;
        this.id_user = id_user;
        this.nom= nom;
        this.prenom=prenom;
    }

    public Service(String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, int id_user,String nom,String prenom) {
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;
        this.e_mail = e_mail;
        this.adresse_etab = adresse_etab;
        this.tel_service = tel_service;
        this.image_serv = image_serv;
        this.id_user = id_user;
        this.nom= nom;
        this.prenom=prenom;
    }

    public Service(String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String nom, String prenom) {
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;
        this.e_mail = e_mail;
        this.adresse_etab = adresse_etab;
        this.tel_service = tel_service;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Service(int id_service, String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, String nom, String prenom) {
        this.id_service = id_service;
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;
        this.e_mail = e_mail;
        this.adresse_etab = adresse_etab;
        this.tel_service = tel_service;
        this.image_serv = image_serv;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Service(String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, String nom, String prenom) {
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;
        this.e_mail = e_mail;
        this.adresse_etab = adresse_etab;
        this.tel_service = tel_service;
        this.image_serv = image_serv;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Service(String type_service, String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, int id_user,String nom,String prenom) {
        this.type_service = type_service;
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;
        this.e_mail = e_mail;
        this.adresse_etab = adresse_etab;
        this.tel_service = tel_service;
        this.image_serv = image_serv;
        this.id_user = id_user;
        this.nom= nom;
        this.prenom=prenom;
    }

    public Service(String heure_ouverture, String heure_fermeture, String e_mail, int tel_service, String image_serv, String nom, String prenom) {
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;
        this.e_mail = e_mail;
        this.tel_service = tel_service;
        this.image_serv = image_serv;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Service(String adresse_etab) {
        this.adresse_etab = adresse_etab;
    }

    public int getId_service() {
        return id_service;
    }

    public String getType_service() {
        return type_service;
    }

    public String getHeure_ouverture() {
        return heure_ouverture;
    }

    public String getHeure_fermeture() {
        return heure_fermeture;
    }

    public String getE_mail() {
        return e_mail;
    }

    public String getAdresse_etab() {
        return adresse_etab;
    }

    public int getTel_service() {
        return tel_service;
    }

    public String getImage_serv() {
        return image_serv;
    }

    public int getId_user() {
        return id_user;
    }

    public static void setInstance(Service instance) {
        Service.instance = instance;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public void setType_service(String type_service) {
        this.type_service = type_service;
    }

    public void setHeure_ouverture(String heure_ouverture) {
        this.heure_ouverture = heure_ouverture;
    }

    public void setHeure_fermeture(String heure_fermeture) {
        this.heure_fermeture = heure_fermeture;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public void setAdresse_etab(String adresse_etab) {
        this.adresse_etab = adresse_etab;
    }

    public void setTel_service(int tel_service) {
        this.tel_service = tel_service;
    }

    public void setImage_serv(String image_serv) {
        this.image_serv = image_serv;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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
  
    
     public static Service getInstance() {
        if (instance == null) {
            return instance = new Service();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Service{" + "id_service=" + id_service + ", type_service=" + type_service + ", heure_ouverture=" + heure_ouverture + ", heure_fermeture=" + heure_fermeture + ", e_mail=" + e_mail + ", adresse_etab=" + adresse_etab + ", tel_service=" + tel_service + ", image_serv=" + image_serv + ", id_user=" + id_user + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.id_service;
        hash = 19 * hash + Objects.hashCode(this.type_service);
        hash = 19 * hash + Objects.hashCode(this.heure_ouverture);
        hash = 19 * hash + Objects.hashCode(this.heure_fermeture);
        hash = 19 * hash + Objects.hashCode(this.e_mail);
        hash = 19 * hash + Objects.hashCode(this.adresse_etab);
        hash = 19 * hash + this.tel_service;
        hash = 19 * hash + Objects.hashCode(this.image_serv);
        hash = 19 * hash + this.id_user;
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
        final Service other = (Service) obj;
        if (this.id_service != other.id_service) {
            return false;
        }
        if (this.tel_service != other.tel_service) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (!Objects.equals(this.type_service, other.type_service)) {
            return false;
        }
        if (!Objects.equals(this.e_mail, other.e_mail)) {
            return false;
        }
        if (!Objects.equals(this.adresse_etab, other.adresse_etab)) {
            return false;
        }
        if (!Objects.equals(this.image_serv, other.image_serv)) {
            return false;
        }
        if (!Objects.equals(this.heure_ouverture, other.heure_ouverture)) {
            return false;
        }
        if (!Objects.equals(this.heure_fermeture, other.heure_fermeture)) {
            return false;
        }
        return true;
    }
      
      
}