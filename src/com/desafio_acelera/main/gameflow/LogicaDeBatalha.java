package com.desafio_acelera.main.gameflow;

import com.desafio_acelera.main.model.Heroi;
import com.desafio_acelera.main.model.Inimigo;
import com.desafio_acelera.main.ui.ConsoleUI;

import java.util.Random;

public class LogicaDeBatalha{
    private ConsoleUI ui;
    private Random aleatorio;

    public LogicaDeBatalha(ConsoleUI ui){
        this.ui = ui;
        this.aleatorio = new Random();
    }

    public boolean comecarBatalha(Heroi heroi, Inimigo inimigo){
        ui.digitacaoLenta("\n⚔ BATALHA INICIADA ⚔: " + heroi.getNome() + " vs " + inimigo.getNome());

        int numSecretoHeroi = aleatorio.nextInt(heroi.getHpMaximo()) + 1;
        int numSecretoInimigo = aleatorio.nextInt(inimigo.getHpMaximo() + 1);

        heroi.setNumeroSecreto(numSecretoHeroi);
        inimigo.setNumeroSecreto(numSecretoInimigo);

        ui.imprimir("O número secreto do inimigo foi definido!");
        ui.imprimir("Seu número secreto foi sorteado automaticamente: " + numSecretoHeroi);
        ui.esperarPorEnter();

        while(heroi.estaVivo() && inimigo.estaVivo()){
            ui.imprimir("\n--------------------------------");
            ui.imprimir(heroi.getNome() + "HP: " + heroi.getHpAtual() + " | " + inimigo.getNome() + " HP: " + inimigo.getHpAtual());
            ui.imprimir("Sua vez! Tente adivinhar o número secreto do monstro (1 a " + inimigo.getHpMaximo() + ")");

            int escolhaJogador = ui.lerInt("Qual número você escolhe?");

            if(escolhaJogador == inimigo.getNumeroSecreto()){
                ui.digitacaoLenta("ACERTO CRÍTICO! Você atingiu o ponto fraco!");
                int dano = escolhaJogador;
                inimigo.tomarDano(dano);
                ui.imprimir("Você causou " + dano + " de dano!");
            }
            else{
                ui.imprimir("Você errou o ataque!");
            }

            if(!inimigo.estaVivo()) break;

            ui.imprimir("\nVez do " + inimigo.getNome() + "...");
            for(int i = 0; i < inimigo.getQuantidadeAleatoria(); i++){
                int escolhaInimigo = aleatorio.nextInt(heroi.getHpMaximo() + 1);
                ui.imprimir("O monstro atacou com o número: " + escolhaInimigo);

                if(escolhaInimigo == inimigo.getNumeroSecreto()){
                    ui.digitacaoLenta("DANO! O monstro acertou seu ponto vital!");
                    int dano = escolhaInimigo;
                    heroi.tomarDano(dano);
                    ui.imprimir("Você sofreu " + dano + " de dano!");
                }
                else{
                    ui.imprimir("O monstro errou!");
                }
            }
        }
        if(heroi.estaVivo()){
            ui.imprimir("\nVITÓRIA! O inimigo caiu!");
            heroi.aumentarHpMaximo(5);
            ui.imprimir("Sua vida máxima aumentou em 5!");
            return true;
        }
        else{
            ui.digitacaoLenta("\nDERROTA! Hot Dog caiu em combate!");
            return false;
        }
    }
}
