public class Gerente extends Pessoal {

    private String setor;

    public Gerente(int idade, int tempoDeCasa, double salarioAtual, String nome, String setor) {
        super(idade, tempoDeCasa, salarioAtual, nome);
        this.setor = setor;
    }

}
