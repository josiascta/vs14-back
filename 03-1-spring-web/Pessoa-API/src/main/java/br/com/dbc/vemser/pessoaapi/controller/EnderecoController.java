package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
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
    public Endereco create(@PathVariable("id") Integer id, @RequestBody Endereco endereco) {
        return enderecoService.create(endereco, id);
    }

    @PutMapping("{id}")
    public Endereco update(@PathVariable("id") Integer id,
                          @RequestBody Endereco enderecoAtualizar) {
        return enderecoService.update(id, enderecoAtualizar);
    }

    @DeleteMapping("/{id}") // DELETE localhost:8080/pessoa/10
    public void delete(@PathVariable("id") Integer id) {
        enderecoService.delete(id);
    }
}
