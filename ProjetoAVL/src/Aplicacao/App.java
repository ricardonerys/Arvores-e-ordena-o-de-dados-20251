package Aplicacao;

import AVLTree.AVLTree;
public class App {
    public static void main(String[] args) {

        AVLTree<Integer> arvore = new AVLTree<Integer>();
        
        
        arvore.insert(5);
        arvore.insert(6);
       arvore.insert(3);
        arvore.insert(2);
        
        
        arvore.insert(1);
        arvore.insert(7);
        arvore.passeioPorNivel();
        arvore.remover(2);
        arvore.passeioPorNivel();
        
    }

    
    }
