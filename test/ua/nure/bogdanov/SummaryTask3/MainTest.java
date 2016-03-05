package ua.nure.bogdanov.SummaryTask3;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class MainTest {

	@Test
	public final void testConstructor() {
		new Main();
	}

	@Test
	public final void testMain() {
		try {
			Main.main(new String[] { "input.xml" });
			Main.main(new String[] {});
		} catch (ParserConfigurationException | TransformerException
				| SAXException | IOException | XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = FileNotFoundException.class)
	public final void testMain2() throws ParserConfigurationException, TransformerException, SAXException, IOException, XMLStreamException {
			Main.main(new String[] { "blabla.xml" });
	}

	@Test(expected = NullPointerException.class)
	public final void testMain3() {
		try {
			Main.main(new String[] { "input-invalid.xml" });
		} catch (ParserConfigurationException | TransformerException
				| SAXException | IOException | XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
