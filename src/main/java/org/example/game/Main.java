package org.example.game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangmanGameConsole console = new HangmanGameConsole();

        boolean loop = true;
        while (loop) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Welcome to Hangman!");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Enter the word size to play:");
            System.out.println();
            System.out.println("[1] - 3 Letter Words");
            System.out.println("[2] - 4 Letter Words");
            System.out.println("[3] - 5 Letter Words");
            System.out.println("[0] - Exit");

            int option = scanner.nextInt();
            int wordLength;

            switch (option) {
                case 1:
                    wordLength = 3;
                    break;
                case 2:
                    wordLength = 4;
                    break;
                case 3:
                    wordLength = 5;
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again!");
                    continue;
            }

            WordLoader loader = new WordLoader(wordLength);
            String word = loader.load();
            HangmanGame game = new HangmanGame(word, 5);

            while (!game.isGameOver()) {
                console.displayState(game);
                char guess = console.promptForGuess();
                game.guessLetter(guess);
            }

            console.displayResult(game);
        }

        System.out.println("Thanks for playing! To the next!");
    }
}







