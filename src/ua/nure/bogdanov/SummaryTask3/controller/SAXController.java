package ua.nure.bogdanov.SummaryTask3.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.bogdanov.SummaryTask3.constants.Constants;
import ua.nure.bogdanov.SummaryTask3.constants.XML;
import ua.nure.bogdanov.SummaryTask3.entity.*;

/**
 * Controller for SAX parser.
 * 
 * @author I.Bogdanov
 * 
 */
public class SAXController extends DefaultHandler {

	private String xmlFileName;

	// current element name holder
	private String currentElement;

	// main container
	private Fond fond;

	private Gem gem;

	private VisualParameters params;

	public SAXController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	/**
	 * Parses XML document.
	 * 
	 * @param validate
	 *            If true validate XML document against its XML schema. With
	 *            this parameter it is possible make parser validating.
	 */
	public void parse(boolean validate) throws ParserConfigurationException,
			SAXException, IOException {

		// obtain sax parser factory
		SAXParserFactory factory = SAXParserFactory.newInstance();

		// XML document contains namespaces
		factory.setNamespaceAware(true);

		// set validation
		if (validate) {
			factory.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
			factory.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON,
					true);
		}

		SAXParser parser = factory.newSAXParser();
		parser.parse(xmlFileName, this);
	}

	// ///////////////////////////////////////////////////////////
	// ERROR HANDLER IMPLEMENTATION
	// ///////////////////////////////////////////////////////////

	@Override
	public void error(org.xml.sax.SAXParseException e) throws SAXException {
		// if XML document not valid just throw exception
		System.err.println(e);
	};

	public Fond getFond() {
		return fond;
	}

	// ///////////////////////////////////////////////////////////
	// CONTENT HANDLER IMPLEMENTATION
	// ///////////////////////////////////////////////////////////

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		currentElement = localName;

		if (XML.FOND.equalsTo(currentElement)) {
			fond = new Fond();
			return;
		}

		if (XML.GEM.equalsTo(currentElement)) {
			gem = new Gem();
			return;
		}

		if (XML.VISUAL_PARAMETRS.equalsTo(currentElement)) {
			params = new VisualParameters();
			if (attributes.getLength() > 0) {
				params.setFaceting(Integer.valueOf(attributes.getValue(uri,
						XML.FACETING.value())));
				params.setTransparency(Integer.valueOf(attributes.getValue(uri,
						XML.TRANSPARENCY.value())));
				params.setValueColor(EnumColors.fromValue((attributes.getValue(
						uri, XML.VALUE_COLOR.value()))));
			}
			return;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		String elementText = new String(ch, start, length).trim();

		// return if content is empty
		if (elementText.isEmpty()) {
			return;
		}

		if (XML.NAME.equalsTo(currentElement)) {
			gem.setName(elementText);
			return;
		}
		if (XML.PRECIOUSNESS.equalsTo(currentElement)) {
			gem.setPreciousness(Boolean.valueOf(elementText));
			return;
		}
		if (XML.ORIGIN.equalsTo(currentElement)) {
			gem.setOrigin(elementText);
			return;
		}
		gem.setValue(Double.valueOf(elementText));
		return;
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		if (XML.GEM.equalsTo(localName)) {
			fond.getGem().add(gem);
			return;
		}
		if (XML.VISUAL_PARAMETRS.equalsTo(localName)) {
			// just add to container
			gem.setVisualParameters(params);
			return;
		}

	}
}