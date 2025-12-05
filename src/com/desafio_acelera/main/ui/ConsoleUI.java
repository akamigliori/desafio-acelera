package com.desafio_acelera.main.ui;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner;

    public ConsoleUI(){
        this.scanner = new Scanner(System.in);
    }

    public void digitacaoLenta(String texto){
        for(char c : texto.toCharArray()){
            System.out.print(c);
            try{
                Thread.sleep(30);
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public void imprimir(String texto){
        System.out.println(texto);
    }

    public void esperarPorEnter(){
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }

    public String lerString(String prompt){
        System.out.println(prompt + ": ");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("desistir")){
            System.out.println("Você decidiu abandonar a missão. O mundo caiu em trevas...");
            System.exit(0);
        }
        return input;
    }

    public int lerInt(String prompt){
        while(true){
            try{
               String input = lerString(prompt);
               return Integer.parseInt(input);
            }
            catch(NumberFormatException e){
                System.out.println("Por favor, digite um número válido.");
            }
        }
    }

    public String solicitarEntrada(String mensagem){
        if(mensagem != null && !mensagem.isEmpty()){
            System.out.println(mensagem);
        }
        System.out.println(">> ");
        return scanner.nextLine();
    }
}
