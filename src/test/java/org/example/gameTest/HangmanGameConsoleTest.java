package org.example.gameTest;

import org.example.game.HangmanGameConsole;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HangmanGameConsoleTest {

        @Test
        void testPromptForGuess() {
            String input = "a\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            HangmanGameConsole console = new HangmanGameConsole();

            assertEquals('a', console.promptForGuess());
            System.setIn(System.in);
        }
}


