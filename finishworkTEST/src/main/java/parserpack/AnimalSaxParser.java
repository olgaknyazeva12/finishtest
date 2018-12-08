package parserpack;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AnimalSaxParser extends DefaultHandler {
	private List<Animals> animals;
	private Animals animal;
	boolean bName = false;

	public List<Animals> getAnimals() {
		return animals;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("animal")) {
			String id = attributes.getValue("id");
			animal = new Animals();
			animal.setId(Integer.parseInt(id));
			if (animals == null) {
				animals = new ArrayList<>();
			}

		} else if (qName.equalsIgnoreCase("name")) {
			bName = true;
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("animal")) {
			animals.add(animal);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

		if (bName) {
			animal.setName(new String(ch, start, length));
			bName = false;
		}

	}

}
