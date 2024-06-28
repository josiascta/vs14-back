public class Receipt {

    private Cart cart;

    public Receipt(Cart cart){
        this.cart = cart;
    }

    public void generateReceiptData(){
        cart.showProductsInCart();
        System.out.println("___________________________________");
        System.out.println(" Valor total: " + cart.generateTotalValue());
        System.out.println("___________________________________");
    }
}
