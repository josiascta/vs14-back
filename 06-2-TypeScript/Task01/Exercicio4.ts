let queijos: string[] = ["Mussarela", "Minas", "Parmesão", "Prato", "Gorgonzola"];

console.log("Cardápio de Queijos:", queijos.join(", "));

queijos.push("Mascarpone", "Ricota", "Provolone");

console.log("Lista atualizada:", queijos.join(", "));

queijos.sort();

console.log("Lista atualizada em ordem alfabética:", queijos.join(", "));

let index: number = queijos.findIndex(function(queijo) {
    return queijo > "Cottage";
});

queijos.splice(index, 0, "Cottage");

console.log("Lista atualizada:", queijos.join(", "));