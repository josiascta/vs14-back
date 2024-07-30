package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContatoDTO {
    private Integer idContato;

    private Pessoa pessoa;

    @NotNull
    private TipoContato tipoContato;

    @NotNull
    @Size(min = 1, max = 13)
    private String numero;

    @NotNull
    @NotEmpty
    private String descricao;
}
