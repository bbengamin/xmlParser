package ua.nure.bogdanov.SummaryTask3.entity;

/**
 * Enum with contains valid colors
 * 
 * @author I.Bogdanov
 * 
 */
public enum EnumColors {

	GREEN("green"), RED("red"), WHITE("white"), YELLOW("yellow");

	private final String value;

	EnumColors(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static EnumColors fromValue(String v) {
		for (EnumColors c : EnumColors.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
