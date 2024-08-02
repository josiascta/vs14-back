#### Cenário 01: Saque bem-sucedido em uma conta corrente

```diff
🔴Dado: que a conta corrente possui um saldo de R$ 1000  
🟡Quando: eu saco R$ 900 da conta  
🟢Então: o saldo da conta deve ser R$ 100
```

#### Cenário 02: Tentativa de saque em conta corrente sem saldo suficiente

```diff
🔴Dado: que a conta corrente possui um saldo insuficiente para o saque  
🟡Quando: eu tento sacar um valor maior que o saldo disponível  
🟢Então: uma exceção `ValorDeSaqueInvalidoException` deve ser lançada
```

#### Cenário 03: Saque bem-sucedido em uma conta poupança

```diff
🔴Dado: que a conta poupança possui um saldo de R$ 1000  
🔴E: que a taxa mensal foi aplicada  
🟡Quando: eu saco R$ 900 da conta  
🟢Então: o saldo da conta deve ser R$ 90
```

#### Cenário 04: Tentativa de saque em conta poupança sem saldo suficiente

```diff
🔴Dado: que a conta poupança possui um saldo insuficiente após a aplicação da taxa mensal  
🟡Quando: eu tento sacar um valor maior que o saldo disponível  
🟢Então: uma exceção `ValorDeSaqueInvalidoException` deve ser lançada
```

#### Cenário 05: Saque bem-sucedido em uma conta de pagamento

```diff
🔴Dado: que a conta de pagamento possui um saldo de R$ 1000  
🟡Quando: eu saco R$ 900 da conta  
🟢Então: o saldo da conta deve ser R$ 95.75 (após a aplicação da taxa de saque)
```

#### Cenário 06: Transferência bem-sucedida entre contas do mesmo banco

```diff
🔴Dado: que a conta de origem possui um saldo de R$ 1000  
🔴E: que a conta de destino possui um saldo inicial de R$ 500  
🟡Quando: eu transfiro R$ 200 da conta de origem para a conta de destino  
🟢Então: o saldo da conta de origem deve ser R$ 800  
🟢E: o saldo da conta de destino deve ser R$ 700
```

#### Cenário 07: Tentativa de transferência sem saldo suficiente

```diff
🔴Dado: que a conta de origem possui um saldo insuficiente para a transferência  
🟡Quando: eu tento transferir R$ 200 para outra conta  
🟢Então: uma exceção `ValorDeSaqueInvalidoException` deve ser lançada
```

#### Cenário 08: Depósito bem-sucedido em uma conta corrente

```diff
🔴Dado: que a conta corrente possui um saldo de R$ 100  
🟡Quando: eu deposito R$ 200 na conta  
🟢Então: o saldo da conta deve ser R$ 300
```

#### Cenário 09: Tentativa de depósito com valor inválido

```diff
🔴Dado: que a conta corrente possui um saldo inicial de R$ 100  
🟡Quando: eu tento depositar um valor inválido (por exemplo, -R$ 50)  
🟢Então: uma exceção `ValorDeDepositoInvalidoException` deve ser lançada
```

#### Cenário 10: Transferência bem-sucedida entre contas e verificação dos saldos

```diff
🔴Dado: que a conta corrente possui um saldo de R$ 1000
🔴E: que a conta poupança possui um saldo de R$ 500
🟡Quando: eu transfiro R$ 200 da conta corrente para a conta poupança
🟢Então: a transferência deve ser bem-sucedida
🟢E: o saldo da conta corrente deve ser R$ 800
🟢E: o saldo da conta poupança deve ser R$ 700