package ua.nure.bogdanov.SummaryTask3.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.junit.Test;
import org.xml.sax.SAXException;

import ua.nure.bogdanov.SummaryTask3.constants.Constants;

public class STAXControllerTest {
	private STAXController controller;

	@Test
	public final void testStAXController() throws ParserConfigurationException,
			SAXException, IOException, XMLStreamException {
		controller = new STAXController(Constants.VALID_XML_FILE);
		controller.parse();
		controller.getFond();
	}
}