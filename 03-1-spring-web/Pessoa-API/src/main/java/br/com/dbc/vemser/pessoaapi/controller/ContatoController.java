package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//Ajeitar o Post de contato

@RestController
@RequestMapping("/contato") // localhost:8080/contato
@Validated
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping // GET localhost:8080/contato
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("pessoa/{id}") // GET localhost:8080/contato/1
    public List<Contato> listByPersonId(@PathVariable(value = "id") Integer id) {
        return contatoService.listByPersonId(id);
    }

    @PostMapping("pessoa/{id}") // POST localhost:8080/contato/pessoa/id
    public ResponseEntity<Contato> create(@PathVariable("id") Integer id,
                          @Valid @RequestBody Contato contato) throws Exception {
        return new ResponseEntity<>( contatoService.create(contato, id), HttpStatus.OK);
    }

    @PutMapping("{id}") // PUT localhost:8080/contato/1000
    public ResponseEntity<Contato> update(@PathVariable("id") Integer id,
                         @Valid @RequestBody Contato contatoAtualizar) throws Exception {
        return new ResponseEntity<>(contatoService.update(id, contatoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idContato}") // DELETE localhost:8080/pessoa/10
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
