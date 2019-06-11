package com.example.aluno.myapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aluno.myapplication.R;
import com.example.aluno.myapplication.modelos.Comida;

import java.util.List;

public class ComidasAdapter extends RecyclerView.Adapter<ComidasAdapter.ComidaViewHolder> {
    private Context context;
    private List<Comida> comidas;

    public ComidasAdapter(Context context, List<Comida> comidas) {
        this.context = context;
        this.comidas = comidas;
    }

    @NonNull
    @Override
    //criar
    public ComidaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_comida, viewGroup, false);

        ComidaViewHolder viewHolder = new ComidaViewHolder(view);
        return viewHolder;
    }
    //preencher
    @Override
    public void onBindViewHolder(@NonNull ComidaViewHolder comidaViewHolder, int posicao) {
        Comida comida = comidas.get(posicao);

        comidaViewHolder.txtComidaNome.setText(comida.getNome());
        comidaViewHolder.txtComidaIngrediente.setText(comida.getIngrediente());
        comidaViewHolder.txtComidaValor.setText("R$ " + comida.getValor());
    }

    @Override
    public int getItemCount() {
        return comidas.size();
    }

    class ComidaViewHolder extends RecyclerView.ViewHolder {
        TextView txtComidaNome;
        TextView txtComidaIngrediente;
        TextView txtComidaValor;
        Button btnAdicionar;

         ComidaViewHolder(@NonNull View itemView) {
            super(itemView);

            //Binding
            txtComidaNome = itemView.findViewById(R.id.txt_comida_nome);
            txtComidaIngrediente = itemView.findViewById(R.id.txt_comida_ingrediente);
            txtComidaValor = itemView.findViewById(R.id.txt_comida_valor);
            btnAdicionar = itemView.findViewById(R.id.btn_adicinar);

            //Configurar clicks
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int posicao = getAdapterPosition();
//                    Toast.makeText(context,"Clicou: "+posicao, Toast.LENGTH_SHORT).show();
//                }
//            });
             btnAdicionar.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Comida comida = comidas.get(getAdapterPosition());
                     Toast.makeText(context, comida.getNome()+" Adicinado ao pedido.", Toast.LENGTH_SHORT).show();
                 }
             });
        }
    }
}
