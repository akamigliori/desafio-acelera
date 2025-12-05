package com.desafio_acelera.main.service;

import com.desafio_acelera.main.gameflow.LogicaDeBatalha;
import com.desafio_acelera.main.model.Heroi;
import com.desafio_acelera.main.model.Inimigo;
import com.desafio_acelera.main.ui.ConsoleUI;

public class StoryManager{
    private final ConsoleUI ui;
    private final LogicaDeBatalha LogicaDeBatalha;
    private final Heroi heroi;

    public StoryManager(ConsoleUI ui, Heroi heroi){
        this.ui = ui;
        this.heroi = heroi;
        this.LogicaDeBatalha = new LogicaDeBatalha(ui);
    }

    public void introducao(){
        ui.digitacaoLenta("=== A JORNADA DE HOT DOG ===");
        ui.digitacaoLenta("Vindo de onde os olhos não conseguem alcançar...");
        ui.digitacaoLenta("Glozium: 'Contemplem seu novo mestre... Demonstrativus potentiaaam!'");
        heroi.adicionarItem("Salsichinha");
        ui.esperarPorEnter();
    }

    public boolean jogarFase1(){
        ui.imprimir("\nCAPÍTULO 1: FLORESTA DO ATENDIMENTUS");
        ui.digitacaoLenta("Um lugar encantado, onde almas feridas buscam cura...");

        ui.digitacaoLenta("A floresta parece mais sinistra do que nunca... você conversa com seu pai...");
        ui.digitacaoLenta("\nSandubinha (telepatia): 'Hot Dog... Na floresta de Atendimentus... encontre o ser 'Processus' ele irá te mostrar o monstro a ser enfrentado'");
        ui.esperarPorEnter();

        ui.digitacaoLenta("Você corre pelos arbustos espinhosos e se perde na floresta...");
        ui.digitacaoLenta("Sandubinha fareja algo e começa a correr, você o segue");
        ui.digitacaoLenta("Processus está morto aos pés de uma criatura humanoide.");

        ui.digitacaoLenta("\nHot Dog: 'Não há dúvidas, você o matou! Como pôde ferir Processus?! Não era para o seu poder afetar seres mágicos do tipo dele!'");
        ui.esperarPorEnter();

        ui.digitacaoLenta("Monstro: 'Não afeta diretamente, mas interfere no equilíbrio, eu impeço o atendimento das almas, eu sou Anti-authorizatus! E mesmo esses seres precisam passar pelo Ciclo de Hospitales HAHAHA que pena, esse já era, agora é sua vez e depois matarei esse pirralho assustado nos arbustos, filho desse aqui.'");
        ui.digitacaoLenta("Hot Dog: 'Não se preocupe, jovem. Irei me vingar pelo amigo de meu pai!'");
        ui.esperarPorEnter();

        Inimigo chefao1 = new Inimigo("Anti-authorizatus", 15, 1);

        boolean vitoria = LogicaDeBatalha.comecarBatalha(heroi, chefao1);

        if(vitoria){
            ui.digitacaoLenta("\nFilho de Processus surge: 'Muito obrigado! Tome o artefato [Guia de Atendimento] e vá para o próximo desafio, vou sepultar meu pai.'");
            heroi.adicionarItem("Guia do Atendimento");
            ui.imprimir("[ITEM OBTIDO]: Guia do Atendimento");
            return true;
        }
        else{
            ui.digitacaoLenta("\nO monstro matou o filho de Processus e o mundo foi destruído por Glozium, uma fatalidade terrível... Fim de jogo!");
            return false;
        }
    }

