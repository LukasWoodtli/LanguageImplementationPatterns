package ch04_building_intermediate_form_trees.p11_irregular_heterogeneous_ast;

import org.junit.jupiter.api.Test;

public class HeterogeneousAstTest {
    @Test
    public void testAst() {
        Token plus = new Token(Token.PLUS,"+");
        Token one = new Token(Token.INT,"1");
        Token two = new Token(Token.INT,"2");
        ExprNode root = new AddNode(new IntNode(one), plus, new IntNode(two));
        System.out.println(root.toStringTree());
    }
}
