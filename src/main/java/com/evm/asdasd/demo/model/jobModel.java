package com.evm.asdasd.demo.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TBL_Job")
public class jobModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String nome;

    private List<PessoaModel> funcionario ;


    public jobModel() {
    }

    public List<PessoaModel> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<PessoaModel> funcionario) {
        this.funcionario = funcionario;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
