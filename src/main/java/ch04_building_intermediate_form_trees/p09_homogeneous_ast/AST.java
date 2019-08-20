package ch04_building_intermediate_form_trees.p09_homogeneous_ast;

import java.util.ArrayList;
import java.util.List;

public class AST {
    private Token token;
    private List<AST> children; // normalized list of children

    public AST() {
    }

    public AST(Token token) {
        this.token = token;
    }

    public AST(int tokenType) {
        this.token = new Token(tokenType);
    }

    /* External visitors execute the same action for all nodes
       with same type while walking . */
    public int getNodeType() {
        return token.tokenType;
    }

    public void addChild(AST t) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(t);
    }

    private boolean isNil() {
        return token == null;
    }

    public String toString() {
        return token != null ? token.toString() : "nil";
    }

    public String toStringTree() {
        if (children == null || children.size() == 0) {
            return this.toString();
        }

        StringBuilder buf = new StringBuilder();
        if (!isNil()) {
            buf.append("(");
            buf.append(this.toString());
            buf.append(' ');
        }

        for (int i = 0; i < children.size(); ++i) {
            AST t = children.get(i); // normalized children
            if (i > 0)
                buf.append(' ');
            buf.append(t.toStringTree());
        }

        if (!isNil())
            buf.append(')');

        return buf.toString();
    }
}
