package ua.nure.bogdanov.SummaryTask3.entity;

/**
 * Element of XSD scheme.
 * 
 * @author I.Bogdanov
 * 
 */
public class Gem {



	protected String name;
	protected boolean preciousness;
	protected String origin;
	protected VisualParameters visualParameters;
	protected double value;

	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the preciousness property.
	 * 
	 */
	public boolean isPreciousness() {
		return preciousness;
	}

	/**
	 * Sets the value of the preciousness property.
	 * 
	 */
	public void setPreciousness(boolean value) {
		this.preciousness = value;
	}

	/**
	 * Gets the value of the origin property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Sets the value of the origin property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrigin(String value) {
		this.origin = value;
	}

	/**
	 * Gets the value of the visualParameters property.
	 * 
	 * @return possible object is {@link VisualParameters }
	 * 
	 */
	public VisualParameters getVisualParameters() {
		return visualParameters;
	}

	/**
	 * Sets the value of the visualParameters property.
	 * 
	 * @param value
	 *            allowed object is {@link VisualParameters }
	 * 
	 */
	public void setVisualParameters(VisualParameters value) {
		this.visualParameters = value;
	}

	/**
	 * Gets the value of the value property.
	 * 
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 */
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(System.lineSeparator());
		sb.append("preciousness = ").append(preciousness).append(System.lineSeparator());
		sb.append(origin).append(System.lineSeparator());
		sb.append(visualParameters).append(System.lineSeparator());
		sb.append(value).append(System.lineSeparator());
		return sb.toString().trim();
	}
}
