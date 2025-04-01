package AplicacaoMercado;
import java.util.Scanner;
import Indefinido.Cadastro;

public class Aplicacao {
    public static void main(String[] args) {
        
        Cadastro cad = new Cadastro();

        Scanner scan = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("-----Menu Principal-----");
            System.out.println("selecione uma opcao:");
            System.out.println("1- Cadastrar um novo produto");
            System.out.println("2- Exibir em ordem");
            System.out.println("3- Alterar preco do produto");
            System.out.println("4- Alterar quantidade em estoque do produto");
            System.out.println("5- Exibir informacao de um produto");
            System.out.println("6- Remover produto do cadastro");
            System.out.println("0- fechar programa");
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    cad.Cadastrar();
                    break;
                case 2:
                    cad.exibiremordem();
                    break;
                case 3:
                    cad.alterarpreco();
                    break;
                case 4:
                    System.out.println("4 em dev");
                    break;
                case 5:
                    System.out.println("5 em dev");
                    break;
                case 6:
                    System.out.println("6 em dev");
                    break;
                case 0:
                    System.out.println("fechando programa");
                    break;
                default:
                    System.out.println("opcao invalida");
                    break;
            }

        }while(opcao != 0); 
        // criar funcao para fechar o scanner do cadastro
        scan.close();


    }
}
