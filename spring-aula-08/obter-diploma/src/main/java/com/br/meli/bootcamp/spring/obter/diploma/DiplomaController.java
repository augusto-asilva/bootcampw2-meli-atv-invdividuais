package com.br.meli.bootcamp.spring.obter.diploma;

import com.br.meli.bootcamp.spring.obter.diploma.dto.AlunoDTO;
import com.br.meli.bootcamp.spring.obter.diploma.dto.DimplomaResponseDTO;
import com.br.meli.bootcamp.spring.obter.diploma.entity.Aluno;
import com.br.meli.bootcamp.spring.obter.diploma.entity.Diploma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DiplomaController {

//    @RequestMapping(path = "/diploma", method = RequestMethod.POST)
//    public ResponseEntity<DimplomaResponseDTO> geraDiploma(@RequestBody Aluno aluno) {
//        DimplomaResponseDTO diplomaResponse = new DimplomaResponseDTO(aluno.media(), aluno);
//        return new ResponseEntity<>(diplomaResponse, HttpStatus.CREATED);
//    }

    @PostMapping(path = "/analyzeNotes")
    public ResponseEntity<DimplomaResponseDTO> analyzeNotes(@Valid @RequestBody AlunoDTO alunoDTO) {
        DimplomaResponseDTO diplomaResponse = new DimplomaResponseDTO(alunoDTO.media(), alunoDTO);
        return new ResponseEntity<>(diplomaResponse, HttpStatus.CREATED);
    }
}
