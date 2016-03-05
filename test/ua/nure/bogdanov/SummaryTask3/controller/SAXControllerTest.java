package ua.nure.bogdanov.SummaryTask3.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import ua.nure.bogdanov.SummaryTask3.constants.Constants;

public final class SAXControllerTest {
	private SAXController controller;

	@Test
	public final void testSAXController1() throws ParserConfigurationException,
			SAXException, IOException {
		controller = new SAXController(Constants.VALID_XML_FILE);
		controller.parse(true);
		controller.getFond();
	}

	@Test
	public final void testSAXController2() throws ParserConfigurationException,
			SAXException, IOException {
		controller = new SAXController(Constants.INVALID_XML_FILE);
		controller.parse(false);
		controller.getFond();
	}

	@Test
	public final void testerror() throws SAXException {
		controller = new SAXController(Constants.INVALID_XML_FILE);
		controller.error(new SAXParseException("", null, new Exception()));
	}
}