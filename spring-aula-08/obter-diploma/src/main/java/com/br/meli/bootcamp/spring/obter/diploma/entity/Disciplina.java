package com.br.meli.bootcamp.spring.obter.diploma.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class Disciplina {
    @Valid
    @NotEmpty(message = "Subject is mandatory")
    @Size(min = 8, max = 50, message = "Subject must be between 8 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z ]*$")
    @JsonProperty("subject")
    private String nome;

    @Valid
    @NotNull(message = "Note is mandatory")
    @Range(min = 0, max = 10, message = "Note must be between 1 and 2 characters ando from 0 to 10")
    @JsonProperty("note")
    private Integer nota;

    public Disciplina(String nome, Integer nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}
