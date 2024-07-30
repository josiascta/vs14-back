package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {

    List<Contato> findByPessoa(Pessoa pessoaId);

    List<Contato> findByTipoContato(TipoContato tipoContato);

    @Query("select c from contato c where c.tipoContato = :tipoContato")
    List<Contato> contatosPorTipoDeContato(@Param("tipoContato")TipoContato tipoContato);


}
