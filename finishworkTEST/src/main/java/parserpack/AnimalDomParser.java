package parserpack;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import parserpack.Animals;

public class AnimalDomParser {
	public List<Animals> parse(Document document) throws FileNotFoundException, XMLStreamException {
		NodeList nodeList = document.getElementsByTagName("animal");
		List<Animals> animals = new ArrayList<Animals>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			animals.add(getAnimal(nodeList.item(i)));
		}
		return animals;
	}

	private static Animals getAnimal(Node node) {
		Animals animal = new Animals();
		Element element = (Element) node;
		animal.setId(Integer.parseInt(element.getAttribute("id")));
		animal.setName(getTagValue("name", element));
		return animal;
	}

	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = nodeList.item(0);
		return node.getNodeValue();
	}

}
