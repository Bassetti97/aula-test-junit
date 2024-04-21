package org.example.calculatorIMC;

public class IMCCalc {
    public double calcImc(double height, double weight) {

        if (weight >= 1.0 && height >= 0.1) {
            double result = (weight / (height * height));
            return result;
        } else {
            throw new IllegalArgumentException("Weight and height must be greater than zero.");
        }
    }
}
