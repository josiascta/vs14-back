import java.util.Scanner;

public class ExercicioDez {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Escolha a operação desejada:");
            System.out.println("1. Adição (+)");
            System.out.println("2. Subtração (-)");
            System.out.println("3. Multiplicação (*)");
            System.out.println("4. Divisão (/)");
            System.out.println("5. Cálculo de área de um círculo");
            System.out.println("6. Cálculo de área de um retângulo");
            System.out.println("7. Cálculo de área de um triângulo");
            System.out.println("8. Cálculo de diâmetro de um círculo");
            System.out.println("0. Encerrar o programa");
            System.out.print("Digite o número da operação desejada: ");

            int escolha = scanner.nextInt();
            double num1, num2, resultado;
            double raio, base, altura, area;

            switch (escolha) {
                case 1:
                    System.out.print("Digite o primeiro número: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Digite o segundo número: ");
                    num2 = scanner.nextDouble();
                    resultado = num1 + num2;
                    System.out.println("Resultado: " + resultado);
                    break;
                case 2:
                    System.out.print("Digite o primeiro número: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Digite o segundo número: ");
                    num2 = scanner.nextDouble();
                    resultado = num1 - num2;
                    System.out.println("Resultado: " + resultado);
                    break;
                case 3:
                    System.out.print("Digite o primeiro número: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Digite o segundo número: ");
                    num2 = scanner.nextDouble();
                    resultado = num1 * num2;
                    System.out.println("Resultado: " + resultado);
                    break;
                case 4:
                    System.out.print("Digite o dividendo: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Digite o divisor: ");
                    num2 = scanner.nextDouble();

                    if (num2 != 0) {
                        resultado = num1 / num2;
                        System.out.println("Resultado: " + resultado);
                    } else {
                        System.out.println("Erro: divisão por zero.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o raio do círculo: ");
                    raio = scanner.nextDouble();
                    area = Math.PI * raio * raio;
                    System.out.println("Área do círculo: " + area);
                    break;
                case 6:
                    System.out.print("Digite a base do retângulo: ");
                    base = scanner.nextDouble();
                    System.out.print("Digite a altura do retângulo: ");
                    altura = scanner.nextDouble();
                    area = base * altura;
                    System.out.println("Área do retângulo: " + area);
                    break;
                case 7:
                    System.out.print("Digite a base do triângulo: ");
                    base = scanner.nextDouble();
                    System.out.print("Digite a altura do triângulo: ");
                    altura = scanner.nextDouble();
                    area = (base * altura) / 2;
                    System.out.println("Área do triângulo: " + area);
                    break;
                case 8:
                    System.out.print("Digite o raio do círculo: ");
                    raio = scanner.nextDouble();
                    double diametro = 2 * raio;
                    System.out.println("Diâmetro do círculo: " + diametro);
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}