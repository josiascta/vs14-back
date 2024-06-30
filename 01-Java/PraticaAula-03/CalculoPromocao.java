public class CalculoPromocao extends RH{

    private double aumento;

    public CalculoPromocao(int idade, int tempoDeCasa, double salarioAtual, String nome, boolean isEntrevistador, double aumento) {
        super(idade, tempoDeCasa, salarioAtual, nome, isEntrevistador);
        this.aumento = aumento;
    }
}
