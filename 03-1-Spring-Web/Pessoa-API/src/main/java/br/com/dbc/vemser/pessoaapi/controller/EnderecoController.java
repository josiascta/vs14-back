package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.documentation.EnderecoControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
@Slf4j
public class EnderecoController implements EnderecoControllerDoc {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

    @GetMapping("pessoa/{id}")
    public List<EnderecoDTO> listByPersonId(@PathVariable(value = "id") Integer id) {
        return enderecoService.listByPersonId(id);
    }

    @GetMapping("{id}")
    public EnderecoDTO findById(@PathVariable(value = "id") Integer id) throws Exception {
        return enderecoService.findById(id);
    }

    @PostMapping("pessoa/{id}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("id") Integer id,
                                         @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        log.info("Criando um novo endereço...");
        return new ResponseEntity<>(enderecoService.create(endereco, id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("id") Integer id,
                           @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws Exception {
        log.info("Editando um endereço...");
        return new ResponseEntity<>(enderecoService.update(id, enderecoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // DELETE localhost:8080/pessoa/10
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        log.info("Deletando um endereço...");
        enderecoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
