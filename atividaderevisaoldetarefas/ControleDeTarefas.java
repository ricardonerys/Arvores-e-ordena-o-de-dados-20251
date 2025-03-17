package atividaderevisaoldetarefas;

import java.util.Scanner;

public class ControleDeTarefas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LDEDeTarefas listaDeTarefas = new LDEDeTarefas();

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Remover tarefa");
            System.out.println("3 - Executar próxima tarefa");
            System.out.println("4 - Procurar tarefa");
            System.out.println("5 - Exibir todas as tarefas");
            System.out.println("6 - Alterar prioridade de uma tarefa");
            System.out.println("7 - Contar total de tarefas");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Prioridade (0-10): ");
                    int prioridade = scanner.nextInt();
                    scanner.nextLine();
                    listaDeTarefas.inserir(new Tarefa(descricao, prioridade));
                    break;
                case 2:
                    System.out.print("Descrição da tarefa a remover: ");
                    String descRemover = scanner.nextLine();
                    listaDeTarefas.cancelar(new Tarefa(descRemover));
                    break;
                case 3:
                    listaDeTarefas.executar();
                    break;
                case 4:
                    System.out.print("Descrição da tarefa a procurar: ");
                    String descProcurar = scanner.nextLine();
                    listaDeTarefas.procurar(new Tarefa(descProcurar));
                    break;
                case 5:
                    listaDeTarefas.exibirTarefas();
                    
                    break;
                case 6:
                    System.out.print("Descrição da tarefa para alterar prioridade: ");
                    String descAlterar = scanner.nextLine();
                    System.out.print("Nova prioridade (0-10): ");
                    int novaPrioridade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("em desenvolvimento");
                    listaDeTarefas.alterarPrioridade(descAlterar, novaPrioridade);
                    break;
                case 7:
                    System.out.println("Total de tarefas: " + listaDeTarefas.getQtd());
                    break;
                case 8:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 8);

        scanner.close();
    }
}
