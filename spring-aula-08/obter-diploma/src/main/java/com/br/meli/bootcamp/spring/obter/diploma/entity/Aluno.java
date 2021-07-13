package com.br.meli.bootcamp.spring.obter.diploma.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.OptionalDouble;

public class Aluno {
    @JsonProperty("name")
    private String nome;
    @JsonProperty("subjects")
    private List<Disciplina> disciplinas;

    public Aluno(String nome, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
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

    public void adicionaDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public double media() {
        OptionalDouble media = disciplinas.stream().mapToDouble(d -> Double.valueOf(d.getNota())).average();

        if (media.isPresent()) {
            return media.getAsDouble();
        }

        return -0.0;
    }
}
