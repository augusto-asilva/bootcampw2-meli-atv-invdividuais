package com.br.meli.bootcamp.spring.obter.diploma;

import com.br.meli.bootcamp.spring.obter.diploma.dto.AlunoDTO;
import com.br.meli.bootcamp.spring.obter.diploma.dto.DiplomaResponseDTO;
import com.br.meli.bootcamp.spring.obter.diploma.entity.Disciplina;
import com.br.meli.bootcamp.spring.obter.diploma.service.DiplomaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CertificateServiceImplTest {

    private static DiplomaService service;

    private static List<DiplomaResponseDTO> diplomas;
    private static Validator validator;

    @BeforeAll
    static void init() {
        service = mock(DiplomaService.class);
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

        Mockito.when(service.analyzeNotes(alunoDTO)).thenReturn(true);
        boolean isNotesOk = service.analyzeNotes(alunoDTO);

        assertEquals(true, isNotesOk);
        assertNotEquals(false, isNotesOk);
    }

    @Test
    public void shouldAnalyzeNotesWithViolations(){
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Augus");
        alunoDTO.setDisciplinas(Arrays.asList(
                new Disciplina("Calc", 123),
                new Disciplina("Fis", 321)
        ));

        Mockito.when(service.analyzeNotes(alunoDTO)).thenReturn(false);
        boolean isNotesOk = service.analyzeNotes(alunoDTO);

        assertEquals(false, isNotesOk);
        assertNotEquals(true, isNotesOk);
    }

    @Test
    public void shouldCalculateAverage(){
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Augusto Alves");
        alunoDTO.setDisciplinas(Arrays.asList(
                new Disciplina("Calculo III", 5),
                new Disciplina("Fisica III", 6)
        ));

        Mockito.when(service.calculateAverage(alunoDTO)).thenReturn(5.5);
        Double avg = service.calculateAverage(alunoDTO);

        assertEquals(5.5, avg);
        assertNotEquals(6.0, avg);
    }

    @Test
    public void shouldWriteDiplomaSuccessfully() {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Augusto Alves");
        alunoDTO.setDisciplinas(Arrays.asList(
                new Disciplina("Calculo III", 8),
                new Disciplina("Fisica III", 7)
        ));

        Mockito.when(service.post(alunoDTO)).thenReturn(true);
        boolean hasSaved = service.post(alunoDTO);

        assertEquals(true, hasSaved);
        assertNotEquals(false, hasSaved);
    }

    @Test
    public void shouldWriteDiplomaUnSuccessfully() {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Augusto Alves");
        alunoDTO.setDisciplinas(Arrays.asList(
                new Disciplina("Calculo III", 6),
                new Disciplina("Fisica III", 5)
        ));

        Mockito.when(service.post(alunoDTO)).thenReturn(false);
        boolean hasSaved = service.post(alunoDTO);

        assertEquals(false, hasSaved);
        assertNotEquals(true, hasSaved);
    }

    @Test
    public void shouldWriteDiplomaWithHonor(){
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Augusto Alves");
        alunoDTO.setDisciplinas(Arrays.asList(
                new Disciplina("Calculo III", 10),
                new Disciplina("Fisica III", 9)
        ));

        Mockito.when(service.calculateAverage(alunoDTO)).thenReturn(9.5);
        double average = service.calculateAverage(alunoDTO);

        Mockito.when(service.getDiplomaWithHonor(average)).thenReturn(true);
        boolean hasHonor = service.getDiplomaWithHonor(average);

        assertEquals(true, hasHonor);
        assertNotEquals(false, hasHonor);
    }
}
