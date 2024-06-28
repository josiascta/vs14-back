import java.util.ArrayList;
import java.util.List;
/*Carrinho de Compras
 ○ Os clientes podem adicionar e remover produtos do carrinho.
 ○ Visualizar o total do carrinho.

 ○ Finalização de Compra
 ○ Processamento do pagamento.
 ○ Geração de um recibo detalhado.*/

public class Cart {

    Supermarket supermarket = new Supermarket();


    public void addProduct(Product product) {
        supermarket.cartProducts.add(product);
    }

    public void removeProduct(String nomeDoProduto, int quantClient) {
        int amount = 0;
        for (int i = 0; i < supermarket.cartProducts.size(); i++) {
            if (supermarket.cartProducts.get(i).getName().equalsIgnoreCase(nomeDoProduto)) {
                amount++;
            }
        }
        if(amount != 0 && (quantClient <= amount)){
            for (int i = 0; i < supermarket.cartProducts.size(); i++) {
                if (supermarket.cartProducts.get(i).getName().equalsIgnoreCase(nomeDoProduto)) {
                    supermarket.cartProducts.remove(supermarket.cartProducts.get(i));
                }
            }
            System.out.println("Removido com sucesso!");
        }else {
            System.out.println("Não foi possível remover. Quant desse produto no carrinho: ");
        }
    }

    public double generateTotalValue() {
        double totalValue = 0;
        for (int i = 0; i < supermarket.cartProducts.size(); i++) {
            totalValue += supermarket.cartProducts.get(i).getPrice();
        }
        return totalValue;
    }

    public void showProductsInCart() {
        for(Product p : supermarket.cartProducts) {
            System.out.println("Produto: "+p.getName()+" Preço: "+p.getPrice());
        }
    }

}

