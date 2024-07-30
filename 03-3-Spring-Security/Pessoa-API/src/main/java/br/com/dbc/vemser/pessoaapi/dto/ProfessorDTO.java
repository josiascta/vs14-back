package br.com.dbc.vemser.pessoaapi.dto;
import br.com.dbc.vemser.pessoaapi.entity.pk.ProfessorPK;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {

    @EmbeddedId
    @JsonProperty("professorChave")
    private ProfessorPK professorPK;

    @Column(name = "nome")
    private String nome;

    @Column(name = "salario")
    private Double salario;
}
