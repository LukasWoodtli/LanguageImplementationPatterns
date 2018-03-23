package ch03_enhanced_parsing_patterns.p06_memoizing_parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class MemoizingParserTest {

	@Test
	public void testMemoizing() throws RecognitionException {
		String str = "[a,b]=[c,d]";
		BacktrackLexer lexer = new BacktrackLexer(str);
		BacktrackParser parser = new BacktrackParser(lexer);
		parser.stat(); // begin parsing at rule 'stat'
	}

}
