package com.zup.orangetalents.service;

import com.zup.orangetalents.model.Endereco;
import com.zup.orangetalents.model.Usuario;
import com.zup.orangetalents.repository.EnderecoRepository;
import com.zup.orangetalents.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Endereco save(Endereco e) {
        Optional<Usuario> u = usuarioRepository.findById(e.getUsuario().getCpf());
        if (!u.isPresent())
            throw new IllegalArgumentException("Não existe nenhum usuário com esse CPF!");

        return enderecoRepository.save(e);
    }

}
