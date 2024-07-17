package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;

    public EnderecoService(EnderecoRepository enderecoRepository, PessoaService pessoaService) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaService = pessoaService;
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

    public Endereco create(Endereco endereco, Integer id) throws Exception {
        Pessoa pessoa = pessoaService.getPessoa(id);
        if(pessoa == null) {
            throw new RegraDeNegocioException("Não existe pessoa com id: " + id);
        }
        return enderecoRepository.create(endereco, id);
    }

    public Endereco update(int id, Endereco novosDados) throws Exception {
        if(pessoaService.getPessoa(novosDados.getIdPessoa()) == null) {
            throw new RegraDeNegocioException("Não existe pessoa com id: " + id);
        }else if(enderecoRepository.findById(id) == null) {
            throw new RegraDeNegocioException("Não existe contato com esse id");
        }
        return enderecoRepository.update(id, novosDados);
    }

    public void delete(int id) throws Exception {
        Endereco endereco = getEndereco(id);
        enderecoRepository.delete(endereco);
    }

    public Endereco getEndereco(Integer id) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        return enderecoRecuperado;
    }
}
