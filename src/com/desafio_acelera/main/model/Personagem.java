package com.desafio_acelera.main.model;

public abstract class Personagem{
    protected String nome;
    protected int hpMaximo;
    protected int hpAtual;
    protected int numeroSecreto;

    public Personagem(String nome, int hpMaximo){
        this.nome = nome;
        this.hpMaximo = hpMaximo;
        this.hpAtual = hpMaximo;
    }

    public boolean estaVivo(){
        return hpAtual > 0;
    }

    public String getNome(){
        return nome;
    }

    public int getHpMaximo(){
        return hpMaximo;
    }

    public int getHpAtual(){
        return hpAtual;
    }

    public void setNumeroSecreto(int numeroSecreto){
        this.numeroSecreto = numeroSecreto;
    }

    public int getNumeroSecreto(){
        return numeroSecreto;
    }

    public void tomarDano(int dano){
        this.hpAtual = hpAtual - dano;
        if(this.hpAtual <= 0){
            this.hpAtual = 0;
        }
    }

    public void curarTudo(){
        this.hpAtual = this.hpMaximo;
    }

    public void aumentarHpMaximo(int aumento){
        this.hpMaximo += aumento;
        this.hpAtual = this.hpMaximo;
    }
}
