package br.com.meli.bootcamp.star.wars.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import br.com.meli.bootcamp.star.wars.domain.Character;

import java.io.IOException;

public class DeserealizerCustom extends StdDeserializer<Character> {

    public DeserealizerCustom() {
        this(null);
    }

    protected DeserealizerCustom(Class<?> vc) {
        super(vc);
    }

    @Override
    public Character deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);

        String name = node.get("name").asText();

        int height;
        if (node.get("height").asText().matches("[0-9]"))
            height  = (Integer) ((IntNode) node.get("height")).numberValue();
        else
            height = 0;

        int mass;

        if (node.get("mass").asText().matches("[0-9]"))
            mass = (Integer) ((IntNode) node.get("mass")).numberValue();
        else
            mass = 0;

        String hair_color = node.get("hair_color").asText();
        String skin_color = node.get("skin_color").asText();
        String eye_color = node.get("eye_color").asText();
        String birth_year = node.get("birth_year").asText();
        String gender = node.get("gender").asText();
        String homeworld = node.get("homeworld").asText();
        String species = node.get("species").asText();

        return new Character(name,height,mass,hair_color,skin_color,eye_color,birth_year,gender,homeworld,species);
    }
}
