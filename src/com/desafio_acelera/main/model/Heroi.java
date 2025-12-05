package com.desafio_acelera.main.model;

import java.util.ArrayList;
import java.util.List;

public class Heroi extends Personagem{
    private final List<String> inventario;

    public Heroi(String nome){
        super(nome, 20);
        this.inventario = new ArrayList<>();
    }

    public void adicionarItem(String item){
        this.inventario.add(item);
    }

    public boolean temItem(String nomeDoItem){
        for(String item : inventario){
            if(item.equalsIgnoreCase(nomeDoItem)){
                return true;
            }
        }
        return false;
    }

    public void imprimirInventario(){
        if(inventario.isEmpty()){
            System.out.println("Inventário vazio.");
        }
        else{
            System.out.println("Inventário: " + inventario);
        }
    }

    public List<String>getInventario(){
        return this.inventario;
    }

    public String getItem(int indice){
        if(indice >= 0 && indice < inventario.size()){
            return inventario.get(indice);
        }
        return null;
    }
}