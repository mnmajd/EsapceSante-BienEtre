package Service;

import Entite.Annonce;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Utile.DataSource;
import espacesante.bienetre.EspaceSanteBienEtre;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceUser {

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
            ste.setDate(4, An.getDate_annonce());
            ste.setString(5, An.getAddr_annonce());
            ste.setInt(6, An.getTel_annonce());
            ste.setString(7, An.getImg_annonce());
            ste.setInt(8, An.getId_user());

            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void updateAnnonce(Annonce An, int id) {
        try {
            String req = "UPDATE Annonce SET type_annonce =?, titre_annonce=? ,desc_annonce=?,date_annonce=?,addr_annonce=?,tel_annonce=?,img_annonce=?,id_user=?   WHERE Id_annonce=" + id;
            PreparedStatement ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, An.getType_annonce());
            ste.setString(2, An.getTitre_annonce());
            ste.setString(3, An.getDesc_annonce());
            ste.setDate(4, An.getDate_annonce());
            ste.setString(5, An.getAddr_annonce());
            ste.setInt(6, An.getTel_annonce());
            ste.setString(7, An.getImg_annonce());
            ste.setInt(8, An.getId_user());

            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void deleteAnnonce(int id) {
        try {
            String req = "DELETE FROM Annonce WHERE Id_annonce =" + id;
            PreparedStatement ste = ds.getConnection().prepareStatement(req);

            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EspaceSanteBienEtre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Annonce> selectAnnonce() {
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
                System.out.println(Id_annonce+"------"+Date_annonce);

            } return list ;
        } catch (SQLException ex) {
            Logger.getLogger(Annonce.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        }
       
    }

    // Select * FROM `Annonce` where type_annonce="event";
}
