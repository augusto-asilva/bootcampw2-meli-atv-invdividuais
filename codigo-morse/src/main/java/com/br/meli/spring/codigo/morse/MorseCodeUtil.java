package com.br.meli.spring.codigo.morse;

public class MorseCodeUtil {
    private static char[] letters = {'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0'};
    private static String[] codes = {".-", "-...", "-.-.", "-..", ".",
            "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--",
            "--..", "|"};
    public MorseCodeUtil() { }

    public static String parseToMorseCode(String morseCode) {
        String[] array = morseCode.split(" ");
        StringBuilder sb = new StringBuilder();

        // Morse code to text
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < codes.length; j++) {
                if (array[i].compareTo(codes[j]) == 0) {
                    sb.append((char)(j + 'a'));
                    break;
                }
            }
        }

        return sb.toString();
    }
}
