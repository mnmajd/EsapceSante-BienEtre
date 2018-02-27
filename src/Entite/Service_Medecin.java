/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;

/**
 *
 * @author chayma
 */
public class Service_Medecin extends Service {

    private String promotion;
    private String langues_parlees;
    private String assurance_maladie;
    private String modes_de_reglement;
    private float tarif;
    private String specialite;
   
    private double latitude;
     private double longitude;
    

    public Service_Medecin() {
    }

    public Service_Medecin(String promotion, String langues_parlees, String assurance_maladie, String modes_de_reglement, float tarif, String specialite) {
        this.promotion = promotion;
        this.langues_parlees = langues_parlees;
        this.assurance_maladie = assurance_maladie;
        this.modes_de_reglement = modes_de_reglement;
        this.tarif = tarif;
        this.specialite = specialite;

    }

    public Service_Medecin(int id_service,String heure_ouverture, String heure_fermeture, String promotion,  float tarif,String e_mail, String adresse_etab, int tel_service, String image_serv, String langues_parlees,String modes_de_reglement, String assurance_maladie, String nom, String prenom, String specialite) {
        super(id_service, heure_ouverture, heure_fermeture, e_mail, adresse_etab, tel_service, image_serv, nom, prenom);
        this.promotion = promotion;
        this.langues_parlees = langues_parlees;
        this.assurance_maladie = assurance_maladie;
        this.modes_de_reglement = modes_de_reglement;
        this.tarif = tarif;
        this.specialite = specialite;
    }
    
    public Service_Medecin(int id_service,String heure_ouverture, String heure_fermeture, String promotion,  float tarif,String e_mail, String adresse_etab, int tel_service, String image_serv, String langues_parlees,String modes_de_reglement, String assurance_maladie, String nom, String prenom, String specialite,double longitude,double latitude,int id_user) {
        super(id_service,heure_ouverture,heure_fermeture,e_mail,adresse_etab,tel_service,image_serv,id_user,nom,prenom);
        this.promotion = promotion;
        this.langues_parlees = langues_parlees;
        this.assurance_maladie = assurance_maladie;
        this.modes_de_reglement = modes_de_reglement;
        this.tarif = tarif;
        this.specialite = specialite;
         this.longitude=longitude;
        this.latitude=latitude;
    }

