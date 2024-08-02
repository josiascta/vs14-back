package br.com.dbc.vemser.contaBancaria;

public class ContaPoupanca extends Conta implements Impressao {
    private static final double TAXA_MENSAL = 0.01; //1%

    public void creditarTaxa() {
        this.setSaldo(getSaldo() - (getSaldo() * TAXA_MENSAL));
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "cliente=" + getCliente() +
                ", numeroConta='" + getNumeroConta() + '\'' +
                ", agencia=" + getAgencia() +
                ", saldo=" + getSaldo() +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}
