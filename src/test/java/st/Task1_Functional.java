package st;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Task1_Functional {
	
	private Parser parser;
	
	@Before
	public void setup() {
		parser = new Parser();
	}
	
	@Test
	public void test() {
		assertEquals(5, 2+3);
	}
	

}
