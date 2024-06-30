public class Bebida extends Produto {

    private String tipoEmbalagem;

    public Bebida(String nome, double preco, int quantidade, String tipoEmbalagem) {
        super(nome, preco, quantidade);
        this.tipoEmbalagem = tipoEmbalagem;
    }

    public String getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    public void setTipoEmbalagem(String tipoEmbalagem) {
        this.tipoEmbalagem = tipoEmbalagem;
    }

    @Override
    public void mostrarDetalhesProduto() {
        super.mostrarDetalhesProduto();
        System.out.println(", Tipo de Embalagem: " + tipoEmbalagem);
    }
}
