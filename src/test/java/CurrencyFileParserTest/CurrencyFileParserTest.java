package CurrencyFileParserTest;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import CurrencyFileParser.CurrencyFileParser;

public class CurrencyFileParserTest {

	@Test
	public void currencyFileParserTest() {
		CurrencyFileParser currencyFileParser = new CurrencyFileParser();

		boolean sameValues = false;

		Map<String, String> testMap = new HashMap<String, String>();
		testMap.put("PLN", "4.8240");

		Map<String, String> currencyMap = currencyFileParser.returnMap();

		for (String key : currencyMap.keySet()) {
			for (String keyTest : testMap.keySet()) {
				if (key.equals(keyTest) && currencyMap.get(key).equals(testMap.get(keyTest))) {
					sameValues = true;
				}
			}
		}

		assertTrue(sameValues);
	}

}
