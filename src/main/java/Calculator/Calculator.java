package Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import CurrencyFileParser.CurrencyFileParser;

public class Calculator {

	private double foreignCurrency;
	private double result;
	private String cmd;
	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private Map<String, String> mapCurrency = null;

	public void mainProgram() throws IOException {

		CurrencyFileParser currencyFileParser = new CurrencyFileParser();
		mapCurrency = currencyFileParser.returnMap();

		do {
			showCommands();
			cmd = input.readLine();

			if (cmd.equals("1")) {
				printMap(mapCurrency);
				System.out.print("\nInsert EU value to calculate: ");
				String quantity = input.readLine();
				System.out.print("Insert shortcut for currency to calculate: ");
				String shortcut = input.readLine();
				calculatingCurrency(mapCurrency, quantity, shortcut);
			} else if (cmd.equals("2")) {
				printMap(mapCurrency);
			} else if (cmd.equals("3")) {
				break;
			} else {
				System.out.println("Wrong command!");

			}
		} while (!cmd.equals("3"));
	}

	public double calculatingCurrency(Map<String, String> map, String quantity, String shortcut) throws IOException {

		printMap(map);

		shortcut = shortcut.toUpperCase();
		for (String key : map.keySet()) {
			if (key.equals(shortcut)) {
				foreignCurrency = Double.parseDouble(map.get(key));
				result = Double.parseDouble(quantity) * foreignCurrency;
				System.out.println("-----------------------------------------------------");
				System.out.println("Result: " + String.format("%.4f", result) + " [" + shortcut + "]");
				System.out.println("-----------------------------------------------------");
			}
		}

		return result;
	}

	public void showCommands() {
		System.out.println("--------------------------");
		System.out.println("[1] Calculator : ");
		System.out.println("[2] Show Currencies : ");
		System.out.println("[3] Quit Program : ");
		System.out.print("Choose option and press Enter:");
	}

	public void printMap(Map<String, String> map) {
		for (String key : map.keySet()) {
			System.out.println("Currency: " + key + " Rate: " + map.get(key));
		}
	}

}
