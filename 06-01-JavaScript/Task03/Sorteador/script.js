function iniciarSorteio() {
    const nomesInput = document.getElementById('nomes').value;
    const nomes = nomesInput.split(',').map(nome => nome.trim());
    const velocidade = parseInt(document.getElementById('velocidade').value);
    const tempo = parseInt(document.getElementById('tempo').value);
    const resultadoElemento = document.getElementById('resultado');
    
    if (nomes.length === 0 || nomesInput.trim() === "") {
        alert("Insira pelo menos um nome.");
        return;
    }

    let indiceAtual = 0;

    const intervalo = setInterval(() => {
        resultadoElemento.textContent = nomes[indiceAtual];
        indiceAtual = (indiceAtual + 1) % nomes.length;
    }, velocidade);

    setTimeout(() => {
        clearInterval(intervalo);
        resultadoElemento.textContent = `Nome sorteado: ${nomes[indiceAtual]}`;
    }, tempo);
}