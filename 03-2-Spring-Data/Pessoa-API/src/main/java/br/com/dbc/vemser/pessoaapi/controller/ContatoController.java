package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.documentation.ContatoControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
@Slf4j
public class ContatoController implements ContatoControllerDoc {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    @GetMapping("pessoa/{id}")
    public List<ContatoDTO> listByPersonId(@PathVariable(value = "id") Integer id) throws Exception {
        return contatoService.listByPersonId(id);
    }

    @PostMapping("pessoa/{id}")
    public ResponseEntity<ContatoDTO> create(@PathVariable("id") Integer id,
                                             @Valid @RequestBody ContatoCreateDTO contatoCreateDTO) throws Exception {
        log.info("Criando um novo contato...");
        return new ResponseEntity<>( contatoService.create(contatoCreateDTO, id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ContatoDTO> update(@PathVariable("id") Integer id,
                                             @Valid @RequestBody ContatoCreateDTO contatoCreateDTO) throws Exception {
        log.info("Editando um contato...");
        return new ResponseEntity<>(contatoService.update(id, contatoCreateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
        log.info("Deletado um contato...");
        return ResponseEntity.ok().build();
    }

    @GetMapping("{tipo}")
    public ResponseEntity<List<ContatoDTO>> buscarPorTipoContato(@PathVariable(value = "tipo") Integer tipoContato) {
        return new ResponseEntity<>( contatoService.buscarPorTipoContato(tipoContato), HttpStatus.OK);
    }

}
