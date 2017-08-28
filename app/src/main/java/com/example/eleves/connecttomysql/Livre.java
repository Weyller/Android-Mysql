package com.example.eleves.connecttomysql;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 8/28/2017.
 */

public class Livre {

    private long ISBN;
    private Date datePublication;
    private int nbPages;
    private int quantite;
    private int idEditeur;
    private String nomEditeur;
    private String titre;
    private String auteurs;
    private int numExemplaire;


    //----------------------------


    public String getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(String auteurs) {
        this.auteurs = auteurs;
    }

    //---------------------------------------------------
    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getIdEditeur() {
        return idEditeur;
    }

    public void setIdEditeur(int idEditeur) {
        this.idEditeur = idEditeur;
    }

    public String getNomEditeur() {
        return nomEditeur;
    }

    public void setNomEditeur(String nomEditeur) {
        this.nomEditeur = nomEditeur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }




    public int getNumExemplaire() {
        return numExemplaire;
    }

    public void setNumExemplaire(int numExemplaire) {
        this.numExemplaire = numExemplaire;
    }
    //--------------------------------------------


    @Override
    public String toString() {
        return "Livre{" +
                "ISBN=" + ISBN +
                ", datePublication=" + datePublication +
                ", nbPages=" + nbPages +
                ", quantite=" + quantite +
                ", idEditeur=" + idEditeur +
                ", nomEditeur='" + nomEditeur + '\'' +
                ", titre='" + titre + '\'' +
                ", auteurs=" + auteurs +
                ", numExemplaire=" + numExemplaire +
                '}';
    }
}
