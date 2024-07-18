package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EnderecoCreateDTO {

    private Integer idPessoa;

    @NotNull
    private TipoEndereco tipo;

    @NotEmpty
    @Size(min = 0, max = 250)
    private String logradouro;

    @NotNull
    private Integer numero;

    private String complemento;

    @NotNull
    @NotEmpty
    @Size(min = 0, max = 8)
    private String cep;

    @NotNull
    @NotEmpty
    @Size(min = 0, max = 250)
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
    private String pais;
}
