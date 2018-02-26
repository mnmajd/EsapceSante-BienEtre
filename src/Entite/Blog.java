/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author TAQWA
 */
public class Blog {
  public int id_cat ;
    public int id_article ;
    public int nbr_like ;

  
    public Blog(int id_cat, int id_article) {
        this.id_cat = id_cat;
        this.id_article = id_article;
        
    }

    public Blog(int id_cat, int id_article , int nbr_like) {
        this.id_cat = id_cat;
        this.id_article = id_article;
        this.nbr_like = nbr_like ;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }
    
      public int getNbr_like() {
        return nbr_like;
    }

    public void setNbr_like(int nbr_like) {
        this.nbr_like = nbr_like;
    }

    @Override
    public String toString() {
        return "Blog{" + "id_cat=" + id_cat + ", id_article=" + id_article + ", nbr_like=" + nbr_like + '}';
    }

    
      
      
}
