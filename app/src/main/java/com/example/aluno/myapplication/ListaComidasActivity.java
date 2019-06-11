package com.example.aluno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aluno.myapplication.adapters.ComidasAdapter;
import com.example.aluno.myapplication.modelos.Comida;

public class ListaComidasActivity extends AppCompatActivity {
    private RecyclerView rvComidas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_comidas);

        rvComidas = findViewById(R.id.rv_comidas);
        atualizarViews();
    }

    private void atualizarViews() {
        ComidasAdapter adapter = new ComidasAdapter(this, Comida.getComidas());
        rvComidas.setAdapter(adapter);
        rvComidas.setLayoutManager(new LinearLayoutManager(this));
    }

}
