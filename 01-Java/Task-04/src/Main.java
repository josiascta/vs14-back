import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Supermercado supermercado = new Supermercado();
        Produto produto;

        boolean flag = true;
        while (flag) {
            System.out.println("1. Cliente");
            System.out.println("2. Gerente");
            System.out.println("3. Sair ");
            System.out.print("Digite o setor: ");
            int setor = Integer.parseInt(sc.nextLine());

            if (setor == 1) {
                boolean flagCliente = true;
                Carrinho carrinho = new Carrinho();
                Cliente cliente = null;
                while (flagCliente) {
                    exibirMenuCliente();
                    int opc = Integer.parseInt(sc.nextLine());

                    switch (opc) {
                        case 1:
                            System.out.println("Você quer realizar o cadastro: ");
                            char opcadastro = sc.nextLine().charAt(0);
                            if (opcadastro == 'n') {
                                cliente = new Cliente();
                                supermercado.cadastrarCliente(cliente);
                            } else if (opcadastro == 's') {
                                System.out.println("Digite o seu nome: ");
                                String nomeCliente = sc.nextLine();
                                System.out.println("Digite o seu e-mail: ");
                                String emailCliente = sc.nextLine();
                                cliente = new Cliente(nomeCliente, emailCliente);
                                supermercado.cadastrarCliente(cliente);
                            } else {
                                System.out.println("Digite sim ou não: ");
                            }
                            break;
                        case 2:
                            System.out.println("TODOS OS PRODUTOS");
                            supermercado.printarTodosProdutos();
                            break;
                        case 3:
                            System.out.print("Qual o nome do produto que deseja adicionar ao carrinho: ");
                            String nameProduct = sc.nextLine();
                            System.out.println("Quanto desse produto você quer adicionar no carrinho? ");
                            int quant = Integer.parseInt(sc.nextLine());
                            for (Produto product : supermercado.getProdutos()) {
                                if (product.getNome().equalsIgnoreCase(nameProduct)) {
                                    System.out.println(carrinho.adicionarNoCarrinho(product, quant) ? "Adicionado ao carrinho!" : "Não foi possível adicionar ao carrinho, digite um valor válido!");
                                    break;
                                }
                            }
                            break;
                        case 4:
                            System.out.print("Qual produto você quer remover: ");
                            String produtoRemovido = sc.nextLine();
                            carrinho.removerProdutoCarrinho(produtoRemovido);
                            break;
                        case 5:
                            System.out.println("Total do carrinho: R$ " + carrinho.generateTotalValue());
                            break;
                        case 6:
                            for (Produto p : carrinho.getProdutosNoCarrinho()) {
                                supermercado.removerProdutosDoEstoque(p.getNome());
                            }
                            System.out.println("Compra finalizada com sucesso, escolha a opção 7 para ver o recibo!");
                            break;
                        case 7:
                            if(cliente == null) {
                                cliente = new Cliente();
                            }
                            Recibo recibo = new Recibo(carrinho, cliente);
                            recibo.gerarDadosDoRecibo();
                            carrinho = new Carrinho();
                            flagCliente = false;
                            break;
                        case 8:
                            flagCliente = false;
                    }
                }
            } else if (setor == 2) {
                boolean flagGerente = true;
                while (flagGerente) {
                    exibirMenuGerente();
                    int opc = Integer.parseInt(sc.nextLine());

                    switch (opc) {
                        case 1:
                            System.out.println("Cadastrar produto: ");
                            System.out.println();
                            System.out.println("Nome produto: ");
                            String nome = sc.nextLine();
                            System.out.println("Qual tipo do produto: (comida/bebida/indefinido)");
                            String tipo = sc.nextLine();

                            System.out.println("Preço do produto: ");
                            double preco = Double.parseDouble(sc.nextLine());
                            System.out.println("Quantidade em estoque: ");
                            int qtdEstoque = Integer.parseInt(sc.nextLine());

                            if (tipo.equalsIgnoreCase("comida")) {
                                System.out.println("Digite a data de validade: ");
                                String dataValidade = sc.nextLine();
                                produto = new Comida(nome, preco, qtdEstoque, dataValidade);
                                supermercado.cadastrarProduto(produto);
                            } else if (tipo.equalsIgnoreCase("bebida")) {
                                System.out.println("Digite o tipo de embalagem: ");
                                String tipoEmbalagem = sc.nextLine();
                                produto = new Bebida(nome, preco, qtdEstoque, tipoEmbalagem);
                                supermercado.cadastrarProduto(produto);
                            } else if(tipo.equalsIgnoreCase("indefinido")) {
                                produto = new Produto(nome, preco, qtdEstoque);
                                supermercado.cadastrarProduto(produto);
                            } else {
                                System.out.println("Digite uma opção válida.");
                            }
                            break;
                        case 2:
                            System.out.println("Produtos: ");
                            supermercado.printarTodosProdutos();
                            break;
                        case 3:
                            System.out.print("Qual produto você quer reabastecer? ");
                            String reabastecer = sc.nextLine();
                            System.out.println("Quantidade para adicionar: ");
                            int quant = Integer.parseInt(sc.nextLine());
                            supermercado.adicionarProdutoAoEstoque(reabastecer, quant);
                            break;
                        case 4:
                            flagGerente = false;
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                }
            } else if (setor == 3) {
                System.out.println("Saindo...");
                flag = false;
            } else {
                System.out.println("Valor inválido!!");
            }
        }
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
        System.out.println("3. Reabastecer estoque");
        System.out.println("4. Sair");
    }
}
