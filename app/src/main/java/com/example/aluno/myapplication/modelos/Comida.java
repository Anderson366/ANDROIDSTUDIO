package com.example.aluno.myapplication.modelos;

import java.util.ArrayList;
import java.util.List;

public class Comida {

    private String nome;
    private String ingrediente;
    private double valor;

    public Comida(String nome, String ingrediente, double valor) {
        this.nome = nome;
        this.ingrediente = ingrediente;
        this.valor = valor;
    }

    public static List<Comida> getComidas(){
        List<Comida> comidas = new ArrayList<>();
        comidas.add(new Comida("Coxinha Frango", "Trigo + Frango + Sal", 3));
        comidas.add(new Comida("Coxinha Queijo", "Queijo",1));
        comidas.add(new Comida("Lasanha", "Queijo, ", 30));
        comidas.add(new Comida("Coxinha Pizza", "Trigo + Sal", 3));
        comidas.add(new Comida("Coxinha Queijo", "Queijo",1));
        comidas.add(new Comida("Coxinha Queijo", "Queijo",1));
        comidas.add(new Comida("Coxinha Queijo", "Queijo",1));
        comidas.add(new Comida("Coxinha Queijo", "Queijo",1));
        comidas.add(new Comida("Coxinha Queijo", "Queijo",1));
        comidas.add(new Comida("Lasanha", "Queijo, ", 30));

        return comidas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
