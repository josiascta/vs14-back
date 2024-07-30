package br.com.dbc.vemser.pessoaapi.entity.pk;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
public class ProfessorPK implements Serializable {

    @Column(name = "id_professor")
    private Integer idProfessor;

    @Column(name = "id_universidade")
    private Integer idUniversidade;
}
