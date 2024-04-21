package org.example.gameTest;

import org.example.game.HangmanGame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HangmanGameTest {

    @Test
    void testGuessCorrectLetter() {
        HangmanGame game = new HangmanGame("test", 5);
        assertTrue(game.guessLetter('t'));
        assertEquals("t__t", game.getWordProgress());
    }

    @Test
    void testGuessIncorrectLetter() {
        HangmanGame game = new HangmanGame("test", 5);
        assertFalse(game.guessLetter('y'));
        assertEquals("____", game.getWordProgress());
    }

    @Test
    void testGameOverAllAttemptsUsed() {
        HangmanGame game = new HangmanGame("test", 5);
        game.guessLetter('x');
        game.guessLetter('y');
        game.guessLetter('g');
        game.guessLetter('h');
        game.guessLetter('j');
        assertTrue(game.isGameOver());
    }

    @Test
    void testGameEndsGuessedWord() {
        HangmanGame game = new HangmanGame("test", 5);
        game.guessLetter('t');
        game.guessLetter('e');
        game.guessLetter('s');
        game.guessLetter('t');
        assertTrue(game.isGameOver());
    }

    @Test
    void testChecksIfTheGameEndsBeforeEnteringAnyLetters() {
        HangmanGame game = new HangmanGame("test", 5);
        assertFalse(game.isWordGuessed());
    }

    @Test
    void testChecksIfTheGameIsFinishedAfterGuessingTheCorrectWord() {
        HangmanGame game = new HangmanGame("test", 5);
        game.guessLetter('t');
        game.guessLetter('e');
        game.guessLetter('s');
        assertTrue(game.isWordGuessed());
    }
}

