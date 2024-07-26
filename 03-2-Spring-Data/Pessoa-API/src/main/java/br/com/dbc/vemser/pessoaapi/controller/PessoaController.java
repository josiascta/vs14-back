package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.PropertieReader;
import br.com.dbc.vemser.pessoaapi.documentation.PessoaControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.PessoaComPetsDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCompletoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaPersonalizadoDTO;
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

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!" + propertieReader.getApp() + ": " + propertieReader.getAmbiente();
    }

    @GetMapping("/hello-2")
    public String hello2() {
        return "Hello world 2!";
    }

    @GetMapping
    public ResponseEntity<List<PessoaCompletoDTO>> list() {
        return new ResponseEntity<>(pessoaService.list(), HttpStatus.OK);
    }

    @GetMapping("/byname")
    public List<PessoaCompletoDTO> listByName(@RequestParam(value = "nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @PostMapping
    public ResponseEntity<PessoaCompletoDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        log.info("Criando uma nova pessoa...");
        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.OK);
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaCompletoDTO> update(@PathVariable("idPessoa") Integer id,
                                                    @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("Editando uma pessoa...");
        return new ResponseEntity<>(pessoaService.update(id, pessoaAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        log.info("Deletando uma pessoa...");
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/p")
    public ResponseEntity<List<PessoaCompletoDTO>> buscarPessoasPorPeriodo(
            @RequestParam("dataInicial") String dataInicial,
            @RequestParam("dataFinal") String dataFinal) {
        LocalDate dataInicialLocalDate = LocalDate.parse(dataInicial);
        LocalDate dataFinalLocalDate = LocalDate.parse(dataFinal);

        return new ResponseEntity<>(pessoaService.buscarPessoasPorPeriodo(dataInicialLocalDate, dataFinalLocalDate), HttpStatus.OK);

    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PessoaCompletoDTO> buscarPessoaPorCpf(
            @PathVariable("cpf") String cpf) {
        return new ResponseEntity<>(pessoaService.buscarPessoaCpf(cpf), HttpStatus.OK);
    }

    @RequestMapping("/com-enderecos")
    public ResponseEntity<List<PessoaCompletoDTO>> pessoaComEndereco(@RequestParam(name = "id_pessoa", required = false) Integer id_pessoa) throws Exception {
        return new ResponseEntity<>(pessoaService.listPessoaComEndereco(id_pessoa), HttpStatus.OK);
    }

    @RequestMapping("/com-contatos")
    public ResponseEntity<List<PessoaCompletoDTO>> pessoaComContatos(@RequestParam(name = "id_pessoa", required = false) Integer id_pessoa) throws Exception {
        return new ResponseEntity<>(pessoaService.listPessoaComContato(id_pessoa), HttpStatus.OK);
    }

    @RequestMapping("/com-pets")
    public ResponseEntity<List<PessoaComPetsDTO>> pessoaComPets(@RequestParam(name = "id_pessoa", required = false) Integer id_pessoa) throws Exception {
        return new ResponseEntity<>(pessoaService.listPessoaComPet(id_pessoa), HttpStatus.OK);
    }

    @RequestMapping("/pessoa-completo")
    public ResponseEntity<List<PessoaCompletoDTO>> pessoaCompleto(@RequestParam(name = "id_pessoa", required = false) Integer id_pessoa) throws Exception {
        return new ResponseEntity<>(pessoaService.listPessoaCompleto(id_pessoa), HttpStatus.OK);
    }

    @RequestMapping("/pessoa-personalizada")
    public ResponseEntity<List<PessoaPersonalizadoDTO>> pessoaCompleto() throws Exception {
        return new ResponseEntity<>(pessoaService.listPessoaPersonalizada(), HttpStatus.OK);
    }
}
