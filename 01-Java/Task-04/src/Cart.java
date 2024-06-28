import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> produtosNoCarrinho = new ArrayList<>();


    public List<Product> getProdutos() {
        return produtosNoCarrinho;
    }

    public void adicionarProdutoCarrinho(Product product) {
        int cont = 0;
        for (Product p : produtosNoCarrinho) {
            if (p.getNome().equalsIgnoreCase(product.getNome())) {
                cont++;
            }
        }
        System.out.println(cont);
        if (cont < product.getQtdEstoque()) {
            produtosNoCarrinho.add(product);
            System.out.println("Produto adicionado.");
        } else {
            System.out.println("SEM ESTOQUE.");
        }
    }


    public void removerProdutoCarrinho(String nome, int quant) {
        int cont = 0;

        for (int i = 0; i < produtosNoCarrinho.size(); i++) {
            if (produtosNoCarrinho.get(i).getNome().equalsIgnoreCase(nome)) {
                cont++;
            }
        }
        if (cont != 0 && (quant <= cont)) {
            for (int i = 0; i < produtosNoCarrinho.size(); i++) {
                if (produtosNoCarrinho.get(i).getNome().equalsIgnoreCase(nome)) {
                    produtosNoCarrinho.remove(produtosNoCarrinho.get(i));
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

    public void finalizarCompra() {
        double precoTotal = generateTotalValue();

        for (int i = 0; i < produtosNoCarrinho.size(); i++) {
            if (produtosNoCarrinho.get(i).getQtdEstoque() >= 0) {
                produtosNoCarrinho.get(i).setQtdEstoque(produtosNoCarrinho.get(i).getQtdEstoque() - 1);
                System.out.println(produtosNoCarrinho.get(i).getQtdEstoque());
            }
        }
        System.out.println("Compra finalizada.");
    }


}
