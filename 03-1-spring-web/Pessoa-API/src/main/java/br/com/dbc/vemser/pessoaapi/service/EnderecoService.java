package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public List<EnderecoDTO> list() {
        return enderecoRepository.list()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO findById(int id) throws Exception {
        if(enderecoRepository.findById(id) == null){
            throw new RegraDeNegocioException("Não existe um contato com esse ID");
        }
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRepository.findById(id), EnderecoDTO.class);

        return enderecoDTO;
    }

    public List<EnderecoDTO> listByPersonId(int id) {
        return enderecoRepository.listByPersonId(id)
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO create(EnderecoCreateDTO endereco, Integer id) throws Exception {
        PessoaDTO pessoa = pessoaService.findById(id);
        if (pessoa == null) {
            throw new RegraDeNegocioException("Não existe pessoa com id: " + id);
        }
        Endereco enderecoEntity = objectMapper.convertValue(endereco, Endereco.class);
        enderecoEntity = enderecoRepository.create(enderecoEntity, id);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        emailService.sendEmail(pessoaService.findById(enderecoDTO.getIdPessoa()), enderecoDTO, "Criando um endereço", "email-template-post-endereco.ftl", "criado");

        return enderecoDTO;
    }

    public EnderecoDTO update(int id, EnderecoCreateDTO novosDados) throws Exception {
        if (pessoaService.findById(novosDados.getIdPessoa()) == null) {
            throw new RegraDeNegocioException("Não existe pessoa com id: " + id);
        } else if (enderecoRepository.findById(id) == null) {
            throw new RegraDeNegocioException("Não existe contato com esse id");
        }
        Endereco enderecoEntity = objectMapper.convertValue(novosDados, Endereco.class);

        enderecoEntity = enderecoRepository.update(id, enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        emailService.sendEmail(pessoaService.findById(enderecoDTO.getIdPessoa()), enderecoDTO, "Atualizando um endereço", "email-template-post-endereco.ftl", "atualizado");

        return enderecoDTO;
    }

    public void delete(int id) throws Exception {
        Endereco endereco = getEndereco(id);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
        emailService.sendEmail(pessoaService.findById(enderecoDTO.getIdPessoa()), enderecoDTO, "Deletando um endereço", "email-template-post-endereco.ftl", "deletado");

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
