package pratica;

import java.util.Scanner;

public class ExercicioUm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Você quer calcular a área do círculo, quadrado ou triângulo? ");

        String resposta = sc.nextLine();

        switch (resposta){
            case "círculo":
                System.out.println("Digite o raio do círculo: ");
                double raio = sc.nextDouble();
                System.out.println("A área do círculo é: " + Math.PI *  Math.pow(raio, 2));
                break;
            case "quadrado":
                System.out.println("Digite o lado do quadrado: ");
                double lado = sc.nextDouble();
                System.out.println("A área do quadrado é: " + Math.pow(lado, 2));
                break;
            case "triângulo":
                System.out.println("Digite a base e altura do triângulo: ");
                System.out.println("Base: ");
                double base = sc.nextDouble();
                System.out.println("Altura: ");
                double altura = sc.nextDouble();
                System.out.println("A área do quadrado é: " + ((base * altura)/2));
                break;
        }
    }
}
