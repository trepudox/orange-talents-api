package com.zup.orangetalents.service;

import com.zup.orangetalents.model.Usuario;
import com.zup.orangetalents.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

        // TODO: validador de cpf
        System.out.println("\npassoooou!!!\n");

        return repository.save(u);

    }

    public Optional<Usuario> getByCpf(String cpf) {
        cpf = cpf.replace("-", "");
        cpf = cpf.replace(".", "");

        try {
            Long cpfEmNumero = Long.valueOf(cpf);
            return repository.findById(cpfEmNumero);
        } catch (NumberFormatException e) {
            throw new MethodArgumentTypeMismatchException(cpf, Long.class, "erro", null, e);
        }

    }

    private boolean validaCpf(Long cpf) {
        return true;
    }
}
