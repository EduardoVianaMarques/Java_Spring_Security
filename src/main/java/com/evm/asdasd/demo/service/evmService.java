package com.evm.asdasd.demo.service;


import com.evm.asdasd.demo.model.PessoaModel;
import com.evm.asdasd.demo.repository.evmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class evmService {

    @Autowired
    private evmRepository  evmRepository;

    public List<PessoaModel> findAll() {
        return evmRepository.findAll();
    }

    public Optional<PessoaModel> findById(Long id) {
        return evmRepository.findById(id);
    }

    public PessoaModel cadastro(PessoaModel pessoaModel) {
        return evmRepository.save(pessoaModel);
    }

    public void  deleteById(Long id) {
        evmRepository.deleteById(id);
    }

    public PessoaModel atualizar(Long id, PessoaModel pessoaModel) {
        PessoaModel request = evmRepository.findById(id).get();
        request.setName(pessoaModel.getName());
        request.setIdade(pessoaModel.getIdade());
        request.setCpf(pessoaModel.getCpf());
        return evmRepository.save(request);

    }

}
