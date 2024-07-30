package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contato")
    @SequenceGenerator(name = "seq_contato", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "id_contato")
    private Integer idContato;

    @Column(name = "tipo")
    private TipoContato tipoContato;

    @Column(name = "numero")
    private String numero;

    @Column(name = "descricao")
    private String descricao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private Pessoa pessoa;
}
