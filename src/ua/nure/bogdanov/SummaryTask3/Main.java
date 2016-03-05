package ua.nure.bogdanov.SummaryTask3;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import ua.nure.bogdanov.SummaryTask3.controller.DOMController;
import ua.nure.bogdanov.SummaryTask3.controller.SAXController;
import ua.nure.bogdanov.SummaryTask3.controller.STAXController;
import ua.nure.bogdanov.SummaryTask3.entity.Fond;
import ua.nure.bogdanov.SummaryTask3.util.Sorter;

/**
 * Entry point for SummaryTask3.
 * 
 * @author I.Bogdanov
 * 
 */
public class Main {
	public static void usage() {
		System.out.println("Usage:\njava -jar SummaryTask3.jar xmlFileName");
		System.out
				.println("java ua.kharkov.knure.bogdanov.SummaryTask3.Main xmlFileName");
	}

	public static void main(String[] args) throws ParserConfigurationException,
			TransformerException, SAXException, IOException, XMLStreamException {
		if (args.length != 1) {
			usage();
			return;
		}

		String xmlFileName = args[0];
		System.out.println("Input ==> " + xmlFileName);

		// ///////////////////////////////////////////////////////
		// DOM
		// //////////////////////////////////////////////////////

		// get
		DOMController domController = new DOMController(xmlFileName);
		domController.parse(true);
		Fond fond = domController.getFond();

		// sort (case 1)
		Sorter.sortGemsByName(fond);

		// save
		String outputXmlFile = "output.dom.xml";
		DOMController.saveToXML(fond, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);

		// //////////////////////////////////////////////////////
		// SAX
		// //////////////////////////////////////////////////////

		// get
		SAXController saxController = new SAXController(xmlFileName);
		saxController.parse(true);
		fond = saxController.getFond();

		// sort (case 2)
		Sorter.sortGemsByOrigin(fond);

		// save
		outputXmlFile = "output.sax.xml";

		// other way:
		DOMController.saveToXML(fond, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);

		// //////////////////////////////////////////////////////
		// StAX
		// //////////////////////////////////////////////////////

		// get
		STAXController staxController = new STAXController(xmlFileName);
		staxController.parse();
		fond = staxController.getFond();

		// sort (case 3)
		Sorter.sortGemsByValue(fond);

		// save
		outputXmlFile = "output.stax.xml";
		DOMController.saveToXML(fond, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);
	}

}