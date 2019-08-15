package p09_homogeneous_ast;

public class Token {
    public static final int INVALID_TOKEN_TYPE = 0;
    public static final int PLUS = 1;
    public static final int INT = 2;

    private String text = "";
    int tokenType;

    public Token(int tokenType) {
        this.tokenType = tokenType;
    }

    public Token(int tokenType, String text) {
        this.tokenType = tokenType;
        this.text = text;
    }

    public String toString() {
        return text;
    }
}
