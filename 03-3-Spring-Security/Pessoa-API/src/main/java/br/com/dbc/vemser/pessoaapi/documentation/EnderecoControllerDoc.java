package br.com.dbc.vemser.pessoaapi.documentation;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


public interface EnderecoControllerDoc {

    @Operation(summary = "Listar endereços", description = "Lista todos os endereços do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<EnderecoDTO> list();

    @Operation(summary = "Listar endereços pelo id da pessoa", description = "Listar endereços pelo id da pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Listar endereços pelo id da pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("pessoa/{id}")
    public List<EnderecoDTO> listByPersonId(@PathVariable(value = "id") Integer id);

    @Operation(summary = "Cria um endereço", description = "Cria um novo endereço")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna um novo endereço"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("pessoa/{id}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("id") Integer id,
                                              @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception;

    @Operation(summary = "Lista um endereço pelo id", description = "Lista um endereço pelo id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista um endereço pelo id"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("{id}")
    public EnderecoDTO findById(@PathVariable(value = "id") Integer id) throws Exception;

    @Operation(summary = "Atualiza dados do endereço", description = "Atualiza dados do endereço")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Atualiza um endereço"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("{id}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("id") Integer id,
                                              @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws Exception;


    @Operation(summary = "Deleta um endereço", description = "Deleta um endereço")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta um endereço"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception;
}
