import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Produto> produtosNoCarrinho = new ArrayList();

    public Carrinho() {}

    public boolean adicionarNoCarrinho(Produto produto, int quantidade){
        int cont = 0;

        for (int i = 0; i < produtosNoCarrinho.size(); i++) {
            if (produtosNoCarrinho.get(i).getNome().equalsIgnoreCase(produto.getNome())) {
                cont++;
            }
        }
        if(cont >= produto.getQuantidade()){
            return false;
        }
        if(quantidade <= produto.getQuantidade()) {

            for (int i = 0; i < quantidade; i++) {
                produtosNoCarrinho.add(produto);
            }

            return true;
        }return false;
    }

    public List<Produto> getProdutosNoCarrinho() {
        return produtosNoCarrinho;
    }

    public void removerProdutoCarrinho(String nome) {
        int cont = 0;

        for (int i = 0; i < produtosNoCarrinho.size(); i++) {
            if (produtosNoCarrinho.get(i).getNome().equalsIgnoreCase(nome)) {
                cont++;
            }
        }

        if (cont != 0) {
            for (int i = 0; i < produtosNoCarrinho.size(); i++) {
                if (produtosNoCarrinho.get(i).getNome().equalsIgnoreCase(nome)) {
                    produtosNoCarrinho.remove(produtosNoCarrinho.get(i));
                    i--;
                }
            }
            System.out.println("Removido com sucesso!");
        } else {
            System.out.println("Não foi possível remover.");
        }

    }

    public double generateTotalValue() {
        double totalValue = 0;
        for (int i = 0; i < produtosNoCarrinho.size(); i++) {
            totalValue += produtosNoCarrinho.get(i).getPreco();
        }
        return totalValue;
    }
}
