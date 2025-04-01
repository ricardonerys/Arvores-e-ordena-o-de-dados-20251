package Queue;

public class Queue<T> {

    private QueueNode<T> inicio;
    private QueueNode<T> fim;

    public boolean IsEmpty(){
        return this.inicio == null;
    }

    public void enQueue (T info){
        QueueNode<T> novo = new QueueNode<T>(info);
        if(this.IsEmpty()==true){
            this.inicio = novo;
            this.fim = novo;

        }else{
            this.fim.setProx(novo);
            this.fim = novo;
        }
    }
    
    public T deQueue(){
        QueueNode<T> aux = this.inicio;
        this.inicio = this.inicio.getProx;
        return aux.getInfo;
    }
}