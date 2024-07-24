package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    List<Endereco> findByIdPessoa(Integer pessoaId);

    List<Endereco> findAllTipo(TipoEndereco tipoEndereco);

    List<Endereco> findByCep(String cep);

    List<Endereco> findByCidadeAndEstado(String cidade, String estado);

    List<Endereco> findByPais(String pais);
}
