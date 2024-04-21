package org.example.calculatorIMC;

import java.util.Scanner;

public class IMCCalcMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            System.out.println("Enter your height (ex: 1,63):");
            double height = scanner.nextDouble();

            System.out.println("Enter your weight:");
            double weight = scanner.nextDouble();

            IMCCalc imcCalc = new IMCCalc();
            try {
                double imc = imcCalc.calcImc(height, weight);
                System.out.println("Your IMC is: " + imc);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Do you want to calculate IMC again? (Y/N)");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("Y")) {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Goodbye!");
                System.out.println("-----------------------------------------------------------------------");
                loop = false;
            }
        }
    }
}
