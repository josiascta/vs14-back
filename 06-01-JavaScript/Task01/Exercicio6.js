let livros = [
    { id: "01", categoria: "Terror", titulo: "It" },
    { id: "02", categoria: "Terror", titulo: "O Exorcista" },
    { id: "03", categoria: "Terror", titulo: "Drácula" },
    { id: "04", categoria: "Romance", titulo: "O Morro dos Ventos Uivantes" },
    { id: "05", categoria: "Policial", titulo: "O Silêncio dos Inocentes" },
    { id: "06", categoria: "Suspense", titulo: "Boneco de Neve" },
    { id: "07", categoria: "Suspense", titulo: "Bird Box" },
    { id: "08", categoria: "Romance", titulo: "Orgulho e Preconceito" }
];

let catalogoCompleto = [];
let livrosTerror = [];

for (let i = 0; i < livros.length; i++) {
    catalogoCompleto.push(livros[i].titulo);
}

for (let i = 0; i < livros.length; i++) {
    if (livros[i].categoria === "Terror") {
        livrosTerror.push(livros[i].titulo);
    }
}

console.log("O catálogo de livros da biblioteca é composto por:");
console.log(catalogoCompleto.join(", "));

console.log("\nOs livros de categoria de Terror da biblioteca, são:");
console.log(livrosTerror.join(", "));