    public boolean jogarFase2(){
        ui.imprimir("\nCAPITULO 2: CAVERNAS DE FATURAMENTUS");
        ui.digitacaoLenta("Existe sempre um preço a se pagar pela cura do corpo e da alma...");
        ui.digitacaoLenta("Explorando a caverna, Hot Dog escuta sons metálicos...");
        ui.esperarPorEnter();

        boolean chefaoBuffado = false;
        boolean passouPeloEnigma = false;

        while(!passouPeloEnigma){
            ui.imprimir("\n---ESCOLHA UMA AÇÃO---");
            ui.imprimir("A) O Ciclum Receitatus Hospitalis");
            ui.imprimir("B) O Rito dos Curandeiros Eternos");
            ui.imprimir("C) A Roda da Vida e da Cura");
            ui.imprimir("[I] Abrir Inventário/Usar Item");

            String entrada = ui.solicitarEntrada("Sua escolha: ").toUpperCase();

            if(entrada.equalsIgnoreCase("I")){
                if(heroi.getInventario().isEmpty()){
                    ui.imprimir("Inventário está vazio.");
                }
                else{
                    ui.imprimir("---INVENTÁRIO---");
                    for(int i = 0; i < heroi.getInventario().size(); i++){
                        ui.imprimir((i + 1 + ". " + heroi.getItem(i)));
                    }
                    ui.imprimir("0: Voltar");

                    String selecaoStr = ui.solicitarEntrada("Digite o número do item para usar:");
                    try{
                        int selecao = Integer.parseInt(selecaoStr) - 1;

                        if(selecao >= 0 && selecao < heroi.getInventario().size()){
                            String itemUsado = heroi.getItem(selecao);
                            ui.imprimir("Você segurou: [" + itemUsado + "]");

                            if(itemUsado.equalsIgnoreCase("Salsichinha")){
                                ui.digitacaoLenta("\n[!] Salsichinha começa a latir para uma parede falsa!");
                                ui.digitacaoLenta("O animal descobre um portal secreto que evita todas as armadilhas!");
                                ui.digitacaoLenta("Você atravessa a passagem secreta com segurança!");
                                passouPeloEnigma = true;
                            }
                            else{
                                ui.imprimir("Nada acontece ao usar esse item aqui.");
                            }
                        }
                        else if(!selecaoStr.equals("0")){
                            ui.imprimir("Item inválido.");
                        }
                    }
                    catch(NumberFormatException e){
                        ui.imprimir("Entrada inválida.");
                    }
                }
            }
            else{
                switch(entrada){
                    case "A":
                        ui.digitacaoLenta("Resposta correta! Você avança com segurança.");
                        passouPeloEnigma = true;
                        break;
                    case "B":
                        ui.digitacaoLenta("Errado! Você cai em uma armadilha de espinhos!");
                        heroi.tomarDano(2);
                        ui.imprimir("Você sofreu 2 de dano. Vida atual: " + heroi.getHpAtual());
                        if(heroi.getHpAtual() <= 0){
                            return false;
                        }
                        passouPeloEnigma = true;
                        break;
                    case "C":
                        ui.digitacaoLenta("Errado! A energia do erro fortalece o mal à frente...");
                        chefaoBuffado = true;
                        ui.imprimir("O Chefão ganhou +6 de vida!");
                        passouPeloEnigma = true;
                        break;
                    default:
                        ui.imprimir("Opção inválida. Tente A, B, C ou I para abrir o inventário.");
                }
            }
        }

        ui.digitacaoLenta("\nHot Dog enconta os Anciões trabalhando sem parar.");
        ui.digitacaoLenta("De repente surge: GLOZIUM ADMINISTRATUS (Cavaleiro Infernal)");

        int vidaBoss = 6;
        if(chefaoBuffado){
            vidaBoss += 6;
        }

        Inimigo gloziumAdministratus = new Inimigo("Glozium Administratus", vidaBoss, 2);
        boolean usouBuff = false;
        int danoOriginal = heroi.getDano();

        if(heroi.temItem("Salsichinha")){
            ui.imprimir("\nDeseja realizar um ataque combinado com Salsichinha (+1 de dano)? (S/N)");
            String opcao = ui.solicitarEntrada("").toUpperCase();

            if(opcao.equalsIgnoreCase("S")){
                heroi.setDano(danoOriginal + 1);
                usouBuff = true;
                ui.imprimir("Salsichinha se prepara para a batalha! (Dano aumentado!)");
            }
        }

        ui.esperarPorEnter();
        boolean vitoria = LogicaDeBatalha.comecarBatalha(heroi, gloziumAdministratus);

        if(usouBuff){
            heroi.setDano(danoOriginal);
        }

        if(vitoria){
            ui.digitacaoLenta("\nAncião Faturador: 'Tome o artefato e suma.'");
            heroi.adicionarItem("Faturamentus");
            ui.imprimir("[ITEM OBTIDO]: Faturamentus");
            return true;
        }
        else{
            ui.digitacaoLenta("\nO mundo foi destruído por Glozium...");
            return false;
        }
    }
}
