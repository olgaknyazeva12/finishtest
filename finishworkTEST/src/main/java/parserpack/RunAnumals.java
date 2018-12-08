package parserpack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;

import org.xml.sax.SAXException;

public class RunAnumals {

	private static final String ANIMALS_XML = "animals.xml";

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		System.out.println(" ========================= SAX parser ==============================");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		AnimalSaxParser animalSaxParser = new AnimalSaxParser();
		saxParser.parse(new File(ANIMALS_XML), animalSaxParser);
		List<Animals> animals = animalSaxParser.getAnimals();
		animals.forEach(animal -> System.out.println(animal));

		System.out.println(" ============================== STAX parser =========================");
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(ANIMALS_XML));
		animals = new AnimalStaxParser().parse(xmlEventReader);
		animals.forEach(animal -> System.out.println(animal));

		System.out.println(" ============================== DOM parser =========================");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(ANIMALS_XML);
		animals = new AnimalDomParser().parse(document);
		animals.forEach(animal -> System.out.println(animal));
	}

}
