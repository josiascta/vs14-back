package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/hello") // GET localhost:8080/pessoa/hello
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/hello-2") // GET localhost:8080/pessoa/hello-2
    public String hello2() {
        return "Hello world 2!";
    }

    @GetMapping // GET localhost:8080/pessoa
    public ResponseEntity<List<Pessoa>> list() {
        return new ResponseEntity<>(pessoaService.list(), HttpStatus.OK);
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public List<Pessoa> listByName(@RequestParam(value = "nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @PostMapping // POST localhost:8080/pessoa
    public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa pessoa) throws Exception {
        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.OK);
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8080/pessoa/1000
    public ResponseEntity<Pessoa> update(@PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return new ResponseEntity<>(pessoaService.update(id, pessoaAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idPessoa}") // DELETE localhost:8080/pessoa/10
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
