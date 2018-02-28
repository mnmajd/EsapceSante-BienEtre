/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Service;
import Entite.Service_Medecin;

import Utils.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entite.Rating;

/**
 *
 * @author chayma
 */
public class Service_service {

    public static void addserviceMed(Service_Medecin m) {
        try {

            String req = "Insert into service values(?,?,?,?,?,?,?,?,?,?,?,NULL,?,?,?,NULL,NULL,NULL,NULL,?,?,?,?,?)";

            PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1, m.getId_service());
            ste.setString(2, "medecin");
            ste.setString(3, m.getHeure_ouverture());
            ste.setString(4, m.getHeure_fermeture());
            ste.setString(5, m.getPromotion());
            ste.setFloat(6, m.getTarif());
            ste.setString(7, m.getE_mail());
            ste.setString(8, m.getAdresse_etab());
            ste.setInt(9, m.getTel_service());
            ste.setInt(10, 1);
            ste.setString(11, m.getImage_serv());
            ste.setString(12, m.getLangues_parlees());
            ste.setString(13, m.getModes_de_reglement());
            ste.setString(14, m.getAssurance_maladie());
            ste.setString(15, m.getNom());
            ste.setString(16, m.getPrenom());
            ste.setString(17, m.getSpecialite());
            ste.setDouble(18, m.getLongitude());
            ste.setDouble(19, m.getLatitude());

            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    

    public static void DeleteService(int id_service) {

        try {
            String req1 = "DELETE  FROM service WHERE id_service=?";
            PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req1);

            ste.setInt(1, id_service);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service_service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateServiceMED(Service_Medecin m, int id) {

        try {
            String req2 = "UPDATE  service SET heure_ouverture=?,heure_fermeture=?,promotion=?,tarif=?,e_mail=?,adresse_etab=?,tel_service=?,image_serv=?,langues_parlees=?,modes_de_reglement=?,assurance_maladie=?,nom=?,prenom=?,latitude=?,longitude=?  WHERE id_service=?";
            PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req2);
            ste.setString(1, m.getHeure_ouverture());
            ste.setString(2, m.getHeure_fermeture());
            ste.setString(3, m.getPromotion());
            ste.setFloat(4, m.getTarif());
            ste.setString(5, m.getE_mail());
            ste.setString(6, m.getAdresse_etab());
            ste.setInt(7, m.getTel_service());
            ste.setString(8, m.getImage_serv());
            ste.setString(9, m.getLangues_parlees());
            ste.setString(10, m.getModes_de_reglement());
            ste.setString(11, m.getAssurance_maladie());
            ste.setString(12, m.getNom());
            ste.setString(13, m.getPrenom());
           
             ste.setDouble(14, m.getLongitude());
            ste.setDouble(15, m.getLatitude());
            ste.setInt(16, id);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service_service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<Service_Medecin> SelectServiceMED(String type_service) {
        List<Service_Medecin> list = new ArrayList<>();
        try {
            String req3 = "SELECT * FROM service where type_service=? ";
            PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req3);
            ste.setString(1, type_service);
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                // String image_serv, String langues_parlees,String modes_de_reglement, String assurance_maladie, String nom, String prenom, String specialite) {

                list.add(new Service_Medecin(
                        result.getInt("id_service"),
                        result.getString("heure_ouverture"),
                        result.getString("heure_fermeture"),
                        result.getString("promotion"),
                        result.getFloat("tarif"),
                        result.getString("e_mail"),
                        result.getString("adresse_etab"),
                        result.getInt("tel_service"),
                        result.getString("image_serv"),
                        result.getString("langues_parlees"),
                        result.getString("modes_de_reglement"),
                        result.getString("assurance_maladie"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("specialite")
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static List<Service_Medecin> SelectServiceMED1(String type_service) {
        List<Service_Medecin> list = new ArrayList<>();
        try {
            String req3 = "SELECT * FROM service where type_service=? ";
            PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req3);
            ste.setString(1, type_service);
            ResultSet result = ste.executeQuery();
            while (result.next()) {
               list.add(new Service_Medecin(
                      
                        result.getInt("id_service"),
                        result.getString("heure_ouverture"),
                        result.getString("heure_fermeture"),
                        result.getString("promotion"),
                        result.getFloat("tarif"),
                        result.getString("e_mail"),
                        result.getString("adresse_etab"),
                        result.getInt("tel_service"),
                        result.getString("image_serv"),
                        result.getString("langues_parlees"),
                        result.getString("modes_de_reglement"),
                        result.getString("assurance_maladie"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("specialite"),
                        result.getDouble("longitude"),
                        result.getDouble("latitude"),
                        result.getInt("id_user")
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    public static List<Service_Medecin> findmedbyspec(String specialite){
             List<Service_Medecin> list = new ArrayList<>();
try{
       String req4 = "SELECT * FROM service where specialite LIKE ? ";
        PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req4);
       ste.setString(1, "%"+specialite.toLowerCase()+"%");
       
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(new Service_Medecin(
                        result.getInt("id_service"),
                        result.getString("heure_ouverture"),
                        result.getString("heure_fermeture"),
                        result.getString("promotion"),
                        result.getFloat("tarif"),
                        result.getString("e_mail"),
                        result.getString("adresse_etab"),
                        result.getInt("tel_service"),
                        result.getString("image_serv"),
                        result.getString("langues_parlees"),
                        result.getString("modes_de_reglement"),
                        result.getString("assurance_maladie"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("specialite"),
                        result.getDouble("longitude"),
                        result.getDouble("latitude"),
                        result.getInt("id_user")
                ));
                                        System.out.println(result.getInt("id_service"));

      
       }
         } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
}
    
     public static List<Service_Medecin> findmedbyadresse(String adresse_etab){
             List<Service_Medecin> list = new ArrayList<>();
try{
       String req4 = "SELECT * FROM service where adresse_etab LIKE ? ";
        PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req4);
       ste.setString(1, "%"+adresse_etab.toLowerCase()+"%");
      
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(new Service_Medecin(
                            result.getInt("id_service"),
                        result.getString("heure_ouverture"),
                         result.getString("heure_fermeture"),
                        result.getString("promotion"),
                        result.getFloat("tarif"),
                        result.getString("e_mail"),
                        result.getString("adresse_etab"),
                        result.getInt("tel_service"),
                        result.getString("image_serv"),
                        result.getString("langues_parlees"),
                        result.getString("modes_de_reglement"),
                        result.getString("assurance_maladie"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("specialite")
                ));
       
       }
         } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
} 
     
     
     public static List<Service_Medecin> findmedbynom(String nom){
             List<Service_Medecin> list = new ArrayList<>();
try{
       String req4 = "SELECT * FROM service where nom LIKE ? ";
        PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req4);
       ste.setString(1, "%"+nom.toLowerCase()+"%");
       
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(new Service_Medecin(
                       result.getInt("id_service"),
                        result.getString("heure_ouverture"),
                        result.getString("heure_fermeture"),
                        result.getString("promotion"),
                        result.getFloat("tarif"),
                        result.getString("e_mail"),
                        result.getString("adresse_etab"),
                        result.getInt("tel_service"),
                        result.getString("image_serv"),
                        result.getString("langues_parlees"),
                        result.getString("modes_de_reglement"),
                        result.getString("assurance_maladie"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("specialite"),
                        result.getDouble("longitude"),
                        result.getDouble("latitude"),
                        result.getInt("id_user")
                ));
       
       }
         } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
}
     
       public static List<Service_Medecin> findmedbymail(String e_mail){
             List<Service_Medecin> list = new ArrayList<>();
try{
       String req4 = "SELECT * FROM service where e_mail LIKE ? ";
        PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req4);
       ste.setString(1, "%"+e_mail.toLowerCase()+"%");
      
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(new Service_Medecin(
                        result.getInt("id_service"),
                        result.getString("heure_ouverture"),
                         result.getString("heure_fermeture"),
                        result.getString("promotion"),
                        result.getFloat("tarif"),
                        result.getString("e_mail"),
                        result.getString("adresse_etab"),
                        result.getInt("tel_service"),
                        result.getString("image_serv"),
                        result.getString("langues_parlees"),
                        result.getString("modes_de_reglement"),
                        result.getString("assurance_maladie"),
                        result.getString("nom"),
                        result.getString("prenom"),
                         result.getString("specialite"),
                        result.getDouble("longitude"),
                        result.getDouble("latitude"),
                        result.getInt("id_user")
                ));
                                        System.out.println(result.getInt("id_service"));

      
       }
         } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
}
     
     public static List<Service_Medecin> findmedbyid(int id){
             List<Service_Medecin> list = new ArrayList<>();
try{
       String req4 = "SELECT * FROM service where id_service = ? ";
        PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req4);
      
       ste.setString(1, String.valueOf(id));
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(new Service_Medecin(
                        result.getString("heure_ouverture"),
                         result.getString("heure_fermeture"),
                        result.getString("promotion"),
                        result.getFloat("tarif"),
                        result.getString("e_mail"),
                        result.getString("adresse_etab"),
                        result.getInt("tel_service"),
                        result.getString("image_serv"),
                        result.getString("langues_parlees"),
                        result.getString("modes_de_reglement"),
                        result.getString("assurance_maladie"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("specialite")
                ));
       
       }
         } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
}

     
      public static List<Service_Medecin> findmedbyiduser(int id_user){
             List<Service_Medecin> list = new ArrayList<>();
try{
       String req4 = "SELECT * FROM service where id_user = ? ";
        PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req4);
       
       ste.setString(1, String.valueOf(id_user));
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(new Service_Medecin(
                         result.getInt("id_service"),
                        result.getString("heure_ouverture"),
                         result.getString("heure_fermeture"),
                        result.getString("promotion"),
                        result.getFloat("tarif"),
                        result.getString("e_mail"),
                        result.getString("adresse_etab"),
                        result.getInt("tel_service"),
                        result.getString("image_serv"),
                        result.getString("langues_parlees"),
                        result.getString("modes_de_reglement"),
                        result.getString("assurance_maladie"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("specialite"),
                        result.getDouble("longitude"),
                        result.getDouble("latitude"),
                        result.getInt("id_user")
                ));
       
       }
         } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
}

    

    
      public static List<Rating> Selectrat(int id_service) {
        List<Rating> list = new ArrayList<>();
        try {
            String req3 = "SELECT * FROM rating where id_service=? ";
            PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req3);
            ste.setInt(1, id_service);
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                // String image_serv, String langues_parlees,String modes_de_reglement, String assurance_maladie, String nom, String prenom, String specialite) {

                list.add(new Rating(
                        result.getInt("id_rating"),
                        result.getInt("id_user"),
                        result.getFloat("valeur"),
                         result.getInt("id_service")
                        
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
      
      
      
      public static Float getVote(int id) {
        String req = "SELECT avg(valeur) FROM rating where id_service=?";
        Float y = 0f;
        try {
           PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);       
           ste.setInt(1, id);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                y = rs.getFloat(1);
            }

        } catch (SQLException ex) {
            System.out.println("Problème importation liste Vote");
        }
        return y;
    }

    public static void setRating(int id_service, int id_user, int valeur) {
        String req = "INSERT INTO rating(id_service, id_user, valeur) VALUES(?,?,?)";
        try {
             PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1, id_service);
            ste.setInt(2, id_user);
            ste.setInt(3, valeur);
            ste.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Problème rating");
        }

    }

    public static void updateRating(int valeur, int id_user, int id_service) {
        String req = "UPDATE rating SET valeur=? WHERE (id_user=? AND id_service=?)";
        try {
            PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1, valeur);
            ste.setInt(2, id_user);
            ste.setInt(3, id_service);

            ste.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Problème rating");
        }
    }

    public static Float getRating(int id_user, int id_service) {
        String req = "SELECT * FROM rating WHERE id_user=? AND id_service=?";
         Float y = 0f;
        try {
           PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1, id_user);
            ste.setInt(2, id_service);
            ste.executeQuery();
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                y = rs.getFloat("valeur");
            }
           
        } catch (SQLException ex) {
            System.out.println("Problème rating");
        }
       
        return y;
        
    }
      
      
}

