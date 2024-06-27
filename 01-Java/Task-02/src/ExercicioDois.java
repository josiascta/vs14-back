import java.util.Scanner;

public class ExercicioDois {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] timesGerais = new String[100][2];
        String[] timesDaCasa = new String[100];
        String[] timesVisitantes = new String[100];
        int[] pontuacoesDaCasa = new int[100];
        int[] pontuacoesVisitante = new int[100];
        String[] datasDoJogo = new String[100];

        int quantidadeDeJogos = 0;
        int quantTimes = 0;

        boolean flag = true;
        while (flag) {
            System.out.println("1 - Inserir novo jogo ");
            System.out.println("2 - Exibir todos os jogos ");
            System.out.println("3 - Buscar jogos por time ");
            System.out.println("4 - Exibir classicação dos timesDaCasaSemRepeticoes ");
            System.out.println("5 - Sair ");
            int opcao = Integer.parseInt(sc.nextLine());
            switch (opcao){
                case 1:
                    if(quantidadeDeJogos < 100){
                        System.out.print("Digite o nome do time da casa: ");
                        String timeDaCasa = sc.nextLine();

                        System.out.print("Digite a pontuação do time da casa: ");
                        int pontuacaoDaCasa = Integer.parseInt(sc.nextLine());

                        while(pontuacaoDaCasa < 0){
                            System.out.print("Digite um valor maior ou igual a zero!");
                            pontuacaoDaCasa = Integer.parseInt(sc.nextLine());
                        }

                        boolean isRepetido = false;
                        for(int i = 0; i < quantTimes; i++) {
                            if (timesGerais[i][0].equalsIgnoreCase(timeDaCasa)) {
                                isRepetido = true;
                                int quant = Integer.parseInt(timesGerais[i][1]) + pontuacaoDaCasa;
                                timesGerais[i][1] = String.valueOf(quant);
                                break;
                            }
                        }
                        if(!isRepetido){
                            timesGerais[quantTimes][0] = timeDaCasa;
                            timesGerais[quantTimes][1] = String.valueOf(pontuacaoDaCasa);
                            quantTimes++;
                        }

                        System.out.print("Digite o nome do time visitante: ");
                        String timeDoVisitante = sc.nextLine();

                        System.out.print("Digite a pontuação do time visitante: ");
                        int pontuacaoDoVisitante = Integer.parseInt(sc.nextLine());

                        while(pontuacaoDoVisitante < 0){
                            System.out.print("Digite um valor maior ou igual a zero!");
                            pontuacaoDoVisitante = Integer.parseInt(sc.nextLine());
                        }

                        isRepetido = false;
                        for(int i = 0; i < quantTimes; i++) {
                            if (timesGerais[i][0].equalsIgnoreCase(timeDoVisitante)) {
                                isRepetido = true;
                                int quant = Integer.parseInt(timesGerais[i][1]) + pontuacaoDoVisitante;
                                timesGerais[i][1] = String.valueOf(quant);
                                break;
                            }
                        }
                        if(!isRepetido){
                            timesGerais[quantTimes][0] = timeDoVisitante;
                            timesGerais[quantTimes][1] = String.valueOf(pontuacaoDoVisitante);
                            quantTimes++;
                        }

                        System.out.print("Digite a data do jogo: ");
                        String dataDoJogo = sc.nextLine();
                        timesDaCasa[quantidadeDeJogos] = timeDaCasa;
                        timesVisitantes[quantidadeDeJogos] = timeDoVisitante;
                        pontuacoesDaCasa[quantidadeDeJogos] = pontuacaoDaCasa;
                        pontuacoesVisitante[quantidadeDeJogos] = pontuacaoDoVisitante;
                        datasDoJogo[quantidadeDeJogos] = dataDoJogo;
                        quantidadeDeJogos++;
                    }else{
                        System.out.println("Está lotado.");
                    }
                    break;
                case 2:
                    System.out.println("Todos os jogos: ");
                    for(int i = 0; i < quantidadeDeJogos; i++){
                        System.out.println(timesDaCasa[i] + ": " + pontuacoesDaCasa[i] + "\n X " + timesVisitantes[i] + ": " + pontuacoesVisitante[i]);
                        System.out.println(datasDoJogo[i]);
                        System.out.println();
                    }
                    break;
                case 3:
                    boolean foiEncontrado = false;
                    System.out.println("Digite o nome do time: ");
                    String nomeDoTime = sc.nextLine().toLowerCase();
                    for(int i = 0; i < timesDaCasa.length; i++){
                        if(timesDaCasa[i] == null){
                            break;
                        }
                        else if (timesDaCasa[i].toLowerCase().equals(nomeDoTime)){
                            System.out.println(timesDaCasa[i]);
                            System.out.println("Pontuação: " + pontuacoesDaCasa[i]);
                            System.out.println("Data: " + datasDoJogo[i]);
                            foiEncontrado = true;
                        }
                    }
                    for(int i = 0; i < timesVisitantes.length; i++){
                        if(timesVisitantes[i] == null){
                            break;
                        }
                        else if(timesVisitantes[i].toLowerCase().equals(nomeDoTime)){
                            System.out.println(timesVisitantes[i]);
                            System.out.println("Pontuação: " + pontuacoesVisitante[i]);
                            System.out.println("Data: " + datasDoJogo[i]);
                            foiEncontrado = true;
                        }
                    }
                    if(!foiEncontrado){
                        System.out.println("Não foi encontrado");
                    }
                    break;
                case 4:
                    //Usando SelectionSort para ordenar a lista
                    int n = quantTimes;

                    for (int i = 0; i < n - 1; i++) {
                        int maxIndex = i;
                        for (int j = i + 1; j < n; j++) {
                            if (Integer.parseInt(timesGerais[j][1]) > Integer.parseInt(timesGerais[maxIndex][1])) { // Modificação para ordem decrescente
                                maxIndex = j;
                            }
                        }

                        String[] temp = timesGerais[maxIndex];
                        timesGerais[maxIndex] = timesGerais[i];
                        timesGerais[i] = temp;
                    }
                    System.out.println("Ranking dos times: ");
                    for(int i = 0; i < quantTimes; i++){
                        System.out.print(timesGerais[i][0] + ": ");
                        System.out.println(timesGerais[i][1]);
                    }
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
    }
}
