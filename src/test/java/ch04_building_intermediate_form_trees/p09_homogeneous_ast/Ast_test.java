package ch04_building_intermediate_form_trees.p09_homogeneous_ast;

import org.junit.jupiter.api.Test;
import p09_homogeneous_ast.AST;
import p09_homogeneous_ast.Token;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Ast_test {

    Token one = new Token(Token.INT, "1");
    Token two = new Token(Token.INT, "2");

    @Test
    public void test_ast_nested() {
        Token plus = new Token(Token.PLUS, "+");

        AST root = new AST(plus);
        root.addChild(new AST(one));
        root.addChild(new AST(two));

        String result = root.toStringTree();
        assertThat(result, equalTo("(+ 1 2)"));
    }

    @Test
    public void test_ast_list() {
        AST list = new AST(); // nil node
        list.addChild(new AST(one));
        list.addChild(new AST(two));

        String result = list.toStringTree();
        assertThat(result, equalTo("1 2"));
    }
}
