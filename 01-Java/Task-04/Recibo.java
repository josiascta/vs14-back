public class Recibo {
    private Carrinho carrinho;
    private Cliente cliente;

    public Recibo(Carrinho carrinho, Cliente cliente) {
        this.carrinho = carrinho;
        this.cliente = cliente;
    };

    public void gerarDadosDoRecibo(){
        if(carrinho.getProdutosNoCarrinho().isEmpty()){
            System.out.println("Adicione um produto no carrinho");
            return;
        }
            System.out.println("Compra realizada com sucesso!");
            System.out.println("Cliente: " + cliente.getNome() + ": " + cliente.getEmail());
            System.out.println("Produtos: ");
            for (Produto p : carrinho.getProdutosNoCarrinho()) {
                System.out.println(p.getNome() + ": " + p.getPreco());
            }
            System.out.println("_____________________________");
            System.out.println("Valor total: " + carrinho.generateTotalValue());

    }
}
