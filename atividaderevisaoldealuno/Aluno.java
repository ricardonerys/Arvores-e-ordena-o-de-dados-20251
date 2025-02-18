package atividaderevisaoldealuno;

public class Aluno {
    
    private String matricula;
    private String nome;
    private double media;
    private int faltas;

    public Aluno(String matricula, String nome, double media, int faltas){
        this.matricula = matricula;
        this.nome = nome;
        this.media = media;
        this.faltas = faltas;
    }

    public String getMatricula(){
        return matricula;
    }
    public String getNome(){
        return nome;
    }
    public double getMedia(){
        return media;
    }
    public int getFaltas(){
        return faltas;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setMedia(double media){
        this.media = media;
    }
    public void setFaltas(int faltas){
        this.faltas = faltas;
    }


    
    public String toString(){
        return "matricula:" + matricula + "nome:" + nome + "media:" + media + "faltas:" + faltas;
    }
    public int compareTo(Aluno alunocomparado ){
        return this.matricula.compareTo(alunocomparado.matricula);
    }
}

