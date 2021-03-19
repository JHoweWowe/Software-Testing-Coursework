package st;

import static org.junit.Assert.*;

import java.util.AbstractList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PiazzaTests {

	Parser parser;
	
	@Before
	public void setUp() {
		parser = new Parser();
	}
	
	@Test public void Test138_1() {
		parser.add("list", Parser.STRING);
		parser.parse("--list @$@-ou13ut.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("ou13ut.txt"), charList);
	}
	
	@Test public void Test138_2() {
		parser.add("list", Parser.STRING);
		parser.parse("--list c-8");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("cba98"), charList);
	}
	
	@Test public void Test138_3() {
		parser.add("list", Parser.STRING);
		parser.parse("--list 8-c");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("89abc"), charList);
	}
	
	@Test public void Test97_1() {
		parser.add("list", Parser.STRING);
		parser.parse("--list testa-!@c.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("testac.txt"), charList);
	}
	
	@Test public void Test97_2() {
		parser.add("list", Parser.STRING);
		parser.parse("--list 1-3-1.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("123321.txt"), charList);
	}
	
	@Test public void Test97_3() {
		parser.add("list", Parser.STRING);
		parser.parse("--list 1-33-1.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("123321.txt"), charList);
	}
	
	@Test public void Test121_1() {
		parser.add("list", Parser.STRING);
		parser.parse("--list outp1-.5ut.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("outp1.5ut.txt"), charList);
	}
	
	@Test public void Test121_2() {
		parser.add("list", Parser.STRING);
		parser.parse("--list -output-.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(0, charList.size());
	}
	
	@Test public void Test73_1() {
		parser.add("list", Parser.STRING);
		parser.parse("--list -test123.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(0, charList.size());
	}
	
	@Test public void Test73_2() {
		parser.add("list", Parser.STRING);
		parser.parse("--list test123-.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("test123.txt"), charList);
	}
	
	@Test public void Test73_3() {
		parser.add("list", Parser.STRING);
		parser.parse("--list test1-4-.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("test1234.txt"), charList);
	}

	@Test public void Test73_4() {
		parser.add("list", Parser.STRING);
		parser.parse("--list test1-.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("test1.txt"), charList);
	}

	@Test public void Test73_5() {
		parser.add("list", Parser.STRING);
		parser.parse("--list -test.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(0, charList.size());
	}
	
	@Test public void Test73_6() {
		parser.add("list", Parser.STRING);
		parser.parse("--list test1-4.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("test1234.txt"), charList);
	}
	
	@Test public void Test73_7() {
		parser.add("list", Parser.STRING);
		parser.parse("--list a-A");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("a"), charList);
	}
	
	@Test public void Test73_8() {
		parser.add("list", Parser.STRING);
		parser.parse("--list 0-c");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("0123456789abc"), charList);
	}
	
	@Test public void Test73_9() {
		parser.add("list", Parser.STRING);
		parser.parse("--list 8-c");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("89abc"), charList);
	}
	
	@Test public void Test73_10() {
		parser.add("list", Parser.STRING);
		parser.parse("--list a-g-z");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("abcdefgghijklmnopqrstuvwxyz"), charList);
	}
	
	@Test public void Test73_11() {
		parser.add("list", Parser.STRING);
		parser.parse("--list testc-c.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("testc.txt"), charList);
	}
	
	@Test public void Test73_12() {
		parser.add("list", Parser.STRING);
		parser.parse("--list test1-3-1.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("test123321.txt"), charList);
	}
	
	@Test public void Test73_13() {
		parser.add("list", Parser.STRING);
		parser.parse("--list testa---------c.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("testac.txt"), charList);
	}
	
	@Test public void Test73_14() {
		parser.add("list", Parser.STRING);
		parser.parse("--list test_2?4*#.txt");
		List<Character> charList = parser.getCharacterList("list");
		assertEquals(convertStringToCharList("test24.txt"), charList);
	}
	
	
	// Helper functions
	
		private static List<Character> convertStringToCharList(final String str) {
			return new AbstractList<Character>() {
				@Override
				public Character get(int index) {
					return str.charAt(index);
				}
				
				@Override
				public int size() {
					return str.length();
				}
			};
		}

}
