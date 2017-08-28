package com.example.eleves.connecttomysql;

/**
 * Created by Administrator on 8/28/2017.
 */

public class LivreExemplaire {

    private int numExeplaire;
    private long ISBN;
    private int disponibilite;

    //------------------------------


    public LivreExemplaire(int numExeplaire, long ISBN, int disponibilite) {
        this.numExeplaire = numExeplaire;
        this.ISBN = ISBN;
        this.disponibilite = disponibilite;
    }

    //---------------------------------------
    public int getNumExeplaire() {
        return numExeplaire;
    }

    public void setNumExeplaire(int numExeplaire) {
        this.numExeplaire = numExeplaire;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public int getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }

    //---------------------------


    @Override
    public String toString() {
        return "LivreExemplaire{" +
                "numExeplaire=" + numExeplaire +
                ", ISBN=" + ISBN +
                ", disponibilite=" + disponibilite +
                '}';
    }
}
