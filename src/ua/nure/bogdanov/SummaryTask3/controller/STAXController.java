package ua.nure.bogdanov.SummaryTask3.controller;

import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.bogdanov.SummaryTask3.constants.XML;
import ua.nure.bogdanov.SummaryTask3.entity.*;

/**
 * Controller for StAX parser.
 * 
 * @author I.Bogdanov
 * 
 */
public class STAXController extends DefaultHandler {

	private String xmlFileName;

	// main container
	private Fond fond;

	public Fond getFond() {
		return fond;
	}

	public STAXController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	/**
	 * Parses XML document with StAX (based on event reader). There is no
	 * validation during the parsing.
	 */
	public void parse() throws ParserConfigurationException, SAXException,
			IOException, XMLStreamException {

		Gem gem = new Gem();
		VisualParameters params = new VisualParameters();

		// current element name holder
		String currentElement = null;

		XMLInputFactory factory = XMLInputFactory.newInstance();

		factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);

		XMLEventReader reader = factory.createXMLEventReader(new StreamSource(
				xmlFileName));

		while (reader.hasNext()) {
			XMLEvent event = reader.nextEvent();

			// skip any empty content
			if (event.isCharacters() && event.asCharacters().isWhiteSpace()) {
				continue;
			}

			// handler for start tags
			if (event.isStartElement()) {
				StartElement startElement = event.asStartElement();
				currentElement = startElement.getName().getLocalPart();

				if (XML.FOND.equalsTo(currentElement)) {
					fond = new Fond();
					continue;
				}

				if (XML.GEM.equalsTo(currentElement)) {
					gem = new Gem();
					continue;
				}

				if (XML.VISUAL_PARAMETRS.equalsTo(currentElement)) {
					params = new VisualParameters();
					Attribute attribute = startElement
							.getAttributeByName(new QName(XML.VALUE_COLOR
									.value()));
					if (attribute != null) {
						params.setValueColor(EnumColors.fromValue(attribute
								.getValue()));
					}
					attribute = startElement.getAttributeByName(new QName(
							XML.TRANSPARENCY.value()));
					if (attribute != null) {
						params.setTransparency(Integer.valueOf(attribute
								.getValue()));
					}
					attribute = startElement.getAttributeByName(new QName(
							XML.FACETING.value()));
					if (attribute != null) {
						params.setFaceting(Integer.valueOf(attribute.getValue()));
					}
					continue;
				}
			}

			// handler for contents
			if (event.isCharacters()) {
				Characters characters = event.asCharacters();

				if (XML.NAME.equalsTo(currentElement)) {
					gem.setName(characters.getData());
					continue;
				}
				if (XML.PRECIOUSNESS.equalsTo(currentElement)) {
					gem.setPreciousness(Boolean.valueOf(characters.getData()));
					continue;
				}
				if (XML.ORIGIN.equalsTo(currentElement)) {
					gem.setOrigin(characters.getData());
					continue;
				}
				if (XML.VALUE.equalsTo(currentElement)) {
					gem.setValue(Double.valueOf(characters.getData()));
					continue;
				}

			}

			// handler for end tags
			if (event.isEndElement()) {
				EndElement endElement = event.asEndElement();
				String localName = endElement.getName().getLocalPart();

				if (XML.GEM.equalsTo(localName)) {
					fond.getGem().add(gem);
					continue;
				}

				if (XML.VISUAL_PARAMETRS.equalsTo(localName)) {
					// just add answer to container
					gem.setVisualParameters(params);
					continue;
				}
			}
		}
		reader.close();
	}
}