package org.example.game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HangmanGame {
        private final GuessWord guessWord;
        private final Set<Character> guessedLetters = new HashSet<>();
        private int remainingAttempts;

        public HangmanGame(String word, int attempts) {
            this.guessWord = new GuessWord(word);
            this.remainingAttempts = attempts;
        }

        public boolean guessLetter(char letter) {
            if (guessedLetters.contains(letter)) {
                return false;
            }

            guessedLetters.add(letter);
            List<Integer> positions = guessWord.letterExist(letter);

            if (positions.isEmpty()) {
                remainingAttempts--;
                return false;
            }

            return true;
        }

        public boolean isGameOver() {
            return remainingAttempts <= 0 || isWordGuessed();
        }

        public boolean isWordGuessed() {
            for (int i = 0; i < guessWord.word.length(); i++) {
                if (!guessedLetters.contains(guessWord.word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        public int getRemainingAttempts() {
            return remainingAttempts;
        }

        public String getWordProgress() {
            StringBuilder progress = new StringBuilder();
            for (int i = 0; i < guessWord.word.length(); i++) {
                char c = guessWord.word.charAt(i);
                progress.append(guessedLetters.contains(c) ? c : "_");
            }
            return progress.toString();
        }
    }


