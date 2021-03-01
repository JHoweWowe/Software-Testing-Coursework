package st;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

// This class is for working to determine extra bugs in system
public class Task1_Functional_Working {
	
	private Parser parser;
	
	/** Setup as required **/
	@Before
	public void setup() {
		parser = new Parser();
	}
	
	/** Section 1.3 - Add Options with a Shortcut **/
	
	// Specification 1
	@Test
	public void testBug1310() {
		// Simple test case
		parser.add("optimize", "o", Parser.INTEGER);
		parser.add("optimize", "o", Parser.BOOLEAN);
		assertEquals(parser.getInteger("--optimize"), false);
	}
	
	// In Section 1.3, Specification #2 can be divided into multiple test cases
	@Test (expected = RuntimeException.class)
	public void testBug1321() {		
		// Test Case #1 - Invalid name
		String optionName = "#*(*#@";
		parser.add(optionName, "o", Parser.STRING);
	}
	@Test (expected = RuntimeException.class)
	public void testBug1322() {
		// Test case #2 - Invalid name where digit appears first
		String optionName = "5G";
		parser.add(optionName, "f", Parser.STRING);
	}
	@Test (expected = RuntimeException.class)
	public void testBug1323() {
		// Test case #3 - Invalid shortcut
		String optionName = "validOptionName";
		String shortcut = "#*()";
		parser.add(optionName, shortcut, Parser.STRING);
	}
	@Test (expected = RuntimeException.class)
	public void testBug1324() {
		// Test case #4 - Invalid shortcut where digit appears first
		String optionName = "validOptionName";
		String shortcut = "4G";
		parser.add(optionName, shortcut, Parser.STRING);
	}
	
	// Specification #3 - Divide it up further?
	@Test
	public void testBug1330() {
		String optionName = "fileName";
		String optionNameCaps = "FileName";
		parser.add(optionName, "f", Parser.STRING);
		parser.parse("--fileName=one.txt");
		String test = parser.getString(optionName);
		parser.add(optionNameCaps, "F", Parser.STRING);
		parser.parse("--FileName=One.txt");
		String Test = parser.getString(optionNameCaps);
		assertNotEquals(test,Test);
	}
	
	// Specification #4 - should not give out errors for any expected value
	@Test
	public void testBug1340() {
		parser.add("output", "o", Parser.INTEGER);
		parser.add("o", "output", Parser.INTEGER);
		
		parser.add("output", "o", Parser.BOOLEAN);
		parser.add("o", "output", Parser.BOOLEAN);
		
		parser.add("output", "o", Parser.STRING);
		parser.add("o", "output", Parser.STRING);
		
		parser.add("output", "o", Parser.CHAR);
		parser.add("o", "output", Parser.CHAR);
	}
	@Test
	public void testBug1341() {
		parser.add("output", "o", Parser.INTEGER);
		parser.add("o", "output", Parser.INTEGER);
		assertNotEquals(parser.getInteger("--output"),parser.getInteger("--o"));

	}
	
	
	
	// Specification #5
	@Test
	public void testBug1350() {
		// Simple test case which fails
		parser.add("optimise", "O", Parser.BOOLEAN);
		int test = parser.parse("-O");
		boolean result = parser.getBoolean("optimise");
		assertEquals(result,true);
	}
	@Test
	public void testBug1351() {
		// Simple test case which fails
		parser.add("optimise", "O", Parser.BOOLEAN);
		int test = parser.parse("--optimise");
		boolean result = parser.getBoolean("optimise");
		assertEquals(result,true);
	}
	@Test
	public void testBug1352() {
		// Simple test case which fails
		parser.add("optimise", "O", Parser.BOOLEAN);
		int test = parser.parse("-O=true");
		boolean result = parser.getBoolean("optimise");
		assertEquals(result,true);
	}
	// For positive values
	@Test
	public void testBug1354() {
		parser.add("optimise", "O", Parser.BOOLEAN);
		int test = parser.parse("-O=1");
		boolean result = parser.getBoolean("optimise");
		assertEquals(result,true);
	}
	// For negative values
	@Test
	public void testBug1355() {
		parser.add("optimise", "O", Parser.BOOLEAN);
		int test = parser.parse("-O=-399");
		boolean result = parser.getBoolean("optimise");
		assertEquals(result,true);
	}
	@Test
	public void testBug1356() {
		parser.add("optimise", "O", Parser.BOOLEAN);
		int test = parser.parse("-O -399");
		boolean result = parser.getBoolean("optimise");
		assertEquals(result,true);
	}
	@Test
	public void testBug1357() {
		parser.add("optimise", "O", Parser.BOOLEAN);
		assertEquals(parser.getBoolean("-O"),false);
	}
	@Test
	public void testBug1358() {
		// Simple test case which fails
		parser.add("optimise", "O", Parser.BOOLEAN);
		int test = parser.parse("-O=false");
		boolean result = parser.getBoolean("optimise");
		assertEquals(result,false);
	}
	@Test
	public void testBug1359() {
		// Simple test case which fails
		parser.add("optimise", "O", Parser.BOOLEAN);
		int test = parser.parse("-O=0");
		boolean result = parser.getBoolean("optimise");
		assertEquals(result,false);
	}



	
	
	
	/** Section 1.4 - Add options without shortcut **/
	
