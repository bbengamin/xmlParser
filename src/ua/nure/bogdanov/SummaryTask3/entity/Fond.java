package ua.nure.bogdanov.SummaryTask3.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Root element of XSD scheme.
 * 
 * @author I.Bogdanov
 * 
 */
public class Fond {

	protected List<Gem> gem;

	public List<Gem> getGem() {
		if (gem == null) {
			gem = new ArrayList<Gem>();
		}
		return this.gem;
	}

	@Override
	public String toString() {
		return "Fond " + System.lineSeparator() + gem;
	}

}
