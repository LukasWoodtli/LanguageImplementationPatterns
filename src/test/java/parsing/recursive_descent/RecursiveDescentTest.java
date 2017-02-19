package parsing.recursive_descent;

import parsing.lexer.ListLexer;


import org.junit.Test;


public class RecursiveDescentTest {

	@Test
	public void test() {
		
		ListLexer lexer = new ListLexer("[a,b]");
		ListParser parser = new ListParser(lexer);
		
		// no throw
		parser.list();
		
	}

}
