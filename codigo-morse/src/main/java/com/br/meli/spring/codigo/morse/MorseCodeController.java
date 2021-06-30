package com.br.meli.spring.codigo.morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseCodeController {

    @GetMapping("/translate-morse/{morseCode}")
    public String parseMorseCodeToText(@PathVariable String morseCode){

        String translatedMorseCode = MorseCodeUtil.parseToMorseCode(morseCode);
        return "{\"inputMorseCode\":\"" + morseCode + "\"" + " translatedCode: \"" + translatedMorseCode + "\"}";
    }
}
