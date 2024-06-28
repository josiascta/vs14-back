public class Product {
    private String name;
    private double price;
    private int qtInStock;

    public Product(String name, double price, int qtInStock) {
        this.name = name;
        this.price = price;
        this.qtInStock = qtInStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtInStock() {
        return qtInStock;
    }

    public void setQtInStock(int qtInStock) {
        this.qtInStock = qtInStock;
    }

}
