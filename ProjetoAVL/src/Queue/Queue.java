package Queue;

public class Queue<T> {
    private QueueNode<T> inicio;
    private QueueNode<T> fim;

    public Queue() {
        this.inicio = null;
        this.fim = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void enqueue(T valor) {
        QueueNode<T> novoNo = new QueueNode<T>(valor);
        if (fim != null) {
            fim.setProx(novoNo);
        }
        fim = novoNo;
        if (inicio == null) {
            inicio = novoNo;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia!");
        }
        T valor = inicio.getInfo();
        inicio = inicio.getProx();
        if (inicio == null) {
            fim = null;
        }
        return valor;
    }
    public int qtd() {
        int count = 0;
        QueueNode<T> atual = inicio;
        while (atual != null) {
            count++;
            atual = atual.getProx();
        }
        return count;
    }
}
