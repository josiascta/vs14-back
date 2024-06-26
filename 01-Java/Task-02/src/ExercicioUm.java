import java.util.Scanner;

public class ExercicioUm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] pets = new String[100];
        String[] nomeDosPets = new String[100];
        int quant = 0;

        boolean flag = true;
        while (flag) {
            System.out.println("1 - Inserir um novo pet ");
            System.out.println("2 - Exibir todos os pets ");
            System.out.println("3 - Buscar pets pelo nome ");
            System.out.println("4 - Sair ");
            int opcao = Integer.parseInt(sc.nextLine());
            switch (opcao){
                case 1:
                    if(quant < 100){
                        System.out.print("Digite o tipo do pet: ");
                        String tipoPet = sc.nextLine();
                        System.out.print("Digite o nome do pet: ");
                        String nome = sc.nextLine();
                        pets[quant] = tipoPet;
                        nomeDosPets[quant] = nome;
                        quant++;
                    }else{
                        System.out.println("Está lotado.");
                    }
                    break;
                case 2:
                    System.out.println("Pets: ");
                    for(int i = 0; i < quant; i++){
                        System.out.println(nomeDosPets[i] + ": " + pets[i]);

                    }
                    break;
                case 3:
                    boolean foiEncontrado = false;
                    System.out.println("Digite o nome do pet: ");
                    String nomeDoPet = sc.nextLine().toLowerCase();
                    for(int i = 0; i < quant; i++){
                        if(nomeDoPet.equals(nomeDosPets[i])){
                            System.out.println(nomeDosPets[i]);
                            foiEncontrado = true;
                            break;
                        }
                    }
                    if(!foiEncontrado){
                        System.out.println("Não foi encontrado");
                    }
                    break;
                case 4:
                    flag = false;
                    break;
            }
        }
    }
}
