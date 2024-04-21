package org.example.gameTest;

import org.example.game.GuessWord;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuessWordTest {

    @Test
    void testChecksExistingLetterInPosition() {
        GuessWord guessWord = new GuessWord("banana");
        assertTrue(guessWord.letterExist('b').contains(0));
        assertTrue(guessWord.letterExist('a').contains(1));
        assertTrue(guessWord.letterExist('n').contains(2));
        assertTrue(guessWord.letterExist('a').contains(3));
        assertTrue(guessWord.letterExist('n').contains(4));
        assertTrue(guessWord.letterExist('a').contains(5));
    }

    @Test
    void testCheckNonExistentLetter() {
        GuessWord guessWord = new GuessWord("banana");
        assertTrue(guessWord.letterExist('y').isEmpty());
        assertTrue(guessWord.letterExist('c').isEmpty());
        assertTrue(guessWord.letterExist('d').isEmpty());
    }
}

