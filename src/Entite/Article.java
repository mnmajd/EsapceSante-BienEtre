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
 * @author TAQWA
 */
public class Article{

 

 
    int id_article ;
    int id_cat  ;
    String titre_article ; 
    String sujet_article;	
    String contenu_article;
    Date date_pub ;
    String img_artc	;
  
       int id_user = 3 ;

    public Article(int id_article, 
            String titre_article, String sujet_article,
            String contenu_article,  String img_artc, int id_user, int id_cat) {
        
        this.id_article = id_article;
        this.titre_article = titre_article;
        this.sujet_article = sujet_article;
        this.contenu_article = contenu_article;
       // this.date_pub = date_pub ;
        this.img_artc = img_artc;
       
        this.id_user = id_user;
        this.id_cat = id_cat;
    }

//    public Article(String titr, String sujet, String contenu, Date dateobj, String imaage, int i, int i0, int i1) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public Article(String titr, String sujet, String contenu, Date dateobj, String imaage) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.



    public Article(String titre_article, String sujet_article, String contenu_article, String img_artc, int id_user,int id_cat) {
        
        this.titre_article = titre_article;
        this.sujet_article = sujet_article;
        this.contenu_article = contenu_article;
        this.img_artc = img_artc;
       
        
        this.id_user = id_user;
        this.id_cat = id_cat;
    }

    public Article() {
    }

  public Article(int id_article, String titre_article, String sujet_article, String contenu_article, String img_artc)
  
  { this.id_article = id_article;
      this.titre_article = titre_article;
        this.sujet_article = sujet_article;
        this.contenu_article = contenu_article;
        this.img_artc = img_artc;
       }
  
  public Article(int id_article , String titre_article, String sujet_article, String contenu_article,Date date_pub, String img_artc)
  
  {this.id_article = id_article;
      this.titre_article = titre_article;
        this.sujet_article = sujet_article;
        this.contenu_article = contenu_article;
        this.date_pub = date_pub ; 
        this.img_artc = img_artc;
       }


   
    
    

//    }
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public String getTitre_article() {
        return titre_article;
    }

    public void setTitre_article(String titre_article) {
        this.titre_article = titre_article;
    }

    public String getSujet_article() {
        return sujet_article;
    }

    public void setSujet_article(String sujet_article) {
        this.sujet_article = sujet_article;
    }

    public String getContenu_article() {
        return contenu_article;
    }

    public void setContenu_article(String contenu_article) {
        this.contenu_article = contenu_article;
    }

    public String getImg_artc() {
        return img_artc;
    }

    public void setImg_artc(String img_artc) {
        this.img_artc = img_artc;
    }

    

    public Date getDate_pub() {
        return date_pub;
    }

    public void setDate_pub(Date date_pub) {
        this.date_pub = date_pub;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_user;
        hash = 29 * hash + this.id_article;
        hash = 29 * hash + this.id_cat;
        hash = 29 * hash + Objects.hashCode(this.titre_article);
        hash = 29 * hash + Objects.hashCode(this.sujet_article);
        hash = 29 * hash + Objects.hashCode(this.contenu_article);
        hash = 29 * hash + Objects.hashCode(this.img_artc);
      
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
        final Article other = (Article) obj;
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.id_article != other.id_article) {
            return false;
        }
        if (this.id_cat != other.id_cat) {
            return false;
        }
       
        if (!Objects.equals(this.titre_article, other.titre_article)) {
            return false;
        }
        if (!Objects.equals(this.sujet_article, other.sujet_article)) {
            return false;
        }
        if (!Objects.equals(this.contenu_article, other.contenu_article)) {
            return false;
        }
        if (!Objects.equals(this.img_artc, other.img_artc)) {
            return false;
        }
        return true;
    }
    
    
    

}
  