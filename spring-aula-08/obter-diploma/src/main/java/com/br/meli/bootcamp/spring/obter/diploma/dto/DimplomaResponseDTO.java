package com.br.meli.bootcamp.spring.obter.diploma.dto;

import com.br.meli.bootcamp.spring.obter.diploma.entity.Aluno;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class DimplomaResponseDTO {
    private String message;
    @Range(min = 6, max = 10)
    private Double average;
    @JsonProperty("student")
    private AlunoDTO alunoDto;
    @JsonIgnore
    private boolean withHonor = false;

    public DimplomaResponseDTO() {
    }


    public DimplomaResponseDTO(Double average, AlunoDTO alunoDTO) {
        String avg_str = String.format("%.1f", average);

        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        Number number = 0.0;
        try {
            number = format.parse(avg_str);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        this.message = "Sua média foi de " + avg_str;
        this.average = number.doubleValue();
        this.alunoDto = alunoDTO;

        if (this.average > 9) {
            withHonor = true;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public AlunoDTO getAlunoDto() {
        return alunoDto;
    }

    public void setAlunoDto(AlunoDTO alunoDto) {
        this.alunoDto = alunoDto;
    }

    public boolean isWithHonor() {
        return withHonor;
    }

    public void setWithHonor(boolean withHonor) {
        this.withHonor = withHonor;
    }
}
