package br.com.dbc.vemser.pessoaapi.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaCreateDTO {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @Past
    private LocalDate dataNascimento;

    @NotNull
    @NotEmpty
    @Size(min = 11, max = 11)
    private String cpf;

    private String email;


}
