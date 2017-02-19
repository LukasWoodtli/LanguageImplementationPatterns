package parsing.recursive_descent;

import parsing.lexer.*;

public class ListParser extends Parser {
	public ListParser(Lexer input) {super(input);}
	
	/** list : '[' elements ']' ; // match bracketed list */
	public void list() {
		match(ListLexer.LBRACK); elements(); match(ListLexer.RBRACK);
	}
	
	/** elements : element (',' element)* ; */
	void elements() {
		element();
		while ( lookahead.type == ListLexer.COMMA ) {
			match(ListLexer.COMMA); element();
		}
	}
	
	/** element : name | list ; // element is name or nested list */
	void element() {
		if ( lookahead.type == ListLexer.NAME ) match(ListLexer.NAME);
		else if ( lookahead.type == ListLexer.LBRACK ) list();
		else throw new Error("expecting name or list; found " + lookahead);
	}
}

	
	
	
	
	
	
	
	
	