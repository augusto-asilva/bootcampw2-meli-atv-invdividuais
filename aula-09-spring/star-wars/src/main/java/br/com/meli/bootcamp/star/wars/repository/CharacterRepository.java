package br.com.meli.bootcamp.star.wars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.com.meli.bootcamp.star.wars.domain.Character;

@Repository
public class CharacterRepository {

    private static final String STAR_WARS_FILE = "starwars.json";

    private File getJson(String fileName) throws FileNotFoundException {
        File file = null;
        file = ResourceUtils.getFile("classpath:" + fileName);
        return file;
    }

    public List<Character> getCharactersByName(String name) {
        return this.getCharactes()
                .stream()
                .filter(x -> x.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    private List<Character> getCharactes() {
        List<Character> characters = null;
        try {
            File file = this.getJson(STAR_WARS_FILE);
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Character>> typeRef = new TypeReference<>() {
            };
            characters = mapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
