import java.util.ArrayList;
import java.util.List;

public class Supermercado {

    private List<Produto> produtos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void cadastrarProduto(Produto produto) {
        boolean flag = false;
        for(Produto pro : produtos){
            if(pro.getNome().equals(produto.getNome())){
                flag = true;
                System.out.println("Já existe esse produto cadastrado");
                break;
            }
        }
        if(!flag){
            produtos.add(produto);
            System.out.println("Produto cadastrado com sucesso");
        }
    }

    public void adicionarProdutoAoEstoque(String produto, int quantidade) {
        for(Produto pro : produtos){
            if(pro.getNome().equals(produto)){
                pro.setQuantidade(pro.getQuantidade() + quantidade);
                break;
            }
        }
    }

    public void removerProdutosDoEstoque(String produto) {
        for(Produto pro : produtos){
            if(pro.getNome().equals(produto)){
                pro.setQuantidade(pro.getQuantidade() - 1);
                break;
            }
        }
    }

    public void showAllProducts() {
        for (Produto p : produtos) {
            System.out.println("Nome: " + p.getNome() + "Preço: R$ " + p.getPreco() + "Qtd: " + p.getQuantidade());
            System.out.println();
        }
    }
}
