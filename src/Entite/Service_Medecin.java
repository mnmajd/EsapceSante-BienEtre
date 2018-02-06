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
public class Service_Medecin extends Service{
    private Date promotion;
    private String langues_parlees;
    private String assurance_maladie;
    private String modes_de_reglement;
    private float tarif;

    public Service_Medecin() {
    }

    public Service_Medecin(Date promotion, String langues_parlees, String assurance_maladie, String modes_de_reglement, float tarif) {
        this.promotion = promotion;
        this.langues_parlees = langues_parlees;
        this.assurance_maladie = assurance_maladie;
        this.modes_de_reglement = modes_de_reglement;
        this.tarif = tarif;
    }

   /* public Service_Medecin(String type_service, String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, int id_user) {
        super(type_service, heure_ouverture, heure_fermeture, e_mail, adresse_etab, tel_service, image_serv, id_user);
        this.promotion = promotion;
        this.langues_parlees = langues_parlees;
        this.assurance_maladie = assurance_maladie;
        this.modes_de_reglement = modes_de_reglement;
        this.tarif = tarif;
    }*/


    
    public Service_Medecin(Date promotion, String langues_parlees, String assurance_maladie, String modes_de_reglement, float tarif, int id_service, String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, int id_user) {
        super(id_service, heure_ouverture, heure_fermeture, e_mail, adresse_etab, tel_service, image_serv, id_user);
        this.promotion = promotion;
        this.langues_parlees = langues_parlees;
        this.assurance_maladie = assurance_maladie;
        this.modes_de_reglement = modes_de_reglement;
        this.tarif = tarif;
    }

    

    public Date getPromotion() {
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

    public void setPromotion(Date promotion) {
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
    
    
}
