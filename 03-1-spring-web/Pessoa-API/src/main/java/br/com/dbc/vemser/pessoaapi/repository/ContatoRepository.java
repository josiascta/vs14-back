package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            long id = random.nextInt(900000000, 998952120);
            int pessoaId = random.nextInt(1, 6);
            int tipoContato = random.nextInt(1, 3);
            listaContatos.add(new Contato(COUNTER.incrementAndGet(), pessoaId, TipoContato.ofTipo(tipoContato), String.valueOf(id), "Número"));
        }
    }

    public Contato create(Contato contato) {
        Random random = new Random();
        Integer pessoaId = random.nextInt(1, 6);
        contato.setIdContato(COUNTER.incrementAndGet());
        contato.setIdPessoa(pessoaId);
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }


    public void delete(Integer id) {
        Contato contato = findById(id);
        listaContatos.remove(contato);
    }

    public List<Contato> listByPersonId(int id) {
        List<Contato> contatosDaPessoa = new ArrayList<>();
        for (Contato contato : listaContatos) {
            if (contato.getIdPessoa() == id) {
                contatosDaPessoa.add(contato);
            }
        }
        return contatosDaPessoa;
    }

    public Contato update(int id, Contato novosDados) {
        Contato contato = findById(id);
        contato.setIdPessoa(novosDados.getIdPessoa());
        contato.setTipoContato(novosDados.getTipoContato());
        contato.setDescricao(novosDados.getDescricao());
        contato.setNumero(novosDados.getNumero());
        return contato;

    }

    public Contato findById(int id) {
        Contato contatoRecuperado = null;
        for (Contato contato : listaContatos) {
            if (contato.getIdContato() == id) {
                contatoRecuperado = contato;
                return contatoRecuperado;
            }
        }
        return null;
    }
}
