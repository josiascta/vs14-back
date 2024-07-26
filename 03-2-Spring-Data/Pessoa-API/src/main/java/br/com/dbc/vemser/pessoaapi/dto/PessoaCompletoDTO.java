package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
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
@ToString
public class PessoaCompletoDTO {

    private Integer idPessoa;

    @NotNull
    @NotEmpty
    @Schema(description = "Nome da Pessoa", example = "Rafael Laz")
    private String nome;

    @NotNull
    @Past
    @Schema(description = "Data de nascimento da pessoa", example = "2003-09-29")
    private LocalDate dataNascimento;

    @NotNull
    @NotEmpty
    @Size(min = 11, max = 11)
    @Schema(description = "Cadastro de pessoa física", example = "11512635522")
    private String cpf;

    @Schema(description = "E-mail da pessoa", example = "pessoa@gmail.com")
    private String email;

    private Set<Contato> contatos;

    private Set<Pet> pets;

    private Set<Endereco> enderecos;
}
