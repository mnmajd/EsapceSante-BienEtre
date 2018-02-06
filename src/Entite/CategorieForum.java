/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Objects;

/**
 *
 * @author majd
 */
public class CategorieForum {
    private int id_catF ;
    private String nom_catF ; 
    
    public CategorieForum()
    {
        
    }

    public CategorieForum(String nom_catF) {
        this.nom_catF = nom_catF;
    }

    public int getId_catF() {
        return id_catF;
    }

    public void setId_catF(int id_catF) {
        this.id_catF = id_catF;
    }

    public String getNom_catF() {
        return nom_catF;
    }

    public void setNom_catF(String nom_catF) {
        this.nom_catF = nom_catF;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id_catF;
        hash = 83 * hash + Objects.hashCode(this.nom_catF);
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
        final CategorieForum other = (CategorieForum) obj;
        if (this.id_catF != other.id_catF) {
            return false;
        }
        if (!Objects.equals(this.nom_catF, other.nom_catF)) {
            return false;
        }
        return true;
    }
        
    
    
}
