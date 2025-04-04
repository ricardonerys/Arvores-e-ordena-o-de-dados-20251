package AVLTree;

import Queue.Queue;

public class AVLTree<T extends Comparable <T>> {
    private AVLNode<T> root;
    private boolean status;
    

    private boolean isEmpty () {
        return root == null;
    }
    public void insert (T value) {
        if (this.isEmpty() == true) {
            this.root = new AVLNode<T> (value);
        }
        else {
            this.root = insertNode (this.root, value);
            this.status = false;
        }
    }
        
    private AVLNode<T> insertNode (AVLNode<T> r, T value){
        if (r == null) {
            r = new AVLNode<T> (value);
            this.status = true;
        }
        else if (r.getInfo().compareTo(value) > 0) {
            r.setLeft(insertNode (r.getLeft(),value));
            if (this.status == true) {
                switch (r.getFatBal()) {
                    case 1: r.setFatBal(0);
                        this.status = false;
                        break;
                    case 0: r.setFatBal(-1);
                        break;
                    case -1 : r = this.rotateRight(r);
                        break;
                } // fim switch
            } // fim if
        } // fim if
        else {
            r.setRight(insertNode (r.getRight(),value));
            if (this.status == true) {
                switch (r.getFatBal()) {
                    case -1: r.setFatBal(0);
                        this.status = false;
                        break;
                    case 0: r.setFatBal(1);
                        break;
                    case 1 : r = this.rotateLeft(r);
                        break;
                } // fim switch
            } // fim if
        } // fim else
        return r;
    } // fim insertNode

    
    private AVLNode<T> rotateRight (AVLNode<T> a) {
        AVLNode<T> b, c;
        b = a.getLeft();
        if (b.getFatBal() <= 0) { // rot. simples (modifica o == -1 para <=0)???
            System.out.println("rotacao simples a:"+a.getInfo() + " b:" + b.getInfo());
            a.setLeft(b.getRight());
            b.setRight(a);
            a.setFatBal(0);
            a = b;
        }else { // rotação dupla
            System.out.println("rotacao dupla");
            c = b.getRight();
            b.setRight(c.getLeft());
            c.setLeft(b);
            a.setLeft(c.getRight());
            c.setRight(a);
            if (c.getFatBal() == -1) {
                a.setFatBal(1);
            } else {
                a.setFatBal(0);
            }
            if (c.getFatBal() == 1) {
                b.setFatBal(-1);
            } else {
                b.setFatBal(0);
            }
            a = c;
        }
        a.setFatBal(0);
        this.status = false;
        return a;
    }
            
    private AVLNode<T> rotateLeft (AVLNode<T> a) {
        AVLNode<T> b, c;
        b = a.getRight();
        if (b.getFatBal() >= 0) { // rotação simples
            a.setRight(b.getLeft());
            b.setLeft(a);
            a.setFatBal(0);
            a = b;
        }
        else { // rotação dupla
            c = b.getLeft();
            b.setLeft(c.getRight());
            c.setRight(b);
            a.setRight(c.getLeft());
            c.setLeft(a);
            if (c.getFatBal() == 1) {
                a.setFatBal(-1);
            } else {
                a.setFatBal(0);
            }
            if (c.getFatBal() == -1) {
                b.setFatBal(1);
            } else {
                b.setFatBal(0);
            }
                a = c;
        }
        a.setFatBal(0);
        this.status = false;
        return a;
    }

    public void emOrdem () {
        if (this.isEmpty() == true) {
        System.out.println("Árvore vazia");
        } else {
        this.percorrerEmOrdem (this.root);
        }
        }
    
    private void percorrerEmOrdem (AVLNode<T> r) {
        if (r != null) {
        percorrerEmOrdem (r.getLeft());
        System.out.println(r.getInfo().toString());
        percorrerEmOrdem (r.getRight());
        }
    }

