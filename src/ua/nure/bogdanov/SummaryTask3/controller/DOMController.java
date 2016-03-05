package ua.nure.bogdanov.SummaryTask3.controller;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.bogdanov.SummaryTask3.constants.Constants;
import ua.nure.bogdanov.SummaryTask3.constants.XML;
import ua.nure.bogdanov.SummaryTask3.entity.*;

/**
 * Controller for DOM parser.
 * 
 * @author I.Bogdanov
 * 
 */
public class DOMController {

	private String xmlFileName;

	// main container
	private Fond fond;

	public DOMController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	public Fond getFond() {
		return fond;
	}

	/**
	 * Parses XML document.
	 * 
	 * @param validate
	 *            If true validate XML document against its XML schema.
	 */
	public void parse(boolean validate) throws ParserConfigurationException,
			SAXException, IOException {

		// obtain DOM parser
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// set properties for Factory

		// XML document contains namespaces
		dbf.setNamespaceAware(true);

		// make parser validating
		if (validate) {
			// turn validation on
			dbf.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);

			// turn on xsd validation
			dbf.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
		}

		DocumentBuilder db = dbf.newDocumentBuilder();

		// set error handler
		db.setErrorHandler(new DefaultHandler() {
			@Override
			public void error(SAXParseException e) throws SAXException {
				// throw exception if XML document is NOT valid
				System.err.println(e);
			}
		});

		// parse XML document
		Document document = db.parse(xmlFileName);

		// get root element
		Element root = document.getDocumentElement();

		// create container
		fond = new Fond();

		// obtain questions nodes
		NodeList gemNodes = root.getElementsByTagName(XML.GEM.value());

		// process gems nodes
		for (int j = 0; j < gemNodes.getLength(); j++) {
			Gem gem = getGem(gemNodes.item(j));
			// add question to container
			fond.getGem().add(gem);
		}
	}

	/**
	 * Extracts gem object from the gem XML node.
	 * 
	 * @param qNode
	 *            Gem node.
	 * @return Gem object.
	 */
	private Gem getGem(Node qNode) {
		Gem gem = new Gem();
		Element qElement = (Element) qNode;

		Node ng = qElement.getElementsByTagName(XML.NAME.value()).item(0);
		gem.setName(ng.getTextContent());

		ng = qElement.getElementsByTagName(XML.PRECIOUSNESS.value()).item(0);
		gem.setPreciousness(Boolean.valueOf(ng.getTextContent()));

		ng = qElement.getElementsByTagName(XML.ORIGIN.value()).item(0);
		gem.setOrigin(ng.getTextContent());

		ng = qElement.getElementsByTagName(XML.VISUAL_PARAMETRS.value())
				.item(0);
		VisualParameters vp = getVisualParameters(ng);
		gem.setVisualParameters(vp);

		ng = qElement.getElementsByTagName(XML.VALUE.value()).item(0);
		gem.setValue(Double.valueOf(ng.getTextContent()));

		return gem;
	}

	/**
	 * Extracts visual parameters object from the visual parameters XML node.
	 * 
	 * @param aNode
	 *            Visual parameters node.
	 * @return VisualParameters object.
	 */
	private VisualParameters getVisualParameters(Node aNode) {
		VisualParameters params = new VisualParameters();
		Element aElement = (Element) aNode;

		EnumColors color = EnumColors.fromValue(aElement
				.getAttribute(XML.VALUE_COLOR.value()));
		params.setValueColor(color);

		params.setTransparency(Integer.valueOf(aElement
				.getAttribute(XML.TRANSPARENCY.value())));
		params.setFaceting(Integer.valueOf(aElement.getAttribute(XML.FACETING
				.value())));

		return params;
	}

	// //////////////////////////////////////////////////////
	// Static util methods
	// //////////////////////////////////////////////////////

	/**
	 * Creates and returns DOM of the Fond container.
	 * 
	 * @param fond
	 *            Fond object.
	 * @throws ParserConfigurationException
	 */
	public static Document getDocument(Fond fond)
			throws ParserConfigurationException {

		// obtain DOM parser
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// set properties for Factory

		// XML document contains namespaces
		dbf.setNamespaceAware(true);

		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();

		// create root element
		Element tElement = document.createElement(XML.FOND.value());

		// add root element
		document.appendChild(tElement);

		// add questions elements
		for (Gem gems : fond.getGem()) {

			// add question
			Element qElement = document.createElement(XML.GEM.value());
			tElement.appendChild(qElement);

			Element qtElement = document.createElement(XML.NAME.value());
			qtElement.setTextContent(gems.getName());
			qElement.appendChild(qtElement);

			qtElement = document.createElement(XML.PRECIOUSNESS.value());
			qtElement.setTextContent(String.valueOf(gems.isPreciousness()));
			qElement.appendChild(qtElement);

			qtElement = document.createElement(XML.ORIGIN.value());
			qtElement.setTextContent(gems.getOrigin());
			qElement.appendChild(qtElement);

			VisualParameters params = gems.getVisualParameters();
			if (params != null) {
				Element aElement = document.createElement(XML.VISUAL_PARAMETRS
						.value());
				aElement.setAttribute(XML.VALUE_COLOR.value(), params
						.getValueColor().value());
				aElement.setAttribute(XML.TRANSPARENCY.value(), params
						.getTransparency().toString());
				aElement.setAttribute(XML.FACETING.value(), params
						.getFaceting().toString());
				qElement.appendChild(aElement);
			}

			qtElement = document.createElement(XML.VALUE.value());
			qtElement.setTextContent(String.valueOf(gems.getValue()));
			qElement.appendChild(qtElement);

		}

		return document;
	}

	/**
	 * Saves Fond object to XML file.
	 * 
	 * @param fond
	 *            Fond object to be saved.
	 * @param xmlFileName
	 *            Output XML file name.
	 */
	public static void saveToXML(Fond fond, String xmlFileName)
			throws ParserConfigurationException, TransformerException {
		// Fond -> DOM -> XML
		saveToXML(getDocument(fond), xmlFileName);
	}

	/**
	 * Save DOM to XML.
	 * 
	 * @param document
	 *            DOM to be saved.
	 * @param xmlFileName
	 *            Output XML file name.
	 */
	public static void saveToXML(Document document, String xmlFileName)
			throws TransformerException {

		StreamResult result = new StreamResult(new File(xmlFileName));

		// set up transformation
		TransformerFactory tf = TransformerFactory.newInstance();
		javax.xml.transform.Transformer t = tf.newTransformer();
		t.setOutputProperty(OutputKeys.INDENT, "yes");

		// run transformation
		t.transform(new DOMSource(document), result);
	}
}