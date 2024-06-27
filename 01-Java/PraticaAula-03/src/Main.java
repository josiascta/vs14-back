import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Pessoal> pessoas = new ArrayList<>();

        boolean flag = true;
        while(flag) {
            System.out.println("Digite a opção: " );
            System.out.println("1 - Cadastrar ");
            System.out.println("2 - Ver dados ");
            int opcao = Integer.parseInt(sc.nextLine());
            switch (opcao) {
                case 1:
                    System.out.println("Digite qual cargo: ");
                    System.out.println("1 - Colaborador ");
                    System.out.println("2 - Diretor");
                    System.out.println("3 - Gerente");
                    System.out.println("4 - RH");
                    opcao = Integer.parseInt(sc.nextLine());

                    String nome = sc.nextLine();
                    System.out.println("Digite a idade: ");
                    int idade = Integer.parseInt(sc.nextLine());
                    System.out.println();
                    System.out.println("Digite o tempo de Casa: ");
                    int tempoDeCasa = Integer.parseInt(sc.nextLine());
                    System.out.println("Digite o salario atual: ");
                    double salarioAtual = Double.parseDouble(sc.nextLine());
                    if(opcao == 1){
                        System.out.println("Qual o salário inicial: ");
                        double salarioInicial = Double.parseDouble(sc.nextLine());

                        Colaborador colaborador = new Colaborador(idade, tempoDeCasa, salarioAtual, nome, salarioInicial);
                        pessoas.add(colaborador);
                    }else if(opcao == 2){
                        System.out.println("Qual é o tempo de carga: ");
                        int tempoDeCargo = Integer.parseInt(sc.nextLine());
                        Diretor diretor = new Diretor(idade, tempoDeCasa, salarioAtual, nome, tempoDeCargo);

                        pessoas.add(diretor);
                }else if(opcao == 3){
                        System.out.println("Qual é o setor: ");
                        String setor = sc.nextLine();
                        Gerente gerente = new Gerente(idade, tempoDeCasa, salarioAtual, nome, setor);
                        pessoas.add(gerente);
                }else if(opcao == 4){
                        System.out.println("É entrevistador? ");
                        System.out.println("S ou N: ");
                        boolean isEntrevistador = sc.nextLine().equals("sim");
                        RH rh = new RH(idade, tempoDeCasa, salarioAtual, nome, isEntrevistador);
                        pessoas.add(rh);
                    }
                    else{
                        System.out.println("Não foi encontrado");
                    }
                    break;
                case 2:


            }

        }
    }
}
