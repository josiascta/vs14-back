package br.com.dbc.vemser.pessoaapi.documentation;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCompletoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


public interface PessoaControllerDoc {

    @Operation(summary = "Listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping // GET localhost:8080/pessoa
    public ResponseEntity<List<PessoaCompletoDTO>> list();

    @Operation(summary = "Cria a pessoa", description = "Cria uma nova pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cria uma nova pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping // POST localhost:8080/pessoa
    public ResponseEntity<PessoaCompletoDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception;


    @Operation(summary = "Atualiza dados da pessoa", description = "Atualiza dados da pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Atualiza uma pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}") // PUT localhost:8080/pessoa/1000
    public ResponseEntity<PessoaCompletoDTO> update(@PathVariable("idPessoa") Integer id,
                                                    @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception;

    @Operation(summary = "Deleta uma pessoa", description = "Deleta uma pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta uma pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPessoa}") // DELETE localhost:8080/pessoa/10
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception;
}
