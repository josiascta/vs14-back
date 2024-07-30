package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final PessoaRepository pessoaRepository;

    public ContatoService(ContatoRepository contatoRepository, PessoaService pessoaService, ObjectMapper objectMapper, PessoaRepository pessoaRepository) {
        this.contatoRepository = contatoRepository;
        this.pessoaService = pessoaService;
        this.objectMapper = objectMapper;
        this.pessoaRepository = pessoaRepository;
    }

    public ContatoDTO create(ContatoCreateDTO contatoCreateDTO, Integer idPessoa) throws Exception {
        Pessoa pessoa = objectMapper.convertValue( pessoaService.findById(idPessoa), Pessoa.class);

        if(pessoa == null) {
            throw new RegraDeNegocioException("Não existe pessoa com id: " + idPessoa);
        }
        Contato contatoEntity = objectMapper.convertValue(contatoCreateDTO, Contato.class);
        contatoEntity.setPessoa(pessoa);
        contatoEntity = contatoRepository.save(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
        return contatoDTO;
    }

    public List<ContatoDTO> listByPersonId(Integer id) throws Exception {
        Pessoa pessoa = objectMapper.convertValue(pessoaService.findById(id), Pessoa.class);
        return contatoRepository.findByPessoa(pessoa)
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public List<ContatoDTO> list() {
        return contatoRepository.findAll()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public void delete(Integer id) throws Exception {
        ContatoDTO contato = findById(id);
        Contato contatoEntity = objectMapper.convertValue(contato, Contato.class);
        contatoRepository.delete(contatoEntity);
    }

    public ContatoDTO update(int id, ContatoCreateDTO contatoCreateDTO) throws Exception {
        if(pessoaService.findById(contatoCreateDTO.getIdPessoa()) == null) {
            throw new RegraDeNegocioException("Não existe pessoa com id: " + id);
        }else if(findById(id) == null) {
            throw new RegraDeNegocioException("Não existe contato com esse id");
        }
        Pessoa pessoa = objectMapper.convertValue( pessoaService.findById(contatoCreateDTO.getIdPessoa()), Pessoa.class);


        Contato contatoEntity = objectMapper.convertValue(contatoCreateDTO, Contato.class);

        contatoEntity.setTipoContato(contatoCreateDTO.getTipoContato());
        contatoEntity.setDescricao(contatoCreateDTO.getDescricao());
        contatoEntity.setPessoa(pessoa);
        contatoEntity.setNumero(contatoCreateDTO.getNumero());
        contatoEntity = contatoRepository.save(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);

        return contatoDTO;
    }

    public ContatoDTO findById(int id) throws Exception {
        return objectMapper.convertValue(getContato(id), ContatoDTO.class);
    }

    private Contato getContato(Integer id) throws RegraDeNegocioException {
        Contato contatoRecuperado = contatoRepository.findAll().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        return contatoRecuperado;
    }

    public List<ContatoDTO> buscarPorTipoContato(Integer tipoContato) {
        return contatoRepository.findByTipoContato(TipoContato.ofTipo(tipoContato))
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public Page<ContatoDTO> paginarContatoCres(Integer pagina, Integer tamanho) {
        Pageable pageable = PageRequest.of(pagina, tamanho, Sort.by("idContato").ascending());

        Page<Contato> contatoPage = contatoRepository.findAll(pageable);
        Page<ContatoDTO> contatoDTOPage = contatoPage.map(contato -> objectMapper.convertValue(contato, ContatoDTO.class));

        return contatoDTOPage;
    }
}
