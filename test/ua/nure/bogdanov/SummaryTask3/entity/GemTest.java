package ua.nure.bogdanov.SummaryTask3.entity;

import junit.framework.Assert;

import org.junit.Test;

public final class GemTest {
	@Test
	public void testGetSetName() {
		Gem g = new Gem();
		g.setName("123");
		Assert.assertEquals("123", g.getName());
	}

	@Test
	public void testGetSetPreciousness() {
		Gem g = new Gem();
		g.setPreciousness(true);
		Assert.assertEquals(true, g.isPreciousness());
	}

	@Test
	public void testGetSetOrigin() {
		Gem g = new Gem();
		g.setOrigin("123");
		Assert.assertEquals("123", g.getOrigin());
	}

	@Test
	public void testGetSetVisualParameters() {
		Gem g = new Gem();
		g.setVisualParameters(new VisualParameters());
		Assert.assertNotNull(g.getVisualParameters());
	}

	@Test
	public void testGetSetValue() {
		Gem g = new Gem();
		g.setValue(1.);
		Assert.assertEquals(1., g.getValue());
	}


	@Test
	public void testToString() {
		Assert.assertNotNull(new Gem().toString());
	}
}
