package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco findById(int id) {
        return enderecoRepository.findById(id);
    }

    public List<Endereco> listByPersonId(int id) {
        return enderecoRepository.listByPersonId(id);
    }

    public Endereco create(Endereco endereco, Integer id) {
        return enderecoRepository.create(endereco, id);
    }

    public Endereco update(int id, Endereco novosDados) {
        return enderecoRepository.update(id, novosDados);
    }

    public void delete(int id) {
        enderecoRepository.delete(id);
    }
}
