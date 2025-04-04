package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaComPetsDTO {

    private Integer idPessoa;

    @Schema(description = "Nome da Pessoa", example = "Rafael Laz")
    private String nome;

    @Schema(description = "Data de nascimento da pessoa", example = "2003-09-29")
    private LocalDate dataNascimento;

    @Schema(description = "Cadastro de pessoa física", example = "11512635522")
    private String cpf;

    @Schema(description = "E-mail da pessoa", example = "pessoa@gmail.com")
    private String email;

    private Set<Pet> pets;

}
