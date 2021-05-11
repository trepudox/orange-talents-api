package com.zup.orangetalents.controller;

import com.zup.orangetalents.model.Endereco;
import com.zup.orangetalents.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid Endereco e) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(e));
        } catch (IllegalArgumentException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
        }
    }

}
