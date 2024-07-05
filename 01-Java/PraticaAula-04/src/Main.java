import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        LinkedList<Produto> ordemDeSaida = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        while(flag){
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Editar produto");
            System.out.println("4. Listar produto");
            System.out.println("Escolha uma opção: ");
            int escolha = Integer.parseInt(sc.nextLine());

            switch (escolha){

                case 1:
                    String nome = sc.nextLine();

                    double preco = Double.parseDouble(sc.nextLine()) ;
                    Produto produto = new Produto(nome, preco, 0);
                    produtos.add(produto);
                    break;
                case 2:
                    nome = sc.nextLine();
                    System.out.println();
                    for(Produto produto2 : produtos){
                        if(produto2.getNome().equals(nome)){
                            produtos.remove(produto2);
                            break;
                        }
                    }

                    break;

                case 3:
                    System.out.println("Digite o produto que você quer editar: ");
                    nome = sc.nextLine();
                    for(Produto produto2 : produtos){
                        if(produto2.getNome().equals(nome)){
                            System.out.println("Digite os novos dados desse produto: ");
                            System.out.println("Nome: ");
                            nome = sc.nextLine();
                            System.out.println("Preço: ");
                            preco = Double.parseDouble(sc.nextLine()) ;
                            produto2.setNome(nome);
                            produto2.setPreco(preco);
                        }
                    }

                    break;
                case 4:
                    for(Produto produto2 : produtos){
                        System.out.println("Produto: " + produto2.getNome() + ": " + produto2.getPreco());
                    }
                    break;
                case 5:
                    System.out.println("Quantidade: ");
                    int quantidade = Integer.parseInt(sc.nextLine());
                    System.out.println("Qual o produto: ");
                    String produtoNome = sc.nextLine();
                    for(Produto produto2 : produtos){
                        if(produto2.getNome().equals(produtoNome)){
                            ordemDeSaida.add(produto2);
                            produto2.setQuantidade(produto2.getQuantidade() - quantidade);
                        }
                    }
                    break;

            }
        }

    }
}
