package com.br.meli.bootcamp.spring.obter.diploma;

import com.br.meli.bootcamp.spring.obter.diploma.dto.AlunoDTO;
import com.br.meli.bootcamp.spring.obter.diploma.dto.DimplomaResponseDTO;
import com.br.meli.bootcamp.spring.obter.diploma.entity.Disciplina;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CertificateServiceImplTest {

    private static List<DimplomaResponseDTO> diplomas;
    private static Validator validator;

    @BeforeAll
    static void init() {
        diplomas = new ArrayList<>();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void shouldAnalyzeNotesWithoutViolations(){
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Augusto Alves");
        alunoDTO.setDisciplinas(Arrays.asList(
                new Disciplina("Calculo III", 5),
                new Disciplina("Fisica III", 6)
        ));

        Set<ConstraintViolation<AlunoDTO>> violations = validator.validate(alunoDTO);

        assertEquals(0, violations.size());
        assertNotEquals(false, violations.isEmpty());
    }

    @Test
    public void shouldAnalyzeNotesWithViolations(){
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Augus");
        alunoDTO.setDisciplinas(Arrays.asList(
                new Disciplina("Calc", 123),
                new Disciplina("Fis", 321)
        ));

        Set<ConstraintViolation<AlunoDTO>> violations = validator.validate(alunoDTO);

        assertEquals(5, violations.size());
        assertNotEquals(true, violations.isEmpty());
    }

    @Test
    public void shouldCalculateAverage(){
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Augusto Alves");
        alunoDTO.setDisciplinas(Arrays.asList(
                new Disciplina("Calculo III", 5),
                new Disciplina("Fisica III", 6)
        ));

        Double avg = alunoDTO.media();

        assertEquals(5.5, avg);
        assertNotEquals(6.0, avg);
    }

    @Test
    public void shouldWriteDiplomaWithoutViolations() {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Augusto Alves");
        alunoDTO.setDisciplinas(Arrays.asList(
                new Disciplina("Calculo III", 8),
                new Disciplina("Fisica III", 7)
        ));

        DimplomaResponseDTO dimplomaResponseDTO = new DimplomaResponseDTO(alunoDTO.media(), alunoDTO);

        Set<ConstraintViolation<DimplomaResponseDTO>> violations = validator.validate(dimplomaResponseDTO);

        assertEquals(0, violations.size());
        assertNotEquals(false, violations.isEmpty());
    }

    @Test
    public void shouldWriteDiplomaWithViolations() {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Augusto Alves");
        alunoDTO.setDisciplinas(Arrays.asList(
                new Disciplina("Calculo III", 6),
                new Disciplina("Fisica III", 5)
        ));

        DimplomaResponseDTO dimplomaResponseDTO = new DimplomaResponseDTO(alunoDTO.media(), alunoDTO);

        Set<ConstraintViolation<DimplomaResponseDTO>> violations = validator.validate(dimplomaResponseDTO);

        assertEquals(1, violations.size());
        assertNotEquals(true, violations.isEmpty());
    }

    @Test
    public void shouldWriteDiplomaWithHonor(){
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Augusto Alves");
        alunoDTO.setDisciplinas(Arrays.asList(
                new Disciplina("Calculo III", 10),
                new Disciplina("Fisica III", 9)
        ));

        DimplomaResponseDTO dimplomaResponseDTO = new DimplomaResponseDTO(alunoDTO.media(), alunoDTO);

        boolean hasHonor = dimplomaResponseDTO.isWithHonor();

        assertEquals(true, hasHonor);
        assertNotEquals(false, hasHonor);
    }
}
