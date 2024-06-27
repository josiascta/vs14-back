public class Gerente {

    public String nome;
    private int idade;
    private int tempoDeCasa;
    private String setor;
    private double salario;

    public Gerente(String nome, int idade, int tempoDeCasa, String setor, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.tempoDeCasa = tempoDeCasa;
        this.setor = setor;
        this.salario = salario;
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

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString(){
        return "Nome do gerente: " + nome + "\n" + "Idade: " + idade + "\n" + "Tempo de casa: " + tempoDeCasa + "\n" + "Setor: " + setor + "\n" + "Salário: " + salario;
    }
}
