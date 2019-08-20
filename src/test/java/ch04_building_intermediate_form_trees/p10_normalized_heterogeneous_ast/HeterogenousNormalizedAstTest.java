package ch04_building_intermediate_form_trees.p10_normalized_heterogeneous_ast;

import ch04_building_intermediate_form_trees.p09_homogeneous_ast.Token;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class HeterogenousNormalizedAstTest {

    @Test
    void testAst() {
        Token plus = new Token(Token.PLUS, "+");
        Token one = new Token(Token.INT, "1");
        Token two = new Token(Token.INT, "2");

        ExprNode root = new AddNode(new IntNode(one), plus, new IntNode(two));
        String repr = root.toStringTree();

        assertThat(repr, equalTo("(+ 1<type=tINTEGER> 2<type=tINTEGER>)"));
    }
}
