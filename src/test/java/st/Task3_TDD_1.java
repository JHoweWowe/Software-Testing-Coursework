package st;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

// DEVELOPER NOTE: When compiled with original Parser file, compilation code should fail
// But with original Parser should be fine
// There should be at least 1-2 tests for each specification in final file

// Specification only for getCharacterList(String option)

public class Task3_TDD_1 {
		
	private Parser parser;
	
	@Before
	public void set_up() {
		parser = new Parser();
	}
	
	// Specification #1: Order should matter, returns the value of option with full name
	@Test
	public void checkSpec1() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("-o=test2");
		parser.add("o", "a", Parser.STRING);
		parser.parse("--o=test");

		List<Character> expectedList = parser.getCharacterList("o");
		List<Character> actualList = new ArrayList<Character>(Arrays.asList('t','e','s','t'));
		assertEquals(expectedList, actualList);
	}
	
	// Specification #2: If option is not provided a value, empty list is returned
	@Test
	public void checkSpec2() {
		parser.add("list", "l", Parser.STRING);
		parser.parse("--list");
		List<Character> l = parser.getCharacterList("list");
		List<Character> emptyList = new ArrayList<Character>();
		assertEquals(l, emptyList);
	}
	
	// Specification #3: Character List may only have letters, digits and full stops
	@Test
	public void checkSpec3() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=test123.txt");
		List<Character> l = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('t','e','s','t','1','2','3','.','t','x','t'));
		assertEquals(l, actualList);
	}
	
	// Within #3: Character List has symbols - just remove them
	@Test
	public void checkSpec3Bug1(){
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=@Af*&23#");
		List<Character> l = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('a','f','2','3'));
		assertEquals(l, actualList);
	}
	
	// Specification #4: Value of option isn't case sensitive
	@Test
	public void checkSpec4() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=Test123.txt");
		List<Character> listOne = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('t','e','s','t','1','2','3','.','t','x','t'));
		assertEquals(listOne, actualList);
	}
	
	// Specification #5: Can be divided into two
	// If value starts with hyphen, function will return empty list
	@Test
	public void checkSpec5() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=-test123.txt");
		List<Character> list = parser.getCharacterList("option");
		List<Character> emptyList = new ArrayList<Character>();
		assertEquals(list, emptyList);
	}
	@Test
	public void checkSpec5Part2() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=test123-.txt");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('t','e','s','t','1','2','3','.','t','x','t'));
		assertEquals(list, actualList);
	}
	
	// Specification #6: Hyphen (Order matters)
	@Test
	public void checkSpec6() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=F-a");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>(Arrays.asList('f','e','d','c','b','a'));
		assertEquals(list, actualList);
	}
	
	@Test
	public void checkSpec6Bug0() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=a-E");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('a','b','c','d','e'));
		assertEquals(list, actualList);
	}
	
	
	// Extra specification tests for #6 regarding hyphen
	@Test
	public void checkSpec6Bug1() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=b-7");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>(Arrays.asList('b','a','9','8','7'));
		assertEquals(list, actualList);
	}
	
	@Test
	public void checkSpec6Bug2() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=#*-t3st.tXt");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>(Arrays.asList('t','3','s','t','.','t','x','t'));
		assertEquals(list, actualList);
	}
	
	@Test
	public void checkSpec6Bug3() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=8-D.txt");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('8','9','a','b','c','d','.','t','x','t'));
		assertEquals(list, actualList);
	}
	
	@Test
	public void checkSpec6Bug4() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=D-8.txt");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('d','c','b','a','9','8','.','t','x','t'));
		assertEquals(list, actualList);
	}
	
	// Specification for multiple hyphens
	@Test
	public void checkSpecMultipleHyphens1() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=1-3-1");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('1','2','3','3','2','1'));
		assertEquals(list, actualList);
	}
	
	@Test
	public void checkSpecMultipleHyphens2() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=c-c-c");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('c','c'));
		assertEquals(list, actualList);
	}
	
	@Test
	public void checkSpecMultipleHyphens3() {
		parser.add("option", Parser.STRING);
		parser.parse("--option=test5-3-1.txt");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('t','e','s','t','5','4','3','3','2','1','.','t','x','t'));
		assertEquals(list, actualList);
	}
	
	// Hyphens placed in valid and invalid places
	@Test
	public void checkSpecMultipleHyphens4() {
		parser.add("option", Parser.STRING);
		parser.parse("--option=test1-3-.txt");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('t','e','s','t','1','2','3','.','t','x','t'));
		assertEquals(list, actualList);
	}
	
}
