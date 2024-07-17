package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public List<Endereco> list() {
        return listaEnderecos;
    }

    public Endereco findById(int id) {
        Endereco enderecoRecuperado = null;
        for (Endereco endereco : listaEnderecos) {
            if (endereco.getIdEndereco() == id) {
                enderecoRecuperado = endereco;
                return enderecoRecuperado;
            }
        }
        return null;
    }

    public List<Endereco> listByPersonId(int id) {
        List<Endereco> enderecosDaPessoa = new ArrayList<>();
        for (Endereco endereco : listaEnderecos) {
            if (endereco.getIdPessoa() == id) {
                enderecosDaPessoa.add(endereco);
            }
        }
        return enderecosDaPessoa;
    }

    public Endereco create(Endereco endereco, Integer id) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        endereco.setIdPessoa(id);
        listaEnderecos.add(endereco);
        return endereco;
    }

    public Endereco update(int id, Endereco novosDados) {
        Endereco endereco = findById(id);
        endereco.setIdPessoa(novosDados.getIdPessoa());
        endereco.setCep(novosDados.getCep());
        endereco.setCidade(novosDados.getCidade());
        endereco.setComplemento(novosDados.getComplemento());
        endereco.setEstado(novosDados.getEstado());
        endereco.setLogradouro(novosDados.getLogradouro());
        endereco.setNumero(novosDados.getNumero());
        endereco.setPais(novosDados.getPais());
        endereco.setTipo(novosDados.getTipo());
        return endereco;
    }

    public void delete(Endereco endereco) {
        listaEnderecos.remove(endereco);
    }
}
