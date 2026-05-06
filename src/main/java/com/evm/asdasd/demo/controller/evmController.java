package com.evm.asdasd.demo.controller;


import com.evm.asdasd.demo.model.PessoaModel;
import com.evm.asdasd.demo.service.evmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/evm")
public class evmController {

    @Autowired
    private evmService evmService;

    @GetMapping
    public ResponseEntity<List<PessoaModel>> findAll() {
        List<PessoaModel> requeste = evmService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @GetMapping("/{id}")
    public Optional<PessoaModel> findById(@PathVariable Long id) {
        return evmService.findById(id);
    }

    @PostMapping
    public ResponseEntity<PessoaModel> cadastroLivro(@RequestBody PessoaModel PessoaModel) {
        PessoaModel request = evmService.cadastro(PessoaModel);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaModel> atualizar(@PathVariable Long id, @RequestBody PessoaModel pessoaModel) {
        PessoaModel pessoa = evmService.atualizar(id, pessoaModel);
        return ResponseEntity.ok().body(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        evmService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
