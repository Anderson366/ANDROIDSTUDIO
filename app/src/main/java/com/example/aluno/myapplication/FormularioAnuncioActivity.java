package com.example.aluno.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aluno.myapplication.modelos.Anuncio;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class FormularioAnuncioActivity extends AppCompatActivity {

    EditText editAnuncioTitulo, editAnuncioDescricao, editAnuncioValor, editAnuncioBairro, editAnuncioData;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_anuncio);

        editAnuncioTitulo = findViewById(R.id.edit_anuncio_titulo);
        editAnuncioDescricao = findViewById(R.id.edit_anuncio_descricao);
        editAnuncioValor = findViewById(R.id.edit_anuncio_valor);
        editAnuncioBairro = findViewById(R.id.edit_anuncio_bairro);
        editAnuncioData = findViewById(R.id.edit_anuncio_data);

        firestore = FirebaseFirestore.getInstance();
    }
    public void salvarAnuncio(View view){
        Anuncio anuncio = obterAnuncioDoFormulario();
        firestore.collection("anuncios").add(anuncio).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()){
                    Toast.makeText(FormularioAnuncioActivity.this, "Salvo com sucesso.", Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(FormularioAnuncioActivity.this, "Erro ao salvar.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Anuncio obterAnuncioDoFormulario() {
        String titulo = editAnuncioTitulo.getText().toString();
        String descricao = editAnuncioDescricao.getText().toString();
        double valor = Double.parseDouble(editAnuncioValor.getText().toString());

        return new Anuncio(titulo, descricao, valor);
    }
}
