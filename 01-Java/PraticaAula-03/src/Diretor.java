public class Diretor extends Pessoal{

    private int tempoDeCargo;

    public Diretor(int idade, int tempoDeCasa, double salarioAtual, String nome, int tempoDeCargo) {
        super(idade, tempoDeCasa, salarioAtual, nome);
        this.tempoDeCargo = tempoDeCargo;
    }

    @Override
    public void mostrarInformacoes(){
        super.mostrarInformacoes();
        System.out.println("Tempo de cargo: " + tempoDeCargo);
    }
}
