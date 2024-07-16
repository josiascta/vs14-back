package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Ajeitar o Post de contato

@RestController
@RequestMapping("/contato") // localhost:8080/contato
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
    public Contato create(@PathVariable("id") Integer id, @RequestBody Contato contato) {
        return contatoService.create(contato, id);
    }

    @PutMapping("{id}") // PUT localhost:8080/contato/1000
    public Contato update(@PathVariable("id") Integer id,
                         @RequestBody Contato contatoAtualizar) {
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}") // DELETE localhost:8080/pessoa/10
    public void delete(@PathVariable("idContato") Integer id) {
        contatoService.delete(id);
    }
}
