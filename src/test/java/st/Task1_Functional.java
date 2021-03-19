package st;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import st.OptionMap.Option;

public class Task1_Functional {
	
	private Parser parser;
	
	/** Setup as required **/
	@Before
	public void setup() {
		parser = new Parser();
	}
			
	// Find Bug 1 - 1.4 2 (Empty option name and shortcut)
	@Test
	public void testBug1() {
		parser.add("", "", Parser.STRING);
	}
	
	// Find Bug 2 - 1.3 2 (Invalid shortcut name)
	@Test
	public void testBug2() {		
		String shortCutName = "#*(*#@";
		parser.add(shortCutName, "o", Parser.STRING);
	}
	
	// Find Bug 3 - 1.4 1 (Overriding)
	@Test
	public void testBug3() {
		// Simple test case
		parser.add("optimize", Parser.INTEGER);
		parser.add("optimize", Parser.BOOLEAN);
		assertEquals(parser.parse("--optimize"), true);
	}
	
	// Find Bug 4 - 1.3.5
	@Test
	public void testBug4() {
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
	
	// Find Bug 6 - Problem with parsing the value as single quotations
	@Test
	public void testBug6() {
		parser.add("option", "o", Parser.STRING);
		int value = parser.parse("--option=\"value\"");
		int value2 = parser.parse("--option='value'");
		assertEquals(value,value2);
	}
	
	// Bug 7 - Parsing negative value
	@Test
	public void testBug7() {
		parser.add("option", Parser.INTEGER);
		parser.parse("--option=-2");
		parser.getInteger("option");
	}
	
	// Bug 8 - Add option name as shortcut and parse where there is an underscore
	@Test
	public void testBug8() {
		parser.add("k", "", Parser.STRING);
		parser.parse("-=sZ_wrMcah(");
	}
	
	// Find Bug 9 - Parses with more than 50 characters
	@Test
	public void testBug9() {
		parser.add("test", "", Parser.STRING);
		parser.parse("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY");
	}
	
	// Bug 10 - Parse shortcut with no option
	@Test
	public void testBug10() {
		parser.add("v", Parser.STRING);
		parser.parse("--v=\r");
	}
	
	// Bug 11 - Parsing shortcut with an option name with length of 1
	@Test
	public void testBug11() {
		parser.add("v", "J", Parser.STRING);
		parser.parse("-J=v");
	}
	
	// Find Bug 12 - 1.5.1? (Command Line Options is empty)
	@Test
	public void testBug12() {
		int parseResult = parser.parse("");
		assertEquals(parseResult,1);
	}
		
	// Bug 13 - 1.3 4 (Option can have shortcut that has same name of another option)
	@Test
	public void testBug13() {
		parser.add("key", "value", Parser.STRING);
		parser.add("value", "key", Parser.STRING);
		parser.getInteger("value");
	}

}
