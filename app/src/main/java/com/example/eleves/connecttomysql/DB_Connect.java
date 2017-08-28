package com.example.eleves.connecttomysql;

/**
 * Created by Administrator on 8/27/2017.
 */



import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DB_Connect {

    private final String USER = "root";
    private final String PASSWORD = "root";

    static Connection con;
    //------------------------------

    static Connection DBConnection() {


        try {
            //
            Class.forName("com.mysql.jdbc.Driver");
            //

            String url = "jdbc:mysql://10.0.2.2:3306/";
            con = DriverManager.getConnection(
                    url, "root", "root");
            //
            System.out.println("URL: " + url);
            System.out.println("Connection: " + con);
            //

            //con.close();

            Log.e("LOG_CAT", "connection created");


        } catch (Exception e) {
            e.printStackTrace();

            Log.e("LOG_ERROR", "ERROR connection");

        }
        return con;
    }
    //========================================================================

    public static int createDatabase() {

        int status = 0;

        try {

            con = DBConnection();
            Statement stmt;
            stmt = con.createStatement();


            status = stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS biblio");

            Log.e("LOG_STATUS","STATUS = " + status);
            stmt.close();
            con.close();

            if(status == 1) {

                Log.e("LOG_CAT", "database created");
            }


        } catch (Exception e) {
            e.printStackTrace();

            Log.e("LOG_ERROR", "ERROR database");

        }

        return status;
    }




    //=========================================================================
    public static int createTable() {

        int status = 0;

        try {
            //
           con = DBConnection();
            //
            Statement stmt;
            stmt = con.createStatement();
            stmt.executeQuery("use biblio");
            //===================================================================


            //-----------Client----------------------//
            stmt = con.createStatement();
            status = stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Client " +
                            "(IdClient int(10)  NOT NULL AUTO_INCREMENT, " +
                            "NomClient VARCHAR(50) NOT NULL,  " +
                            "PrClient VARCHAR(50) NOT NULL,  " +
                            "AdrClient VARCHAR(50) NOT NULL,  " +
                            "CelClient VARCHAR(15) NOT NULL,  " +
                            "Login VARCHAR(15) DEFAULT NULL,  " +
                            "Password VARCHAR(15) DEFAULT NULL,  " +
                            "EmailClient VARCHAR(50) NOT NULL,  " +
                            "PRIMARY KEY(IdClient))");

            status = stmt.executeUpdate("INSERT INTO `client` (`IdClient`, `NomClient`, `PrClient`, `AdrClient`," +
                    " `CelClient`, `Login`, `Password`, `EmailClient`) VALUES ('10', 'Robitaille', 'Antoine'," +
                    " '123 rue du Sud Longueuil', '514-598-8897', NULL, NULL, 'rob@gmail.com'), ('11', 'Desir', 'Weyller'," +
                    " '157 rue Briggs Montreal', '514-929-7894', NULL, NULL, 'weyller@gmail.com')");


            //-----------Livre----------------------//
            stmt = con.createStatement();
            status =  stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Livre " +
                            "(NumExemplaire int(10)  NOT NULL AUTO_INCREMENT, " +
                            "ISBN BIGINT(16)  NOT NULL , " +
                            "DatePub VARCHAR(10) NOT NULL,  " +
                            "NbPages VARCHAR(10) NOT NULL,  " +
                            "Nombre int(10) DEFAULT 1,  " +
                            "Disponibilite int(1) DEFAULT 1,  " +
                            "Titre VARCHAR(50) NOT NULL,  " +
                            "NomEditeur VARCHAR(50) NOT NULL, " +
                            "NomAuteur VARCHAR(50) NOT NULL, " +
                            "PrAuteur VARCHAR(50) NOT NULL,  " +
                            "IdTypeLivre int(10) NOT NULL,  " +

                            "PRIMARY KEY(NumExemplaire))");

            status = stmt.executeUpdate("INSERT INTO `livre` (`NumExemplaire`, `ISBN`, `DatePub`, `NbPages`, `Nombre`, `Disponibilite`, `Titre`," +
                    " `NomEditeur`, `NomAuteur`, `PrAuteur`, `IdTypeLivre`) VALUES ('1001', '1128745887', '1995', '350', '1', '1'," +
                    " 'The Rosetta Stone', 'Harper Collins', 'Brown', 'Dan', '1')");

            status = stmt.executeUpdate("INSERT INTO `livre` (`NumExemplaire`, `ISBN`, `DatePub`, `NbPages`, `Nombre`, `Disponibilite`, `Titre`," +
                    " `NomEditeur`, `NomAuteur`, `PrAuteur`, `IdTypeLivre`) VALUES ('1002', '128456545465', '1966', '355', '1', '1'," +
                    " 'Le nom de la rose', 'Edition du jour', 'Flammant', 'Alice', '1')");

            status = stmt.executeUpdate("INSERT INTO `livre` (`NumExemplaire`, `ISBN`, `DatePub`, `NbPages`, `Nombre`, `Disponibilite`, `Titre`," +
                    " `NomEditeur`, `NomAuteur`, `PrAuteur`, `IdTypeLivre`) VALUES ('1003', '18998881871', '2002', '400', '1', '1'," +
                    " 'Les animaux', 'Edition Planete', 'Clemment', 'Ariel', '1')");

            status =stmt.executeUpdate("INSERT INTO `livre` (`NumExemplaire`, `ISBN`, `DatePub`, `NbPages`, `Nombre`, `Disponibilite`, `Titre`," +
                    " `NomEditeur`, `NomAuteur`, `PrAuteur`, `IdTypeLivre`) VALUES ('1004', '196672273346', '1990', '520', '1', '1'," +
                    " 'Les follies', 'Edition du fou', 'Belle', 'Toni', '1')");

            status =stmt.executeUpdate("INSERT INTO `livre` (`NumExemplaire`, `ISBN`, `DatePub`, `NbPages`, `Nombre`, `Disponibilite`, `Titre`," +
                    " `NomEditeur`, `NomAuteur`, `PrAuteur`, `IdTypeLivre`) VALUES ('1005', '189777789854', '1939', '320', '1', '1', " +
                    "'L Etranger', 'Edition Gallimard', 'Camus', 'Albert', '1')");

            status =stmt.executeUpdate("INSERT INTO `livre` (`NumExemplaire`, `ISBN`, `DatePub`, `NbPages`, `Nombre`, `Disponibilite`, `Titre`," +
                    " `NomEditeur`, `NomAuteur`, `PrAuteur`, `IdTypeLivre`) VALUES ('1006', '10077784452', '1979', '358', '1', '1'," +
                    " 'The Shinning', 'Harper Collins', 'King', 'Stephen', '1')");

            status = stmt.executeUpdate("INSERT INTO `livre` (`NumExemplaire`, `ISBN`, `DatePub`, `NbPages`, `Nombre`, `Disponibilite`, `Titre`, " +
                    "`NomEditeur`, `NomAuteur`, `PrAuteur`, `IdTypeLivre`) VALUES ('1007', '196672273346', '1990', '520', '1', '1', " +
                    "'Les follies', 'Edition du fou', 'Belle', 'Toni', '1')");

            status =stmt.executeUpdate("INSERT INTO `livre` (`NumExemplaire`, `ISBN`, `DatePub`, `NbPages`, `Nombre`, `Disponibilite`, `Titre`," +
                    " `NomEditeur`, `NomAuteur`, `PrAuteur`, `IdTypeLivre`) VALUES ('1008', '189777789854', '1939', '320', '1', '1'," +
                    " 'L Etranger', 'Edition Gallimard', 'Camus', 'Albert', '1')");

            status =stmt.executeUpdate("INSERT INTO `livre` (`NumExemplaire`, `ISBN`, `DatePub`, `NbPages`, `Nombre`, `Disponibilite`, `Titre`," +
                    " `NomEditeur`, `NomAuteur`, `PrAuteur`, `IdTypeLivre`) VALUES ('1009', '10077784452', '1979', '358', '1', '1'," +
                    " 'The Shinning', 'Harper Collins', 'King', 'Stephen', '1')");





            //====================================================
            //status = 1;

            stmt.close();
            con.close();

            Log.e("LOG_CAT", "table created");

        } catch (Exception e) {
            e.printStackTrace();

            Log.e("LOG_ERROR", "ERROR table");
        }
    return status;

    }

    //====================================================================================

    public static boolean getData() {

       boolean status = false;
        Client client = new Client();
        Livre livre = new Livre();

        ArrayList<Client> listeClient = new ArrayList<>();


        try {

            con = DBConnection();

            //==================================================

            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            stmt.executeQuery("use biblio");



            String query = "SELECT * FROM `livre`";
            ResultSet rs = stmt.executeQuery(query);


            while (rs.next()) {



            }





            Log.e("LOG_STATUS", "Status = " + status);

            stmt.close();
            con.commit();
            con.close();




        }catch (Exception e)
        {
            e.printStackTrace();
            Log.e("LOG_ERROR", "ERROR insert");
        }



        return status;
    }


}


