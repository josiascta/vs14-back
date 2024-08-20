//01 - Trocar texto do input apertando o botão

document.getElementById('trocarTexto').addEventListener('click', mudarTexto);
document.getElementById('atualizarPagina').addEventListener('click', atualizarPagina);

function mudarTexto(){
    document.getElementById('textoAlterar').innerText = 'Texto Alterado';
}

function atualizarPagina(){
    location.reload();
}

//02 - Mudar a cor 

document.getElementById('cores').addEventListener('input', mudarCorTexto);

function mudarCorTexto(){
    const corSelecionada = document.getElementById('cores').value;

    document.getElementById('textoAlterarCor').style.color = corSelecionada;
}

//03 - Contador

let contador = 0;

function atualizarExibicao() {
  document.getElementById('contador').innerText = contador;
}

function adicionar() {
  contador += 1;
  atualizarExibicao();
}

function resetar() {
  contador = 0;
  atualizarExibicao();
}

document.getElementById('addBotao').addEventListener('click', adicionar);
document.getElementById('resetBotao').addEventListener('click', resetar);

//04 - Imagem com filtro

function applyFilter1() {
    document.getElementById('image').style.filter = 'grayscale(100%)';
}

function applyFilter2() {
    document.getElementById('image').style.filter = 'blur(5px)';
}

function resetFilter() {
    document.getElementById('image').style.filter = 'none';
}

document.getElementById('filter1').addEventListener('click', applyFilter1);
document.getElementById('filter2').addEventListener('click', applyFilter2);
document.getElementById('reset').addEventListener('click', resetFilter);

//05 - Calculadora básica

function calcular() {
    const valor1 = parseFloat(document.getElementById('valor1').value);
    const valor2 = parseFloat(document.getElementById('valor2').value);
    const operacao = document.getElementById('operacao').value;
    let resultado = 0;

    switch (operacao) {
        case 'somar':
            resultado = valor1 + valor2;
            break;
        case 'subtrair':
            resultado = valor1 - valor2;
            break;
        case 'multiplicar':
            resultado = valor1 * valor2;
            break;
        case 'dividir':
            if (valor2 === 0) {
                alert('Não é possível dividir por zero.');
                return;
            }
            resultado = valor1 / valor2;
            break;
        default:
            alert('Selecione uma operação válida.');
            return;
    }

    document.getElementById('resultado').value = resultado;

}

//06 - Calculadora II


function insert(value) {
    let resultado = document.getElementById('resultado2');
    if (resultado.innerText === '0') {
        resultado.innerText = value;
    } else {
        resultado.innerText += value;
    }
}

function clean() {
    document.getElementById('resultado2').innerText = '0';
}

function back() {
    let resultado = document.getElementById('resultado2').innerText;
    if (resultado.length > 1) {
        document.getElementById('resultado2').innerText = resultado.slice(0, -1);
    } else {
        document.getElementById('resultado2').innerText = '0';
    }
}

function calcular2() {
    let resultado = document.getElementById('resultado2').innerText;

    resultado = eval(resultado); 
    document.getElementById('resultado2').innerText = resultado;
}







