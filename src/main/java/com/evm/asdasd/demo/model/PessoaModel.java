package com.evm.asdasd.demo.model;


import com.evm.asdasd.demo.tiposUsuarios.TiposUsuarios;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String idade;
    private String cpf;

    @OneToMany
    private List<jobModel> jobModelList;


    public PessoaModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
