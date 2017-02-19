package parsing.lexer;

import java.lang.String;

public abstract class Lexer {
    public static final char EOF = (char) - 1;
    public static final int EOF_TYPE = 1;
    String input; // input string
    int p = 0;    // index of current char
    char c;

    public Lexer(String input) {
        this.input = input;
        c = input.charAt(p);  // prime lookahead
    }

	public void consume() {
	    p++;
	    if (p >= input.length()) c = EOF;
	    else c = input.charAt(p);
	}
	public void match(char x) {
	    if (c == x) consume();
	    else throw new Error("expecting " + x + "; found " + c);
	}
	
	public abstract Token nextToken();
	public abstract String getTokenName(int tokenType);
}