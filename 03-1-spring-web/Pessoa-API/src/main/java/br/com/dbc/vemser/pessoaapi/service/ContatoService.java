package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;

    public ContatoService(ContatoRepository contatoRepository, PessoaService pessoaService) {
        this.contatoRepository = contatoRepository;
        this.pessoaService = pessoaService;
    }

    public Contato create(Contato contato, Integer idPessoa) throws Exception {
        Pessoa pessoa = pessoaService.getPessoa(idPessoa);
        if(pessoa == null) {
            throw new RegraDeNegocioException("Não existe pessoa com id: " + idPessoa);
        }
        return contatoRepository.create(contato, idPessoa);
    }

    public List<Contato> listByPersonId(Integer id) {
        return contatoRepository.listByPersonId(id);
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public void delete(Integer id) throws Exception {
        Contato contato = getContato(id);
        contatoRepository.delete(contato);
    }

    public Contato update(int id, Contato novosDados) throws Exception {
        if(pessoaService.getPessoa(novosDados.getIdPessoa()) == null) {
            throw new RegraDeNegocioException("Não existe pessoa com id: " + id);
        }else if(contatoRepository.findById(id) == null) {
            throw new RegraDeNegocioException("Não existe contato com esse id");
        }
        return contatoRepository.update(id, novosDados);
    }

//    public Contato findById(int id) {
//        return contatoRepository.findById(id);
//    }

    public Contato getContato(Integer id) throws RegraDeNegocioException {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        return contatoRecuperado;
    }
}
