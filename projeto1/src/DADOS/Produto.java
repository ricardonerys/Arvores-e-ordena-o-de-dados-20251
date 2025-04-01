package DADOS;

public class Produto implements Comparable <Produto> {
    //atributos
    private String codigo;
    private String descricao;
    private String fornecedor;
    private double preco;
    private int quantidade;
    //construtor
    public Produto(String codigo, String descricao, String fornecedor, double preco, int quantidade){
        this.codigo = codigo;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public Produto(String codigo){
        this.codigo = codigo;
    }
    // gets e sets
    public String getCodigo(){
        return codigo;
    }
    public String getDescricao(){
        return descricao;
    }
    public String getFornecedor(){
        return fornecedor;
    }
    public double getPreco(){
        return preco;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setFornecedor(String fornecedor){
        this.fornecedor = fornecedor;
    }
    public void setCodigo(double preco){
        this.preco = preco;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    //tostring
    public String toString(){
        return "codigo:" + codigo + " descricao: " + descricao + " fornecedor: " + fornecedor + " codigo: " + codigo + " quantidade: "+ quantidade;
    }
    //compareto
    public int compareTo(Produto codigocomp){
        return this.codigo.compareTo(codigocomp.codigo);
    }
}
