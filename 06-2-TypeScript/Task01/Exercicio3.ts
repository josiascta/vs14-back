function calcularDiferencaIdade(idade1: number, idade2: number):number {
    return idade1 - idade2;
}

const idadeCarlos: number = 18;
const idadeAna: number = 15;

const diferencaIdade: number = calcularDiferencaIdade(idadeCarlos, idadeAna);

console.log(`Nossa diferença de idade é: ${diferencaIdade}`);