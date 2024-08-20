interface Relatorio{
    cliente: string;
    produto: string;
}

const relatorios: Relatorio[] = [
    { cliente: "Claudino", produto: "Refrigerante" },
    { cliente: "Maribela", produto: "Refrigerante" },
    { cliente: "Jacinto", produto: "Refrigerante" },
    { cliente: "Olimpo", produto: "Refrigerante" },
    { cliente: "Pafúncio", produto: "Suco" },
    { cliente: "Felisberta", produto: "Suco" },
    { cliente: "Pafúncio", produto: "Cerveja" },
    { cliente: "Felisberta", produto: "Cerveja" },
    { cliente: "Claudino", produto: "Pizza Calabresa" },
    { cliente: "Maribela", produto: "Pizza Mafiosa" },
    { cliente: "Jacinto", produto: "Pizza Calabresa" },
    { cliente: "Olimpo", produto: "Pizza Mussarela" },
    { cliente: "Pafúncio", produto: "Pizza Quatro Queijos" },
    { cliente: "Felisberta", produto: "Pizza Mussarela" },
  ];

const pedidosPizza: string[] = relatorios
  .filter(item => item.produto.includes("Pizza"))
  .map(item => item.produto);

console.log("Pedidos de Pizza:", pedidosPizza);

const clientesRefrigerante: string[] = relatorios
  .filter(item => item.produto === "Refrigerante")
  .map(item => item.cliente);

console.log("Clientes que pediram refrigerante:", clientesRefrigerante);

const clientesSuco: string[] = relatorios
  .filter(item => item.produto === "Suco")
  .map(item => item.cliente);

console.log("Clientes que pediram suco:", clientesSuco);

const clientesCerveja: string[] = relatorios
  .filter(item => item.produto === "Cerveja")
  .map(item => item.cliente);

console.log("Clientes que pediram cerveja:", clientesCerveja);