package ua.nure.bogdanov.SummaryTask3.entity;

/**
 * Attribute of {@link Gem}
 * 
 * @author I.Bogdanov
 * 
 */
public class VisualParameters {

	protected EnumColors valueColor;
	protected Integer transparency;
	protected Integer faceting;

	/**
	 * Gets the value of the valueColor property.
	 * 
	 * @return possible object is {@link EnumColors }
	 * 
	 */
	public EnumColors getValueColor() {
		if (valueColor == null) {
			return EnumColors.WHITE;
		} else {
			return valueColor;
		}
	}

	/**
	 * Sets the value of the valueColor property.
	 * 
	 * @param value
	 *            allowed object is {@link EnumColors }
	 * 
	 */
	public void setValueColor(EnumColors value) {
		this.valueColor = value;
	}

	/**
	 * Gets the value of the transparency property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getTransparency() {
		return transparency;
	}

	/**
	 * Sets the value of the transparency property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setTransparency(Integer value) {
		this.transparency = value;
	}

	/**
	 * Gets the value of the faceting property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getFaceting() {
		return faceting;
	}

	/**
	 * Sets the value of the faceting property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setFaceting(Integer value) {
		this.faceting = value;
	}

	@Override
	public String toString() {
		return "Color = " + valueColor + ", transparency = " + transparency
				+ ", faceting=" + faceting;
	}

}
