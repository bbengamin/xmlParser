package ua.nure.bogdanov.SummaryTask3.constants;

import junit.framework.Assert;

import org.junit.Test;

public final class XMLTest {

	@Test
	public void testConstructor1() {
		XML e = XML.FACETING;
		XML.values();
		e.toString();
	}

	@Test
	public void testValue() {
		Assert.assertEquals("Faceting", XML.FACETING.value());
	}

	@Test
	public void testEqualsTo() {
		Assert.assertTrue(XML.FACETING.equalsTo("Faceting"));
	}

	@Test
	public void testValueOf() {
		XML.valueOf("FOND");
	}

}
