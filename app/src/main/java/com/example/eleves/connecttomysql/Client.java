package com.example.eleves.connecttomysql;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 8/28/2017.
 */

public class Client implements Serializable{


    private int idClient;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String login;
    private String password;
    private String email;

    public Client() {

    }

    public Client(int idClient, String nom, String prenom, String adresse, String telephone, String login, String password, String email) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    //====================================
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


