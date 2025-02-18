package atividaderevisaoldetarefas;

public class LDEDeTarefas {
    private LDENode inicio;
    private LDENode fim;
    private int qtd;

    public LDEDeTarefas(){
        this.inicio = null;
        this.fim=null;
        this.qtd = 0;
    }

    public LDENode getInicio() {
        return inicio;
    }

    public void setInicio(LDENode inicio) {
        this.inicio = inicio;
    }

    public LDENode getFim() {
        return fim;
    }

    public void setFim(LDENode fim) {
        this.fim = fim;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public int comparar(Tarefa tarefacomparada){
           LDENode tarefaatual = inicio;
           while(tarefaatual.getProximo()!= null){
            if(tarefaatual.getInfo().compareTo(tarefacomparada) == 0){
                return 0;
            }
            tarefaatual = tarefaatual.getProximo();
           }
           return 1;

    }
    public void inserir(Tarefa tarefainserir){

        if(tarefainserir.getPrioridade() >=0 && tarefainserir.getPrioridade() <=10){

            if(comparar(tarefainserir)==0){
                System.out.println("tarefa ja existe!!");
                return;
            }
            LDENode novono = new LDENode(tarefainserir);

            if(inicio == fim){//pro caso de lista vazia
                inicio = novono ;
                fim = novono;
            }else{//caso de lista com nos
                LDENode noatual = inicio;
                while(noatual.getInfo().getPrioridade()>=novono.getInfo().getPrioridade() || noatual.getProximo() != null){
                    noatual=noatual.getProximo();
                }
                if(noatual.getProximo()!= null){

                    noatual.setProximo(novono);
                    novono.setAnterior(noatual);
                }else{
                novono.setProximo(noatual);
                novono.setAnterior(noatual.getAnterior());
                noatual.setAnterior(novono);
                novono.getAnterior().setProximo(novono);
                }
            }



        }else{
            System.out.println("valor de prioridade incompativel!!");
            return;
        }
        
    }

}
