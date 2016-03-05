package ua.nure.bogdanov.SummaryTask3;

import org.junit.Test;

import ua.nure.bogdanov.SummaryTask3.Demo;

public class DemoTest {

	@Test
	public void testConstructor() throws Exception {
		new Demo();
	}

	@Test
	public void test() throws Exception {
		Demo.main(new String[0]);
	}

}
