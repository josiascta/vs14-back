package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public List<PessoaDTO> buscarPessoasPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        return pessoaRepository.findByDataNascimentoBetween(dataInicial, dataFinal)
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO buscarPessoaCpf(String cpf) {
        return objectMapper.convertValue(pessoaRepository.findByCpf(cpf), PessoaDTO.class);
    }


    public PessoaDTO create(PessoaCreateDTO dto) throws Exception {

        Pessoa pessoaEntity = objectMapper.convertValue(dto, Pessoa.class);
        pessoaEntity = pessoaRepository.save(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        emailService.sendEmail(pessoaDTO);
        return pessoaDTO;
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa ->
                {
                    PessoaDTO p = objectMapper.convertValue(pessoa, PessoaDTO.class);
                    p.setContatos(pessoa.getContatos());
                    p.setPets(pessoa.getPets());
                    p.setEnderecos(pessoa.getEnderecos());
                    return p;
                })
                .collect(Collectors.toList());
    }


    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizar) throws Exception {

        Pessoa pessoaEntity = getPessoa(id);

        pessoaEntity.setNome(pessoaAtualizar.getNome());
        pessoaEntity.setEmail(pessoaAtualizar.getEmail());
        pessoaEntity.setCpf(pessoaAtualizar.getCpf());
        pessoaRepository.save(pessoaEntity);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findAllByNomeContainsIgnoreCase(nome)
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO findById(Integer id) throws Exception {
        return objectMapper.convertValue(getPessoa(id), PessoaDTO.class);
    }


    private Pessoa getPessoa(Integer id) throws RegraDeNegocioException {


        Pessoa pessoaRecuperada = pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        return pessoaRecuperada;
    }

    public List<PessoaDTO> listPessoaComEndereco(Integer idEPessoa) throws Exception {
        List<PessoaDTO> pessoaDTOS = new ArrayList<>();
        if(idEPessoa != null) {
            PessoaDTO pessoaRecuperada = findById(idEPessoa);

            if (pessoaRecuperada.getIdPessoa() != null) {
                pessoaDTOS.add(pessoaRecuperada);
                pessoaDTOS.get(0).setEnderecos(getPessoa(idEPessoa).getEnderecos());
            }
        }else {
            pessoaDTOS = pessoaRepository.findAll()
                    .stream()
                    .map(pessoa ->
                    {
                        PessoaDTO p = objectMapper.convertValue(pessoa, PessoaDTO.class);
                        p.setEnderecos(pessoa.getEnderecos());
                        return p;
                    })
                    .collect(Collectors.toList());
        }
        return pessoaDTOS;
    }

    public List<PessoaDTO> listPessoaComContato(Integer idEPessoa) throws Exception {
        List<PessoaDTO> pessoaDTOS = new ArrayList<>();
        if(idEPessoa != null) {
            PessoaDTO pessoaRecuperada = findById(idEPessoa);

            if (pessoaRecuperada.getIdPessoa() != null) {
                pessoaDTOS.add(pessoaRecuperada);
                pessoaDTOS.get(0).setContatos(getPessoa(idEPessoa).getContatos());
            }
        }else {
            pessoaDTOS = pessoaRepository.findAll()
                    .stream()
                    .map(pessoa ->
                    {
                        PessoaDTO p = objectMapper.convertValue(pessoa, PessoaDTO.class);
                        p.setContatos(pessoa.getContatos());
                        return p;
                    })
                    .collect(Collectors.toList());
        }
        return pessoaDTOS;
    }

    public List<PessoaDTO> listPessoaComPet(Integer idEPessoa) throws Exception {
        List<PessoaDTO> pessoaDTOS = new ArrayList<>();
        if(idEPessoa != null) {
            PessoaDTO pessoaRecuperada = findById(idEPessoa);

            if (pessoaRecuperada.getIdPessoa() != null) {
                pessoaDTOS.add(pessoaRecuperada);
                pessoaDTOS.get(0).setPets(getPessoa(idEPessoa).getPets());
            }
        }else {
            pessoaDTOS = pessoaRepository.findAll()
                    .stream()
                    .map(pessoa ->
                    {
                        PessoaDTO p = objectMapper.convertValue(pessoa, PessoaDTO.class);
                        p.setPets(pessoa.getPets());
                        return p;
                    })
                    .collect(Collectors.toList());
        }
        return pessoaDTOS;
    }
}

