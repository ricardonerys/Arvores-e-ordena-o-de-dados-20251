public class LSENode{
    private Aluno info;
    private LSENode prox;

    public LSENode(Aluno info){
        this.info = info;
        this.prox = null;   
    }

    public Aluno getInfo(){
        return info;
    }
    public LSENode getProx(){
        return prox;
    }
    public void setInfo(Aluno info){
        this.info = info;
    }
    public void setProx(LSENode prox){
        this.prox = prox;
    }
}