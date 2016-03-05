package ua.nure.bogdanov.SummaryTask3.entity;

import junit.framework.Assert;

import org.junit.Test;

public class VisualParametersTest {

	@Test
	public void testGetSetFaceting() {
		VisualParameters g = new VisualParameters();
		g.setFaceting(123);
		Assert.assertEquals(Integer.valueOf(123), g.getFaceting());
	}

	@Test
	public void testGetSetTransparency() {
		VisualParameters g = new VisualParameters();
		g.setTransparency(321);
		Assert.assertEquals(Integer.valueOf(321), g.getTransparency());
	}

	@Test
	public void testGetSetValueColor1() {
		VisualParameters g = new VisualParameters();
		g.setValueColor(EnumColors.GREEN);
		Assert.assertEquals(EnumColors.GREEN, g.getValueColor());
	}
	@Test
	public void testGetSetValueColor2() {
		VisualParameters g = new VisualParameters();
		Assert.assertEquals(EnumColors.WHITE, g.getValueColor());
	}

	@Test
	public void testToString() {
		Assert.assertNotNull(new VisualParameters().toString());
	}
}
