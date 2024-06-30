public class CalculoFerias extends RH{

    private double salarioFerias;


    public CalculoFerias(int idade, int tempoDeCasa, double salarioAtual, String nome, boolean isEntrevistador, double salarioFerias) {
        super(idade, tempoDeCasa, salarioAtual, nome, isEntrevistador);
        this.salarioFerias = salarioFerias;
    }
}
