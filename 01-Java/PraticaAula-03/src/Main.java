import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Colaborador colaborador = null;
        Gerente gerente = null;
        Diretor diretor = null;

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
                    opcao = Integer.parseInt(sc.nextLine());
                    if(opcao == 1){
                        System.out.println("Digite o nome do colaborador: ");
                        String nome = sc.nextLine();
                        System.out.println("Digite a idade: ");

                        int idade = Integer.parseInt(sc.nextLine());
                        System.out.println();
                        System.out.println("Digite o tempo de Casa: ");
                        int tempoDeCasa = Integer.parseInt(sc.nextLine());
                        System.out.println("Digite o salario inicial: ");
                        double salarioInicial = Double.parseDouble(sc.nextLine());
                        System.out.println("Digite o salario atual: ");
                        double salarioAtual = Double.parseDouble(sc.nextLine());

                        colaborador = new Colaborador(nome, idade, tempoDeCasa, salarioInicial, salarioAtual);

                    }else if(opcao == 2){
                        System.out.println("Digite o nome do diretor: ");
                        String nome = sc.nextLine();
                        System.out.println("Digite a idade: ");

                        int idade = Integer.parseInt(sc.nextLine());
                        System.out.println("Digite o tempo de Casa: ");
                        int tempoDeCasa = Integer.parseInt(sc.nextLine());
                        System.out.println();
                        System.out.println("Digite o tempo do cargo: ");
                        int tempoDeCargo = Integer.parseInt(sc.nextLine());
                        System.out.println();
                        System.out.println("Digite o salario: ");
                        double salarioAtual = Double.parseDouble(sc.nextLine());

                        diretor = new Diretor(nome, idade, tempoDeCasa, tempoDeCargo, salarioAtual);
                }else if(opcao == 3){
                        System.out.println("Digite o nome do gerente: ");
                        String nome = sc.nextLine();
                        System.out.println("Digite a idade: ");

                        int idade = Integer.parseInt(sc.nextLine());
                        System.out.println("Digite o tempo de Casa: ");
                        int tempoDeCasa = Integer.parseInt(sc.nextLine());
                        System.out.println("Digite o setor: ");
                        String setor = sc.nextLine();
                        System.out.println("Digite o salario: ");
                        double salario = Double.parseDouble(sc.nextLine());

                        gerente = new Gerente(nome, idade, tempoDeCasa, setor, salario);

                }
                    else{
                        System.out.println("Não foi encontrado");
                    }
                    break;
                case 2:
                    if(colaborador != null && gerente != null && diretor != null){
                        System.out.println(colaborador);
                        System.out.println();
                        System.out.println(gerente);
                        System.out.println();
                        System.out.println(diretor);
                    }else{
                        System.out.println("Cadastre os dados primeiro! ");
                    }

            }

        }
    }
}
