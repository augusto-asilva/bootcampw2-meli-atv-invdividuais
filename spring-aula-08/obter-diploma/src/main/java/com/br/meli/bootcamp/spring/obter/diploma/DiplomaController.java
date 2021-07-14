package com.br.meli.bootcamp.spring.obter.diploma;

import com.br.meli.bootcamp.spring.obter.diploma.dto.AlunoDTO;
import com.br.meli.bootcamp.spring.obter.diploma.dto.DiplomaResponseDTO;
import com.br.meli.bootcamp.spring.obter.diploma.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DiplomaController {

    @Autowired
    private DiplomaService SERVICE;

//    @RequestMapping(path = "/diploma", method = RequestMethod.POST)
//    public ResponseEntity<DimplomaResponseDTO> geraDiploma(@RequestBody Aluno aluno) {
//        DimplomaResponseDTO diplomaResponse = new DimplomaResponseDTO(aluno.media(), aluno);
//        return new ResponseEntity<>(diplomaResponse, HttpStatus.CREATED);
//    }

    @PostMapping(path = "/analyzeNotes")
    public ResponseEntity<DiplomaResponseDTO> analyzeNotes(@Valid @RequestBody AlunoDTO alunoDTO) {
        DiplomaResponseDTO diplomaResponse = new DiplomaResponseDTO(alunoDTO.media(), alunoDTO);
        return new ResponseEntity<>(diplomaResponse, HttpStatus.CREATED);
    }
}
