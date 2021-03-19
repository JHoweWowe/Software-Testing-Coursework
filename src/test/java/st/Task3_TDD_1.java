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
	
	// Specification #1: Order should matter
	@Test
	public void checkSpec1() {
		parser.add("o", "a", Parser.STRING);
		parser.parse("--o=test");
		parser.add("option", "o", Parser.STRING);
		parser.parse("-o=test2");
		List<Character> expectedList = parser.getCharacterList("o");
		List<Character> actualList = new ArrayList<Character>(Arrays.asList('t','e','s','t','2'));
		assertEquals(expectedList, actualList);
	}
	
	// Specification #2: If option is not provided a value, empty list is returned
	@Test
	public void checkSpec2() {
		parser.add("list", "l", Parser.STRING);
		parser.parse("--list=");
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
	// Within #3: Character List has symbols - runtimeexception should occur
	@Test (expected = RuntimeException.class)
	public void checkSpec3Bug1(){
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=f3#");
		List<Character> l = parser.getCharacterList("option");
	}
	
	// Specification #4: Value of option isn't case sensitive
	@Test
	public void checkSpec4() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=Test123.txt");
		parser.add("option2", "o", Parser.STRING);
		parser.parse("--option=test123.txt");
		
		List<Character> listOne = parser.getCharacterList("option");
		List<Character> listTwo = parser.getCharacterList("option2");
		assertEquals(listOne, listTwo);
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
		parser.parse("--option=e-a");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>(Arrays.asList('e','d','c','b','a'));
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

}
