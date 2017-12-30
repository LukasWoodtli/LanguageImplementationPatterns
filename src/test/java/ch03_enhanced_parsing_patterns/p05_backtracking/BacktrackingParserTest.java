package ch03_enhanced_parsing_patterns.p05_backtracking;


import org.junit.Test;

public class BacktrackingParserTest {

	@Test
	public void testAssignement() throws RecognitionException {
		BacktrackLexer lexer = new BacktrackLexer("[a,b] = [c,d]");
		BacktrackParser parser = new BacktrackParser(lexer);
		parser.stat(); // begin parsing at rule 'stat'
	}
	
	@Test
	public void testList() throws RecognitionException {
		BacktrackLexer lexer = new BacktrackLexer("[a,b]");
		BacktrackParser parser = new BacktrackParser(lexer);
		parser.stat(); // begin parsing at rule 'stat'
	}
	
	@Test(expected=ch03_enhanced_parsing_patterns.p05_backtracking.RecognitionException.class)
	public void testParseError() throws RecognitionException {
		BacktrackLexer lexer = new BacktrackLexer("[a,b]=[c,d");
		BacktrackParser parser = new BacktrackParser(lexer);
		parser.stat(); // begin parsing at rule 'stat'
	}

}
