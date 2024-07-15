package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController() {
        contatoService = new ContatoService();
    }

    @GetMapping // GET localhost:8080/contato
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/{id}") // GET localhost:8080/contato/1
    public List<Contato> listByPersonId(@PathVariable(value = "id") Integer id) {
        return contatoService.listByPersonId(id);
    }

    @PostMapping // POST localhost:8080/contato
    public Contato create(@RequestBody Contato contato) {
        Contato contato1 = contatoService.create(contato);
        return contato1;
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8080/contato/1000
    public Contato update(@PathVariable("idPessoa") Integer id,
                         @RequestBody Contato contatoAtualizar) {
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}") // DELETE localhost:8080/pessoa/10
    public void delete(@PathVariable("idContato") Integer id) {
        contatoService.delete(id);
    }
}
