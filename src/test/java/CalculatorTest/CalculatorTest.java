package CalculatorTest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import Calculator.Calculator;

public class CalculatorTest {

	@Test
	public void calculatingCurrencyTest() throws IOException {
		Map<String, String> currency = new HashMap<String, String>();
		currency.put("PLN", "4.81");
		currency.put("USD", "1.0067");

		Calculator calculator = new Calculator();
		double actualValue = calculator.calculatingCurrency(currency, "5", "PLN");
		double expectedValue = 5 * 4.81;

		assertEquals(expectedValue, actualValue, 0.001);

		actualValue = calculator.calculatingCurrency(currency, "20", "USD");
		expectedValue = 20 * 1.0067;

		assertEquals(expectedValue, actualValue, 0.001);
	}

}
