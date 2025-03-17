package atividaderevisaoldetarefas;

public class LDEDeTarefas {
    private LDENode inicio;
    private LDENode fim;
    private int qtd;

    public LDEDeTarefas() {
        this.inicio = null;
        this.fim = null;
        this.qtd = 0;
    }

    public int comparar(Tarefa tarefacomparada) {
        LDENode tarefaatual = inicio;
        while (tarefaatual != null) {
            if (tarefaatual.getInfo().compareTo(tarefacomparada) == 0) {
                return 0;
            }
            tarefaatual = tarefaatual.getProximo();
        }
        return 1;
    }

    public void inserir(Tarefa tarefainserir) {
        if (tarefainserir.getPrioridade() < 0 || tarefainserir.getPrioridade() > 10) {
            System.out.println("Valor de prioridade incompatível!!");
            return;
        }

        if (comparar(tarefainserir) == 0) {
            System.out.println("Tarefa já existe!!");
            return;
        }

        LDENode novono = new LDENode(tarefainserir);

        if (inicio == null) { // Lista vazia
            inicio = fim = novono;
        } else if (tarefainserir.getPrioridade() > inicio.getInfo().getPrioridade()) {
            // Inserir no início
            novono.setProximo(inicio);
            inicio.setAnterior(novono);
            inicio = novono;
        } else {
            LDENode noatual = inicio;
            while (noatual.getProximo() != null && noatual.getProximo().getInfo().getPrioridade() >= tarefainserir.getPrioridade()) {
                noatual = noatual.getProximo();
            }

            novono.setProximo(noatual.getProximo());
            novono.setAnterior(noatual);

            if (noatual.getProximo() != null) {
                noatual.getProximo().setAnterior(novono);
            } else {
                fim = novono;
            }

            noatual.setProximo(novono);
        }
        qtd++;
    }

    public void procurar(Tarefa tarefaaprocurar) {
        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }

        LDENode tarefaatual = inicio;
        int cont = 0;
        while (tarefaatual != null && tarefaatual.getInfo().compareTo(tarefaaprocurar) != 0) {
            tarefaatual = tarefaatual.getProximo();
            cont++;
        }

        if (tarefaatual != null) {
            System.out.println("Faltam " + cont + " tarefas até a tarefa: " + tarefaaprocurar.getDescricao());
        } else {
            System.out.println("Tarefa não encontrada!!");
        }
    }

    public void executar() {
        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }

        if (inicio == fim) {
            inicio = fim = null;
        } else {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
        }

        qtd--;
        System.out.println("Tarefa concluída e removida da lista!");
    }

    public void cancelar(Tarefa tarefaacancelar) {
        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }

        LDENode noatual = inicio;
        while (noatual != null && noatual.getInfo().compareTo(tarefaacancelar) != 0) {
            noatual = noatual.getProximo();
        }

        if (noatual == null) {
            System.out.println("Descrição não encontrada na lista!");
            return;
        }

        // Remover o nó encontrado
        if (noatual == inicio) {
            inicio = noatual.getProximo();
            if (inicio != null) {
                inicio.setAnterior(null);
            } else {
                fim = null;
            }
        } else if (noatual == fim) {
            fim = noatual.getAnterior();
            fim.setProximo(null);
        } else {
            noatual.getAnterior().setProximo(noatual.getProximo());
            noatual.getProximo().setAnterior(noatual.getAnterior());
        }

        qtd--;
        System.out.println("Tarefa removida com sucesso!");
    }

    public void exibirTarefas(){
        LDENode noatual = inicio;
        if(inicio == null){
            System.out.println("lista vazia!nada para exibir!");
            return;
        }
        while(noatual.getProximo() != null){
            System.out.println(noatual.getInfo().toString());
            noatual=noatual.getProximo();

        }
        System.out.println(noatual.getInfo().toString());
    }

    public void alterarPrioridade(String descricao, int novaPrioridade) {
        LDENode noAtual = inicio;
        while (noAtual != null && !noAtual.getInfo().getDescricao().equals(descricao)) {
            noAtual = noAtual.getProximo();
        }
        if (noAtual == null) {
            System.out.println("Tarefa não encontrada!");
            return;
        }
        cancelar(noAtual.getInfo());
        inserir(new Tarefa(descricao, novaPrioridade));
        System.out.println("Prioridade alterada com sucesso!");
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
}
