package com.example.aluno.myapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aluno.myapplication.ListaComidasActivity;
import com.example.aluno.myapplication.R;
import com.example.aluno.myapplication.ResultAnuncioActivity;
import com.example.aluno.myapplication.modelos.Anuncio;

import java.util.List;

public class AnuncioAdapter extends RecyclerView.Adapter<AnuncioAdapter.AnuncioViewHolder>{
    private Context context;
    private List<Anuncio> anuncios;


    public AnuncioAdapter(Context context, List<Anuncio> anuncios) {
        this.context = context;
        this.anuncios = anuncios;

    }

    @NonNull
    @Override
    public AnuncioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_anuncio, viewGroup, false);
        return new AnuncioViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AnuncioViewHolder anuncioViewHolder, int posicao) {
        Anuncio anuncio = this.anuncios.get(posicao);
        anuncioViewHolder.txtTitulo.setText(anuncio.getTitulo());
        anuncioViewHolder.txtDescricao.setText(anuncio.getDescricao());
        anuncioViewHolder.txtData.setText(anuncio.getData_anuncio());
        anuncioViewHolder.txtPreco.setText("R$ " + anuncio.getPreco());
        anuncioViewHolder.txtBairro.setText(anuncio.getBairro());
    }

    @Override
    public int getItemCount() {
        return anuncios.size();
    }

    class AnuncioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTitulo, txtDescricao, txtPreco, txtData, txtBairro;
        Button btnDetalhe;

        AnuncioViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitulo = itemView.findViewById(R.id.txt_titulo);
            txtDescricao = itemView.findViewById(R.id.txt_descricao);
            txtPreco = itemView.findViewById(R.id.txt_preco);
            txtData = itemView.findViewById(R.id.txt_data);
            txtBairro = itemView.findViewById(R.id.txt_bairro);
            btnDetalhe = itemView.findViewById(R.id.btn_detalhe);


            itemView.setOnClickListener(this);
//            Intent intent = new Intent();
//            startActivity(intent);
//            btnDetalhe.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Anuncio anuncio = anuncios.get(getAdapterPosition());
//                    Toast.makeText(context,anuncio.getTitulo(), Toast.LENGTH_SHORT).show();
//                }
//            });
        }

        @Override
        public void onClick(View v) {
            Anuncio anuncio = anuncios.get(getAdapterPosition());

            Intent intent = new Intent(context, ResultAnuncioActivity.class);
            intent.putExtra("ANUNCIO TITULO", anuncio.getTitulo());
            intent.putExtra("ANUNCIO DATA", anuncio.getData_anuncio());
            intent.putExtra("ANUNCIO DESCRICAO", anuncio.getDescricao());
            intent.putExtra("ANUNCIO BAIRRO", anuncio.getBairro());

            context.startActivity(intent);


        }
    }
}
