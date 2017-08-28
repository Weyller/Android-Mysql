package com.example.eleves.connecttomysql;

/**
 * Created by Administrator on 8/27/2017.
 */



import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


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


            status = stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS resto");

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
            stmt.executeQuery("use resto");

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS composants " +
                            "(Type_de_composant VARCHAR(30) NOT NULL," +
                            " Num_du_composant INT NOT NULL, " +
                            " Composant VARCHAR(30) NOT NULL UNIQUE, " +
                            "PRIMARY KEY (Type_de_composant, Num_du_composant))");
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS commandes " +
                            "(Commande INT NOT NULL, " +
                            " TypeDeComposant VARCHAR(30) NOT NULL," +
                            " NumDuComposant INT NOT NULL, " +

                            " PRIMARY KEY (Commande, TypeDeComposant)," +
                            " FOREIGN KEY (TypeDeComposant,NumDuComposant) " +
                            "REFERENCES composants(Type_de_composant, " +
                            "Num_du_composant))");
            status = 1;

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

    public static int insertData() {

        int status = 0;

        try {

            con = DBConnection();

            //==================================================  Insert composants

            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            stmt.executeQuery("use resto");

            stmt.executeUpdate("INSERT INTO COMPOSANTS ( TYPE_DE_COMPOSANT, NUM_DU_COMPOSANT, COMPOSANT )" +
                    "VALUES ('Plat principal', 1,'Maigret de canard')");
            stmt.executeUpdate("INSERT INTO COMPOSANTS ( TYPE_DE_COMPOSANT, NUM_DU_COMPOSANT, COMPOSANT )" +
                    "VALUES ('Dessert', 1,'Creme brulee')");
            stmt.executeUpdate("INSERT INTO COMPOSANTS ( TYPE_DE_COMPOSANT, NUM_DU_COMPOSANT, COMPOSANT )" +
                    "VALUES ('Dessert', 2,'Tarte de chocolat')");
            stmt.executeUpdate("INSERT INTO COMPOSANTS ( TYPE_DE_COMPOSANT, NUM_DU_COMPOSANT, COMPOSANT )" +
                    "VALUES ('Boisson', 1,'Vin maison')");
            stmt.executeUpdate("INSERT INTO COMPOSANTS ( TYPE_DE_COMPOSANT, NUM_DU_COMPOSANT, COMPOSANT )" +
                    "VALUES ('Boisson', 2,'Coca-Cola')");

            // stmt.close();
            // con.commit();
            // con.close();
            //==================================================  Insert Commandes

            // con.setAutoCommit(false);
            //  Statement stmt2 = con.createStatement();
            stmt.executeUpdate("INSERT INTO COMMANDES ( COMMANDE, TYPEDECOMPOSANT, NUMDUCOMPOSANT )" +
                    "VALUES (1, 'Plat principal', 1)");
            stmt.executeUpdate("INSERT INTO COMMANDES ( COMMANDE, TYPEDECOMPOSANT, NUMDUCOMPOSANT )" +
                    "VALUES (1, 'Dessert', 1)");
            stmt.executeUpdate("INSERT INTO COMMANDES ( COMMANDE, TYPEDECOMPOSANT, NUMDUCOMPOSANT )" +
                    "VALUES (1, 'Boisson', 1)");
            stmt.executeUpdate("INSERT INTO COMMANDES ( COMMANDE, TYPEDECOMPOSANT, NUMDUCOMPOSANT )" +
                    "VALUES (2, 'Dessert', 2)");
            stmt.executeUpdate("INSERT INTO COMMANDES ( COMMANDE, TYPEDECOMPOSANT, NUMDUCOMPOSANT )" +
                    "VALUES (2, 'Plat principal', 1)");
            stmt.executeUpdate("INSERT INTO COMMANDES ( COMMANDE, TYPEDECOMPOSANT, NUMDUCOMPOSANT )" +
                    "VALUES (2, 'Boisson', 2)");

            status = 1;

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


