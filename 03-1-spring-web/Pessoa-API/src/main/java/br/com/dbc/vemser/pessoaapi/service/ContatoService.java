package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public Contato create(Contato contato, Integer idPessoa) {
        return contatoRepository.create(contato, idPessoa);
    }

    public List<Contato> listByPersonId(Integer id) {
        return contatoRepository.listByPersonId(id);
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public void delete(Integer id) {
        contatoRepository.delete(id);
    }

    public Contato update(int id, Contato novosDados) {
        return contatoRepository.update(id, novosDados);
    }

    public Contato findById(int id) {
        return contatoRepository.findById(id);
    }
}
