package tasks;

/*Desenvolva um programa em Java para registrar o número total de votos em um
município, bem como o número de votos brancos, nulos e válidos. O programa deve
calcular e exibir o percentual que cada tipo de voto representa em relação ao total de
eleitores.*/

import java.util.Scanner;

public class TaskCinco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int votosBrancos = sc.nextInt();
        int votosNulos = sc.nextInt();
        int votosValidos = sc.nextInt();

        int votosTotais = votosBrancos + votosNulos + votosValidos;

        int porcentagemVotosBrancos = votosBrancos * 100 / votosTotais;
        int porcentagemVotosNulos = votosNulos * 100 / votosTotais;
        int porcentagemVotosValidos = votosValidos * 100 / votosTotais;

        System.out.println("Votos totais: " + votosTotais);
        System.out.println("Votos brancos: " + votosBrancos + ". Porcentagem: " + porcentagemVotosBrancos + "%");
        System.out.println("Votos nulos: " + votosNulos + ". Porcentagem: " + porcentagemVotosNulos + "%");
        System.out.println("Votos validos: " + votosValidos + ". Porcentagem: " + porcentagemVotosValidos + "%");
    }
}
