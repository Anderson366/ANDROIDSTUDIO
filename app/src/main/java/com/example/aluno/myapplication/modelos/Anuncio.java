package com.example.aluno.myapplication.modelos;

import java.util.ArrayList;
import java.util.List;

public class Anuncio {
    private String titulo;
    private String descricao;
    private double preco;
    private String data_anuncio;
    private String bairro;

    public Anuncio(){

    }

    public Anuncio(String titulo, String descricao, double preco, String data_anuncio, String bairro) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.data_anuncio = data_anuncio;
        this.bairro = bairro;
    }
    public static List<Anuncio> getAnuncios(){
        List<Anuncio> anuncios = new ArrayList<>();
        anuncios.add(new Anuncio("Abajur 0", "Usado no máximo 4 vezes.", 80, "29 de maio de 2019", "Santa Rosa"));
        anuncios.add(new Anuncio("Abajur 1", "Médio.", 40, "29 de maio de 2019", "Pedra Mole"));
        anuncios.add(new Anuncio("Abajur 2", "Pequeno.", 20, "29 de maio de 2019", "Centro Sul"));
        anuncios.add(new Anuncio("Abajur 3", "Pequeno.", 19, "29 de maio de 2019", "Centro Sul"));
        anuncios.add(new Anuncio("Abajur 4", "Pequeno.", 18, "03 de junho de 2019", "Centro Sul"));
        anuncios.add(new Anuncio("Abajur 5", "Pequeno.", 17, "05 de junho de 2019", "Centro Norte"));
        return  anuncios;
    }

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getDescricao() {return descricao;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    public double getPreco() {return preco;}

    public void setPreco(double preco) {this.preco = preco;}

    public String getData_anuncio() {return data_anuncio;}

    public void setData_anuncio(String data_anuncio) {this.data_anuncio = data_anuncio;}

    public String getBairro() {return bairro;}

    public void setBairro(String bairro) {this.bairro = bairro;}
}
