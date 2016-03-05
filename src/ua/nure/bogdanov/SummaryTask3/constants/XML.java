package ua.nure.bogdanov.SummaryTask3.constants;

/**
 * Holds entities declared in XSD document.
 * 
 * @author I.Bogdanov
 * 
 */
public enum XML {
	// elements names
	FOND("Fond"), GEM("Gem"), NAME("Name"), PRECIOUSNESS("Preciousness"), ORIGIN(
			"Origin"), VISUAL_PARAMETRS("VisualParameters"), VALUE("Value"),

	// attribute name
	VALUE_COLOR("valueColor"), TRANSPARENCY("Transparency"), FACETING(
			"Faceting");

	private String value;

	XML(String value) {
		this.value = value;
	}

	public boolean equalsTo(String name) {
		return value.equals(name);
	}

	public String value() {
		return value;
	}
}