	// Specification #1
	@Test
	public void testBug1410() {
		// Simple test case
		parser.add("optimize", Parser.INTEGER);
		parser.add("optimize", Parser.BOOLEAN);
		assertEquals(parser.parse("--optimize"), true);
	}
	
	// Specification #2
	@Test
	public void testBug1420() {
		parser.add("5G", Parser.BOOLEAN);
		parser.add("5G", Parser.INTEGER);
		parser.add("5G", Parser.CHAR);
		parser.add("5G", Parser.STRING);
	}
	
	/** Section 1.5 - Parse command line option **/
	@Test
	public void testBug1531() {
		parser.add("option", Parser.INTEGER);
		int parseResult = parser.parse("--option 0");
		assertEquals(parseResult, 0);
	}
	@Test
	public void testBug1535() {
		parser.add("option", Parser.STRING);
		int parseResult = parser.parse("--option=value");
		assertEquals(parseResult,0);
	}
	@Test
	public void testBug1536() {
		parser.add("option", Parser.STRING);
		int parseResult = parser.parse("--option value");
		assertEquals(parseResult, 0);
	}
	
	@Test
	public void testBug1540() {
		parser.add("option", "o", Parser.STRING);
		int value = parser.parse("--option=\"value\"");
		assertEquals(value,0);
		int value2 = parser.parse("--option='value'");
		assertEquals(value2,0);
		int value3 = parser.parse("--option=value");
		assertEquals(value3,0);
		assertEquals(value,value2,value3);
	}

	@Test
	public void testBug1550() {
		// 2 Cases single with double and double with single
		parser.add("option", Parser.STRING);
		int parseResult = parser.parse("--option='value=\"abc\"'");
		String str = parser.getString("option");
		assertEquals(str,"value=\"abc\"");
	}
	@Test
	public void testBug1551() {
		// 2 Cases single with double and double with single
		parser.add("option", Parser.STRING);
		int parseResult = parser.parse("--option=\"value='abc'\"");
		String str = parser.getString("option");
		assertEquals(str,"value='abc'");
	}
	
