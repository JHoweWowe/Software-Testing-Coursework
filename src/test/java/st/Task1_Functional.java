package st;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Task1_Functional {
	
	private Parser parser;
	
	/** Setup as required **/
	@Before
	public void setup() {
		parser = new Parser();
	}
		
	// Find Bug 1 - 1.3 1
	@Test
	public void testBug1() {
		// Simple test case
		parser.add("output", "o", Parser.BOOLEAN);
		parser.parse("-o=false");
		parser.add("output", "o", Parser.BOOLEAN);
		parser.parse("-o=true");
		assertEquals(parser.getBoolean("--output"),false);
	}
	
	// Find Bug 2 - 1.3 2
	@Test (expected = RuntimeException.class)
	public void testBug2() {		
		// Test Case #1 - Invalid name
		String optionName = "#*(*#@";
		parser.add(optionName, "o", Parser.STRING);
	}
	
	// Find Bug 3 - 1.4 1
	@Test(expected = RuntimeException.class)
	public void testBug3() {
		// Simple test case
		parser.add("optimize", Parser.INTEGER);
		parser.add("optimize", Parser.BOOLEAN);
		assertEquals(parser.parse("--optimize"), true);
	}
	
	// Find Bug 4 - 1.3.5
	@Test
	public void testBug4() {
		// Simple test case which fails
		parser.add("optimise", "O", Parser.BOOLEAN);
		int test = parser.parse("-O=0");
		boolean result = parser.getBoolean("optimise");
		assertEquals(result,false);
	}
	
	// Find Bug 5 - 1.6.2
	@Test
	public void testBug5() {
		char result = parser.getChar("no_output");
		assertEquals(result,'\0');
	}
	
	// Find Bug 6 - 1.5.4
	@Test
	public void testBug6() {
		parser.add("option", "o", Parser.STRING);
		int value = parser.parse("--option=\"value\"");
		int value2 = parser.parse("--option='value'");
		int value3 = parser.parse("--option=value");
		assertEquals(value,value2,value3);
	}


	
	

	


}
