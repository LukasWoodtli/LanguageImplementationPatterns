package parsing.recursive_descent;

import parsing.lexer.ListLexer;


import org.junit.Test;


public class RecursiveDescentTest {

	@Test
	public void testOk() {
		
		ListLexer lexer = new ListLexer("[a,b]");
		ListParser parser = new ListParser(lexer);

		// no throw
		parser.list();		
	}
	
	@Test(expected=java.lang.Error.class)
	public void testFail() {
		ListLexer lexer = new ListLexer("[a,]");
		ListParser parser = new ListParser(lexer);

		parser.list();
	}

}
