import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LSEAluno lista = new LSEAluno();
        int opcao;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1 - Inserir aluno no início");
            System.out.println("2 - Inserir aluno no final");
            System.out.println("3 - Exibir alunos");
            System.out.println("4 - Exibir um aluno específico");
            System.out.println("5 - Alterar dados de um aluno");
            System.out.println("6 - Remover aluno do início");
            System.out.println("7 - Remover aluno do final");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a matrícula: ");
                    String matricula1 = scanner.nextLine();
                    System.out.print("Digite o nome: ");
                    String nome1 = scanner.nextLine();
                    System.out.print("Digite a média: ");
                    double media1 = scanner.nextDouble();
                    System.out.print("Digite o número de faltas: ");
                    int faltas1 = scanner.nextInt();
                    scanner.nextLine();
                    lista.inseririnicio(new Aluno(matricula1, nome1, media1, faltas1));
                    break;
                case 2:
                    System.out.print("Digite a matrícula: ");
                    String matricula2 = scanner.nextLine();
                    System.out.print("Digite o nome: ");
                    String nome2 = scanner.nextLine();
                    System.out.print("Digite a média: ");
                    double media2 = scanner.nextDouble();
                    System.out.print("Digite o número de faltas: ");
                    int faltas2 = scanner.nextInt();
                    scanner.nextLine();
                    lista.inserirfinal(new Aluno(matricula2, nome2, media2, faltas2));
                    break;
                case 3:
                    lista.exibiralunos();
                    break;
                case 4:
                    System.out.print("Digite a matrícula do aluno a exibir: ");
                    String matriculaBusca = scanner.nextLine();
                    lista.exibirAluno(matriculaBusca);
                    break;
                case 5:
                    System.out.print("Digite a matrícula do aluno a alterar: ");
                    String matriculaAlterar = scanner.nextLine();
                    System.out.print("Digite a nova média: ");
                    double novaMedia = scanner.nextDouble();
                    System.out.print("Digite o novo número de faltas: ");
                    int novasFaltas = scanner.nextInt();
                    scanner.nextLine();
                    lista.alteraraluno(matriculaAlterar, novaMedia, novasFaltas);
                    break;
                case 6:
                    lista.removerInicio();
                    break;
                case 7:
                    lista.removerfim();
                    break;
                case 0:
                    System.out.println(" fechando programa");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}