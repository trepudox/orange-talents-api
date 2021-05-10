package com.zup.orangetalents.service;

import com.zup.orangetalents.model.Endereco;
import com.zup.orangetalents.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public Endereco save(Endereco e) {
        return repository.save(e);
    }

}
