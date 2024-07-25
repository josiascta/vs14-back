package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.PropertieReader;
import br.com.dbc.vemser.pessoaapi.documentation.PessoaControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import br.com.dbc.vemser.pessoaapi.service.PetService;
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
@RequestMapping("/pet") // localhost:8080/pessoa
public class PetController {

    private final PetService petService;
    private final PropertieReader propertieReader;

    @GetMapping
    public ResponseEntity<List<PetDTO>> list() {
        return new ResponseEntity<>(petService.list(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PetDTO> create(@Valid @RequestBody PetCreateDTO petCreateDTO) throws Exception {
        log.info("Criando um novo pet...");
        return new ResponseEntity<>(petService.create(petCreateDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDTO> update(@PathVariable("id") Integer id,
                                            @Valid @RequestBody PetCreateDTO petAtualizar) throws Exception {
        log.info("Editando um pet...");
        return new ResponseEntity<>(petService.update(id, petAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        log.info("Deletando um pet...");
        petService.delete(id);
        return ResponseEntity.ok().build();
    }

}
