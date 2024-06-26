import java.util.Scanner;

/*Crie um programa em Java que valide se um número fornecido por um usuário é par ou
ímpar. O programa deve declarar uma variável número, atribuir um valor a ela e, em
seguida, determinar se o número é par ou ímpar sem usar instruções if ou else. Exiba o
resultado.*/

public class ExercicioDois {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int num = Integer.parseInt(sc.nextLine());

        String resultado = (num % 2 == 0) ? "O número é par" : "O número é ímpar";
        System.out.println(resultado);
    }
}
