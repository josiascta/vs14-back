package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    List<Endereco> findByTipoEndereco(TipoEndereco tipoEndereco);

    List<Endereco> findByCep(String cep);

    List<Endereco> findByCidadeAndEstado(String cidade, String estado);

    List<Endereco> findByPais(String pais);

    @Query("select e from endereco e WHERE e.pais = :pais")
    List<Endereco> enderecosPorPais(@Param("pais") String pais);

//    @Query("Select ")
//    List<Endereco> enderecosPorIdPessoa(@Param("idPessoa") Integer idPessoa);]

}
