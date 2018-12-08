package adapter;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class AppTest {

	@Test
	public void shouldAnswerWithTrue()
			throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		Text text = new Text();
		Xml xml = new Xml();
		Adapter adapter = new Adapter(xml);
		assertTrue(text.checkName(adapter.getXmlAsText()));
	}
}
