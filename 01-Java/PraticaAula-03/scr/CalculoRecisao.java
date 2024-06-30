public class CalculoRecisao extends RH{

    private double valorRecisao;

    public CalculoRecisao(int idade, int tempoDeCasa, double salarioAtual, String nome, boolean isEntrevistador, double valorRecisao) {
        super(idade, tempoDeCasa, salarioAtual, nome, isEntrevistador);
        this.valorRecisao = valorRecisao;
    }
}
