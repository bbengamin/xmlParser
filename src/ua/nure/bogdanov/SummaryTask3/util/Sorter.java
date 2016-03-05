package ua.nure.bogdanov.SummaryTask3.util;

import java.util.Collections;
import java.util.Comparator;

import ua.nure.bogdanov.SummaryTask3.entity.*;

/**
 * Contains static methods for sorting.
 * 
 * @author I.Bogdanov
 * 
 */
public class Sorter {

	// //////////////////////////////////////////////////////////
	// these are comparators
	// //////////////////////////////////////////////////////////

	/**
	 * Sorts gems by name
	 */
	public static final Comparator<Gem> SORT_GEMS_BY_NAME = new Comparator<Gem>() {
		@Override
		public int compare(Gem o1, Gem o2) {
			return o1.getName().compareTo(o2.getName());
		}
	};

	/**
	 * Sorts gems by origin
	 */
	public static final Comparator<Gem> SORT_GEMS_BY_ORIGIN = new Comparator<Gem>() {
		@Override
		public int compare(Gem o1, Gem o2) {
			return o1.getOrigin().compareTo(o2.getOrigin());
		}
	};
	/**
	 * Sorts gems by value
	 */
	public static final Comparator<Gem> SORT_GEMS_BY_VALUE = new Comparator<Gem>() {
		@Override
		public int compare(Gem o1, Gem o2) {
			return Double.compare(o1.getValue(), o2.getValue());
		}
	};

	// //////////////////////////////////////////////////////////
	// these methods take Fond object and sort it
	// with according comparator
	// //////////////////////////////////////////////////////////

	/**
	 * Sorts gems by name using an appropriate comparator
	 */
	public static final void sortGemsByName(Fond fond) {
		Collections.sort(fond.getGem(), SORT_GEMS_BY_NAME);
	}

	/**
	 * Sorts gems by value using an appropriate comparator
	 */
	public static final void sortGemsByValue(Fond fond) {
		Collections.sort(fond.getGem(), SORT_GEMS_BY_VALUE);
	}

	/**
	 * Sorts gems by origin using an appropriate comparator
	 */
	public static final void sortGemsByOrigin(Fond fond) {
		Collections.sort(fond.getGem(), SORT_GEMS_BY_ORIGIN);
	}
}