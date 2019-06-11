package com.example.aluno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aluno.myapplication.adapters.AnuncioAdapter;
import com.example.aluno.myapplication.modelos.Anuncio;

public class ListaAnuncioActivity extends AppCompatActivity {

    private RecyclerView rvAnuncio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_anuncio);

        rvAnuncio = findViewById(R.id.rv_anuncio);
//        atualizarViews();
        
    }

    @Override
    protected void onResume() {
        super.onResume();
        AnuncioAdapter adapter = new AnuncioAdapter(this, Anuncio.getAnuncios());
        rvAnuncio.setAdapter(adapter);
        rvAnuncio.setLayoutManager(new LinearLayoutManager(this));
    }

//    private void atualizarViews() {
//        AnuncioAdapter adapter = new AnuncioAdapter(this, Anuncio.getAnuncios());
//        rvAnuncio.setAdapter(adapter);
//        rvAnuncio.setLayoutManager(new LinearLayoutManager(this));
//    }
}
