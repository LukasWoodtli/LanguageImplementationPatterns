package ch03_enhanced_parsing_patterns.p06_memoizing_parser;

import java.lang.String;

public abstract class Lexer {
	public static final char EOF = (char) -1;
	public static final int EOF_TYPE = 1;
	String input; // input string
	int i = 0; // index of current char
	protected char c; // current character

	public Lexer(String input) {
		this.input = input;
		c = input.charAt(i); // prime lookahead
	}

	/** Move to next non-whitespace character */
	public void consume() {
		advance();
	}

	/** Move one character; detect "end of file" */
	public void advance() {
		i++;
		if (i >= input.length())
			c = EOF;
		else
			c = input.charAt(i);
	}

	/** Ensure x is next character on the input stream */
	public void match(char x) {
		if (c == x)
			consume();
		else
			throw new Error("expecting " + x + "; found " + c);
	}

	public abstract Token nextToken();

	abstract void WS();

	public abstract String getTokenName(int x);

}
