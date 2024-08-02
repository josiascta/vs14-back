package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
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
        contatoEntity = contatoRepository.create(contatoEntity, idPessoa);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
        return contatoDTO;
    }

    public List<ContatoDTO> listByPersonId(Integer id) {
        return contatoRepository.listByPersonId(id)
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public List<ContatoDTO> list() {
        return contatoRepository.list()
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

        contatoEntity = contatoRepository.update(id, contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);

        return contatoDTO;
    }

    //TODO Tirar o get e usar só esse método
    public ContatoDTO findById(int id) throws Exception {
        if(contatoRepository.findById(id) == null){
            throw new RegraDeNegocioException("Não existe um contato com esse ID");
        }
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoRepository.findById(id), ContatoDTO.class);
        return contatoDTO;
    }

//    public Contato getContato(Integer id) throws RegraDeNegocioException {
//        Contato contatoRecuperado = contatoRepository.list().stream()
//                .filter(contato -> contato.getIdContato().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
//        return contatoRecuperado;
//    }
}
