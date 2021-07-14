package com.br.meli.bootcamp.spring.obter.diploma;

import com.br.meli.bootcamp.spring.obter.diploma.dto.AlunoDTO;
import com.br.meli.bootcamp.spring.obter.diploma.dto.DiplomaResponseDTO;
import com.br.meli.bootcamp.spring.obter.diploma.service.DiplomaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DiplomaController {

    @Autowired
    private DiplomaService service;

//    @RequestMapping(path = "/diploma", method = RequestMethod.POST)
//    public ResponseEntity<DimplomaResponseDTO> geraDiploma(@RequestBody Aluno aluno) {
//        DimplomaResponseDTO diplomaResponse = new DimplomaResponseDTO(aluno.media(), aluno);
//        return new ResponseEntity<>(diplomaResponse, HttpStatus.CREATED);
//    }

    @PostMapping(path = "/analyzeNotes")
    public ResponseEntity<String> analyzeNotes(@Valid @RequestBody AlunoDTO alunoDTO) {
        boolean isNotesOk = service.analyzeNotes(alunoDTO);
        if (isNotesOk) {
            return new ResponseEntity<>("{ \"message\": \"Dados do aluno validos\"}", HttpStatus.OK);
        }
        return new ResponseEntity<>("{ \"message\": \"Dados do aluno invalidos\"}", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/calculate-average")
    public ResponseEntity<String> calculateAverage(@Valid @RequestBody AlunoDTO alunoDTO) throws JsonProcessingException {
        double average = service.calculateAverage(alunoDTO);
        ObjectMapper mapper = new ObjectMapper();
        String alunoStr = mapper.writeValueAsString(alunoDTO);
        return new ResponseEntity<>("{ \"average\": " + alunoStr + "," +
                "\"average\": \"" + average +"\"}", HttpStatus.OK);
    }

    @PostMapping(path = "/diploma-honored")
    public ResponseEntity<DiplomaResponseDTO> writeDiplomaWithHonor(@Valid @RequestBody AlunoDTO alunoDTO) throws JsonProcessingException {
        DiplomaResponseDTO response = service.postWithResponse(alunoDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
