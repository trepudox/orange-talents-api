package com.zup.orangetalents.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "O campo logradouro não pode estar em branco")
    private String logradouro;

    @Column(nullable = false)
    @Min(value = 1, message = "Número inválido")
    private int numero;

    @Column(nullable = false)
    @NotBlank(message = "O campo complemento não pode estar em branco")
    private String complemento;

    @Column(nullable = false)
    @NotBlank(message = "O campo bairro não pode estar em branco")
    private String bairro;

    @Column(nullable = false)
    @NotBlank(message = "O campo cidade não pode estar em branco")
    private String cidade;

    @Column(nullable = false)
    @NotBlank(message = "O campo estado não pode estar em branco")
    private String estado;

    @Column(nullable = false)
    @NotBlank(message = "O campo CEP não pode estar em branco")
    private String cep;

    @Column(nullable = false)
    @NotBlank(message = "O campo nome do endereço não pode estar em branco")
    private String nomeEndereco;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties("listaEndereco")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNomeEndereco() {
        return nomeEndereco;
    }

    public void setNomeEndereco(String nomeEndereco) {
        this.nomeEndereco = nomeEndereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
