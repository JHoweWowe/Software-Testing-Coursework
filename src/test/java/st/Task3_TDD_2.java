package st;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Task3_TDD_2 {

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
	@Test
	public void checkSpec1Part2() {
		parser.add("o", "a", Parser.STRING);
		parser.parse("--o=fullOption");
		parser.add("option", "o", Parser.STRING);
		parser.parse("-o=shortcutOption");

		List<Character> expectedList = parser.getCharacterList("o");
		List<Character> actualList = new ArrayList<Character>(
				Arrays.asList('f','u','l','l','o','p','t','i','o','n'));
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
	// For option without shortcut
	@Test
	public void checkSpec2Part2() {
		parser.add("option", Parser.STRING);
		parser.parse("--option");
		List<Character> l = parser.getCharacterList("option");
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
	// Within #3: Ensuring character list value only has letters, digits and full stops
	@Test
	public void checkSpec3Part1(){
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=@af,*.&23#");
		List<Character> l = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('a','f','.','2','3'));
		assertEquals(l, actualList);
	}
	// String has more symbols
	@Test
	public void checkSpec3Part2() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=[+3!a#%.r&(9@$]k^q*");
		List<Character> l = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('3','a','.','r','9','k','q'));
		assertEquals(l, actualList);
	}
	
	// Specification #4: Value of option isn't case sensitive
	@Test
	public void checkSpec4Part1() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=Test123.txt");
		List<Character> listOne = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('t','e','s','t','1','2','3','.','t','x','t'));
		assertEquals(listOne, actualList);
	}
	@Test
	public void checkSpecPart2() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=yEeToRnOYE3t.tXt");
		List<Character> listOne = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('y','e','e','t','o','r','n','o','y','e','3','t','.','t','x','t'));
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
	// Hyphen both placed in end of string and in between valid characters
	@Test
	public void checkSpec5Part3() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=te!s#t1-2-3-.txt");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('t','e','s','t','1','2','2','3','.','t','x','t'));
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
	public void checkSpec6Part0() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=a-E");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('a','b','c','d','e'));
		assertEquals(list, actualList);
	}
	
	
	// Extra specification tests for #6 regarding hyphen and using a mixture of alphanumerical characters
	@Test
	public void checkSpec6Part1() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=b-7");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>(Arrays.asList('b','a','9','8','7'));
		assertEquals(list, actualList);
	}
	
	@Test
	public void checkSpec6Part2() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=#*-t3st.tXt");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>(Arrays.asList('t','3','s','t','.','t','x','t'));
		assertEquals(list, actualList);
	}
	
	@Test
	public void checkSpec6Part3() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=8-D.txt");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('8','9','a','b','c','d','.','t','x','t'));
		assertEquals(list, actualList);
	}
	
	@Test
	public void checkSpec6Part4() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=D-8.txt");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('d','c','b','a','9','8','.','t','x','t'));
		assertEquals(list, actualList);
	}
	
	/** Specification for multiple hyphens **/
	@Test
	public void checkSpecMultipleHyphens1() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=0-3-1");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('0','1','2','3','3','2','1'));
		assertEquals(list, actualList);
	}
	
	// Parsing with same character in between each hyphen in the string
	@Test
	public void checkSpecMultipleHyphens2() {
		parser.add("option", "o", Parser.STRING);
		parser.parse("--option=d-d-d");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('d','d'));
		assertEquals(list, actualList);
	}
	
	// Same numerical value appears twice in a string
	@Test
	public void checkSpecMultipleHyphens3() {
		parser.add("option", Parser.STRING);
		parser.parse("--option=test3-3-1.txt");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('t','e','s','t','3','3','2','1','.','t','x','t'));
		assertEquals(list, actualList);
	}
	
	// Hyphens placed in valid and invalid places
	@Test
	public void checkSpecMultipleHyphens4() {
		parser.add("option", Parser.STRING);
		parser.parse("--option=test2-4-.txt");
		List<Character> list = parser.getCharacterList("option");
		List<Character> actualList = new ArrayList<Character>
		(Arrays.asList('t','e','s','t','2','3','4','.','t','x','t'));
		assertEquals(list, actualList);
	}

}
