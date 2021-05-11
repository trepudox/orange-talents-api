package com.zup.orangetalents.service;

import com.zup.orangetalents.model.Usuario;
import com.zup.orangetalents.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario save(Usuario u) {
        if (repository.findById(u.getCpf()).isPresent())
            throw new IllegalArgumentException("Não foi possível registrar o usuário, o CPF informado já estava cadastrado!");
        if(repository.findByEmail(u.getEmail()).isPresent())
            throw new IllegalArgumentException("Não foi possível registrar o usuário, o email informado já estava cadastrado");

        return repository.save(u);
    }

    public Optional<Usuario> getByCpf(String cpf) {
        cpf = cpf.replace("-", "");
        cpf = cpf.replace(".", "");

        return repository.findById(cpf);
    }

}
