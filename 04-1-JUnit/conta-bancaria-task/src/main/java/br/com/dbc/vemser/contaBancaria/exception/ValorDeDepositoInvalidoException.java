package br.com.dbc.vemser.contaBancaria.exception;

public class ValorDeDepositoInvalidoException extends Exception{

    public ValorDeDepositoInvalidoException(String erro){
        super(erro);
    }
}
