package Stack;

public class Stack<T> {
    StackNode<T> inicio;
    StackNode<T> fim;

    public boolean isEmpty(){
        return this.fim == null;
    }

    public void empilhar(T node){
        StackNode<T> novo = new StackNode<T>(node);
        if(isEmpty()==true){
            inicio = novo;
            fim = novo;
        }else{
            novo.setProx(inicio);
            inicio = novo;
        }
    }

    public T desempilhar(){
        
    }
}
