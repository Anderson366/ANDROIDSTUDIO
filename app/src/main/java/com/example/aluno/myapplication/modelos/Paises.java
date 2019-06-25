package com.example.aluno.myapplication.modelos;

import java.util.ArrayList;
import java.util.List;

public class Paises {
    String nome;
    double populacao;
    String idioma;
    String continente;
    double pib;

    public Paises(String nome, double continente, String idioma, double pib, String populacao){

    }

    public Paises(String nome, double populacao, String idioma, String continente, double pib) {
        this.nome = nome;
        this.populacao = populacao;
        this.idioma = idioma;
        this.continente = continente;
        this.pib = pib;
    }

    public static List<Paises> getPaises(){
        List<Paises> paises = new ArrayList<>();
        paises.add(new Paises("Brasil", 200, "Portugues", "America do Sul", 80));
        return paises;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPopulacao() {
        return populacao;
    }

    public void setPopulacao(double populacao) {
        this.populacao = populacao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public double getPib() {
        return pib;
    }

    public void setPib(double pib) {
        this.pib = pib;
    }
}
