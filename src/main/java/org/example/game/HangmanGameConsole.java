package org.example.game;

import java.util.Scanner;

public class HangmanGameConsole {

        private final Scanner scanner = new Scanner(System.in);

        public char promptForGuess() {
            System.out.print("Enter a letter: ");
            return scanner.nextLine().charAt(0);
        }

        public void displayState(HangmanGame game) {
            System.out.println("Word: " + game.getWordProgress());
            System.out.println("Remaining attempts: " + game.getRemainingAttempts());
            System.out.println();
        }

        public void displayResult(HangmanGame game) {
            if (game.isWordGuessed()) {
                System.out.println("Congratulations! You guessed the word: " + game.getWordProgress());
            } else {
                System.out.println("Game Over! You couldn't guess the word. The word was: " + game.getWordProgress());
            }
        }
    }

