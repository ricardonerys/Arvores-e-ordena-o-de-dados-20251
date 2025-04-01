package Indefinido;
import ABBGenerica.ABB;
import DADOS.Produto;

import java.util.Scanner;


public class Cadastro {
    private ABB<Produto> arv = new ABB<Produto>();


    Scanner scanner = new Scanner(System.in);

    //public Cadastro(ABB<Produto> arv){
    //    this.arv = arv;
    //}

    public void Cadastrar(){
        System.out.println("digite o codigo do produto:");
        String novocod = scanner.nextLine();
        System.out.println("digite a descricao do produto:");
        String novodes = scanner.nextLine();
        System.out.println("digite o fornecedor do produto:");
        String novofor = scanner.nextLine();
        System.out.println("digite o preco do produto:");
        double novopre = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("digite a quantidade em estoque:");
        int novoqua = scanner.nextInt();
        scanner.nextLine();
        Produto novo = new Produto(novocod,novodes,novofor,novopre,novoqua);

        if(this.arv.busca(novo)!=null){
            System.out.println("codigo do produto ja existe");
            return;
        }else{
            this.arv.insert(novo);
        }
    }

    public void exibiremordem(){
        this.arv.emOrdem();
    }

    public void procurar(String cod){
        
    //    como retornar um tipo que nao é visivel?
    }

    public void alterarpreco(){
        String cod = scanner.nextLine();
        Produto pesq = new Produto(cod);
        if(this.arv.busca(pesq)!= null){
            //???
        }else{
            System.out.println("codigo nao encontrado");
        }
    }
    

}
