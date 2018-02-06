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
 * @author chayma
 */

  
public class Service_Pharmacie extends Service{
    private String type_pharm;
    private Date annee_creation;

    public String getType_pharm() {
        return type_pharm;
    }

    public void setType_pharm(String type_pharm) {
        this.type_pharm = type_pharm;
    }

    public Date getAnnee_creation() {
        return annee_creation;
    }

    public void setAnnee_creation(Date annee_creation) {
        this.annee_creation = annee_creation;
    }

//    public Service_Pharmacie(String type_pharm,Date annee_creation, int id_service, String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, int id_user) {
//        super(id_service, heure_ouverture, heure_fermeture, e_mail, adresse_etab, tel_service, image_serv, id_user);
//        this.type_pharm = type_pharm;
//        this.annee_creation=annee_creation;
//    }

    public Service_Pharmacie(String type_pharm,Date annee_creation, String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, int id_user) {
        super(heure_ouverture, heure_fermeture, e_mail, adresse_etab, tel_service, image_serv, id_user);
        this.type_pharm = type_pharm;
        this.annee_creation=annee_creation;
    }

//    public Service_Pharmacie(String type_pharm,Date annee_creation, String type_service, String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, int id_user) {
//        super(type_service, heure_ouverture, heure_fermeture, e_mail, adresse_etab, tel_service, image_serv, id_user);
//        this.type_pharm = type_pharm;
//        this.annee_creation=annee_creation;
//    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.type_pharm);
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
        final Service_Pharmacie other = (Service_Pharmacie) obj;
        if (!Objects.equals(this.type_pharm, other.type_pharm)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service_Pharmacie{" + "type_pharm=" + type_pharm + '}';
    }
    
     
    
}
