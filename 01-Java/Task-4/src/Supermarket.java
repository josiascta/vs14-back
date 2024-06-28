import java.util.ArrayList;
import java.util.List;

public class Supermarket {


    List<Product> products = new ArrayList<>();
    List<Client> clients = new ArrayList<>();
    List<Product> cartProducts = new ArrayList<>();
    List<Receipt> receipts = new ArrayList<>();
    List<Product> purchases = new ArrayList<>();

    public Supermarket() {

    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void showAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Lista de produtos vazia.");
            return;
        }
        for (Product p : products) {
            System.out.println("Nome: " + p.getName() + "Preço: R$ " + p.getPrice() + "Qtd: " + p.getPrice());
            System.out.println();
        }
    }

    public void addReceipt(Receipt receipt){
        receipts.add(receipt);
    }

    public void checkout() {
        for(int i = 0; i <=cartProducts.size(); i++) {
            if(cartProducts.get(i).getName().equalsIgnoreCase(products.get(i).getName())) {
                products.get(i).setQtInStock(products.get(i).getQtInStock() - cartProducts.get(i).getQtInStock());
            }
        }

    }


}
