package org.example.game;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessWord {
    protected final String word;

    public GuessWord(String word) {
        this.word = word;
    }

    public List<Integer> letterExist(char letter) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                positions.add(i);
            }
        }
        return positions;
    }
}
