package br.com.dbc.vemser.contaBancaria;

import br.com.dbc.vemser.contaBancaria.exception.ValorDeDepositoInvalidoException;
import br.com.dbc.vemser.contaBancaria.exception.ValorDeSaqueInvalidoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    private ContaCorrente contaCorrente;
    private ContaPagamento contaPagamento;
    private ContaPoupanca contaPoupanca;

    @BeforeEach
    void setup() {
        contaCorrente = new ContaCorrente();
        contaPagamento = new ContaPagamento();
        contaPoupanca = new ContaPoupanca();
    }

    @Test
    void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() throws ValorDeSaqueInvalidoException {
        contaCorrente.setSaldo(1000);

        contaCorrente.sacar(900);

        assertEquals(100, contaCorrente.getSaldo());
    }

    @Test
    void deveTestarSaqueContaCorrenteSemSaldo(){
        double saque = 10;

        assertThrows(ValorDeSaqueInvalidoException.class, () -> contaCorrente.sacar(saque));
    }

    @Test
    void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() throws ValorDeSaqueInvalidoException {
        contaPoupanca.setSaldo(1000);

        contaPoupanca.creditarTaxa();
        contaPoupanca.sacar(900);

        assertEquals(90, contaPoupanca.getSaldo());


    }

    @Test
    void deveTestarSaqueContaPoupancaSemSaldo(){
        double saque = 10;

        contaPoupanca.creditarTaxa();
        assertThrows(ValorDeSaqueInvalidoException.class, () -> contaPoupanca.sacar(saque));
    }

    @Test
    void deveTestarSaqueContaPagamentoComSucesso() throws ValorDeSaqueInvalidoException {
        contaPagamento.setSaldo(1000);


        contaPagamento.sacar(900);

        assertEquals(95.75, contaPagamento.getSaldo());


    }

    @Test
    void deveTestarTransferenciaEVerificarSaldoComSucesso() throws ValorDeDepositoInvalidoException, ValorDeSaqueInvalidoException {
        contaCorrente.setSaldo(1000);

        contaCorrente.transferir(new ContaCorrente(),500);

        assertEquals(500, contaCorrente.getSaldo());
    }

    @Test
    void deveTestarTransferenciaSemSaldoSuficiente() {
        contaCorrente.setSaldo(100);

        assertThrows(ValorDeSaqueInvalidoException.class, () -> {
            contaCorrente.transferir(contaPoupanca, 200);
        });
    }

    @Test
    void deveTestarDepositoComSucesso() throws ValorDeDepositoInvalidoException {
        contaCorrente.setSaldo(100);

        contaCorrente.depositar(200);

        assertEquals(300, contaCorrente.getSaldo());
    }

    @Test
    void deveTestarDepositoInvalido() {
        contaCorrente.setSaldo(100);

        assertThrows(ValorDeDepositoInvalidoException.class, () -> {
            contaCorrente.depositar(-50);
        });
    }

    @Test
    void deveTestarTransferenciaEntreContasComSucessoEVerificarSaldoComSucesso() throws ValorDeSaqueInvalidoException, ValorDeDepositoInvalidoException {
        contaCorrente.setSaldo(1000);
        contaPoupanca.setSaldo(500);

        boolean sucesso = contaCorrente.transferir(contaPoupanca, 200);

        assertTrue(sucesso);
        assertEquals(800, contaCorrente.getSaldo());
        assertEquals(700, contaPoupanca.getSaldo());
    }
}