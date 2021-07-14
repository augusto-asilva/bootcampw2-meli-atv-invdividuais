package com.br.meli.bootcamp.spring.obter.diploma.dto;

import com.br.meli.bootcamp.spring.obter.diploma.entity.Aluno;
import com.br.meli.bootcamp.spring.obter.diploma.entity.Disciplina;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.executable.ValidateOnExecution;
import java.util.List;
import java.util.OptionalDouble;

public class AlunoDTO {
    @NotEmpty(message = "Name is mandatory")
    @Size(min = 8, max = 50, message = "Name must be between 8 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z ]*$")
    private String nome;

    @NotNull(message = "Subjects is mandatory")
    @Valid
    @JsonProperty("subjects")
    private List<Disciplina> disciplinas;
    @JsonIgnore
    private Double media;

    public AlunoDTO() {
    }

    public AlunoDTO(Aluno aluno) {
        this.nome = aluno.getNome();
        this.media = aluno.media();
        this.disciplinas = aluno.getDisciplinas();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Double media() {
        return this.media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
