package Aplicacao;

import AVLTree.AVLTree;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AVLTree<Integer> arvore = new AVLTree<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMENU:");
            System.out.println("1 - Adicionar elemento");
            System.out.println("2 - Remover elemento");
            System.out.println("3 - Imprimir por nível");
            System.out.println("4 - Imprimir em ordem");
            System.out.println("5 - Criar árvore rápida para teste");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número a ser inserido: ");
                    int numInserir = scanner.nextInt();
                    arvore.insert(numInserir);
                    System.out.println("Número " + numInserir + " inserido com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o número a ser removido: ");
                    int numRemover = scanner.nextInt();
                    arvore.remover(numRemover);
                    break;
                case 3:
                    System.out.println("Árvore por nível:");
                    arvore.passeioPorNivel();
                    break;
                case 4:
                    System.out.println("Árvore em ordem:");
                    arvore.emOrdem();
                    break;
                case 5:
                    System.out.println("Criando árvore rápida para teste...");
                    int[] valoresTeste = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45, 55, 65, 75, 85};
                    
                    for (int valor : valoresTeste) {
                        arvore.insert(valor);
                    }
                    System.out.println("Árvore de teste criada com sucesso!");
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
