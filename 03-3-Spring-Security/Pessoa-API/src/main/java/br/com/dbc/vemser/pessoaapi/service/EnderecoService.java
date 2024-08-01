package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCompletoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
        return enderecoRepository.findAll()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO findById(int id) throws Exception {
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRepository.findById(id), EnderecoDTO.class);

        return enderecoDTO;
    }

//    public List<EnderecoDTO> listByPersonId(int id) {
//        return enderecoRepository.findByIdPessoa(id)
//                .stream()
//                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
//                .collect(Collectors.toList());
//    }

    public EnderecoDTO create(EnderecoCreateDTO endereco, int id) throws Exception {
        Pessoa pessoa = objectMapper.convertValue( pessoaService.findById(id), Pessoa.class);

        if (pessoa == null) {
            throw new RegraDeNegocioException("Não existe pessoa com id: " + id);
        }

        Endereco enderecoEntity = objectMapper.convertValue(endereco, Endereco.class);

        enderecoEntity.getPessoas().add(pessoa);
        enderecoEntity = enderecoRepository.save(enderecoEntity);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
//        emailService.sendEmail(pessoaService.findById(enderecoDTO.getIdPessoa()), enderecoDTO, "Criando um endereço", "criado");

        return enderecoDTO;
    }

    public EnderecoDTO update(int id, EnderecoCreateDTO novosDados) throws Exception {
        if (pessoaService.findById(novosDados.getIdPessoa()) == null) {
            throw new RegraDeNegocioException("Não existe pessoa com id: " + id);
        }
        Endereco enderecoEntity = getEndereco(id);

        enderecoEntity.setPais(novosDados.getPais());
        enderecoEntity.setCidade(novosDados.getCidade());
        enderecoEntity.setEstado(novosDados.getEstado());
        enderecoEntity.setLogradouro(novosDados.getLogradouro());
        enderecoEntity.setNumero(novosDados.getNumero());
        enderecoEntity.setComplemento(novosDados.getComplemento());
        enderecoEntity.setCep(novosDados.getCep());
        enderecoRepository.save(enderecoEntity);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
//        emailService.sendEmail(pessoaService.findById(enderecoDTO.getIdPessoa()), enderecoDTO, "Atualizando um endereço", "atualizado");

        return enderecoDTO;
    }

    public void delete(int id) throws Exception {
        Endereco endereco = getEndereco(id);
//        EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
//        emailService.sendEmail(pessoaService.findById(enderecoDTO.getIdPessoa()), enderecoDTO, "Deletando um endereço", "deletado");

        enderecoRepository.delete(endereco);
    }

    public Endereco getEndereco(Integer id) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = enderecoRepository.findAll().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        return enderecoRecuperado;
    }

    public List<EnderecoDTO> buscarPorTipoEndereco(Integer tipoEndereco) {
        return enderecoRepository.findByTipoEndereco(TipoEndereco.ofTipo(tipoEndereco))
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> buscarPorCep(String cep) {
        return enderecoRepository.findByCep(cep)
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> buscarPorCidadeEEstado(String cidade, String estado) {
        return enderecoRepository.findByCidadeAndEstado(cidade, estado)
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> buscarPorPais(String pais) {
        return enderecoRepository.findByPais(pais)
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public Page<EnderecoDTO> paginarEndereco(Integer pagina, Integer tamanho) {
        Pageable pageable = PageRequest.of(pagina, tamanho, Sort.by("tipo").ascending());

        Page<Endereco> enderecoPage = enderecoRepository.findAll(pageable);
        Page<EnderecoDTO> enderecoDTOPage = enderecoPage.map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class));

        return enderecoDTOPage;
    }
}
