package ch02_basic_parsing_patterns.p02_lexer;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import ch02_basic_parsing_patterns.p02_lexer.Lexer;
import ch02_basic_parsing_patterns.p02_lexer.ListLexer;
import ch02_basic_parsing_patterns.p02_lexer.Token;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LexerTest {

	@Test
	public void test() {
		String input = "[a, b ]";
		ListLexer lexer = new ListLexer(input);
		
		List<Token> expectedResult = new ArrayList<Token>();
		expectedResult.add(new Token(ListLexer.LBRACK, "["));
		expectedResult.add(new Token(ListLexer.NAME, "a"));
		expectedResult.add(new Token(ListLexer.COMMA, ","));
		expectedResult.add(new Token(ListLexer.NAME, "b"));
		expectedResult.add(new Token(ListLexer.RBRACK, "]"));

		
		List<Token> actualResult = new ArrayList<Token>();

		Token t = lexer.nextToken();
		while (t.type != Lexer.EOF_TYPE) {
			actualResult.add(t);
			t = lexer.nextToken();
		}
		
		assertEquals(expectedResult.size(), actualResult.size());
		
		for(int i=0; i<expectedResult.size(); ++i) {
			assertEquals(expectedResult.get(i).text, actualResult.get(i).text);
			assertEquals(expectedResult.get(i).type, actualResult.get(i).type);
		}
	}

}
