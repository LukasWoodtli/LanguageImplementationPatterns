package ch05_walking_and_rewriting_trees.p13_external_tree_visitor;

public class Token {
    public static final int INVALID_TOKEN_TYPE = 0;
    public static final int PLUS = 1; // token types
    public static final int MULT = 2;
    public static final int DOT = 3;
    public static final int INT = 4;
    public static final int VEC = 5;
    public static final int ID = 6;
    public static final int ASSIGN = 7;
    public static final int PRINT = 8;
    public static final int STAT_LIST = 9;

    public int type;
    public String text;
    public Token(int type, String text) { this.type = type; this.text = text; }
    public Token(int type) { this.type = type; }
    public String toString() { return text; }
}
