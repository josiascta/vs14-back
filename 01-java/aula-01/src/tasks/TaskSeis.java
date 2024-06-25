package tasks;

/*6. Desenvolva um programa em Java que solicite ao usuário as informações de um
funcionário e calcule o salário anual desse funcionário. O programa deve utilizar a classe
Scanner para ler os dados de entrada do usuário e não deve utilizar arrays ou laços de
repetição.
        a. Requisitos → O programa deve solicitar ao usuário as seguintes informações:
i. Nome do funcionário.
ii. Salário mensal do funcionário.
iii. Número de meses trabalhados no ano (pode ser um valor entre 1 e 12).
iv. O programa deve calcular o salário anual do funcionário com base nos
dados fornecidos.
v. O programa deve exibir o nome do funcionário e seu salário anual.*/

import java.util.Scanner;

public class TaskSeis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do funcionário: ");
        String nomeDoFuncionario = sc.nextLine();

        System.out.print("Digite o salário mensal desse funcionário: ");
        double salarioMensal = Double.parseDouble(sc.nextLine());

        System.out.print("Digite o número de meses trabalhados desse funcionário entre 1 e 12: ");
        int numeroDeMesesTrabalhados = sc.nextInt();
        if(numeroDeMesesTrabalhados > 0 && numeroDeMesesTrabalhados < 13){
            System.out.println("Funcionário: " + nomeDoFuncionario);
            System.out.println("Salário anual: " + salarioMensal * numeroDeMesesTrabalhados);
        }else{
            System.out.println("Escolha um valor entre 1 e 12.");
        }
    }
}
