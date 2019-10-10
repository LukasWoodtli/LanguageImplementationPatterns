package ch04_building_intermediate_form_trees.p11_irregular_heterogeneous_ast;

public abstract class HeteroAST {
    protected Token token;

    public HeteroAST() {
    }

    public HeteroAST(Token t) {
        token = t;
    }

    public HeteroAST(int tokenType) {
        this.token = new Token(tokenType);
    }

    public String toString() {
        return token.toString();
    }

    public String toStringTree() {
        return toString();
    }
}
