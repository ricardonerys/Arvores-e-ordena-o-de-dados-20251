package atividaderevisaoldealuno;

public class LSEAluno{

    private LSENode inicio;
    private LSENode fim;
    private int qtd;

    public LSEAluno() {
        this.inicio = null;
        this.fim = null;
        this.qtd = 0;
    }

    public LSENode procuraraluno(Aluno aluno){
        LSENode alunoatual = inicio;
        while(alunoatual != null){
            if(alunoatual.getInfo().compareTo(aluno) == 0){
                return alunoatual;
            }
            alunoatual = alunoatual.getProx();
        }
        return null;
    }

    public LSENode procuraraluno(String matricula) {
        LSENode alunoatual = inicio;
        while (alunoatual != null) {
            if (alunoatual.getInfo().getMatricula().equals(matricula)) { 
                return alunoatual;
            }
            alunoatual = alunoatual.getProx();
        }
        return null;
    }




    public int inseririnicio(Aluno alunoainserir){
        if(procuraraluno(alunoainserir) != null){
            System.out.println("impossivel inserir.aluno ja existe!"); 
            return 0;   
        }
        
        LSENode novono = new LSENode(alunoainserir);

        if(inicio == null){
            inicio = novono;
            fim = novono;
        }else{
            novono.setProx(inicio);
        inicio = novono;
        }
        qtd++;
        System.out.println("aluno inserido no inicio!"); 
        return 1;
    }

    public int inserirfinal(Aluno alunoainserir){
        if(procuraraluno(alunoainserir) != null){
            System.out.println("impossivel inserir.aluno ja existe!"); 
            return 0;   
        }
        
        LSENode novono = new LSENode(alunoainserir);

        if(fim == null){
            inicio = novono;
            fim = novono;
        }else{
            fim.setProx(novono);
            fim = novono;

        }
        qtd++;
        System.out.println("aluno inserido no final!"); 
        return 1;
    }

    public void exibiralunos(){
        if(inicio == null){
            System.out.println("nenhum aluno listado!");
            return;
        }
        LSENode exibidoatual = inicio;
        while (exibidoatual != null) { 
            System.out.println(exibidoatual.getInfo());
            exibidoatual = exibidoatual.getProx();
        }
    }

    public void exibirAluno(String matricula) {
        LSENode encontrado = procuraraluno(matricula);
        if (encontrado == null) {
            System.out.println("Aluno não encontrado.");
        } else {
            Aluno aluno = encontrado.getInfo();
            System.out.println("aluno encontrado: ");
            System.out.println(aluno.toString());

        }
    }

    public void alteraraluno(String matricula, double novaMedia, int novasFaltas) {
        LSENode encontrado = procuraraluno(matricula);
        if (encontrado == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
    
        Aluno aluno = encontrado.getInfo();
        
        aluno.setMedia(novaMedia);
        aluno.setFaltas(novasFaltas);
        
        System.out.println("Dados do aluno alterados!");
    }

    public int removerInicio() {
        if (inicio == null) {
            System.out.println("lista vazia!");
            return 0; 
        }
        inicio = inicio.getProx();

        if (inicio == null) { 
            fim = null;
        }
        System.out.println("dado removido do inicio!");
        qtd--;
        return 1;
    }

    public int removerfim() {
        if (inicio == null) {
            System.out.println("lista vazia!");
            return 0; 
        }
        if (inicio == fim) { 
            inicio = fim = null;
        } else {
            LSENode atual = inicio;

            while (atual.getProx() != fim) { 
                atual = atual.getProx();
            }

            atual.setProx(null);
            fim = atual;
        }
        qtd--;
        System.out.println("dado removido do final!");
        return 1;
    }
}