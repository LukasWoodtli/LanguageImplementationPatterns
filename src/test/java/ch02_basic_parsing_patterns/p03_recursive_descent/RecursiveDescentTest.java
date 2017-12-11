package ch02_basic_parsing_patterns.p03_recursive_descent;

import org.junit.Test;

import ch02_basic_parsing_patterns.p02_lexer.ListLexer;
import ch02_basic_parsing_patterns.p03_recursive_descent.ListParser;


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
