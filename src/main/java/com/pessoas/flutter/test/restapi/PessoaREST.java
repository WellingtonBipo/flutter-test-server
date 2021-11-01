package com.pessoas.flutter.test.restapi;

import java.util.List;

import com.pessoas.flutter.test.restapi.database.RepositorioPessoa;

import com.pessoas.flutter.test.restapi.entity.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PessoaREST {

    @Autowired
    private RepositorioPessoa repositorio;

    @GetMapping
    public List<Pessoa> listar() {
        return repositorio.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody Pessoa pessoa) {
        repositorio.save(pessoa);
    }

    @PutMapping
    public void alterar(@RequestBody Pessoa pessoa) {
        if (pessoa.getId() > 0)
            repositorio.save(pessoa);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id){
        Pessoa p = repositorio.getById(id);
        repositorio.delete(p);
    }

}
