import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean menuFlag = true;
        ContaBancaria contaBancaria;
        List<ContaBancaria> contas = new ArrayList<ContaBancaria>();
        GerenciadorBanco gerenciadorBanco = new GerenciadorBanco(contas);

        while(menuFlag){
            ExibirMenu();
            int opc = sc.nextInt();
            sc.nextLine();
            switch(opc){
                case 1:
                    contaBancaria = new ContaBancaria();
                    System.out.println("Digite o número da sua conta: ");
                    String numeroConta = sc.nextLine();
                    contaBancaria.setNumeroConta(numeroConta);
                    System.out.println("Digite o nome do titular da conta: ");
                    String titularConta = sc.nextLine();
                    contaBancaria.setTitular(titularConta);
                    System.out.println("Conta criada com sucesso!");
                    System.out.println("Número da conta: " + contaBancaria.getNumeroConta());
                    System.out.println("Nome do titular da conta: " + contaBancaria.getTitular());
                    System.out.println("Saldo da conta: " + contaBancaria.getSaldo());
                    gerenciadorBanco.adicionarConta(contaBancaria);
                    break;
                case 2:
                    System.out.println("Digite o número da sua conta: ");
                    numeroConta = sc.nextLine();
                    System.out.println("Quanto você gostaria de depositar: ");
                    double deposito = sc.nextDouble();
                    if(gerenciadorBanco.buscarConta(numeroConta) != null){
                        gerenciadorBanco.buscarConta(numeroConta).depositar(deposito);
                        System.out.println("Deposito feito com sucesso!");
                        System.out.println("Saldo atual: R$ " + gerenciadorBanco.buscarConta(numeroConta).getSaldo());
                    }else{
                        System.out.println("Conta não encontrada!");
                    }

                    break;
                case 3:
                    System.out.println("Digite o número da sua conta: ");
                    numeroConta = sc.nextLine();
                    System.out.println("Quanto você gostaria de sacar: ");
                    double saque = sc.nextDouble();
                    if(gerenciadorBanco.buscarConta(numeroConta) != null){
                        gerenciadorBanco.buscarConta(numeroConta).sacar(saque);
                        System.out.println("Saldo atual: R$ " + gerenciadorBanco.buscarConta(numeroConta).getSaldo());
                    }
                    else{
                        System.out.println("Conta inexistente!");
                    }
                    break;
                case 4:
                    System.out.println("Digite o numero da sua conta: ");
                    numeroConta = sc.nextLine();
                    gerenciadorBanco.removerConta(numeroConta);
                    break;
                case 5:
                    gerenciadorBanco.listarContas();
                    break;
                case 6:
                    System.out.println("Digite o número da conta: ");
                    numeroConta = sc.nextLine();
                    System.out.println("Numero da conta: " + gerenciadorBanco.buscarConta(numeroConta).getNumeroConta());
                    System.out.println("Nome do titular da conta: " + gerenciadorBanco.buscarConta(numeroConta).getTitular());
                    System.out.println("Saldo da conta: " + gerenciadorBanco.buscarConta(numeroConta).getSaldo());
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    menuFlag = false;
                    break;
                default:
                    System.out.println("Digite uma opção válida");
            }
        }

    }
    public static void ExibirMenu(){
        System.out.println(" ______________________");
        System.out.println("|   -- Menu Banco --   |");
        System.out.println("|----------------------|");
        System.out.println("| 1. Criar conta       |");
        System.out.println("| 2. Depositar na conta|");
        System.out.println("| 3. Realizar um saque |");
        System.out.println("| 4. Remover Conta     |");
        System.out.println("| 5. Listar Contas     |");
        System.out.println("| 6. Buscar uma conta  |");
        System.out.println("| 7. Sair              |");
        System.out.println("|______________________|");
    }
}
