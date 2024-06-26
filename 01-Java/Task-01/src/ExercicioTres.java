/*Você foi contratado para criar um programa em Java que converta uma temperatura
fornecida em graus Celsius para graus Fahrenheit. Utilize as fórmulas de conversão
apropriadas para realizar essa tarefa. O programa deve declarar uma constante
        (celsiusTemperature) com o valor da temperatura em graus Celsius e, em seguida,
calcular e exibir a correspondente temperatura em graus Fahrenheit.*/

import java.util.Scanner;

public class ExercicioTres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um valor em graus Celsius: ");
        double celsius = sc.nextDouble();

        double fahrenheit = (celsius * 1.8) + 32;
        System.out.println("Fahrenheit: " + fahrenheit);
    }
}
