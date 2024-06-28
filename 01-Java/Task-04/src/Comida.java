public class Comida extends Produto {
    private String dataValidade;


    public Comida(String nome, double preco, int quantidade, String dataValidade) {
        super(nome, preco, quantidade);
        this.dataValidade = dataValidade;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public void mostrarDetalhesProduto() {
        super.mostrarDetalhesProduto();
        System.out.println(", Data de validade: " + dataValidade);
    }
}
