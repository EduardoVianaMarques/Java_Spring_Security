package com.evm.asdasd.demo.service;


import com.evm.asdasd.demo.model.evmModel;
import com.evm.asdasd.demo.repository.evmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class evmService {

    @Autowired
    private evmRepository  evmRepository;

    public List<evmModel> findAll() {
        return evmRepository.findAll();
    }

    public evmModel findById(long id) {
        return evmRepository.findById(id).orElse(null);
    }

    public evmModel cadastro(evmModel evmmodel) {
        return evmRepository.save(evmmodel);
    }

    public void  deleteById(Long id) {
        evmRepository.deleteById(id);
    }

    public evmModel atualizar(Long id,evmModel evmmodel) {
        evmModel newevm = evmRepository.findById(id).get();
        newevm.setName(evmmodel.getName());
        return evmRepository.save(newevm);

    }

}
