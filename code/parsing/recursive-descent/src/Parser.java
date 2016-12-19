public abstract class Parser {
	Lexer input;	 //from where do we get tokens?
	Token lookahead; // The current lookahead token
	
	public Parser(Lexer input) { this.input = input; consume();}
	
	/** if lookahead token type matches x, consume & return else error */
	public void match(int x) {
		if ( lookahead.type == x) consume();
		else throw new Error("expecting " + input.getTokenName(x) +
				"; found " + lookahead);
	}
	
	public void consume() { lookahead = input.nextToken(); }
}
