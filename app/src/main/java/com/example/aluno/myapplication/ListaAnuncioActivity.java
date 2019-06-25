package com.example.aluno.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.aluno.myapplication.adapters.AnuncioAdapter;
import com.example.aluno.myapplication.modelos.Anuncio;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListaAnuncioActivity extends AppCompatActivity {

    private RecyclerView rvAnuncio;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_anuncio);

        rvAnuncio = findViewById(R.id.rv_anuncio);
        firestore = FirebaseFirestore.getInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();
        obterAnunciosDoFirestore();
//        AnuncioAdapter adapter = new AnuncioAdapter(this, Anuncio.getAnuncios());
//        rvAnuncio.setAdapter(adapter);
//        rvAnuncio.setLayoutManager(new LinearLayoutManager(this));


    }
    //OnClick
    public void atualizar(View view){
        obterAnunciosDoFirestore();
    }

    public void formularioAnuncio(View view){
        Intent intent = new Intent(this, FormularioAnuncioActivity.class);
        startActivity(intent);
    }

    private void atualizarRecyclerView(List<Anuncio> anuncios){
        AnuncioAdapter adapter = new AnuncioAdapter(this, anuncios);
        rvAnuncio.setAdapter(adapter);
        rvAnuncio.setLayoutManager(new LinearLayoutManager(this));

    }
    private void obterAnunciosDoFirestore(){

        final List<Anuncio> anuncios = new ArrayList<>();

        firestore.collection("anuncios").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (DocumentSnapshot documento: task.getResult()){
                        Anuncio anuncio = documento.toObject(Anuncio.class);
                        anuncios.add(anuncio);
                    }
                    //Terminou de pegar todos os documentos
                    atualizarRecyclerView(anuncios);
                }
            }
        });

    }

//    private void atualizarViews() {
//        AnuncioAdapter adapter = new AnuncioAdapter(this, Anuncio.getAnuncios());
//        rvAnuncio.setAdapter(adapter);
//        rvAnuncio.setLayoutManager(new LinearLayoutManager(this));
//    }
}
