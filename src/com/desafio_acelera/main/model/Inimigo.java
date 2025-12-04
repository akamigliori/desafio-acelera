package com.desafio_acelera.main.model;

public class Inimigo extends Personagem {
    private int quantidadeAleatoria;

    public Inimigo(String nome, int hpMaximo, int quantidadeAleatoria){
        super(nome, hpMaximo);
        this.quantidadeAleatoria = quantidadeAleatoria;
    }

    public int getQuantidadeAleatoria(){
        return quantidadeAleatoria;
    }
}
