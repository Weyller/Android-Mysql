package com.example.eleves.connecttomysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {


    Button bouttonCreate, b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            b1 = (Button) findViewById(R.id.b1);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Thread thread1 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {

                                //===========================================

                                   int status = DB_Connect.createDatabase();

                                //===========================================

                         if(status == 1) {

                             runOnUiThread(new Runnable() {
                                 @Override
                                 public void run() {
                                     Toast.makeText(getApplicationContext(), "Database créé",
                                             Toast.LENGTH_SHORT).show();
                                 }
                             });

                         }


                            } catch (Exception e) {
                                e.printStackTrace();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Problemes de creation de BD",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    });
                    thread1.start();
                }
            });
            b2 = (Button) findViewById(R.id.b2);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Thread thread2 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {

                                //=============================================================

                                   int status =  DB_Connect.createTable();

                                //=============================================================

                                if(status == 1) {

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getApplicationContext(), "Tables créées",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }


                            } catch (Exception e) {
                                e.printStackTrace();

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Problemes de creation de Table",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    });
                    thread2.start();
                }
            });

            //------------------------------------------------------------------

            b3 = (Button) findViewById(R.id.b3);
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Thread thread3 = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {

                                //=====================================================

                                   int status = DB_Connect.insertData();

                                //=====================================================

                               if(status == 1) {

                                   runOnUiThread(new Runnable() {
                                       @Override
                                       public void run() {
                                           Toast.makeText(getApplicationContext(), "Donnes inserees",
                                                   Toast.LENGTH_SHORT).show();
                                       }
                                   });
                               }

                            } catch (Exception e) {
                                e.printStackTrace();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Problemes d'insertion",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });


                            }
                        }
                    });
                    thread3.start();
                }
            });


        }
    }
}

