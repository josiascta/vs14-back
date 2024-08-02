package br.com.dbc.vemser.contaBancaria;

import br.com.dbc.vemser.contaBancaria.exception.ValorDeSaqueInvalidoException;

public class ContaCorrente extends Conta implements Impressao {
    private double chequeEspecial;

    @Override
    public boolean sacar(double valor) throws ValorDeSaqueInvalidoException {
        if (valor <= 0) {
            throw new ValorDeSaqueInvalidoException("Não é possível realizar saque de zero reais.");
        } else if (valor > (super.getSaldo() + chequeEspecial)) {
            throw new ValorDeSaqueInvalidoException("Saldo e cheque especial insuficientes para realizar o saque.");
        } else {
            setSaldo(getSaldo() - valor);
        }
        return true;
    }

    public double retornarSaldoComChequeEspecial() {
        return getSaldo() + chequeEspecial;
    }

    public void imprimirContaCorrente() {
        System.out.println(this);
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "cliente=" + getCliente() +
                ", numeroConta='" + getNumeroConta() + '\'' +
                ", agencia=" + getAgencia() +
                ", saldo=" + getSaldo() +
                ", chequeEspecial=" + chequeEspecial +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}
