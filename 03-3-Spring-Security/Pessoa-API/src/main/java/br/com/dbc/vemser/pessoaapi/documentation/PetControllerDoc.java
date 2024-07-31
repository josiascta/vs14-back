package br.com.dbc.vemser.pessoaapi.documentation;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


public interface PetControllerDoc {

    @Operation(summary = "Lista contatos", description = "Lista contatos")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<ContatoDTO> list();

    @Operation(summary = "Lista contatos pelo id de pessoa", description = "Lista contatos pelo id de pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista contatos pelo id de pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("pessoa/{id}")
    public List<ContatoDTO> listByPersonId(@PathVariable(value = "id") Integer id) throws Exception;


    @Operation(summary = "Cria um contato", description = "Cria um contato")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cria um contato"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("pessoa/{id}")
    public ResponseEntity<ContatoDTO> create(@PathVariable("id") Integer id,
                                             @Valid @RequestBody ContatoCreateDTO contatoCreateDTO) throws Exception;

    @Operation(summary = "Atualiza um contato", description = "Atualiza um contato")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Atualiza um contato"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("{id}")
    public ResponseEntity<ContatoDTO> update(@PathVariable("id") Integer id,
                                             @Valid @RequestBody ContatoCreateDTO contatoCreateDTO) throws Exception;

    @Operation(summary = "Deleta um contato", description = "Deleta um contato")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta um contato"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer id) throws Exception;
}
