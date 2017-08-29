package com.example.eleves.connecttomysql;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {


    Button bouttonListe, b1, b2, b3;

    ArrayList<Livre> listLivre = new ArrayList<>();
    ListView listView;
    static Livre livre;
    ImageView imageView;
    ArrayAdapter<Livre> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        {

            setTitle("Bibliotheque George-Etienne Cartier");

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            listView = (ListView)findViewById(R.id.list);

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


                                   listLivre = DB_Connect.getLivre();



                                Intent intent = new Intent(MainActivity.this, LivreActivity.class);
                                intent.putExtra("livres", listLivre);
                               // startActivity(intent);

//                                //=====================================================
//                                // Initialisation du ListView contenant la liste des livres
//                                listView = (ListView)findViewById(R.id.list) ;

//                                //---- ARRAY ADAPTER TO PRINT IN LISTVIEW --------------------------------------------------------------
//                                adapter = new ArrayAdapter<Livre>(MainActivity.this,R.layout.list_view_livre,R.id.textViewauteur, listLivre);

//                                // OBJET ADAPTER adapter passe a la listView livre
//                                listView.setAdapter(adapter);

                                //=====================================================

                               if(listLivre != null) {

                                   runOnUiThread(new Runnable() {
                                       @Override
                                       public void run() {
                                           Toast.makeText(getApplicationContext(), "Donnes disponibles",
                                                   Toast.LENGTH_SHORT).show();
                                       }
                                   });
                               }

                            } catch (Exception e) {
                                e.printStackTrace();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Problemes requetes",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });


                            }
                        }
                    });
                    thread3.start();
                }
            });


bouttonListe = (Button)findViewById(R.id.btlist);
            bouttonListe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    adapter = new ArrayAdapter<Livre>(MainActivity.this,R.layout.list_view_livre, R.id.textViewauteur, listLivre)
                    {
                        public Livre getItem(int position){
                            return listLivre.get(position);
                        }

                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            View view = super.getView(position, convertView, parent);

                            TextView text1 = (TextView) view.findViewById(R.id.textViewauteur);
                            TextView text2 = (TextView) view.findViewById(R.id.textViewTitre);
                            /**********************/

                            //------------------------
                            // Log.d("acceuil"," testing chien");
                            //System.out.println(chiens.get(position).getNom());
                            //System.out.println(chiens.get(position).getSexe());

                            // text1.setTextColor(Color.BLUE);
                            // text2.setTextColor(Color.BLUE);
                           // text1.setTypeface(Typeface.DEFAULT_BOLD);
                            text2.setTypeface(Typeface.DEFAULT_BOLD);
                            text2.setTextSize(20);
                            text1.setText(listLivre.get(position).toString());
                            text1.setText((listLivre.get(position).getPrenAuteur() + " " +listLivre.get(position).getNomAuteur()));
                            text2.setText(listLivre.get(position).getTitre());
//                            text2.setText("Exemplaire: "+ listLivre.get(position).getNumExemplaire()
                            //        + "  Etat: " + chiens.get(position).getEtatSteril()
                            //        + "  Sexe: " + chiens.get(position).getSexe()
//                                      );

                            return view;
                        }
                    };
                    //-------------------------------------------------------------------------------------------------------

                    // OBJET ADAPTER adapter passe a la listView
                    listView.setAdapter(adapter);





                }
            });



        }
    }
}

