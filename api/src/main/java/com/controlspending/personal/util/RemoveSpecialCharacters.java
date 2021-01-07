package com.controlspending.personal.util;

import java.text.Normalizer;

public class RemoveSpecialCharacters {

    public static String validate(String input) {
        String inputAscRemove = Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("[^ a-zA-Z0-9_-]", "").trim();
        return inputAscRemove;
    }
}
