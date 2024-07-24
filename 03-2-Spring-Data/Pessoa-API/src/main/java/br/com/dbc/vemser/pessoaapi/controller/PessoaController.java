package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.PropertieReader;
import br.com.dbc.vemser.pessoaapi.documentation.PessoaControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController implements PessoaControllerDoc {

    private final PessoaService pessoaService;
    private final PropertieReader propertieReader;

    @GetMapping("/hello") // GET localhost:8080/pessoa/hello
    public String hello() {
        return "Hello world!" + propertieReader.getApp() + ": " + propertieReader.getAmbiente();
    }

    @GetMapping("/hello-2") // GET localhost:8080/pessoa/hello-2
    public String hello2() {
        return "Hello world 2!";
    }

    @GetMapping // GET localhost:8080/pessoa
    public ResponseEntity<List<PessoaDTO>> list() {
        return new ResponseEntity<>(pessoaService.list(), HttpStatus.OK);
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam(value = "nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @PostMapping // POST localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        log.info("Criando uma nova pessoa...");
        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.OK);
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                            @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("Editando uma pessoa...");
        return new ResponseEntity<>(pessoaService.update(id, pessoaAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idPessoa}") // DELETE localhost:8080/pessoa/10
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        log.info("Deletando uma pessoa...");
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/periodo") //GET localhost:8080/pessoa/periodo?dataInicial=2023-01-01&dataFinal=2023-12-31
    public ResponseEntity<List<PessoaDTO>> buscarPessoasPorPeriodo(
            @RequestParam("dataInicial") LocalDate dataInicial,
            @RequestParam("dataFinal") LocalDate dataFinal) {
        return new ResponseEntity<>(pessoaService.buscarPessoasPorPeriodo(dataInicial, dataFinal), HttpStatus.OK);

    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PessoaDTO> buscarPessoaPorCpf(
            @PathVariable("cpf") String cpf) {
        return new ResponseEntity<>(pessoaService.buscarPessoaCpf(cpf), HttpStatus.OK);
    }

}
