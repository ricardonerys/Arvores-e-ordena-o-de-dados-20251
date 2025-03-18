import ABBGenerica.ABB;
import DADOS.Aluno;

public class App {
    public static void main(String[]args){
        
        ABB<Aluno> abbteste = new ABB<Aluno>();
        Aluno alteste = new Aluno("1", "ricardo", 10, 0);
        Aluno alteste2 = new Aluno("2", "ricardo", 10, 0);
        Aluno alteste3 = new Aluno("3", "ricardo", 10, 0);
        Aluno alteste4 = new Aluno("4", "ricardo", 10, 0);
        Aluno alteste5 = new Aluno("5", "ricardo", 10, 0);
        Aluno alteste6 = new Aluno("6", "ricardo", 10, 0);
        abbteste.insert(alteste);
        abbteste.insert(alteste2);
        abbteste.insert(alteste3);
        abbteste.insert(alteste4);
        abbteste.insert(alteste5);
        abbteste.insert(alteste6);
        abbteste.exibirmenor();
        abbteste.exibirmaior();
        
    }
}
