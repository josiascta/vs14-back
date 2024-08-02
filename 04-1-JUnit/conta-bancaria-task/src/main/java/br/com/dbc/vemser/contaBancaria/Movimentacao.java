package br.com.dbc.vemser.contaBancaria;

import br.com.dbc.vemser.contaBancaria.exception.ValorDeDepositoInvalidoException;
import br.com.dbc.vemser.contaBancaria.exception.ValorDeSaqueInvalidoException;

public interface Movimentacao {
    boolean sacar(double valor) throws Exception;
    boolean depositar(double valor) throws ValorDeDepositoInvalidoException;
    boolean transferir(Conta conta, double valor) throws ValorDeSaqueInvalidoException, ValorDeDepositoInvalidoException;
}
