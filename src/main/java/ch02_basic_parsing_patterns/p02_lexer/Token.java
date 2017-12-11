package ch02_basic_parsing_patterns.p02_lexer;

public class Token {
    public int type;
    public String text;
  
    public Token(int type, String text) {
        this.type = type;
        this.text = text;
    }

    public String toString() {
        String tname = ListLexer.tokenNames[type];
        return "<'" + text + "'," + tname + ">";
    }
}