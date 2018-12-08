package adapter;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

public class Xml {
	AnimalParserMethods method = new AnimalParserMethods();

	public String getXML() throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		return method.saxMethod();
	}
}
