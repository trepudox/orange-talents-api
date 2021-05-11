package com.zup.orangetalents.controller;

import com.zup.orangetalents.model.Usuario;
import com.zup.orangetalents.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid Usuario u) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(u));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar usuário\nErro: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping("/{cpf}")
    public ResponseEntity<?> getByCpf(@PathVariable String cpf) {
        Optional<Usuario> u = service.getByCpf(cpf);

        if (u.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(u);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuário foi encontrado com esse CPF.");
        }

    }

}
