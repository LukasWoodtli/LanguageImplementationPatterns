package ch02_basic_parsing_patterns.p04_llk_recursive_descent;



import org.junit.Test;

public class LookaheadParserTest {

	@Test
	public void testOk() {
		LookaheadLexer lexer = new LookaheadLexer("[a,b=c,[d,e]]");
		LookaheadParser parser = new LookaheadParser(lexer, 2);
		
		parser.list();
		
	}
	
	@Test(expected=java.lang.Error.class)
	public void testFail() {
		LookaheadLexer lexer = new LookaheadLexer("[a,b=c,,[d,e]]");
		LookaheadParser parser = new LookaheadParser(lexer, 2);
		
		parser.list();
	}

}
