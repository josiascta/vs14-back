public class RH extends Pessoal{

    private boolean isEntrevistador;

    public RH(int idade, int tempoDeCasa, double salarioAtual, String nome, boolean isEntrevistador) {
        super(idade, tempoDeCasa, salarioAtual, nome);
        this.isEntrevistador = isEntrevistador;
    }
}
