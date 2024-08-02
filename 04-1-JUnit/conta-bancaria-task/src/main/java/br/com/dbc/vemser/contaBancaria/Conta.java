package br.com.dbc.vemser.contaBancaria;

import br.com.dbc.vemser.contaBancaria.exception.ValorDeDepositoInvalidoException;
import br.com.dbc.vemser.contaBancaria.exception.ValorDeSaqueInvalidoException;

public abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;

    @Override
    public boolean transferir(Conta conta, double valor) throws ValorDeSaqueInvalidoException, ValorDeDepositoInvalidoException {
        boolean conseguiuSacar = sacar(valor);
        boolean conseguiuDepositar = false;
        if (conseguiuSacar) {
            conseguiuDepositar = conta.depositar(valor);
        }
        return conseguiuDepositar && conseguiuSacar;
    }

    @Override
    public boolean depositar(double valor) throws ValorDeDepositoInvalidoException {
        if (valor <= 0) {
            throw new ValorDeDepositoInvalidoException("Não é possível depositar valor negativo ou zero");

        } else {
            saldo += valor;
        }
        return true;
    }

    @Override
    public boolean sacar(double valor) throws ValorDeSaqueInvalidoException {
        if (valor <= 0) {
            throw new ValorDeSaqueInvalidoException("Não é possível realizar saque de zero reais.");
        } else if (valor > saldo) {
            throw new ValorDeSaqueInvalidoException("Saldo e cheque especial insuficientes para realizar o saque.");
        } else {
            setSaldo(getSaldo() - valor);
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "cliente=" + cliente +
                ", numeroConta='" + numeroConta + '\'' +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
