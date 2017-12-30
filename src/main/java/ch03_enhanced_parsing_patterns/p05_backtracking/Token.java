package ch03_enhanced_parsing_patterns.p05_backtracking;

public class Token {
    public int type;
    public String text;
  
    public Token(int type, String text) {
        this.type = type;
        this.text = text;
    }

    public String toString() {
        String tname = BacktrackLexer.tokenNames[type];
        return "<'" + text + "'," + tname + ">";
    }
}