    public Service_Medecin(double latitude, double longitude, String adresse_etab) {
        super(adresse_etab);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Service_Medecin(String promotion, String langues_parlees, String assurance_maladie, String modes_de_reglement, float tarif, String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String nom, String prenom) {
        super(heure_ouverture, heure_fermeture, e_mail, adresse_etab, tel_service, nom, prenom);
        this.promotion = promotion;
        this.langues_parlees = langues_parlees;
        this.assurance_maladie = assurance_maladie;
        this.modes_de_reglement = modes_de_reglement;
        this.tarif = tarif;
    }
    
   
    public Service_Medecin(String heure_ouverture, String heure_fermeture, String promotion,  float tarif,String e_mail, String adresse_etab, int tel_service, String image_serv, String langues_parlees,String modes_de_reglement, String assurance_maladie, String nom, String prenom, String specialite) {
        super(heure_ouverture, heure_fermeture, e_mail, adresse_etab, tel_service, image_serv, nom, prenom);
        this.promotion = promotion;
        this.langues_parlees = langues_parlees;
        this.assurance_maladie = assurance_maladie;
        this.modes_de_reglement = modes_de_reglement;
        this.tarif = tarif;
        this.specialite = specialite;
    }

    public Service_Medecin(String heure_ouverture, String heure_fermeture, String promotion,  float tarif,String e_mail,String adresse_etab, int tel_service, String image_serv, String langues_parlees,String modes_de_reglement, String assurance_maladie, String nom, String prenom, String specialite,double longitude,double latitude) {
        super(heure_ouverture, heure_fermeture, e_mail,adresse_etab,tel_service, image_serv, nom, prenom);
        this.promotion = promotion;
        this.langues_parlees = langues_parlees;
        this.assurance_maladie = assurance_maladie;
        this.modes_de_reglement = modes_de_reglement;
        this.tarif = tarif;
        this.specialite = specialite;
        this.longitude=longitude;
        this.latitude=latitude;
                
    }
    
     public Service_Medecin(String heure_ouverture, String heure_fermeture, String promotion,  float tarif,String e_mail,String adresse_etab, int tel_service, String image_serv, String langues_parlees,String modes_de_reglement, String assurance_maladie, String nom, String prenom,double longitude,double latitude) {
        super(heure_ouverture, heure_fermeture, e_mail,adresse_etab,tel_service, image_serv, nom, prenom);
        this.promotion = promotion;
        
        this.langues_parlees = langues_parlees;
        
        this.assurance_maladie = assurance_maladie;
        
        this.modes_de_reglement = modes_de_reglement;
        
        this.tarif = tarif;
        this.longitude=longitude;
        this.latitude=latitude;
       
      
                
    }
    
    public Service_Medecin(String promotion, String langues_parlees, String assurance_maladie, String modes_de_reglement, float tarif, String specialite, int id_service, String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, int id_user, String nom, String prenom) {
        super(id_service, heure_ouverture, heure_fermeture, e_mail, adresse_etab, tel_service, image_serv, id_user, nom, prenom);
        this.promotion = promotion;
        this.langues_parlees = langues_parlees;
        this.assurance_maladie = assurance_maladie;
        this.modes_de_reglement = modes_de_reglement;
        this.tarif = tarif;
        this.specialite = specialite;
    }

    public Service_Medecin(String modes_de_reglement, float tarif, String adresse_etab, String image_serv, String nom, String prenom, String specialite) {
        super(adresse_etab, image_serv, nom, prenom);

        this.modes_de_reglement = modes_de_reglement;
        this.tarif = tarif;

        this.specialite = specialite;
    }
    public Service_Medecin(int id_service,String modes_de_reglement, float tarif, String adresse_etab, String image_serv, String nom, String prenom, String specialite) {
        super(id_service,adresse_etab, image_serv, nom, prenom);

        this.modes_de_reglement = modes_de_reglement;
        this.tarif = tarif;
        this.specialite = specialite;
    }

    public Service_Medecin(String promotion, String langues_parlees, String assurance_maladie, String modes_de_reglement, float tarif, String specialite, double latitude, double longitude, String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String nom, String prenom) {
        super(heure_ouverture, heure_fermeture, e_mail, adresse_etab, tel_service, nom, prenom);
        this.promotion = promotion;
        this.langues_parlees = langues_parlees;
        this.assurance_maladie = assurance_maladie;
        this.modes_de_reglement = modes_de_reglement;
        this.tarif = tarif;
        this.specialite = specialite;
       
        this.latitude = latitude;
        this.longitude = longitude;
    }

    
    
//    public Service_Medecin(Date promotion, String langues_parlees, String assurance_maladie, String modes_de_reglement, float tarif, String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, int id_user) {
//        super(heure_ouverture, heure_fermeture, e_mail, adresse_etab, tel_service, image_serv, id_user ,nom ,prenom);
//        this.promotion = promotion;
//        this.langues_parlees = langues_parlees;
//        this.assurance_maladie = assurance_maladie;
//        this.modes_de_reglement = modes_de_reglement;
//        this.tarif = tarif;
//        
//    }
//    public Service_Medecin(String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, int id_user) {
//        super(heure_ouverture, heure_fermeture, e_mail, adresse_etab, tel_service, image_serv, id_user,nom,prenom);
//    }
    public Service_Medecin(String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, int id_user, String nom, String prenom, String specialite) {
        super(heure_ouverture, heure_fermeture, e_mail, adresse_etab, tel_service, image_serv, id_user, nom, prenom);
    }

    public String getPromotion() {
        return promotion;
    }

    public String getLangues_parlees() {
        return langues_parlees;
    }

    public String getAssurance_maladie() {
        return assurance_maladie;
    }

    public String getModes_de_reglement() {
        return modes_de_reglement;
    }

    public float getTarif() {
        return tarif;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public void setLangues_parlees(String langues_parlees) {
        this.langues_parlees = langues_parlees;
    }

    public void setAssurance_maladie(String assurance_maladie) {
        this.assurance_maladie = assurance_maladie;
    }

    public void setModes_de_reglement(String modes_de_reglement) {
        this.modes_de_reglement = modes_de_reglement;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

   

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        
        return super.toString() + "Service_Medecin{" + "promotion=" + promotion + ", langues_parlees=" + langues_parlees + ", assurance_maladie=" + assurance_maladie + ", modes_de_reglement=" + modes_de_reglement + ", tarif=" + tarif + ", specialite=" + specialite + '}';
    }
    
    

}