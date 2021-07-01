package com.br.meli.bootcamp.spring.obter.diploma.entity;

import java.util.UUID;

public class Diploma {

    private UUID chaveUnica;
    private String aluno;
    private double media;

    public Diploma(Aluno aluno) {
        this.aluno = aluno.getNome();
        this.media = aluno.media();
        this.chaveUnica = UUID.randomUUID();
    }

    public UUID getChaveUnica() {
        return chaveUnica;
    }

    public void setChaveUnica(UUID chaveUnica) {
        this.chaveUnica = chaveUnica;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
