package com.br.meli.bootcamp.spring.obter.diploma;

import com.br.meli.bootcamp.spring.obter.diploma.entity.Aluno;
import com.br.meli.bootcamp.spring.obter.diploma.entity.Diploma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiplomaController {

    @RequestMapping(path = "/diploma", method = RequestMethod.POST)
    public ResponseEntity<Diploma> geraDiploma(@RequestBody Aluno aluno) {
        Diploma diploma = new Diploma(aluno);
        return new ResponseEntity<>(diploma, HttpStatus.CREATED);
    }
}
