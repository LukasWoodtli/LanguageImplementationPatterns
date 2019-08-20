package ch04_building_intermediate_form_trees.p10_normalized_heterogeneous_ast;

import ch04_building_intermediate_form_trees.p09_homogeneous_ast.Token;

public class IntNode extends ExprNode {
    public IntNode(Token t) {
        super(t);
        evalType = tINTEGER;
    }
}
