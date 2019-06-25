package com.example.aluno.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.aluno.myapplication.adapters.PaisesAdapter;
import com.example.aluno.myapplication.modelos.Paises;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListaPaisesActivity extends AppCompatActivity {

    RecyclerView rvPaises;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        rvPaises = findViewById(R.id.rv_paises);
        firestore = FirebaseFirestore.getInstance();
        obterDoFire();

    }

    @Override
    protected void onResume() {
        super.onResume();
        obterDoFire();
    }

    private void atualizarRecyclerView(List<Paises> paises) {
        PaisesAdapter adapter = new PaisesAdapter(this, paises);
        rvPaises.setAdapter(adapter);
        rvPaises.setLayoutManager(new LinearLayoutManager(this));

    }
    private void obterDoFire(){

        final List<Paises> paises = new ArrayList<>();

        firestore.collection("paises").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (DocumentSnapshot documento: task.getResult()){
                        Paises pais = documento.toObject(Paises.class);
                        paises.add(pais);
                    }
                    //Terminou de pegar todos os documentos
                    atualizarRecyclerView(paises);
                }
            }
        });

    }

    public void atualizarPaises(View view) {
        obterDoFire();
    }

    public void formularioPais(View view) {
        Intent intent = new Intent(this, FormularioPaisActivity.class);
        startActivity(intent);
    }
}
