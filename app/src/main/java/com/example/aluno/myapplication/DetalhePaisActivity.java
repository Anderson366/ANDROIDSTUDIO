package com.example.aluno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalhePaisActivity extends AppCompatActivity {

    TextView NomeDetalhe, PopulacaoDetalhe, IdiomaDetalhe, ContinenteDetalhe, PibDetalhe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);

        NomeDetalhe = findViewById(R.id.txt_nome_detalhe);
        PopulacaoDetalhe = findViewById(R.id.txt_detalhe_populacao);
        IdiomaDetalhe = findViewById(R.id.txt_detalhe_idioma);
        ContinenteDetalhe = findViewById(R.id.txt_detalhe_continente);
        PibDetalhe = findViewById(R.id.txt_detalhe_pib);

        Intent i = getIntent();
        NomeDetalhe.setText("Nome: " + i.getStringExtra("NOME PAIS"));
        PopulacaoDetalhe.setText("Populacao: " + i.getDoubleExtra("POPULACAO PAIS",0));
        IdiomaDetalhe.setText("Idioma: " + i.getStringExtra("IDIOMA PAIS"));
        ContinenteDetalhe.setText("Continente: " + i.getStringExtra("CONTINENTE PAIS"));
        PibDetalhe.setText("Pib: " + i.getDoubleExtra("PIB PAIS",0));
    }
}
