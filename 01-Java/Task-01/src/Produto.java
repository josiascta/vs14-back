public class Produto {

    private String nome;
    private String descricao;
    private double preco;
    private int estoque;
    private double precoComDesconto;

    public Produto(String nome, String descricao, double preco, int estoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void aplicarDesconto(double porcentagem){
        precoComDesconto = preco * porcentagem;
    }

    public double getPrecoComDesconto(){
        return precoComDesconto;
    }

    public String toString(){
        return "Nome: " + nome + ": " + descricao + ". Preço com desconto: " + precoComDesconto + ": " + estoque;
    }
}
