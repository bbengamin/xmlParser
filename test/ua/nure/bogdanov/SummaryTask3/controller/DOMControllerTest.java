package ua.nure.bogdanov.SummaryTask3.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import junit.framework.Assert;

import org.junit.Test;
import org.xml.sax.SAXException;

import ua.nure.bogdanov.SummaryTask3.constants.Constants;
import ua.nure.bogdanov.SummaryTask3.entity.Fond;

public class DOMControllerTest {

	@Test
	public void testDOMController() {
		Assert.assertNotNull(new DOMController(Constants.VALID_XML_FILE));
	}

	@Test
	public final void testGetFond() {
		new DOMController(Constants.VALID_XML_FILE).getFond();
	}

	@Test
	public final void testParse() throws ParserConfigurationException,
			SAXException, IOException {
		DOMController domController = new DOMController("input.xml");
		try {
			domController.parse(true);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.err.println(e);
		}
	}
	@Test(expected = NullPointerException.class)
	public final void testParse2() throws ParserConfigurationException,
	SAXException, IOException {
		DOMController domController = new DOMController("input-invalid.xml");
		try {
			domController.parse(true);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.err.println(e);
		}
	}

	@Test
	public final void testGetDocument() throws ParserConfigurationException {
		new DOMController(Constants.VALID_XML_FILE);
		DOMController domController = new DOMController("input.xml");
		try {
			domController.parse(true);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.err.println(e);
		}
		Fond f = domController.getFond();
		DOMController.getDocument(f);
	}

	@Test
	public final void testsaveToXML() throws ParserConfigurationException,
			TransformerException {
		new DOMController(Constants.VALID_XML_FILE);
		DOMController domController = new DOMController("input.xml");
		try {
			domController.parse(true);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.err.println(e);
		}
		Fond f = domController.getFond();
		DOMController.saveToXML(f, "test_DOM.xml");

	}
}
