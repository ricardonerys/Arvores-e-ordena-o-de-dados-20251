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
        if(raiz != null){                                                   //verifica se arvore esta vazia
            int resultado = valor.compareTo(raiz.getInfo());                
            if(resultado == 0){                                             //se encontrar o valor correto
                if(raiz.getLeft() == null && raiz.getRight() == null){      //remocao de um nó sem filhos: para eles, os fatbals e rotacoe foram feitos apos a chamada da recursão
                    raiz = null;
                    
                }
                else if(raiz.getLeft() == null){                            //remocao de um no comm apenas um filho: o ajuste apos a chamada da recursao tambem resolveu este caso
                    raiz = raiz.getRight();
                } 
                else if(raiz.getRight() == null){
                    raiz = raiz.getLeft();
                }
                else {                                                      //remocao de no com 2 filhos. consegui ajustar os fatores utilizando uma fila que armazena todos os pais anteriores e ajusta os fatbals se necessario

                    AVLNode<T> pai, filho;
                    pai = raiz;
                    filho = pai.getLeft();
                    if(filho.getRight() != null){                           //daqui em diante o codigo comeca a se diferenciar do remover da abbgenerica

                        Queue<AVLNode<T>> fila = new Queue<>();             //fila criada para receber os pais anteriores até chegar no final

                        while(filho.getRight() != null){                    //while semelhante ao que tem no remover da classe abbgenerica, com o adicional de enfilerar os pais anteriores
                            pai = filho;
                            filho = filho.getRight();
                                                                            //provavel uso de fila para referencias de pais anteriores
                            
                            fila.enqueue(pai);                              //enfilerando os pais
                        }
                        pai.setRight(filho.getLeft());                      //remove referencia do filho

                        fila.dequeue();                                     //desenfilera o pai final que ja esta em posicao
                        pai.setFatBal(pai.getFatBal()-1);                   //ajusta o fatbal do pai final

                        if(pai.getFatBal()<-1){                             //descobri um padrao que: o pai final SEMPRE muda o fatball decrementando 1. isso gera algumas possibilidades
                            pai = this.rotateRight(pai);                    //para o caso de apos o decremento, seja identificado um desbalanceamento 
                        }

                        if(pai.getFatBal()==0){                             //para o caso do pai final for zero depois do decremento.se acontecer, é necessario decrenebtar os pais anteriores
                            while(!fila.isEmpty()){                         //utilizando fila que foram armazenadas as referencias dos pais anteriores
                                AVLNode<T> paiant = fila.dequeue();
                                paiant.setFatBal(paiant.getFatBal()-1);
                            }
                        } 
                    }
                    else {                                                  //para o caso de nao precisar entrar no while. aqui o pai nao muda e é sempre o mesmo desde o inicio
                        pai.setLeft(filho.getLeft());                       
                        pai.setFatBal(pai.getFatBal()+1);                   //nesse caso sempre vai incrementar o fatball em 1
                        if(pai.getFatBal()>1){                              //caso identifique algum desbalanceamento
                            raiz = this.rotateLeft(raiz);
                        }
                    }
                    raiz.setInfo(filho.getInfo());                          //passando a info para o no "raiz"(o no que foi identificado o valor a se remover)
                }
            } 
            else if(resultado < 0){                                         //parte referente a remocao dos nós com apenas um filho ou nenhum


                int fbfilhoant=0;                                           

                if(raiz.getLeft()!=null){
                    fbfilhoant=raiz.getLeft().getFatBal();                  //guardando o fatbal do filho antes da recursao
                }

                raiz.setLeft(removeNode(raiz.getLeft(), valor));            //chamada da recursão

                if(raiz.getLeft()!=null){                                   
                    if((raiz.getLeft().getFatBal()!=fbfilhoant && raiz.getLeft().getFatBal() == 0)){    
                                                                            //encontrei um padrao: sempre que o no é removido a esquerda, o fatbal do pai incrementa em 1
                        raiz.setFatBal(raiz.getFatBal()+1);                 //outro padrao: na volta da recursao, se for identificado que o fatbal do filho mudou especificamente para 0,incremento ao pai em 1
                                                                            
                    }
                }else{
                                                                            //mesmo ajuste de fatbal, mas para os pais que tiveram os filhos removidos
                    raiz.setFatBal(raiz.getFatBal()+1);
                }
                if(raiz.getFatBal()>1){                                     //rotaciona caso passe do limite do balanceamento
                    raiz = this.rotateLeft(raiz);
                }
               


            } 
            else {
                                                                            //nessa parte sigo com a mesma logica, só que invertida para os nós removidos pela direita
                int fbfilhoant=0;

                if(raiz.getRight()!=null){
                    fbfilhoant=raiz.getRight().getFatBal();
                }
                
                raiz.setRight(removeNode(raiz.getRight(), valor));
                
                if(raiz.getRight()!=null){
                    if((raiz.getRight().getFatBal()!=fbfilhoant && raiz.getRight().getFatBal() == 0)){
                        
                        raiz.setFatBal(raiz.getFatBal()-1);
                    }
                }else{
                    
                    raiz.setFatBal(raiz.getFatBal()-1);
                }
                if(raiz.getFatBal()<-1){
                    raiz = this.rotateRight(raiz);
                }
               
                

            }
        }
        return raiz;                                               //por fim, retorna a "raiz", para voltar da recursao
    }
}