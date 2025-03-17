package atividaderevisaoldetarefas;

public class Tarefa implements Comparable<Tarefa>{

    private String descricao;//descricao da tarefa
    private int prioridade;//0-10

    public Tarefa(String descricao,int prioridade){
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public Tarefa(String descricao){
        this.descricao = descricao;
        this.prioridade = 0;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
    
    public String toString() {
        return "Tarefa [descricao=" + descricao + ", prioridade=" + prioridade + "]";
    }

    public int compareTo(Tarefa tarefacomparada){
        return this.descricao.compareTo(tarefacomparada.descricao);
    }    

}
