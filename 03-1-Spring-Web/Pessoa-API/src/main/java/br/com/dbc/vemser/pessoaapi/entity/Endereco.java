package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Endereco {

    private Integer idEndereco;

    private Integer idPessoa;

    private TipoEndereco tipo;

    private String logradouro;

    private Integer numero;

    private String complemento;

    private String cep;

    private String cidade;

    private String estado;

    private String pais;

}
