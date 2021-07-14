package com.br.meli.bootcamp.spring.obter.diploma;

import com.br.meli.bootcamp.spring.obter.diploma.dto.AlunoDTO;
import com.br.meli.bootcamp.spring.obter.diploma.entity.Disciplina;
import com.br.meli.bootcamp.spring.obter.diploma.service.DiplomaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class CertificateControllerTest {

    @Autowired
    MockMvc mvc;

    ObjectMapper mapper;

    @BeforeEach
    void setup() {
        mapper = new ObjectMapper();
    }

    @Test
    void shouldAnalyzeDiplomaEndpoint() throws Exception {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Augusto Alves");
        alunoDTO.setDisciplinas(Arrays.asList(
                new Disciplina("Calculo III", 5),
                new Disciplina("Fisica III", 6)
        ));

        mvc.perform(post("/analyzeNotes")
                .contentType("application/json")
                .content(mapper.writeValueAsString(alunoDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldCalculateAverageEndpoint() throws Exception {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Augusto Alves");
        alunoDTO.setDisciplinas(Arrays.asList(
                new Disciplina("Calculo III", 5),
                new Disciplina("Fisica III", 6)
        ));

        mvc.perform(post("/calculate-average")
                .contentType("application/json")
                .content(mapper.writeValueAsString(alunoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.average", is("5.5")));
    }

    @Test
    void shouldWriteDiplomaWithHonorEndpoint() throws Exception {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNome("Augusto Alves");
        alunoDTO.setDisciplinas(Arrays.asList(
                new Disciplina("Calculo III", 10),
                new Disciplina("Fisica III", 9)
        ));

        mvc.perform(post("/diploma-honored")
                .contentType("application/json")
                .content(mapper.writeValueAsString(alunoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.average", is(9.5)))
                .andExpect(jsonPath("$.withHonor", is(true)));
    }


}
