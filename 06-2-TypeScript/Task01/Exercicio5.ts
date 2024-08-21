function somar(numero1: number, numero2:number): number{
    return numero1 + numero2;
}

let numero1: number = 7;
let numero2: number = 5;

let resultado: number = somar(numero1, numero2);

console.log(`A soma de ${numero1} e ${numero2} é: ${resultado}`);