package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaComPetsDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCompletoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaPersonalizadoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public List<PessoaCompletoDTO> buscarPessoasPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        return pessoaRepository.findByDataNascimentoBetween(dataInicial, dataFinal)
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaCompletoDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaCompletoDTO buscarPessoaCpf(String cpf) {
        return objectMapper.convertValue(pessoaRepository.findByCpf(cpf), PessoaCompletoDTO.class);
    }


    public PessoaCompletoDTO create(PessoaCreateDTO dto) throws Exception {

        Pessoa pessoaEntity = objectMapper.convertValue(dto, Pessoa.class);
        pessoaEntity = pessoaRepository.save(pessoaEntity);
        PessoaCompletoDTO pessoaCompletoDTO = objectMapper.convertValue(pessoaEntity, PessoaCompletoDTO.class);
        emailService.sendEmail(pessoaCompletoDTO);
        return pessoaCompletoDTO;
    }

    public List<PessoaCompletoDTO> list() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa ->
                {
                    PessoaCompletoDTO p = objectMapper.convertValue(pessoa, PessoaCompletoDTO.class);
                    p.setContatos(pessoa.getContatos());
                    p.setPets(pessoa.getPets());
                    p.setEnderecos(pessoa.getEnderecos());
                    return p;
                })
                .collect(Collectors.toList());
    }


    public PessoaCompletoDTO update(Integer id,
                                    PessoaCreateDTO pessoaAtualizar) throws Exception {

        Pessoa pessoaEntity = getPessoa(id);

        pessoaEntity.setNome(pessoaAtualizar.getNome());
        pessoaEntity.setEmail(pessoaAtualizar.getEmail());
        pessoaEntity.setCpf(pessoaAtualizar.getCpf());
        pessoaRepository.save(pessoaEntity);

        PessoaCompletoDTO pessoaCompletoDTO = objectMapper.convertValue(pessoaEntity, PessoaCompletoDTO.class);
        return pessoaCompletoDTO;
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<PessoaCompletoDTO> listByName(String nome) {
        return pessoaRepository.findAllByNomeContainsIgnoreCase(nome)
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaCompletoDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaCompletoDTO findById(Integer id) throws Exception {
        return objectMapper.convertValue(getPessoa(id), PessoaCompletoDTO.class);
    }


    private Pessoa getPessoa(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        return pessoaRecuperada;
    }

    public List<PessoaCompletoDTO> listPessoaComEndereco(Integer idEPessoa) throws Exception {
        List<PessoaCompletoDTO> pessoaCompletoDTOS = new ArrayList<>();
        if(idEPessoa != null) {
            PessoaCompletoDTO pessoaRecuperada = findById(idEPessoa);

            if (pessoaRecuperada.getIdPessoa() != null) {
                pessoaCompletoDTOS.add(pessoaRecuperada);
                pessoaCompletoDTOS.get(0).setEnderecos(getPessoa(idEPessoa).getEnderecos());
            }
        }else {
            pessoaCompletoDTOS = pessoaRepository.findAll()
                    .stream()
                    .map(pessoa ->
                    {
                        PessoaCompletoDTO p = objectMapper.convertValue(pessoa, PessoaCompletoDTO.class);
                        p.setEnderecos(pessoa.getEnderecos());
                        return p;
                    })
                    .collect(Collectors.toList());
        }
        return pessoaCompletoDTOS;
    }

    public List<PessoaCompletoDTO> listPessoaComContato(Integer idEPessoa) throws Exception {
        List<PessoaCompletoDTO> pessoaCompletoDTOS = new ArrayList<>();
        if(idEPessoa != null) {
            PessoaCompletoDTO pessoaRecuperada = findById(idEPessoa);

            if (pessoaRecuperada.getIdPessoa() != null) {
                pessoaCompletoDTOS.add(pessoaRecuperada);
                pessoaCompletoDTOS.get(0).setContatos(getPessoa(idEPessoa).getContatos());
            }
        }else {
            pessoaCompletoDTOS = pessoaRepository.findAll()
                    .stream()
                    .map(pessoa ->
                    {
                        PessoaCompletoDTO p = objectMapper.convertValue(pessoa, PessoaCompletoDTO.class);
                        p.setContatos(pessoa.getContatos());
                        return p;
                    })
                    .collect(Collectors.toList());
        }
        return pessoaCompletoDTOS;
    }

    //Versão da aula
    public List<PessoaComPetsDTO> listPessoaComPet(Integer idEPessoa) throws Exception {
        List<PessoaComPetsDTO> pessoaDTOS = new ArrayList<>();
        if(idEPessoa != null) {
            Pessoa pessoaRecuperada = pessoaRepository.findByIdPessoaAndPetsNotNull(idEPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));

            PessoaComPetsDTO pessoaDTO = objectMapper.convertValue(pessoaRecuperada, PessoaComPetsDTO.class);
            pessoaDTO.setPets(getPessoa(idEPessoa).getPets());
            pessoaDTOS.add(pessoaDTO);
        }else {
            pessoaDTOS = pessoaDTOS = pessoaRepository.findAllByPetsNotNull()
                    .stream()
                    .map(pessoa ->
                    {
                        PessoaComPetsDTO p = objectMapper.convertValue(pessoa, PessoaComPetsDTO.class);
                        p.setPets(pessoa.getPets());
                        return p;
                    })
                    .collect(Collectors.toList());
        }
        return pessoaDTOS;
    }

    public List<PessoaCompletoDTO> listPessoaCompleto(Integer idEPessoa) throws Exception {
        List<PessoaCompletoDTO> pessoaDTOS = new ArrayList<>();
        if(idEPessoa != null) {
            Pessoa pessoaRecuperada = getPessoa(idEPessoa);

            PessoaCompletoDTO pessoaCompletoDTO = objectMapper.convertValue(pessoaRecuperada, PessoaCompletoDTO.class);
            pessoaCompletoDTO.setPets(getPessoa(idEPessoa).getPets());
            pessoaCompletoDTO.setEnderecos(getPessoa(idEPessoa).getEnderecos());
            pessoaCompletoDTO.setContatos(getPessoa(idEPessoa).getContatos());
            pessoaDTOS.add(pessoaCompletoDTO);
        }else {
            pessoaDTOS = list();
        }
        return pessoaDTOS;
    }

    public List<PessoaPersonalizadoDTO> listPessoaPersonalizada() throws Exception {
        return pessoaRepository.findAllPessoasPersonalizados();
    }
}

