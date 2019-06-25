package com.example.aluno.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aluno.myapplication.DetalhePaisActivity;
import com.example.aluno.myapplication.R;
import com.example.aluno.myapplication.modelos.Paises;

import java.util.List;


public class PaisesAdapter extends RecyclerView.Adapter<PaisesAdapter.PaisesViewHolder>{
    private Context context;
    private List<Paises> paises;

    public PaisesAdapter(Context context, List<Paises> paises) {
        this.context = context;
        this.paises = paises;
    }

    @NonNull
    @Override
    public PaisesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_paises, viewGroup, false);
        PaisesViewHolder paisesViewHolder = new PaisesViewHolder(view);
        return paisesViewHolder;
    }

    public void onBindViewHolder(@NonNull PaisesViewHolder viewHolder, int i) {
        Paises pais = this.paises.get(i);
        viewHolder.txtnomepaises.setText(pais.getNome());
        viewHolder.txtpopulacao.setText(pais.getPopulacao() + " Mi");
        viewHolder.txtidioma.setText(pais.getIdioma());
        viewHolder.txtcontinente.setText(pais.getContinente());
        viewHolder.txtpib.setText(pais.getPib()+" PIB PER");
    }

    @Override
    public int getItemCount() { return paises.size(); }


    class PaisesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtnomepaises, txtpopulacao, txtidioma, txtcontinente, txtpib;

        public PaisesViewHolder(@NonNull View itemView) {
            super(itemView);
            txtnomepaises = itemView.findViewById(R.id.txt_nome_pais);
            txtpopulacao = itemView.findViewById(R.id.txt_populacao);
            txtidioma = itemView.findViewById(R.id.txt_idioma);
            txtcontinente = itemView.findViewById(R.id.txt_continente);
            txtpib = itemView.findViewById(R.id.txt_pib);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Paises pais = paises.get(getAdapterPosition());

            Intent intent = new Intent(context, DetalhePaisActivity.class);
            intent.putExtra("NOME PAIS", pais.getNome());
            intent.putExtra("POPULACAO PAIS", pais.getPopulacao());
            intent.putExtra("IDIOMA PAIS", pais.getIdioma());
            intent.putExtra("CONTINENTE PAIS", pais.getContinente());
            intent.putExtra("PIB PAIS", pais.getPib());

            context.startActivity(intent);

        }
    }
}
