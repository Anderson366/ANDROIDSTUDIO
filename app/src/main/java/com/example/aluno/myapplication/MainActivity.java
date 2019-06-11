package com.example.aluno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int contador = 0;
    private TextView referencia_text_view;
    private Button referencia_butao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        referencia_text_view = findViewById(R.id.textView1);
        referencia_butao = findViewById(R.id.button2);

    }

    public void mostrar_toast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_menssagem, Toast.LENGTH_SHORT);

        toast.show();
    }

    public void incrementar_count(View view) {
        contador++;
        referencia_text_view.setText("" + contador);

    }


}
