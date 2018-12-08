package parserpack;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import parserpack.Animals;

public class AnimalStaxParser {
	private static final String ID = "id";
	private static final String NAME = "name";

	private static final String ANIMAL = "animal";
	private Animals animal;
	List<Animals> animals = new ArrayList<>();

	public List<Animals> parse(XMLEventReader xmlEventReader) throws FileNotFoundException, XMLStreamException {
		while (xmlEventReader.hasNext()) {
			XMLEvent xmlEvent = xmlEventReader.nextEvent();
			proceedStartElement(xmlEvent, xmlEventReader);
			proceedEndElement(xmlEvent);
		}
		return animals;
	}

	private void proceedStartElement(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws XMLStreamException {
		if (xmlEvent.isStartElement()) {
			StartElement startElement = xmlEvent.asStartElement();
			if (isTagNameEqual(startElement, ANIMAL)) {
				animal = new Animals();
				Attribute attribute = startElement.getAttributeByName(new QName(ID));
				if (attribute != null) {
					animal.setId(Integer.parseInt(attribute.getValue()));
				}

			} else if (isTagNameEqual(startElement, NAME)) {
				animal.setName(xmlEventReader.nextEvent().asCharacters().getData());
			}

		}
	}

	private void proceedEndElement(XMLEvent xmlEvent) {
		if (xmlEvent.isEndElement()) {
			EndElement endElement = xmlEvent.asEndElement();
			if (endElement.getName().getLocalPart().equals(ANIMAL)) {
				animals.add(animal);
			}
		}
	}

	private boolean isTagNameEqual(StartElement startElement, String tagName) {
		return startElement.getName().getLocalPart().equals(tagName);
	}
}
