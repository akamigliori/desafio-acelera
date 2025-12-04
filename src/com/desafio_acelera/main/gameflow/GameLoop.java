package com.desafio_acelera.main.gameflow;

import com.desafio_acelera.main.model.Heroi;
import com.desafio_acelera.main.service.StoryManager;
import com.desafio_acelera.main.ui.ConsoleUI;

public class GameLoop {
    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        boolean continuar = true;

        while(continuar){
            Heroi heroi = new Heroi("Hot Dog");
            StoryManager historia = new StoryManager(ui, heroi);

            historia.introducao();

            boolean f1Completa = historia.jogarFase1();

            if(f1Completa){
                ui.esperarPorEnter();
                boolean f2Completa = historia.jogarFase2();

                if(f2Completa){
                    ui.digitacaoLenta("\nPARABÉNS! Você completou a demo da jornada de Hot Dog!");
                }
            }

            String resposta = ui.lerString("\nDeseja jogar novamente? (S/N)");
            if(!resposta.equalsIgnoreCase("S")){
                continuar = false;
            }
        }
        ui.imprimir("Obrigado por jogar!");
    }
}