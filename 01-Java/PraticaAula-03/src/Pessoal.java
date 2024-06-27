public class Pessoal {

    private String nome;
    private int idade;
    private int tempoDeCasa;
    private double salarioAtual;

    public Pessoal(int idade, int tempoDeCasa, double salarioAtual, String nome) {
        this.idade = idade;
        this.tempoDeCasa = tempoDeCasa;
        this.salarioAtual = salarioAtual;
        this.nome = nome;
    }

    public void mostrarInformacoes(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Tempo de Casa: " + tempoDeCasa);
        System.out.println("Salário atual: " + salarioAtual);
    }
}
