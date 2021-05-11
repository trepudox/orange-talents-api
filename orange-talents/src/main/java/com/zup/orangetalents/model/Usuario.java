package com.zup.orangetalents.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @Column(nullable = false, unique = true)
    @CPF(message = "CPF inválido!")
    @NotBlank(message = "O campo CPF não pode estar em branco")
    private String cpf;

    @Column(nullable = false)
    @NotBlank(message = "O campo nome não pode estar em branco")
    private String nome;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "O campo email não pode estar em branco")
    private String email;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "usuario")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties("usuario")
    private List<Endereco> listaEndereco;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        cpf = cpf.replace("-", "");
        cpf = cpf.replace(".", "");

        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

}
