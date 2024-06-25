package tasks;

import java.time.Duration;
import java.util.Scanner;

/**Escrever um algoritmo que lê a hora de início e hora de término de um jogo, ambas
subdivididas em dois valores distintos: horas e minutos. Calcular e escrever a duração do
jogo, também em horas e minutos, considerando que o tempo máximo de duração de um
jogo é de 24 horas e que o jogo pode iniciar em um dia e terminar no dia seguinte.
 **/
public class TaskUm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a hora que começa o jogo: ");
        int horas = Integer.parseInt(sc.nextLine());
        System.out.print("Minutos: ");
        int minutos = Integer.parseInt(sc.nextLine());
        InicioDeJogo inicio = new InicioDeJogo(horas, minutos);

        System.out.print("Digite a hora que termina o jogo: ");
        horas = Integer.parseInt(sc.nextLine());
        System.out.print("Minutos: ");
        minutos = Integer.parseInt(sc.nextLine());
        System.out.print("Do próximo dia? ");
        boolean resposta = sc.nextLine().equals("sim");
        TerminoDeJogo termino = new TerminoDeJogo(horas, minutos, resposta);

        Duration tempoDeJogo = (Duration.between(inicio.horarioDeInicio(), termino.horarioDeTermino()));

        if(tempoDeJogo.toMinutes() > 1440){
            System.out.println("O jogo não pode durar mais de 24 horas.");
        }else{
            System.out.println("O tempo total de jogo é de " + tempoDeJogo.toHours() + ":" + tempoDeJogo.toMinutesPart() + " horas.");
        }

    }
}
