package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Você foi contratado para desenvolver um sistema simples para um e-commerce que
gerencia produtos. O sistema deve permitir o cadastro de produtos com as seguintes
informações:
a. Nome do produto (String)
b. Descrição do produto (String)
c. Preço do produto (double)
d. Estoque disponível (int)
        e. Além disso, o sistema deve oferecer funcionalidades para aplicar promoções aos
produtos, incluindo descontos percentuais. As promoções disponíveis são:
f. Desconto percentual: reduz o preço do produto em uma determinada
porcentagem.
g. O sistema deve permitir realizar as seguintes operações:
h. Cadastrar um novo produto.
i. Aplicar uma promoção de desconto percentual a um produto.
j. Exibir os detalhes de um produto, incluindo seu preço atualizado com as
promoções aplicadas.
k. O sistema deve ser implementado em Java, utilizando os conceitos de tipos de
dados adequados para representar as informações dos produtos e as operações
de cálculo de desconto.*/

public class TaskOito {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Produto> produtos = new ArrayList<Produto>();

        boolean flag = true;
        while(flag){
            System.out.println("O que você deseja fazer: ");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Exibir detalhes do produto");
            System.out.println("3 - Aplicar desconto em um produto");

            int controle = Integer.parseInt(sc.nextLine());
            int opcao = Integer.parseInt(sc.nextLine());
            switch(controle){
                case 1:
                    String nome = sc.nextLine();
                    double preco = sc.nextDouble();
                    String descricao = sc.nextLine();
                    int estoque = Integer.parseInt(sc.nextLine());

                    Produto produto = new Produto(nome, descricao, preco, estoque);
                    produtos.add(produto);
                    break;
                case 2:
                    System.out.println("Escolha um produto para ver seus dados: ");
                    for(int i = 0; i<produtos.size(); i++){
                        System.out.println((i) + " - " + produtos.get(i).getNome());
                    }
                    opcao = Integer.parseInt(sc.nextLine());
                    System.out.println(produtos.get(opcao));
                    break;
                case 3:
                    System.out.println("Escolha um produto para aplicar desconto: ");
                    for(int i = 0; i<produtos.size(); i++){
                        System.out.println((i) + " - " + produtos.get(i).getNome());
                    }
                    opcao = Integer.parseInt(sc.nextLine());
                    double porcentagemDeDesconto = Double.parseDouble(sc.nextLine());
                    produtos.get(opcao).aplicarDesconto(porcentagemDeDesconto);
                case 4:
                    flag = false;
            }

        }
    }
}
