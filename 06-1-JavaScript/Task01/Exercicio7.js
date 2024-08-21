let numeros = [];
for (let i = 1; i <= 30; i++) {
    numeros.push(i);
}

for (let i = 0; i < numeros.length; i++) {
    if (numeros[i] % 2 === 0) {
        console.log(`Os números pares da lista são: ${numeros[i]} e possui o índice: ${i}`);
    }
}