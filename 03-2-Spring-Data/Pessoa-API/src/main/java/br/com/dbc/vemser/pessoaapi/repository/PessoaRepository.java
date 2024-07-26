package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.PessoaPersonalizadoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    List<Pessoa> findAllByNomeContainsIgnoreCase(String nome);

    List<Pessoa> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

    Pessoa findByCpf(String cpf);

    List<Pessoa> findAllByPetsNotNull();

    Optional<Pessoa> findByIdPessoaAndPetsNotNull(Integer integer);

    @Query("""
    select new br.com.dbc.vemser.pessoaapi.dto.PessoaPersonalizadoDTO(
    p.idPessoa,
    p.nome,
    p.email,
    c.numero,
    e.cep,
    e.cidade,
    e.estado,
    e.pais,
    pets.nome
    )FROM pessoa p
    left join p.contatos c
    left join p.enderecos e
    left join p.pets pets
"""
    )
    List<PessoaPersonalizadoDTO> findAllPessoasPersonalizados();

}
