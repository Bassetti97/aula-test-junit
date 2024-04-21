package org.example.calculatorIMCTest;

import org.assertj.core.data.Offset;
import org.example.calculatorIMC.IMCCalc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IMCCalcTest {

    @Test
    void calculaterImc() {
        IMCCalc calculator = new IMCCalc();
        var result = calculator.calcImc(1.75, 70.0);
        assertThat(result).isCloseTo(22.86, Offset.offset(0.02));

    }

    @Test
    void calcImcZeroWeight() {
        IMCCalc calculator = new IMCCalc();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var result = calculator.calcImc(1.75, 0.0);
            assertEquals("Weight and height must be greater than zero.", result);
        });

    }

    @Test
    void calcImcZeroHeight() {
        IMCCalc calculator = new IMCCalc();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var result = calculator.calcImc(0.75, 70.0);
            assertEquals("Weight and height must be greater than zero.", result);
        });
    }

    @Test
    void calcImcNegativeWeight() {
        IMCCalc calculator = new IMCCalc();

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calcImc(1.75, -70.0);
        });
        assertEquals("Weight and height must be greater than zero.", exception.getMessage());
    }

    @Test
    void calcImcNegativeHeight() {
        IMCCalc calculator = new IMCCalc();

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calcImc(-1.75, 70.0);
        });
        assertEquals("Weight and height must be greater than zero.", exception.getMessage());
    }
}