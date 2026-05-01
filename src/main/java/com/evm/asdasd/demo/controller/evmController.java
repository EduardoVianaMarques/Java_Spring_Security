package com.evm.asdasd.demo.controller;


import com.evm.asdasd.demo.model.evmModel;
import com.evm.asdasd.demo.repository.evmRepository;
import com.evm.asdasd.demo.service.evmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/evm")
public class evmController {

    @Autowired
    private evmService evmService;

    @GetMapping
    public ResponseEntity<List<evmModel>> findAll() {
        List<evmModel> requeste = evmService.findAll();
        return ResponseEntity.ok().body(requeste);
    }
    @PostMapping
    public ResponseEntity<evmModel> cadastroLivro(@RequestBody evmModel evmModel) {
        evmModel request = evmService.cadastro(evmModel);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        evmService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<evmModel> atualizar(@PathVariable Long id, @RequestBody evmModel evmModel) {
        evmModel evm = evmService.atualizar(id, evmModel);
        return ResponseEntity.ok().body(evm);
    }

}
