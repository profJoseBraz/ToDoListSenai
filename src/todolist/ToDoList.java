/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package todolist;

import java.util.Scanner;



/**
 *
 * @author jose310361
 */
public class ToDoList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays para armazenar até 10 tarefas
        String[] tarefas = new String[10];
        boolean[] concluidas = new boolean[10];

        int opcao = 0;
        //teste
        while (opcao != 5) {

            System.out.println("\n=== LISTA DE TAREFAS ===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("5 - Sair");

            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o ENTER

            switch (opcao) {

                // ADICIONAR TAREFA
                case 1:

                    int posicaoLivre = -1;

                    // Procura uma posição vazia
                    for (int i = 0; i < tarefas.length; i++) {
                        if (tarefas[i] == null) {
                            posicaoLivre = i;
                            break;
                        }
                    }

                    if (posicaoLivre == -1) {
                        System.out.println("\nA lista de tarefas está cheia!");
                    } else {
                        System.out.print("\nDigite a tarefa: ");
                        tarefas[posicaoLivre] = scanner.nextLine();

                        concluidas[posicaoLivre] = false;

                        System.out.println("Tarefa adicionada com sucesso!");
                    }

                    break;

                // LISTAR TAREFAS
                case 2:

                    System.out.println("\n=== MINHAS TAREFAS ===\n");

                    boolean existeTarefa = false;

                    for (int i = 0; i < tarefas.length; i++) {

                        if (tarefas[i] != null) {

                            existeTarefa = true;

                            if (concluidas[i] == true) {
                                System.out.println((i + 1) + " - [X] " + tarefas[i]);
                            } else {
                                System.out.println((i + 1) + " - [ ] " + tarefas[i]);
                            }
                        }
                    }

                    if (existeTarefa == false) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    }

                    break;

                // CONCLUIR TAREFA
                case 3:

                    System.out.print("\nDigite o número da tarefa que deseja concluir: ");
                    int numeroConcluir = scanner.nextInt();

                    // Converte o número exibido para a posição do array
                    int indiceConcluir = numeroConcluir - 1;

                    if (indiceConcluir >= 0 &&
                        indiceConcluir < tarefas.length &&
                        tarefas[indiceConcluir] != null) {

                        concluidas[indiceConcluir] = true;

                        System.out.println("Tarefa concluída com sucesso!");

                    } else {
                        System.out.println("Tarefa inválida!");
                    }

                    break;

                // EXCLUIR TAREFA
                case 4:

                    System.out.print("\nDigite o número da tarefa que deseja excluir: ");
                    int numeroExcluir = scanner.nextInt();

                    // Converte o número exibido para a posição do array
                    int indiceExcluir = numeroExcluir - 1;

                    if (indiceExcluir >= 0 &&
                        indiceExcluir < tarefas.length &&
                        tarefas[indiceExcluir] != null) {

                        // Remove a tarefa
                        tarefas[indiceExcluir] = null;
                        concluidas[indiceExcluir] = false;

                        System.out.println("Tarefa excluída com sucesso!");

                    } else {
                        System.out.println("Tarefa inválida!");
                    }

                    break;

                // SAIR
                case 5:

                    System.out.println("\nPrograma encerrado. Até mais!");

                    break;

                // OPÇÃO INVÁLIDA
                default:

                    System.out.println("\nOpção inválida! Tente novamente.");

                    break;
            }
        }

        scanner.close();
    }
    
}
