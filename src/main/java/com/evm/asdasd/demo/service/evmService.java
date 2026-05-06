package com.evm.asdasd.demo.service;


import com.evm.asdasd.demo.model.evmModel;
import com.evm.asdasd.demo.repository.evmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class evmService {

    @Autowired
    private evmRepository  evmRepository;

    public List<evmModel> findAll() {
        return evmRepository.findAll();
    }

    public Optional<evmModel> findById(Long id) {
        return evmRepository.findById(id);
    }

    public evmModel cadastro(evmModel evmmodel) {
        return evmRepository.save(evmmodel);
    }

    public void  deleteById(Long id) {
        evmRepository.deleteById(id);
    }

    public evmModel atualizar(Long id,evmModel evmModel) {
        evmModel request = evmRepository.findById(id).get();
        request.setName(evmModel.getName());
        request.setIdade(evmModel.getIdade());
        request.setCpf(evmModel.getCpf());
        return evmRepository.save(request);

    }

}
