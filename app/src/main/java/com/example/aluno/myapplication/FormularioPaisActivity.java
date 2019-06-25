package com.example.aluno.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aluno.myapplication.modelos.Paises;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class FormularioPaisActivity extends AppCompatActivity {

    EditText editPaisNome, editPaisContinente, editPaisIdioma, editPaisPib, editPaisPopulacao;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_pais);

        editPaisNome = findViewById(R.id.edit_nome_pais);
        editPaisContinente = findViewById(R.id.edit_continente_pais);
        editPaisIdioma = findViewById(R.id.edit_idioma_pais);
        editPaisPib = findViewById(R.id.edit_pib_pais);
        editPaisPopulacao = findViewById(R.id.edit_populacao_pais);

        firestore = FirebaseFirestore.getInstance();
    }

    public void salvarPais(View view) {
        Paises pais = obterPaisDoFormulario();
        firestore.collection("paises").add(pais).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(FormularioPaisActivity.this, "Salvo com sucesso..", Toast.LENGTH_SHORT).show();
                }
            }
            }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(FormularioPaisActivity.this, "Erro ao salvar..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Paises obterPaisDoFormulario() {
        String nome = editPaisNome.getText().toString();
        double continente = Double.parseDouble(editPaisContinente.getText().toString());
        String idioma = editPaisIdioma.getText().toString();
        double pib = Double.parseDouble(editPaisPib.getText().toString());
        String populacao = editPaisPopulacao.getText().toString();

        return new Paises(nome, continente, idioma, pib, populacao);

    }
}
