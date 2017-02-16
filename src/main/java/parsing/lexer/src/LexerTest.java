
public class LexerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListLexer lexer = new ListLexer(args[0]);

		Token t = lexer.nextToken();
		while (t.type != Lexer.EOF_TYPE) {
			System.out.println(t);
			t = lexer.nextToken();
		}
		
		System.out.println(t); // EOF
	}
}
