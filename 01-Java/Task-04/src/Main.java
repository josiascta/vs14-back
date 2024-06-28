import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Supermarket supermarket = new Supermarket();
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;


        do {
            System.out.print("Digite o setor: (cliente/gerente/sair): ");
            String setor = sc.nextLine();

            if (setor.equalsIgnoreCase("cliente")) {
                exibirMenuCliente();
                int opc = Integer.parseInt(sc.nextLine());

                switch (opc) {
                    case 1:
                        System.out.println("Digite o seu nome: ");
                        String nomeCliente = sc.nextLine();
                        System.out.println("Digite o seu e-mail: ");
                        String emailCliente = sc.nextLine();
                        Cliente cliente = new Cliente(nomeCliente, emailCliente);
                        supermarket.clients.add(cliente);
                        break;
                    case 2:
                        supermarket.showAllProducts();
                        break;
                    case 3:
                        System.out.println("Qual o nome do produto que deseja adicionar ao carrinho: ");
                        String nameProduct = sc.nextLine();
                        for (Product product : supermarket.products) {
                            if (product.getNome().equalsIgnoreCase(nameProduct)) {
                                cart.adicionarProdutoCarrinho(product);
                                break;
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Qual produto você quer remover: ");
                        String produtoRemovido = sc.nextLine();
                        System.out.println("Qual a quantidade: ");
                        int quant = Integer.parseInt(sc.nextLine());
                        cart.removerProdutoCarrinho(produtoRemovido, quant);
                        break;
                    case 5:
                        System.out.println("Total do carrinho: R$ " + cart.generateTotalValue());
                        break;
                    case 6:
                        cart.finalizarCompra();
                        break;
                }
            } else if (setor.equalsIgnoreCase("gerente")) {
                exibirMenuGerente();
                int opc = Integer.parseInt(sc.nextLine());

                switch (opc) {
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
                    case 3:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } else if (setor.equalsIgnoreCase("sair")) {
                flag = false;
            }

        } while (flag);


    }

    public static void exibirMenuCliente() {
        System.out.println("Menu");
        System.out.println("1. Realizar Cadastro de cliente");
        System.out.println("2. Ver produtos");
        System.out.println("3. Adicionar ao carrinho");
        System.out.println("4. Remover no carrinho");
        System.out.println("5. Visualizar o total do carrinho");
        System.out.println("6. Finalizar Compra");
        System.out.println("7. Ver recibo");
        System.out.println("8. Sair");
    }

    public static void exibirMenuGerente() {
        System.out.println("Menu");
        System.out.println("1. Realizar Cadastro de produto");
        System.out.println("2. Ver produtos");
        System.out.println("3. Sair");
    }
}