	@Test
	public void testBug1560() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=value");
		assertEquals(parser.parse("--option=value1"),parser.getString("--option"));
	}
	
	/** Section 1.6 **/
	/*** Assume options are not defined ***/
	@Test
	public void testBug1621() {
		parser.add("no_output", Parser.INTEGER);
		int value = parser.getInteger("no_output");
		assertEquals(value,0);
	}
	@Test
	public void testBug1622() {
		parser.add("no_output", Parser.BOOLEAN);
		boolean optimise = parser.getBoolean("no_output");
		assertEquals(optimise,false);
	}
	@Test
	public void testBug1623() {
		parser.add("no_output", Parser.STRING);
		String output_file_name = parser.getString("no_output");
		assertEquals(output_file_name,"");
	}
	@Test
	public void testBug1624() {
		char result = parser.getChar("no_output");
		assertEquals(result,'\0');
	}
	// Bug 8
	  @Test(timeout = 4000)
	  public void test13()  throws Throwable  {
	      OptionMap optionMap0 = new OptionMap();
	      optionMap0.store("v", "", 2);
	      // Undeclared exception!
	      try { 
	        optionMap0.setValueWithOptioShortcut("", "sZ_wrMcah(");
	        fail("Expecting exception: RuntimeException");
	      
	      } catch(RuntimeException e) {
	         //
	         // no message in exception (getMessage() returned null)
	         //
	         
	      }
	  }


	  // Bug 11
	  @Test(timeout = 4000)
	  public void test15()  throws Throwable  {
	      OptionMap optionMap0 = new OptionMap();
	      optionMap0.store("v", "J", 2);
	      // Undeclared exception!
	      try { 
	        optionMap0.setValueWithOptioShortcut("J", "v");
	        fail("Expecting exception: RuntimeException");
	      
	      } catch(RuntimeException e) {
	         //
	         // no message in exception (getMessage() returned null)
	         //
	         
	      }
	  }
	  
	  // Bug 10
	  @Test(timeout = 4000)
	  public void test18()  throws Throwable  {
	      OptionMap optionMap0 = new OptionMap();
	      optionMap0.store("v", "", 2);
	      // Undeclared exception!
	      try { 
	        optionMap0.setValueWithOptionName("", "OptionMap [options=\n\t{name=v, shortcut=, type=2, value=}\n]");
	        fail("Expecting exception: RuntimeException");
	      
	      } catch(RuntimeException e) {
	         //
	         // no message in exception (getMessage() returned null)
	         //
	         
	      }
	  }

	  @Test(timeout = 4000)
	  public void test23()  throws Throwable  {
	      OptionMap optionMap0 = new OptionMap();
	      optionMap0.store("K", "v", 1);
	      optionMap0.store("v", "K", 2);
	      // Undeclared exception!
	      try { 
	        optionMap0.getValue("v");
	        fail("Expecting exception: RuntimeException");
	      
	      } catch(RuntimeException e) {
	         //
	         // no message in exception (getMessage() returned null)
	         //
	         
	      }
	  }

	  @Test(timeout = 4000)
	  public void test24()  throws Throwable  {
	      OptionMap optionMap0 = new OptionMap();
	      optionMap0.store("K", "v", 1);
	      String string0 = optionMap0.getValue("v");
	      assertEquals("", string0);
	  }

	  @Test(timeout = 4000)
	  public void test25()  throws Throwable  {
	      OptionMap optionMap0 = new OptionMap();
	      optionMap0.store("v", "", 2);
	      String string0 = optionMap0.getValue("v");
	      assertEquals("", string0);
	  }

	  @Test(timeout = 4000)
	  public void test26()  throws Throwable  {
	      OptionMap optionMap0 = new OptionMap();
	      optionMap0.store("v", "", 2);
	      optionMap0.store("v", "rZge", 1);
	      assertEquals(2, OptionMap.BOOLEAN);
	  }

	  @Test(timeout = 4000)
	  public void test27()  throws Throwable  {
	      OptionMap optionMap0 = new OptionMap();
	      // Undeclared exception!
	      try { 
	        optionMap0.store("", "&", 2);
	        fail("Expecting exception: RuntimeException");
	      
	      } catch(RuntimeException e) {
	         //
	         // no message in exception (getMessage() returned null)
	         //
	         
	      }
	  }

	  @Test(timeout = 4000)
	  public void test28()  throws Throwable  {
	      OptionMap optionMap0 = new OptionMap();
	      // Undeclared exception!
	      try { 
	        optionMap0.store("", "", 2);
	        fail("Expecting exception: RuntimeException");
	      
	      } catch(RuntimeException e) {
	         //
	         // no message in exception (getMessage() returned null)
	         //
	         
	      }
	  }

	  @Test(timeout = 4000)
	  public void test29()  throws Throwable  {
	      OptionMap optionMap0 = new OptionMap();
	      optionMap0.store("NHK", "v", 2);
	      optionMap0.setValueWithOptionName("NHK", "NHK");
	      // Undeclared exception!
	      try { 
	        optionMap0.setValueWithOptionName("NHK", "q+nlUy-11c");
	        fail("Expecting exception: RuntimeException");
	      
	      } catch(RuntimeException e) {
	         //
	         // no message in exception (getMessage() returned null)
	         //
	         
	      }
	  }

	  @Test(timeout = 4000)
	  public void test30()  throws Throwable  {
	      OptionMap optionMap0 = new OptionMap();
	      OptionMap.Option optionMap_Option0 = optionMap0.new Option("", "", (Integer) 4);
	      optionMap_Option0.setShortcut("");
	      assertEquals("", optionMap_Option0.getValue());
	  }

	  @Test(timeout = 4000)
	  public void test31()  throws Throwable  {
	      OptionMap optionMap0 = new OptionMap();
	      OptionMap.Option optionMap_Option0 = optionMap0.new Option((String) null, (String) null, (Integer) 4);
	      optionMap_Option0.setName((String) null);
	      assertNull(optionMap_Option0.getName());
	  }

	  @Test(timeout = 4000)
	  public void test32()  throws Throwable  {
	      OptionMap optionMap0 = new OptionMap();
	      optionMap0.store("N", "v", 2);
	      // Undeclared exception!
	      try { 
	        optionMap0.setValueWithOptionName("v", "v");
	        fail("Expecting exception: RuntimeException");
	      
	      } catch(RuntimeException e) {
	         //
	         // no message in exception (getMessage() returned null)
	         //
	         
	      }
	  }

	  @Test(timeout = 4000)
	  public void test33()  throws Throwable  {
	      OptionMap optionMap0 = new OptionMap();
	      OptionMap.Option optionMap_Option0 = optionMap0.new Option("w+BW)t!pQ6{Kh8O-xk", (Integer) 3);
	      optionMap_Option0.setType((Integer) optionMap0.INTEGER);
	      assertEquals("", optionMap_Option0.getValue());
	  }


}
