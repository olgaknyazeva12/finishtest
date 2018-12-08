package adapter;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

public class Adapter {

	Xml xml = new Xml();

	public Adapter(Xml xml2) {

	}

	public String getXmlAsText() throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		return xml.getXML().replaceAll("[()]", "");
	}

}
