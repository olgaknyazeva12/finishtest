package adapter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import org.xml.sax.SAXException;

public class AnimalParserMethods {

	private static final String ANIMALS_XML = "animals.xml";

	public String saxMethod() throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		AnimalSaxParser animalSaxParser = new AnimalSaxParser();
		saxParser.parse(new File(ANIMALS_XML), animalSaxParser);
		List<adapter.Animals> animals = animalSaxParser.getAnimals();
		return animals.get(3).getName();
	}

}