    public void passeioPorNivel() {
        if (this.isEmpty()) {
            System.out.print("Árvore vazia");
            return;
        }
    
        Queue<AVLNode<T>> fila = new Queue<>();
        fila.enqueue(this.root); //enfilera o primeiro
        boolean temMaisNivel = true; // Para evitar adicionar níveis vazios
    
        while (!fila.isEmpty() && temMaisNivel) {
            temMaisNivel = false; // Assume que não há mais nós válidos
            int qtdNivel = fila.qtd(); // Número de nós no nível atual
    
            for (int i = 0; i < qtdNivel; i++) {

                AVLNode<T> aux = fila.dequeue(); // criando a fila
    
                if (aux != null) {

                    System.out.print(aux.getInfo() + " ");
                    fila.enqueue(aux.getLeft());
                    fila.enqueue(aux.getRight());
    
                    
                    if (aux.getLeft() != null || aux.getRight() != null) {
                        temMaisNivel = true;
                    }
                    
                } else {
                    System.out.print("null ");
                    fila.enqueue(null);
                    fila.enqueue(null);
                }
            }
    
            System.out.println();
        }
    }
    public void remover (T valor) {
        if (this.isEmpty() == true) {
            System.out.println("Nenhum no encontrado");
        }
        else {
            this.root = removeNode(this.root, valor);
        }
    }

    private AVLNode<T> removeNode(AVLNode<T> raiz, T valor){
        if(raiz != null){
            int resultado = valor.compareTo(raiz.getInfo());
            if(resultado == 0){
                if(raiz.getLeft() == null && raiz.getRight() == null){
                    raiz = null;
                    



                }
                else if(raiz.getLeft() == null){
                    raiz = raiz.getRight();
                } 
                else if(raiz.getRight() == null){
                    raiz = raiz.getLeft();
                }
                else {
                    
                    AVLNode<T> pai, filho;
                    pai = raiz;
                    filho = pai.getLeft();
                    if(filho.getRight() != null){
                        while(filho.getRight() != null){
                            pai = filho;
                            filho = filho.getRight();
                        }
                        pai.setRight(filho.getLeft());
                    }
                    else {
                        pai.setLeft(filho.getLeft());
                    }
                    raiz.setInfo(filho.getInfo());
                }
            } 
            else if(resultado < 0){


                int fbfilhoant=0;

                if(raiz.getLeft()!=null){
                    fbfilhoant=raiz.getLeft().getFatBal();
                }

                raiz.setLeft(removeNode(raiz.getLeft(), valor));

                if(raiz.getLeft()!=null){
                    if((raiz.getLeft().getFatBal()!=fbfilhoant && raiz.getLeft().getFatBal() == 0)){
                        
                        raiz.setFatBal(raiz.getFatBal()+1);
                        System.out.println("ajustando fatbal de: "+ raiz.getInfo() + "para " + raiz.getFatBal());
                    }
                }else{
                    
                    raiz.setFatBal(raiz.getFatBal()+1);
                    System.out.println("ajustando fatbal de: "+ raiz.getInfo() + "para " + raiz.getFatBal());
                }


                if(raiz.getFatBal()>1){
                    //rotaciona
                    System.out.println(raiz.getInfo()+"desbalanceado");
                    raiz = this.rotateLeft(raiz);
                }
               


            } 
            else {
                
                int fbfilhoant=0;

                if(raiz.getRight()!=null){
                    fbfilhoant=raiz.getRight().getFatBal();
                }
                

                raiz.setRight(removeNode(raiz.getRight(), valor));
                
                if(raiz.getRight()!=null){
                    if((raiz.getRight().getFatBal()!=fbfilhoant && raiz.getRight().getFatBal() == 0)){
                        
                        raiz.setFatBal(raiz.getFatBal()-1);
                        System.out.println("ajustando fatbal de: "+ raiz.getInfo() + "para " + raiz.getFatBal());
                    }
                }else{
                    
                    raiz.setFatBal(raiz.getFatBal()-1);
                    System.out.println("ajustando fatbal de: "+ raiz.getInfo() + "para " + raiz.getFatBal());
                }


                if(raiz.getFatBal()<-1){
                    //rotaciona
                    System.out.println(raiz.getInfo()+"desbalanceado");
                    raiz = this.rotateRight(raiz);
                }
               
                

            }
        }
        return raiz;
    }
}