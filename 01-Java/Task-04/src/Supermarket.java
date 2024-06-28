import java.util.ArrayList;
import java.util.List;

public class Supermarket {


    List<Product> products = new ArrayList<>();
    List<Cliente> clients = new ArrayList<>();

    public Supermarket() {

    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Cliente> getClients() {
        return clients;
    }

    public void showAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Lista de produtos vazia.");
            return;
        }
        for (Product p : products) {
            System.out.println("Nome: " + p.getNome() + "Preço: R$ " + p.getPreco() + "Qtd: " + p.getPreco());
            System.out.println();
        }
    }
}
