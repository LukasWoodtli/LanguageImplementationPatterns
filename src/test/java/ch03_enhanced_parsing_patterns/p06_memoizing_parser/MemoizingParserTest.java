package ch03_enhanced_parsing_patterns.p06_memoizing_parser;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class MemoizingParserTest {

	@Test
	public void testMemoizing() throws RecognitionException {
		PrintStream stdout = System.out;
		// save output to stdout
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));

		String str = "[a,b]=[c,d]";
		BacktrackLexer lexer = new BacktrackLexer(str);
		BacktrackParser parser = new BacktrackParser(lexer);
		parser.stat(); // begin parsing at rule 'stat'

		String expectedOutput = "attempt alternative 1\nparse list rule at token index: 0\nattempt alternative 2\nparsed list before at index 0; skip ahead to token index 5: =\nparse list rule at token index: 6\npredict alternative 2\nparse list rule at token index: 0\nparse list rule at token index: 6\n";
		System.setOut(stdout);
		System.out.print(baos.toString());
		assertEquals(expectedOutput, baos.toString());
	}

}
