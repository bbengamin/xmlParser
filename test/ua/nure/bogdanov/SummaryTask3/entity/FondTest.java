package ua.nure.bogdanov.SummaryTask3.entity;

import junit.framework.Assert;

import org.junit.Test;

public final class FondTest {

	@Test
	public void testNew1() {
		Fond f = new Fond();
		Assert.assertNotNull(f.getGem());
	}

	@Test
	public void testAdd() {
		Fond f = new Fond();
		f.getGem();
		Assert.assertNotNull(f.getGem().add(new Gem()));
		
	}

	@Test
	public void testToString() {
		Fond f = new Fond();
		f.getGem();
		f.getGem().add(new Gem());
		Assert.assertNotNull(f.toString());
	}
}
