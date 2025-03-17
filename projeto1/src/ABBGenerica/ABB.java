package ABBGenerica;

public class ABB <T extends Comparable <T>> {
    private ABBNode <T> root;

    public boolean isEmpty() {
        if(this.root == null){
            return true;
        }
        return false;
    }
    
    public ABBNode <T> funcao(T valor){ //funcao de busca
        
        int retorno;

        if (this.root != null) {
            ABBNode <T> aux = this.root;
            while(true){

                retorno = valor.compareTo(aux.getInfo());

                if (retorno == 0) {
                System.out.println("Valor encontrado! \n");
                return aux;
                }
                else if (retorno < 0) {
                    if (aux.getLeft() != null) {
                    aux = aux.getLeft();
                    }else{
                        System.out.println("valor nao encontrado");
                        return null;
                    }
                
                } else if(retorno > 0 ){
                    if(aux.getRight() != null){
                        aux = aux.getRight();
                    }else{
                        System.out.println("valor nao encontrado");
                        return null;
                    }

                }
            }  
        }else{
            return null;
        }
    }

    
    public void insert(T valor){
        if(isEmpty() == true){
            this.root = new ABBNode<T>(valor);
        } else {
            inserir(this.root, valor);
        }
    }

    private void inserir(ABBNode<T> node, T valor){
        int retorno;
        if (node != null) {

            while(true){

                retorno = valor.compareTo(node.getInfo());

                if (retorno == 0) {
                System.out.println("Valor repetido! \n");
                return;
                }
                else if (retorno < 0) {
                    if (node.getLeft() != null) {
                    node = node.getLeft();
                    }else{
                        ABBNode<T> novo = new ABBNode<T>(valor);
                        node.setLeft(novo);
                        break;
                    }
                
                } else if(retorno > 0 ){
                    if(node.getRight() != null){
                        node = node.getRight();
                    }else{
                        ABBNode<T> novo = new ABBNode<T>(valor);
                        node.setRight(novo);
                        break;
                    }

                }
            }  
        }

    }

}