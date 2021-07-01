package com.br.meli.bootcamp.spring.obter.diploma.entity;

import java.util.List;
import java.util.OptionalDouble;

public class Aluno {
    private String nome;
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
        OptionalDouble media = disciplinas.stream().mapToDouble(d -> d.getNota()).average();

        if (media.isPresent()) {
            return media.getAsDouble();
        }

        return -0.0;
    }
}
