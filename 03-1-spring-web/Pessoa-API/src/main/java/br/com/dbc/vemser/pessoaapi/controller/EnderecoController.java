package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
public class EnderecoController {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("pessoa/{id}")
    public List<Endereco> listByPersonId(@PathVariable(value = "id") Integer id) {
        return enderecoService.listByPersonId(id);
    }

    @GetMapping("{id}")
    public Endereco findById(@PathVariable(value = "id") Integer id) {
        return enderecoService.findById(id);
    }

    @PostMapping("pessoa/{id}")
    public ResponseEntity<Endereco> create(@PathVariable("id") Integer id,
                                         @Valid @RequestBody Endereco endereco) throws Exception {
        return new ResponseEntity<>(enderecoService.create(endereco, id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Endereco> update(@PathVariable("id") Integer id,
                           @Valid @RequestBody Endereco enderecoAtualizar) throws Exception {
        return new ResponseEntity<>(enderecoService.update(id, enderecoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // DELETE localhost:8080/pessoa/10
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        enderecoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
