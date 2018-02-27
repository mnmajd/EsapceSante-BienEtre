/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Entite;
//
//import java.sql.Date;
//import java.util.Objects;
//
///**
// *
// * @author chayma
// */
//public class Service_SalleDeSport extends Service{
//    private String activite;
//    private String cible;
//    private String description;
//    private Date annee_creation;
//
//    public Service_SalleDeSport(String activite, String cible, String description,Date annee_creation) {
//        this.activite = activite;
//        this.cible = cible;
//        this.description = description;
//        this.annee_creation=annee_creation;
//    }
//
//    public Service_SalleDeSport(String type_service, String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, int id_user) {
//        super(type_service, heure_ouverture, heure_fermeture, e_mail, adresse_etab, tel_service, image_serv, id_user);
//    }
//
//    public Service_SalleDeSport(String activite, String cible, String description,Date annee_creation, String heure_ouverture, String heure_fermeture, String e_mail, String adresse_etab, int tel_service, String image_serv, int id_user) {
//        super( heure_ouverture, heure_fermeture, e_mail, adresse_etab, tel_service, image_serv, id_user);
//        this.activite = activite;
//        this.cible = cible;
//        this.description = description;
//        this.annee_creation=annee_creation;
//    }
//
//    public Date getAnnee_creation() {
//        return annee_creation;
//    }
//
//    public void setAnnee_creation(Date annee_creation) {
//        this.annee_creation = annee_creation;
//    }
//
//    public Service_SalleDeSport(){
//    }
//
//    public String getActivite() {
//        return activite;
//    }
//
//    public void setActivite(String activite) {
//        this.activite = activite;
//    }
//
//    public String getCible() {
//        return cible;
//    }
//
//    public void setCible(String cible) {
//        this.cible = cible;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Override
//    public String toString() {
//        return "Service_SalleDeSport{" + "activite=" + activite + ", cible=" + cible + ", description=" + description + '}';
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 29 * hash + Objects.hashCode(this.activite);
//        hash = 29 * hash + Objects.hashCode(this.cible);
//        hash = 29 * hash + Objects.hashCode(this.description);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Service_SalleDeSport other = (Service_SalleDeSport) obj;
//        if (!Objects.equals(this.activite, other.activite)) {
//            return false;
//        }
//        if (!Objects.equals(this.cible, other.cible)) {
//            return false;
//        }
//        if (!Objects.equals(this.description, other.description)) {
//            return false;
//        }
//        return true;
//    }
//    
//    
//}