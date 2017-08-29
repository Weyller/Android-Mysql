package com.example.eleves.connecttomysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class LivreActivity extends AppCompatActivity {

    ArrayList<Livre> listLivre = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livre);


        setTitle("Liste de livre");

        // On recueille les donnees envoyees par la page precedente
        Intent intent = getIntent();

        listLivre = (ArrayList<Livre>) intent.getSerializableExtra("livres");

     for(int i = 0; i<listLivre.size(); i++){


     }

     String s = String.valueOf(listLivre.get(0).getNumExemplaire());


        TextView num = (TextView) findViewById(R.id.textViewExempl);
        num.setText(String.valueOf(listLivre.get(0).getNumExemplaire()));

        TextView isbn = (TextView) findViewById(R.id.textViewisbn);
        isbn.setText(String.valueOf(listLivre.get(0).getISBN()));

        TextView date = (TextView) findViewById(R.id.textViewdate);
        date.setText(String.valueOf(listLivre.get(0).getDatePublication()));

        TextView editeur = (TextView) findViewById(R.id.textViewedit);
        editeur.setText(String.valueOf(listLivre.get(0).getNomEditeur()));

        TextView auteur = (TextView) findViewById(R.id.textViewauteur);
        String nom = String.valueOf(listLivre.get(5).getNomAuteur());
        String prenm = String.valueOf(listLivre.get(5).getPrenAuteur());
        auteur.setText(prenm +" "+ nom);

        TextView disp = (TextView) findViewById(R.id.textViewquant);
        disp.setText(String.valueOf(listLivre.get(0).getDisponibilite()));

        TextView titre = (TextView) findViewById(R.id.textViewTitre);
        titre.setText(String.valueOf(listLivre.get(3).getTitre()));












    }
}
