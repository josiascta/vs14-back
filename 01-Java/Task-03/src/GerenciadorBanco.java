
import java.util.List;

public class GerenciadorBanco {

    private List<ContaBancaria> contas;

    public GerenciadorBanco(List<ContaBancaria> contas) {
        this.contas = contas;
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public void removerConta(String numeroConta) {
        boolean isFound = false;
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumeroConta().equals(numeroConta)) {
                if (buscarConta(numeroConta).getSaldo() == 0) {
                    contas.remove(i);
                    isFound = true;
                    System.out.println("Conta removida com sucesso!");
                    break;
                } else {
                    System.out.println("Impossível excluir a conta com saldo.");
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("Conta não encontrada.");
        }
    }

    public ContaBancaria buscarConta(String numeroConta) {
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumeroConta().equals(numeroConta)) {
                return contas.get(i);
            }
        }
        return null;
    }

    public void listarContas() {
        System.out.println("Listando todas as contas: ");
        for (ContaBancaria conta : contas) {
            System.out.println("Número conta: " + conta.getNumeroConta());
            System.out.println("Titular conta: " + conta.getTitular());
            System.out.println("Saldo: " + conta.getSaldo());
            System.out.println();
        }
    }

}