package org.example.currencyTest;

import org.example.conversion.CurrencyConverter;
import org.example.conversion.CurrencyRate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CurrencyConverterTest {
    @Test
    void convertUSDToEURTest() {
        List<CurrencyRate> rates = new ArrayList<>();
        rates.add(new CurrencyRate("USD-AmericanDollar", 1.0));
        rates.add(new CurrencyRate("EUR-Euro", 0.92));
        CurrencyConverter converter = new CurrencyConverter(rates);

        //100USD = 92EUR
        assertEquals(92.0, converter.convert(100, "USD-AmericanDollar", "EUR-Euro"), 0.02);
    }

    @Test
    void convertEURToUSDTest() {
        List<CurrencyRate> rates = new ArrayList<>();
        rates.add(new CurrencyRate("USD-AmericanDollar", 1.09));
        rates.add(new CurrencyRate("EUR-Euro", 1.0));
        CurrencyConverter converter = new CurrencyConverter(rates);

        //100EUR = 109USD
        assertEquals(109.0, converter.convert(100, "EUR-Euro", "USD-AmericanDollar"), 0.02);
    }

    @Test
    void convertBRLToUSDTest() {
        List<CurrencyRate> rates = new ArrayList<>();
        rates.add(new CurrencyRate("USD-AmericanDollar", 0.20));
        rates.add(new CurrencyRate("BRL-BrazilianReal", 1.0));
        CurrencyConverter converter = new CurrencyConverter(rates);

        //100BRL = 20USD
        assertEquals(20.0, converter.convert(100, "BRL-BrazilianReal", "USD-AmericanDollar"), 0.02);
    }

    @Test
    void convertBRLToEURTest() {
        List<CurrencyRate> rates = new ArrayList<>();
        rates.add(new CurrencyRate("EUR-Euro", 0.18));
        rates.add(new CurrencyRate("BRL-BrazilianReal", 1.0));
        CurrencyConverter converter = new CurrencyConverter(rates);

        //100BRL = 18EUR
        assertEquals(18.0, converter.convert(100, "BRL-BrazilianReal", "EUR-Euro"), 0.02);
    }

    @Test
    void convertEURToBRLTest() {
        List<CurrencyRate> rates = new ArrayList<>();
        rates.add(new CurrencyRate("EUR-Euro", 1.0));
        rates.add(new CurrencyRate("BRL-BrazilianReal", 5.46));
        CurrencyConverter converter = new CurrencyConverter(rates);

        //100EUR = 546BRL
        assertEquals(546.0, converter.convert(100, "EUR-Euro", "BRL-BrazilianReal"), 0.02);
    }

    @Test
    void convertUSDToBRLTest() {
        List<CurrencyRate> rates = new ArrayList<>();
        rates.add(new CurrencyRate("USD-AmericanDollar", 1.0));
        rates.add(new CurrencyRate("BRL-BrazilianReal", 5.03));
        CurrencyConverter converter = new CurrencyConverter(rates);

        //100USD = 503BRL
        assertEquals(503.0, converter.convert(100, "USD-AmericanDollar", "BRL-BrazilianReal"), 0.02);
    }

    @Test
    void convertInvalidCurrencyTest() {
        List<CurrencyRate> rates = new ArrayList<>();
        rates.add(new CurrencyRate("USD-AmericanDollar", 1.0));
        CurrencyConverter converter = new CurrencyConverter(rates);
        try {
            converter.convert(100, "USD-AmericanDollar", "ABC");
        } catch (IllegalArgumentException e) {
            assertEquals("Currency not supported", e.getMessage());
        }
    }

}
