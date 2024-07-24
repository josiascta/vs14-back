package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public ContatoService(ContatoRepository contatoRepository, PessoaService pessoaService, ObjectMapper objectMapper) {
        this.contatoRepository = contatoRepository;
        this.pessoaService = pessoaService;
        this.objectMapper = objectMapper;
    }

    public ContatoDTO create(ContatoCreateDTO contatoCreateDTO, Integer idPessoa) throws Exception {
        PessoaDTO pessoa = pessoaService.findById(idPessoa);
        if(pessoa == null) {
            throw new RegraDeNegocioException("Não existe pessoa com id: " + idPessoa);
        }
        Contato contatoEntity = objectMapper.convertValue(contatoCreateDTO, Contato.class);
        contatoEntity.setIdPessoa(idPessoa);
        contatoEntity = contatoRepository.save(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
        return contatoDTO;
    }

    public List<ContatoDTO> listByPersonId(Integer id) {
        return contatoRepository.findByIdPessoa(id)
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
        Contato contatoEntity = objectMapper.convertValue(contatoCreateDTO, Contato.class);

        contatoEntity.setTipoContato(contatoCreateDTO.getTipoContato());
        contatoEntity.setDescricao(contatoCreateDTO.getDescricao());
        contatoEntity.setIdPessoa(contatoCreateDTO.getIdPessoa());
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
}
