package ch03_enhanced_parsing_patterns.p05_backtracking;

public class BacktrackParser extends Parser {
	public BacktrackParser(Lexer input) { super(input); }

	
	/** stat : list EOF | assign EOF */
	public void stat() throws RecognitionException {
		// attempt alternative 1: list EOF
		if (speculate_stat_alt1()) {
			list();
			match(Lexer.EOF_TYPE);
		}
		// attempt alternative 2: assign EOF
		else if (speculate_stat_alt2()) {
			assign();
			match(Lexer.EOF_TYPE);
		}
		else
			throw new NoViableAltException("expecting stat found " + LT(1));
	}
	
	public boolean speculate_stat_alt1() {
		boolean success = true;
		mark(); // mark this spot so we can rewind
		try {
			list();
			match(Lexer.EOF_TYPE);
		}
		catch (RecognitionException e) {
			success = false;
		}
		
		release();
		return success;
	}
	

	public boolean speculate_stat_alt2() {
		boolean success = true;
		mark(); // mark this spot so we can rewind
		try {
			assign();
			match(Lexer.EOF_TYPE);
		}
		catch (RecognitionException e) {
			success = false;
		}
		
		release();
		return success;
	}

	/** assign : list '=' list ; // parallel assignment */
	public void assign() throws RecognitionException {
		list();
		match(BacktrackLexer.EQUALS);
		list();
	}

	public void list() throws RecognitionException {
		match(BacktrackLexer.LBRACK);
		elements();
		match(BacktrackLexer.RBRACK);
	}

	
	public Token LT(int i) {
		sync(i);
		return lookahead.get(p+i-1);
	}

	void elements() throws RecognitionException {
		element();
		while (LA(1) == BacktrackLexer.COMMA) {
			match(BacktrackLexer.COMMA);
			element();
		}
	}

	void element() throws RecognitionException {
		if (LA(1) == BacktrackLexer.NAME && LA(2) == BacktrackLexer.EQUALS) {
			match(BacktrackLexer.NAME);
			match(BacktrackLexer.EQUALS);
			match(BacktrackLexer.NAME);
		}
		else if (LA(1) == BacktrackLexer.NAME) match(BacktrackLexer.NAME);
		else if (LA(1) == BacktrackLexer.LBRACK) list();
		else throw new  NoViableAltException("expecting element found " + LT(1));
	}

	
}
