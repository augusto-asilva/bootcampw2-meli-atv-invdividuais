package br.com.meli.bootcamp.star.wars.controller;

import br.com.meli.bootcamp.star.wars.domain.Character;
import br.com.meli.bootcamp.star.wars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("starwars/")
public class CharacterController {

    @Autowired
    private CharacterService service;

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Character> getCharactersByName(@PathVariable String name){
        return service.getCharactersByName(name);
    }
}
