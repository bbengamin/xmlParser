package ua.nure.bogdanov.SummaryTask3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ua.nure.bogdanov.SummaryTask3.constants.*;
import ua.nure.bogdanov.SummaryTask3.controller.*;
import ua.nure.bogdanov.SummaryTask3.entity.*;
import ua.nure.bogdanov.SummaryTask3.util.SorterTest;

@RunWith(Suite.class)
@SuiteClasses({ DemoTest.class, MainTest.class, ConstantsTest.class,
		XMLTest.class, DOMControllerTest.class, SAXControllerTest.class,
		STAXControllerTest.class, EnumColorsTest.class, FondTest.class,
		GemTest.class, VisualParametersTest.class, SorterTest.class })
public class AllTests {
}
