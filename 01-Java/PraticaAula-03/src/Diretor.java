public class Diretor {

    public String nome;
    private int idade;
    private int tempoDeCasa;
    private int tempoDeCargo;
    private double salario;

    public Diretor(String nome, int idade, int tempoDeCasa, int tempoDeCargo, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.tempoDeCasa = tempoDeCasa;
        this.tempoDeCargo = tempoDeCargo;
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

    public int getTempoDeCargo() {
        return tempoDeCargo;
    }

    public void setTempoDeCargo(int tempoDeCargo) {
        this.tempoDeCargo = tempoDeCargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString(){
        return "Nome do diretor: " + nome + "\n" + "Idade: " + idade + "\n" + "Tempo de casa: " + tempoDeCasa + "\n" + "Tempo de cargo: " + tempoDeCargo + "\n" + "Salário: " + salario;
    }
}
