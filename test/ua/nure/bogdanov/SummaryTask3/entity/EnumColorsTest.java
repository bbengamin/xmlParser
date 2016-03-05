package ua.nure.bogdanov.SummaryTask3.entity;

import junit.framework.Assert;

import org.junit.Test;

public final class EnumColorsTest {

	@Test
	public void testConstructor1() {
		EnumColors e = EnumColors.GREEN;
		EnumColors.values();
		e.toString();
	}

	@Test
	public void testValue() {
		Assert.assertEquals("green", EnumColors.GREEN.value());
	}

	@Test
	public void testFromValue1() {
		Assert.assertNotNull(EnumColors.fromValue("green"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromValue2() {
		EnumColors.fromValue("blabla");
	}

	@Test
	public void testValueOf() {
		EnumColors.valueOf("GREEN");
	}

}
