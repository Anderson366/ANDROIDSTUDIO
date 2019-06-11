package com.example.aluno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultAnuncioActivity extends AppCompatActivity {

    TextView TituloDetalhe, PrecoDetalhe, DescricaoDetalhe, DataDetalhe, BairroDetalhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_anuncio);
        TituloDetalhe = findViewById(R.id.txt_titulo_detalhe);
        PrecoDetalhe = findViewById(R.id.txt_preco_detalhe);
        DescricaoDetalhe = findViewById(R.id.txt_descricao_detalhe);
        DataDetalhe = findViewById(R.id.txt_data_detalhe);
        BairroDetalhe = findViewById(R.id.txt_bairro_detalhe);

        Intent it = getIntent();
        TituloDetalhe.setText(it.getStringExtra("ANUNCIO TITULO"));
        PrecoDetalhe.setText(it.getStringExtra("ANUNCIO DESCRICAO"));
        DescricaoDetalhe.setText(it.getStringExtra("ANUNCIO DESCRICAO"));
        DataDetalhe.setText(it.getStringExtra("ANUNCIO "));
        BairroDetalhe.setText(it.getStringExtra("ANUNCIO BAIRRO"));
    }
//    public void dados(View view){
//
//        String titulo = TituloDetalhe.getText().toString();
//        double preco = PrecoDetalhe.getText().toString();
//        String descricao = DescricaoDetalhe.getText().toString();
//        String data = DataDetalhe.getText().toString();
//        String bairro = Bairro.getText().toString();
//    }
//    Intent it = getIntent();

}
