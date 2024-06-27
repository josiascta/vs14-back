public class Colaborador {

    public String nome;
    private int idade;
    private int tempoDeCasa;
    private double salarioInicial;
    private double salarioAtual;

    public Colaborador(String nome, int idade, int tempoDeCasa, double salarioInicial, double salarioAtual) {
        this.nome = nome;
        this.idade = idade;
        this.tempoDeCasa = tempoDeCasa;
        this.salarioInicial = salarioInicial;
        this.salarioAtual = salarioAtual;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getTempoDeCasa() {
        return tempoDeCasa;
    }

    public void setTempoDeCasa(int tempoDeCasa) {
        this.tempoDeCasa = tempoDeCasa;
    }

    public double getSalarioInicial() {
        return salarioInicial;
    }

    public void setSalarioInicial(double salarioInicial) {
        this.salarioInicial = salarioInicial;
    }

    public double getSalarioAtual() {
        return salarioAtual;
    }

    public void setSalarioAtual(double salarioAtual) {
        this.salarioAtual = salarioAtual;
    }

    public String toString(){
        return "Nome do colaborador: " + nome + "\n" + "Idade: " + idade + "\n" + "Tempo de casa: " + tempoDeCasa + "\n" + "Salário inicial: " + salarioInicial + "\n" + "Salário atual: " + salarioAtual;
    }
}
