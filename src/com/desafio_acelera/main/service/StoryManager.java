package com.desafio_acelera.main.service;

import com.desafio_acelera.main.gameflow.LogicaDeBatalha;
import com.desafio_acelera.main.model.Heroi;
import com.desafio_acelera.main.model.Inimigo;
import com.desafio_acelera.main.ui.ConsoleUI;

public class StoryManager{
    private ConsoleUI ui;
    private LogicaDeBatalha LogicaDeBatalha;
    private Heroi heroi;

    public StoryManager(ConsoleUI ui, Heroi heroi){
        this.ui = ui;
        this.heroi = heroi;
        this.LogicaDeBatalha = new LogicaDeBatalha(ui);
    }

    public void introducao(){
        ui.digitacaoLenta("=== A JORNADA DE HOT DOG ===");
        ui.digitacaoLenta("Vindo de onde os olhos não conseguem alcançar...");
        ui.digitacaoLenta("Glozium: 'Contemplem seu novo mestre... Demonstrativus potentiaaam!'");
        ui.esperarPorEnter();
    }

    public boolean jogarFase1(){
        ui.imprimir("\nCAPÍTULO 1: FLORESTA DO ATENDIMENTUS");
        ui.digitacaoLenta("Um lugar encantado, onde almas feridas buscam cura...");

        ui.digitacaoLenta("\nSandubinha (telepatia): 'Hot Dog... Na floresta... encontre o ser Processus...'");
        ui.esperarPorEnter();

        ui.digitacaoLenta("Você corre pelos arbustos espinhosos. Chega a um campo limpo.");
        ui.digitacaoLenta("Processus está morto aos pés de uma criatura humanoide.");

        ui.digitacaoLenta("\nHot Dog: 'Não há dúvidas, você o matou! Como pôde ferir Processus?!'");
        ui.esperarPorEnter();

        ui.digitacaoLenta("Monstro: 'Eu sou Anti-authorizatus! Impeço o atendimento das almas!'");
        ui.digitacaoLenta("Monstro: 'Agora é a sua vez, pirralho!'");
        ui.esperarPorEnter();

        Inimigo chefao1 = new Inimigo("Anti-authorizatus", 15, 1);

        boolean vitoria = LogicaDeBatalha.comecarBatalha(heroi, chefao1);

        if(vitoria){
            ui.digitacaoLenta("\nFilho de Processus surge: 'Muito obrigado! Tome o artefato [Guia de Atendimento].'");
            ui.imprimir("Você obteve: Guia de Atendimento");
            return true;
        }
        else{
            ui.digitacaoLenta("\nO monstro matou o filho de Processus e o mundo foi destruído por Glozium...");
            return false;
        }
    }

    public boolean jogarFase2(){
        ui.imprimir("\nCAPÍTULO 2: O HOSPITALIS");
        ui.digitacaoLenta("Você chega aos portões de Hospitalis.");
        ui.digitacaoLenta("Um guarda bloqueia o caminho");

        ui.imprimir("1: Lutar\n2: Tentar conversar");
        int escolha = ui.lerInt("Sua escolha");

        if(escolha == 2){
            ui.digitacaoLenta("O guarda deixa você passar pois você tem o Guia do Atendimento.");
            return true;
        }
        else{
            Inimigo guarda = new Inimigo("Guarda Corrompido", 20, 2);
            return LogicaDeBatalha.comecarBatalha(heroi, guarda);
        }
    }
}
