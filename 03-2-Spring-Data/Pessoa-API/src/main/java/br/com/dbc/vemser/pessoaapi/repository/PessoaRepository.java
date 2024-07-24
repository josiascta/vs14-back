package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    List<Pessoa> findAllByNomeContainsIgnoreCase(String nome);

    List<Pessoa> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

    Pessoa findByCpf(String cpf);
}
