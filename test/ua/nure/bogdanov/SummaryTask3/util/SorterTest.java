package ua.nure.bogdanov.SummaryTask3.util;

import junit.framework.Assert;

import org.junit.Test;

import ua.nure.bogdanov.SummaryTask3.entity.Fond;
import ua.nure.bogdanov.SummaryTask3.entity.Gem;

public final class SorterTest {
	
	@Test
	public void testConstructor() {
		new Sorter();
	}
	@Test
	public void testSortGemsByName() {
		Fond f = new Fond();
		Fond f1 = new Fond();
		Gem g1 = new Gem();
		Gem g2 = new Gem();
		Gem g3 = new Gem();

		g1.setName("a");
		g2.setName("b");
		g3.setName("c");

		f.getGem().add(g3);
		f.getGem().add(g1);
		f.getGem().add(g2);
		
		f1.getGem().add(g1);
		f1.getGem().add(g2);
		f1.getGem().add(g3);
		
		Sorter.sortGemsByName(f);
		Assert.assertTrue(f.getGem().equals(f1.getGem()));
		
	}
	@Test
	public void testSortGemsByValue() {
		Fond f = new Fond();
		Fond f1 = new Fond();
		Gem g1 = new Gem();
		Gem g2 = new Gem();
		Gem g3 = new Gem();
		
		g1.setValue(1.);
		g2.setValue(2.);
		g3.setValue(3.);
		
		f.getGem().add(g3);
		f.getGem().add(g1);
		f.getGem().add(g2);
		
		f1.getGem().add(g1);
		f1.getGem().add(g2);
		f1.getGem().add(g3);
		
		Sorter.sortGemsByValue(f);
		Assert.assertTrue(f.getGem().equals(f1.getGem()));
		
	}
	@Test
	public void testSortGemsByOrigin() {
		Fond f = new Fond();
		Fond f1 = new Fond();
		Gem g1 = new Gem();
		Gem g2 = new Gem();
		Gem g3 = new Gem();
		
		g1.setOrigin("a");
		g2.setOrigin("b");
		g3.setOrigin("c");
		
		f.getGem().add(g3);
		f.getGem().add(g1);
		f.getGem().add(g2);
		
		f1.getGem().add(g1);
		f1.getGem().add(g2);
		f1.getGem().add(g3);
		
		Sorter.sortGemsByOrigin(f);
		Assert.assertTrue(f.getGem().equals(f1.getGem()));
		
	}
}