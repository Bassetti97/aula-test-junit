package org.example.conversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CurrencyMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<CurrencyRate> rates = new ArrayList<>();
        rates.add(new CurrencyRate("USD", 1.0));
        rates.add(new CurrencyRate("EUR", 0.92));
        rates.add(new CurrencyRate("BRL", 5.03));

        CurrencyConverter converter = new CurrencyConverter(rates);

        boolean loop = true;
        while (loop) {
            System.out.println("Enter the currency option you want to convert:");
            System.out.println("[1] USD - American Dollar");
            System.out.println("[2] EUR - Euro");
            System.out.println("[3] BRL - Brazilian Real");
            System.out.println("[0] Exit");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            String fromCurrency;
            switch (opcao) {
                case 1:
                    fromCurrency = "USD";
                    break;
                case 2:
                    fromCurrency = "EUR";
                    break;
                case 3:
                    fromCurrency = "BRL";
                    break;
                case 0:
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("Goodbye!");
                    System.out.println("-----------------------------------------------------------------------");
                    return;
                default:
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("Invalid option. Try again!");
                    System.out.println("-----------------------------------------------------------------------");
                    continue;
            }


            System.out.println("Enter the destination currency (USD, EUR, BRL):");
            String toCurrency = scanner.nextLine();
            System.out.println("Enter the value to be converted:");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            try {
                double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);
                System.out.println(amount + " " + fromCurrency + " = " + convertedAmount + " " + toCurrency);
                System.out.println("---------------------------------------------------------------------------");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

    }
}
