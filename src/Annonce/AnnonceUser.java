/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Annonce;

import Entite.Annonce;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Utile.DataSource;
import espacesante.bienetre.EspaceSanteBienEtre;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;

public class AnnonceUser {

    static DataSource ds = DataSource.getInstance();

    public static void inserAnnonce(Annonce An) {
        try {
            String req = "INSERT INTO Annonce (`type_annonce`,"
                    + " `titre_annonce`, "
                    + "`desc_annonce`, "
                    + "`date_annonce`,"
                    + " `addr_annonce`,"
                    + " `tel_annonce`,"
                    + " `img_annonce`,"
                    + " `id_user`) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, An.getType_annonce());
            ste.setString(2, An.getTitre_annonce());
            ste.setString(3, An.getDesc_annonce());

            ste.setString(4, An.getDate_annonce());
            ste.setString(5, An.getAddr_annonce());
            ste.setInt(6, An.getTel_annonce());
            ste.setString(7, An.getImg_annonce());
            ste.setInt(8, An.getId_user());

            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void updateAnnonce(Annonce An, int id) {
        try {
            String req = "UPDATE Annonce SET type_annonce =?, titre_annonce=? ,desc_annonce=?,date_annonce=?,addr_annonce=?,tel_annonce=?,img_annonce=?,id_user=?   WHERE Id_annonce=" + id;
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, An.getType_annonce());
            ste.setString(2, An.getTitre_annonce());
            ste.setString(3, An.getDesc_annonce());
            ste.setString(4, An.getDate_annonce());
            ste.setString(5, An.getAddr_annonce());
            ste.setInt(6, An.getTel_annonce());
            ste.setString(7, An.getImg_annonce());
            ste.setInt(8, An.getId_user());

            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void deleteAnnonce(int id) {
        try {
            String req = "DELETE FROM Annonce WHERE Id_annonce =" + id;
            PreparedStatement ste = ds.getConnection().prepareStatement(req);

            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EspaceSanteBienEtre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Annonce> selectAnnonce() {
        List<Annonce> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM Annonce ";
            PreparedStatement ste = ds.getConnection().prepareStatement(req);

            ResultSet result = ste.executeQuery();
            while (result.next()) {

                Annonce Annonce = new Annonce();
                int Id_annonce = result.getInt("Id_annonce");
                int Id_user = result.getInt("Id_user");
                String Titre_annonce = result.getString("Titre_annonce");
                String Img_annonce = result.getString("Img_annonce");
                String Desc_annonce = result.getString("Desc_annonce");
                Date Date_annonce = result.getDate("Date_annonce");
                String Addr_annonce = result.getString("Addr_annonce");
                int Tel_annonce = result.getInt("Tel_annonce");
                String Type_annonce = result.getString("Type_annonce");
                list.add(Annonce);
                System.out.println(Id_annonce + "-----" + Id_user + "-------" + Titre_annonce + "------" + Date_annonce);

            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Annonce.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static List<Annonce> selectAnnonce1() {
        List<Annonce> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM Annonce ";
            PreparedStatement ste = ds.getConnection().prepareStatement(req);

            ResultSet result = ste.executeQuery();
            while (result.next()) {
                list.add(new Annonce(
                        result.getInt("id_annonce"),
                        result.getString("Type_annonce"),
                        result.getString("Titre_annonce"),
                        result.getString("Date_annonce"),
                        result.getString("Desc_annonce"),
                        result.getString("Addr_annonce"),
                        result.getInt("Tel_annonce"),
                        result.getString("Img_annonce")
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Annonce.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

//    public static List<String> EvenmntList() {
//        List<String> p = new ArrayList<>();
//        try {
//            String sql = " select titre_annonce from Annonce";
//            PreparedStatement ste = ds.getConnection().prepareStatement(sql);
//            ResultSet result = ste.executeQuery();
//            while (result.next()) {
//                p.add(result.getString("Titre_Annonce"));
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        return p;
//    }
}
