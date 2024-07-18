package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public PessoaService(PessoaRepository pessoaRepository, ObjectMapper objectMapper){
        this.pessoaRepository = pessoaRepository;
        this.objectMapper = objectMapper;
    }

    public PessoaDTO create(PessoaCreateDTO dto) throws Exception {

        Pessoa pessoaEntity = objectMapper.convertValue(dto, Pessoa.class);
        pessoaEntity = pessoaRepository.create(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        return pessoaDTO;
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.list()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }


    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizar) throws Exception {

        Pessoa pessoaEntity = objectMapper.convertValue(pessoaAtualizar, Pessoa.class);
        pessoaEntity = pessoaRepository.update(id, pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.listByName(nome)
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    //Retornar um DTO para controller
    public PessoaDTO findById(Integer id) throws Exception {
        if(pessoaRepository.findById(id) == null){
            throw new RegraDeNegocioException("Não existe um pessoa com esse ID");
        }
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaRepository.findById(id), PessoaDTO.class);
        return pessoaDTO;
    }


    private Pessoa getPessoa(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        return pessoaRecuperada;
    }
}
