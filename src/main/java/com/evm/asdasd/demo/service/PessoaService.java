package com.evm.asdasd.demo.service;


import com.evm.asdasd.demo.model.PessoaModel;
import com.evm.asdasd.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaModel> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<PessoaModel> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    public PessoaModel cadastro(PessoaModel pessoaModel) {
        return pessoaRepository.save(pessoaModel);
    }

    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }

    public PessoaModel atualizar(Long id, PessoaModel pessoaModel) {
        PessoaModel request = pessoaRepository.findById(id).get();
        request.setName(pessoaModel.getName());
        request.setIdade(pessoaModel.getIdade());
        request.setCpf(pessoaModel.getCpf());
        return pessoaRepository.save(request);

    }

}
