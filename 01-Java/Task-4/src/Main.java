//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Supermarket supermarket = new Supermarket();
        Cart cart = new Cart();
        int opt = 0;
        boolean exitMenu = false;
        String sector = sc.nextLine();

        do {
            ShowMenu(sector);
            if (sc.hasNextInt()) {
                opt = sc.nextInt();
            } else {
                System.out.println("Digite um numero inteiro: ");
                sc.nextLine();
            }

            if (sector.equalsIgnoreCase("gerente")) {
                switch (opt) {
                    case 1:
                        System.out.println("Cadastrar produto: ");
                        System.out.println("Nome produto: ");
                        String name = sc.nextLine();
                        System.out.println("Preço do produto: ");
                        double price = sc.nextDouble();
                        System.out.println("Quantidade em estoque: ");
                        int qtInStock = sc.nextInt();
                        sc.nextLine();
                        Product product = new Product(name, price, qtInStock);
                        supermarket.products.add(product);
                        break;
                    case 2:
                        System.out.println("Produtos: ");
                        supermarket.showAllProducts();
                        break;
                }
            } else if (sector.equalsIgnoreCase("cliente")) {
                switch (opt) {
                    case 1:

                        System.out.println("Digite o seu nome: ");
                        String nameClient = sc.nextLine();
                        System.out.println("Digite o seu e-mail: ");
                        String emailClient = sc.nextLine();
                        Client client = new Client(nameClient, emailClient);
                        supermarket.clients.add(client);

                        break;
                    case 2:
                        System.out.println("Produtos:");
                        for (int i = 0; i < supermarket.getProducts().size(); i++) {
                            System.out.println(supermarket.getProducts().get(i).getName() + ": " + supermarket.getProducts().get(i).getQtInStock());
                        }
                        break;
                    case 3:
                        boolean isProductFound = false;
                        System.out.println("Você deseja adicionar ou remover um produto?");
                        String addOrRemove = sc.nextLine();
                        if(addOrRemove.equalsIgnoreCase("adicionar")) {

                            System.out.println("Qual o nome do produto que deseja adicionar ao carrinho: ");
                            String nameProduct = sc.nextLine();
                            for (Product product : supermarket.products) {
                                if (product.getName().equalsIgnoreCase(nameProduct)) {
                                    cart.addProduct(product);
                                    isProductFound = true;
                                    System.out.println("Produto adicionado ao carrinho com sucesso!");
                                    break;
                                }
                            }
                        }else{
                            System.out.println("Qual o nome do produto que deseja remover do carrinho: ");
                            String nameProduct = sc.nextLine();
                            System.out.println("Digite a quantidade que deseja remover: ");
                            int qtyProduct = sc.nextInt();
                            cart.removeProduct(nameProduct,qtyProduct);

                        }
                        if(isProductFound){
                            System.out.println("Produto não encontrado, por favor digite o nome do produto novamente");
                        }
                        break;
                    case 4:
                        System.out.println("Total: R$ ");
                        System.out.printf("%.2f%n",cart.generateTotalValue());
                        cart.showProductsInCart();
                        break;

                    case 5:
                        System.out.println("Qual metódo de pagamento? (Débito ou Crédito)");
                        String paymentOpt = sc.nextLine();

                        System.out.println("Compra finalizada.");
                        break;
                    case 6:
                        break;
                    case 7:
                        System.out.println();
                        exitMenu = true;
                        break;
                    default:
                        System.out.println("Digite uma opção válida");
                }
            } else {
                System.out.println("Escolha entre Cliente ou Gerente");

            }
        } while (!exitMenu);
    }

    public static void ShowMenu(String sector) {
        if (sector.equalsIgnoreCase("cliente")) {
            System.out.println("Menu");
            System.out.println("1. Realizar Cadastro de cliente");
            System.out.println("2. Ver produtos");
            System.out.println("3. Adicionar ou remover produtos ao carrinho");
            System.out.println("4. Visualizar o total do carrinho");
            System.out.println("5. Finalizar Compra");
            System.out.println("6. Ver recibo");
            System.out.println("7. Sair");
        } else if (sector.equalsIgnoreCase("Gerente")) {
            System.out.println("Menu");
            System.out.println("1. Realizar Cadastro de produto");
            System.out.println("2. Ver produtos");
        } else {
            System.out.println("Digite uma opção válida (cliente ou gerente)");
        }

    }
}