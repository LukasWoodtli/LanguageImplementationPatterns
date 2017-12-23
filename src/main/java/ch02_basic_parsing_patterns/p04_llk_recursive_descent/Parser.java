package ch02_basic_parsing_patterns.p04_llk_recursive_descent;

import ch02_basic_parsing_patterns.p02_lexer.Lexer;
import ch02_basic_parsing_patterns.p02_lexer.Token;

public abstract class Parser {

	Lexer input;
	Token[] lookahead;
	int k;
	int p = 0;
	
public Parser(Lexer input, int k) {
	this.input = input;
	this.k = k;
	this.lookahead = new Token[k];

	for (int i = 1; i <= k; i++)
		consume();
}

public void consume() {
	lookahead[p] = input.nextToken();
	p = (p + 1) % k;
}

public Token LT(int i) {
	return lookahead[(p + i - 1) % k];
}

public int LA(int i) { return LT(i).type; }

void match(int x) {
	if (LA(1) == x) consume();
	else throw new Error("expecting " + input.getTokenName(x) + "; found " + LT(1));
}
}
