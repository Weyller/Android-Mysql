package com.example.eleves.connecttomysql;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 8/28/2017.
 */

public class Livre implements Serializable{

    private int numExemplaire;
    private long ISBN;
    private String datePublication;
    private int nbPages;
    private int quantite;
    private int disponibilite;
    private int idEditeur;
    private String titre;
    private String nomEditeur;
    private String nomAuteur;
    private String prenAuteur;
    private int typeLivre;


    //==============================================

    public Livre() {


    }


    public Livre(int numExemplaire, long ISBN, String datePublication, int nbPages, int quantite,
                 int disponibilite, int idEditeur, String titre, String nomEditeur, String nomAuteur,
                 String prenAuteur, int typeLivre) {
        this.numExemplaire = numExemplaire;
        this.ISBN = ISBN;
        this.datePublication = datePublication;
        this.nbPages = nbPages;
        this.quantite = quantite;
        this.disponibilite = disponibilite;
        this.idEditeur = idEditeur;
        this.titre = titre;
        this.nomEditeur = nomEditeur;
        this.nomAuteur = nomAuteur;
        this.prenAuteur = prenAuteur;
        this.typeLivre = typeLivre;
    }


    //----------------------------


    public int getNumExemplaire() {
        return numExemplaire;
    }

    public void setNumExemplaire(int numExemplaire) {
        this.numExemplaire = numExemplaire;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
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

    public int getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }

    public int getIdEditeur() {
        return idEditeur;
    }

    public void setIdEditeur(int idEditeur) {
        this.idEditeur = idEditeur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNomEditeur() {
        return nomEditeur;
    }

    public void setNomEditeur(String nomEditeur) {
        this.nomEditeur = nomEditeur;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    public String getPrenAuteur() {
        return prenAuteur;
    }

    public void setPrenAuteur(String prenAuteur) {
        this.prenAuteur = prenAuteur;
    }

    public int getTypeLivre() {
        return typeLivre;
    }

    public void setTypeLivre(int typeLivre) {
        this.typeLivre = typeLivre;
    }

    //===============================


    @Override
    public String toString() {
        return "Livre{" +
                "numExemplaire=" + numExemplaire +
                ", ISBN=" + ISBN +
                ", datePublication=" + datePublication +
                ", nbPages=" + nbPages +
                ", quantite=" + quantite +
                ", disponibilite=" + disponibilite +
                ", idEditeur=" + idEditeur +
                ", titre='" + titre + '\'' +
                ", nomEditeur='" + nomEditeur + '\'' +
                ", nomAuteur='" + nomAuteur + '\'' +
                ", prenAuteur='" + prenAuteur + '\'' +
                ", typeLivre=" + typeLivre +
                '}';
    }
}
