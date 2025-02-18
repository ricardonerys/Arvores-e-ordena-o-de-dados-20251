package atividaderevisaoldetarefas;

public class LDENode {
    private LDENode anterior;
    private LDENode proximo;
    private Tarefa info;

    public LDENode(Tarefa info){
        
        this.anterior = null;
        this.proximo = null;
        this.info=info;

    }

    public LDENode getAnterior() {
        return anterior;
    }

    public void setAnterior(LDENode anterior) {
        this.anterior = anterior;
    }

    public LDENode getProximo() {
        return proximo;
    }

    public void setProximo(LDENode proximo) {
        this.proximo = proximo;
    }

    public Tarefa getInfo() {
        return info;
    }

    public void setInfo(Tarefa info) {
        this.info = info;
    }

    
}
