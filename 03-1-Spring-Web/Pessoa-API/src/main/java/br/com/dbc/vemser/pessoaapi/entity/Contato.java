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
public class Contato {
    private Integer idContato;

    private Integer idPessoa;

    private TipoContato tipoContato;

    private String numero;

    private String descricao;

}
