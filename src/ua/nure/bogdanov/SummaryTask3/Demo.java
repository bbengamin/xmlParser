package ua.nure.bogdanov.SummaryTask3;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

/**
 * Demo class to run project WO command line.
 * 
 * @author I.Bogdanov
 * 
 */
public class Demo {

	public static void main(String[] args) throws ParserConfigurationException,
			TransformerException, SAXException, IOException, XMLStreamException {
		Main.main(new String[] { "input.xml" });
	}

}