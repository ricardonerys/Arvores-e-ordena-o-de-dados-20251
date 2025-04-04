package Queue;

class QueueNode<T> {
    
    //atributos
    private T info;
    private QueueNode <T> prox;

    QueueNode (T info){
        this.info = info;
        this.prox = null;   
    }

    T getInfo(){
        return info;
    }
    QueueNode<T> getProx(){
        return prox;
    }
    void setInfo(T info){
        this.info = info;
    }
    void setProx(QueueNode<T> prox){
        this.prox = prox;
    }
}
