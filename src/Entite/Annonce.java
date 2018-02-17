package Entite;

import java.sql.Date;
import java.time.LocalDate;

public class Annonce {

    public int id_annonce;
    public String type_annonce;
    public String titre_annonce;
    public String date_annonce;
    public String desc_annonce;
    public String addr_annonce;
    public int tel_annonce;
    public String img_annonce;
    public static int id_user = 2;

    public Annonce() {
    }

    public Annonce(int id_annonce, String type_annonce, String titre_annonce, String date_annonce, String desc_annonce, String addr_annonce, int tel_annonce, String img_annonce) {
       
        this.id_annonce = id_annonce;
        this.type_annonce = type_annonce;
        this.titre_annonce = titre_annonce;
        this.date_annonce = date_annonce;
        this.desc_annonce = desc_annonce;
        this.addr_annonce = addr_annonce;
        this.tel_annonce = tel_annonce;
        this.img_annonce = img_annonce;
    }

    public Annonce(String titre_annonce) {
        this.titre_annonce = titre_annonce;
    }

    public Annonce(String type_annonce, String titre_annonce, String date_annonce, String desc_annonce, String addr_annonce, int tel_annonce, String img_annonce) {
        
        this.type_annonce = type_annonce;
        this.titre_annonce = titre_annonce;
        this.date_annonce = date_annonce;
        this.desc_annonce = desc_annonce;
        this.addr_annonce = addr_annonce;
        this.tel_annonce = tel_annonce;
        this.img_annonce = img_annonce;
    }
    public Annonce(String type_annonce, String titre_annonce, String date_annonce, String desc_annonce, String addr_annonce, int tel_annonce, String img_annonce, int id_user) {

        this.id_user = id_user;
        this.type_annonce = type_annonce;
        this.titre_annonce = titre_annonce;
        this.date_annonce = date_annonce;
        this.desc_annonce = desc_annonce;
        this.addr_annonce = addr_annonce;
        this.tel_annonce = tel_annonce;
        this.img_annonce = img_annonce;
    }
//
//    public Annonce(int id_annonce, String type_annonce, String titre_annonce, String date_annonce, String desc_annonce, String addr_annonce, int tel_annonce, String img_annonce) {
//        this.id_annonce = id_annonce;
//        this.type_annonce = type_annonce;
//        this.titre_annonce = titre_annonce;
//        this.date_annonce = date_annonce;
//        this.desc_annonce = desc_annonce;
//        this.addr_annonce = addr_annonce;
//        this.tel_annonce = tel_annonce;
//        this.img_annonce = img_annonce;
//    }

   

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public String getType_annonce() {
        return type_annonce;
    }

    public void setType_annonce(String type_annonce) {
        this.type_annonce = type_annonce;
    }

    public String getTitre_annonce() {
        return titre_annonce;
    }

    public void setTitre_annonce(String titre_annonce) {
        this.titre_annonce = titre_annonce;
    }

    public String getDate_annonce() {
        return date_annonce;
    }

    public void setDate_annonce(String date_annonce) {
        this.date_annonce = date_annonce;
    }

    public String getDesc_annonce() {
        return desc_annonce;
    }

    public void setDesc_annonce(String desc_annonce) {
        this.desc_annonce = desc_annonce;
    }

    public String getAddr_annonce() {
        return addr_annonce;
    }

    public void setAddr_annonce(String addr_annonce) {
        this.addr_annonce = addr_annonce;
    }

    public int getTel_annonce() {
        return tel_annonce;
    }

    public void setTel_annonce(int tel_annonce) {
        this.tel_annonce = tel_annonce;
    }

    public String getImg_annonce() {
        return img_annonce;
    }

    public void setImg_annonce(String img_annonce) {
        this.img_annonce = img_annonce;
    }

    public static int getId_user() {
        return id_user;
    }

    public static void setId_user(int id_user) {
        Annonce.id_user = id_user;
    }

}
