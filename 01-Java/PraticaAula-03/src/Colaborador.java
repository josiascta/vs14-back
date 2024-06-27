public class Colaborador extends Pessoal {


    private double salarioInicial;

    public Colaborador(int idade, int tempoDeCasa, double salarioAtual, String nome, double salarioInicial) {
        super(idade, tempoDeCasa, salarioAtual, nome);
        this.salarioInicial = salarioInicial;
    }

}
