async function fetchData(){
    try{

        const nomePokemon = document.getElementById("nomePokemon").value.toLowerCase();
        const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${nomePokemon}`);

        if(!response.ok){
            alert("Pokémon não encontrado");
        }

        

        const data = await response.json();
        const fotoPokemon = data.sprites.front_default;
        
        const imgElement = document.getElementById("fotoPokemon");

        const tipoUm = data.types[0].type.name;

        const pokemonVida = data.stats[0].base_stat;
        const pokemonAtaque = data.stats[1].base_stat;
        const pokemonDefesa = data.stats[2].base_stat;
        const pokemonSpAtaque = data.stats[3].base_stat;
        const pokemonSpDefesa = data.stats[4].base_stat;
        const pokemonVelocidade = data.stats[5].base_stat;



        const hpElement = document.getElementById("hp").innerText = 'Vida: ' + pokemonVida;
        const atkElement = document.getElementById("ataque").innerText = 'Ataque: ' + pokemonAtaque;
        const dfsElement = document.getElementById("defesa").innerText = 'Defesa: ' + pokemonDefesa;
        const spatkElement = document.getElementById("spataque").innerText = 'Sp.Ataque: ' + pokemonSpAtaque;
        const spdfsElement = document.getElementById("spdefesa").innerText = 'Sp.Defesa: ' + pokemonSpDefesa;
        const vddElement = document.getElementById("velocidade").innerText = 'Velocidade: ' + pokemonVelocidade;

        let tipo = 'Tipo: ';
        for (let i = 0; i < data.types.length; i++){
            tipo += data.types[i].type.name + " ";
        }
        const tipoElement = document.getElementById("tipo").innerText = tipo;


        imgElement.src = fotoPokemon;
        imgElement.style.display = "block";
        
    }
    catch(error){
        console.error(error);
    }
}

