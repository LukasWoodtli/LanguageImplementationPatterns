package ch03_enhanced_parsing_patterns.p05_backtracking;

import java.util.ArrayList;
import java.util.List;


public abstract class Parser {
	Lexer input;
	List<Integer> markers;
	List<Token> lookahead;
	int p = 0;

	public Parser(Lexer input) {
		this.input = input;
		markers = new ArrayList<Integer>();
		lookahead = new ArrayList<Token>();
		sync(1); // prime lookahead
	}

	public void consume() {
		p++;
		// have we hit end of buffer when not backtracking?
		if (p == lookahead.size() && !isSpeculating()) {
			p = 0;
			lookahead.clear();
		}
		sync(1);
	}

	/** Make sure we have i tokens from current position p */
	public void sync(int i) {
		if (p+i-1 > lookahead.size() - 1) {
			int n = (p + i -1) - (lookahead.size() - 1);
			fill(n);
		}
	}

	
	public void fill(int n) { // add n tokens
		for (int i=1; i<=n; i++) {
			lookahead.add(input.nextToken());
		}
	}

	public Token LT(int i) {
		sync(i);
		return lookahead.get(p + i - 1);
	}
	
	public int LA(int i) {
		return LT(i).type;
	}

	public void match(int x) throws MismatchedTokenException {
		if (LA(1) == x)
			consume();
		else {
			Token lt1 = LT(1);
			String msg = "expecting " +
					input.getTokenName(x) +
					" found " + lt1;
			throw new MismatchedTokenException(msg);	
		}
	}
	
	public int mark() {
		markers.add(p);
		return p;
	}
	
	public void release() {
		int marker = markers.get(markers.size() - 1);
		markers.remove(markers.size() - 1);
		seek(marker);
	}
	
	public void seek(int index) {
		p = index;
	}
	
	public boolean isSpeculating() {
		return markers.size() > 0;
	}
}
