package CurrencyFileParser;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CurrencyFileParser {

	private Map<String, String> mapCurrency=null;

	public CurrencyFileParser() {
		try {
			mapCurrency = new HashMap<String, String>();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("src/main/resources/eurofxref-daily.xml"));
			document.getDocumentElement().normalize();

			NodeList list = document.getElementsByTagName("Cube");

			for (int temp = 0; temp < list.getLength(); temp++) {
				Node currentNode = list.item(temp);
				if (currentNode.getAttributes().getNamedItem("currency") != null) {
					mapCurrency.put(currentNode.getAttributes().getNamedItem("currency").getNodeValue(),
							currentNode.getAttributes().getNamedItem("rate").getNodeValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Map<String,String> returnMap(){
		
		return this.mapCurrency;
	}
	
}
