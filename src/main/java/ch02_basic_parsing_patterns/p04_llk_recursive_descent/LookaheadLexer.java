package ch02_basic_parsing_patterns.p04_llk_recursive_descent;

import ch02_basic_parsing_patterns.p02_lexer.Lexer;
import ch02_basic_parsing_patterns.p02_lexer.Token;

public class LookaheadLexer extends Lexer {
    public static int NAME = 2;
    public static int COMMA = 3;
    public static int LBRACK = 4;
    public static int RBRACK = 5;
    public static int EQUALS = 6;
    public static String[] tokenNames = {"n/a", "<EOF>", "NAME", "COMMA", "LBRACK", "RBRACK", "EQUALS"};

    public String getTokenName(int x) {return tokenNames[x];}

    public LookaheadLexer(String input) {super(input);}

    boolean isLETTER() {return c>='a' && c<='z' || c>='A' && c<='Z';}

    public Token nextToken() {
        while (c != EOF) {
            switch (c) {
            case ' ': case '\t': case '\n': case '\r': WS(); continue;
            case ',': consume(); return new Token(COMMA, ",");
            case '[': consume(); return new Token(LBRACK, "[");
            case ']': consume(); return new Token(RBRACK, "]");
            case '=': consume(); return new Token(EQUALS, "=");
            default:
                if (isLETTER()) return NAME();
                throw new Error("invalid character: " + c);
            }
        }
        return new Token(EOF_TYPE, "<EOF>");
    }
    
    Token NAME() {
        StringBuilder buf = new StringBuilder();
        do {buf.append(c); consume(); } while (isLETTER());
        return new Token(NAME, buf.toString());
    }

    void WS() { 
        while (c ==' ' || c == '\t' || c == '\n' || c == '\r') consume();
    } 
}