package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/paginacao")
@Validated
@Slf4j
public class PaginacaoController {

    private final ContatoService contatoService;
    private final EnderecoService enderecoService;

    @GetMapping("/contato")
    public Page<ContatoDTO> paginarContatoCres(@RequestParam(value = "pagina", required = false, defaultValue = "0") Integer pagina,
                                               @RequestParam(value = "tamanho", required = false, defaultValue = "10") Integer tamanho) {
        return contatoService.paginarContatoCres(pagina, tamanho);
    }


//    @GetMapping("/contato")
//    public Page<ContatoDTO> paginarEndereco(@RequestParam(value = "pagina", required = false, defaultValue = "0") Integer pagina,
//                                               @RequestParam(value = "tamanho", required = false, defaultValue = "10") Integer tamanho) {
//        return contatoService.paginarContatoCres(pagina, tamanho);
//    }
}
