/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Service;
import Entite.Service_Medecin;
import Entite.Service_Pharmacie;
import Entite.Service_SalleDeSport;
import Utile.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chayma
 */
public class Service_service {

    public static void addserviceMed(Service_Medecin m) {
        try {

            String req = "Insert into service values(?,?,?,?,?,?,?,?,?,?,?,NULL,?,?,?,NULL,NULL,NULL,NULL)";

            PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1, m.getId_service());
            ste.setString(2, "medecin");
            ste.setString(3, m.getHeure_ouverture());
            ste.setString(4, m.getHeure_fermeture());
            ste.setDate(5, m.getPromotion());
            ste.setFloat(6, m.getTarif());
            ste.setString(7, m.getE_mail());
            ste.setString(8, m.getAdresse_etab());
            ste.setInt(9, m.getTel_service());
            ste.setInt(10, m.getId_user());
            ste.setString(11, m.getImage_serv());
            ste.setString(12, m.getLangues_parlees());
            ste.setString(13, m.getAssurance_maladie());
            ste.setString(14, m.getModes_de_reglement());

            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void addserviceSport(Service_SalleDeSport sp) {
        try {

            String req = "Insert into service values(?,?,?,?,NULL,NULL,?,?,?,?,?,?,NULL,NULL,NULL,?,?,?,NULL)";

            PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1, sp.getId_service());
            ste.setString(2, "Salle-De_Sport");
            ste.setString(3, sp.getHeure_ouverture());
            ste.setString(4, sp.getHeure_fermeture());
            ste.setString(5, sp.getE_mail());
            ste.setString(6, sp.getAdresse_etab());
            ste.setInt(7, sp.getTel_service());
            ste.setInt(8, sp.getId_user());
            ste.setString(9, sp.getImage_serv());
            ste.setDate(10, sp.getAnnee_creation());
            ste.setString(11, sp.getActivite());
            ste.setString(12, sp.getCible());
            ste.setString(13, sp.getDescription());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void addservicePharmacie(Service_Pharmacie ph) {
        try {

            String req = "Insert into service(`type_service`, "
                    + "`annee_creation`, "
                    + "`heure_ouverture`, "
                    + "`heure_fermeture`, "
                    + "`promotion`, "
                    + "`tarif`, "
                    + "`e_mail`, "
                    + "`adresse_etab`, "
                    + "`tel_service`, "
                    + "`id_user`, "
                    + "`image_serv`, "
                    + "`langues_parlees`, "
                    + "`modes_de_reglement`, "
                    + "`assurance_maladie`, "
                    + "`activite`, "
                    + "`cible`, `description`, `type_pharm`) values(?,?,?,?,NULL,NULL,?,?,?,?,?,NULL,NULL,NULL,NULL,NULL,NULL,?)";

            PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req);

            ste.setString(1, "Pharmacie");
            ste.setDate(2, ph.getAnnee_creation());
            ste.setString(3, ph.getHeure_ouverture());
            ste.setString(4, ph.getHeure_fermeture());
            ste.setString(5, ph.getE_mail());

            ste.setString(6, ph.getAdresse_etab());
            ste.setInt(7, ph.getTel_service());
            ste.setInt(8, ph.getId_user());
            ste.setString(9, ph.getImage_serv());
            ste.setString(10, ph.getType_pharm());

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
            String req2 = "UPDATE  service SET heure_ouverture=?,heure_fermeture=?,promotion=?,tarif=?,e_mail=?,adresse_etab=?,tel_service=?,image_serv=?,langues_parlees=?,modes_de_reglement=?,assurance_maladie=?  WHERE id_service=?";
            PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req2);
            ste.setString(1, m.getHeure_ouverture());
            ste.setString(2, m.getHeure_fermeture());
            ste.setDate(3, m.getPromotion());
            ste.setFloat(4, m.getTarif());
            ste.setString(5, m.getE_mail());
            ste.setString(6, m.getAdresse_etab());
            ste.setInt(7, m.getTel_service());
            ste.setString(8, m.getImage_serv());
            ste.setString(9, m.getLangues_parlees());
            ste.setString(10, m.getModes_de_reglement());
            ste.setString(11, m.getAssurance_maladie());
            ste.setInt(12, id);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service_service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void updateServicePHARM(Service_Pharmacie m, int id) {

        try {
            String req2 = "UPDATE  service SET heure_ouverture=?,heure_fermeture=?,e_mail=?,adresse_etab=?,tel_service=?,image_serv=?,annee_creation=?,type_pharm=?  WHERE id_service=?";
            PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req2);
            ste.setString(1, m.getHeure_ouverture());
            ste.setString(2, m.getHeure_fermeture());
            ste.setString(3, m.getE_mail());
            ste.setString(4, m.getAdresse_etab());
            ste.setInt(5, m.getTel_service());
            ste.setString(6, m.getImage_serv());
            ste.setDate(7,m.getAnnee_creation());
            ste.setString(8, m.getType_pharm());
            ste.setInt(9, id);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service_service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void updateServiceSPORT(Service_SalleDeSport m, int id) {

        try {
            String req3 = "UPDATE  service SET heure_ouverture=?,heure_fermeture=?,e_mail=?,adresse_etab=?,tel_service=?,image_serv=?,annee_creation=?,activite=?,cible=?,description=?  WHERE id_service=?";
            PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req3);
            ste.setString(1, m.getHeure_ouverture());
            ste.setString(2, m.getHeure_fermeture());
            ste.setString(3, m.getE_mail());
            ste.setString(4, m.getAdresse_etab());
            ste.setInt(5, m.getTel_service());
            ste.setString(6, m.getImage_serv());
            ste.setDate(7,m.getAnnee_creation());
            ste.setString(8, m.getActivite());
            ste.setString(9, m.getCible());
            ste.setString(10, m.getDescription());
            ste.setInt(11, id);
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
                list.add(new Service_Medecin(result.getDate("promotion"),
                        result.getString("Langues_parlees"),
                        result.getString("Assurance_maladie"),
                        result.getString("Modes_de_reglement"),
                        result.getFloat("tarif"),
                        result.getString("heure_ouverture"),
                        result.getString("heure_fermeture"),
                        result.getString("e_mail"),
                        result.getString("Adresse_etab"),
                        result.getInt("Tel_service"),
                        result.getString("image_serv"),
                        result.getInt("Id_user")
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static List<Service_SalleDeSport> SelectServiceSPORT(String type_service) {
        List<Service_SalleDeSport> list = new ArrayList<>();
        try {
            String req4 = "SELECT * FROM service where type_service=? ";
            PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req4);
            ste.setString(1, type_service);
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                //String activite, String cible, String description,Date annee_creation, String heure_ouverture, 
               // String heure_fermeture, String e_mail, String adresse_etab, 
                        //int tel_service, String image_serv, int id_user
                list.add(new Service_SalleDeSport(result.getString("activite"),
                        result.getString("cible"),
                        result.getString("description"),
                        result.getDate("annee_creation"),
                        result.getString("heure_ouverture"),
                        result.getString("heure_fermeture"),
                        result.getString("e_mail"),
                        result.getString("adresse_etab"),
                        result.getInt("Tel_service"),
                        result.getString("image_serv"),
                        result.getInt("Id_user")
                                 
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
     public static List<Service_Pharmacie> SelectServicePHARMACIE(String type_service) {
        List<Service_Pharmacie> list = new ArrayList<>();
        try {
            String req4 = "SELECT * FROM service where type_service=? ";
            PreparedStatement ste = ConnexionBD.getInstance().getConnection().prepareStatement(req4);
            ste.setString(1, type_service);
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(new Service_Pharmacie(result.getString("type_pharm"),
                        result.getDate("annee_creation"),
                        result.getString("heure_ouverture"),
                        result.getString("heure_fermeture"),
                        result.getString("e_mail"),
                        result.getString("adresse_etab"),
                        result.getInt("Tel_service"),
                        result.getString("image_serv"),
                        result.getInt("Id_user")
                                 
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
/**/
