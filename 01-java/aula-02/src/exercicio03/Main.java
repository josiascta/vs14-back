package exercicio03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String nomeDoProduto = sc.nextLine();
        System.out.print("Digite o preço do produto: ");
        double precoDoProduto = sc.nextDouble();

        double porcentagem = 5;

        System.out.println("Produto: " + nomeDoProduto);
        System.out.println("Preço:" + precoDoProduto);
        System.out.println("Promoção: " + nomeDoProduto);
        for(int i = 1; i < 11; i++){
            double precoDoProdutoComDesconto = precoDoProduto - (precoDoProduto * porcentagem)/100;
            System.out.println(i + "x R$ " + String.format("%.2f", precoDoProdutoComDesconto) + " = " + String.format("%.2f",precoDoProdutoComDesconto*i) );
            porcentagem += 5;
        }


    }
}
