package ch04_building_intermediate_form_trees.p10_normalized_heterogeneous_ast;

import ch04_building_intermediate_form_trees.p09_homogeneous_ast.Token;

import java.util.List;

public class VectorNode extends ExprNode {
    public VectorNode(Token t, List<ExprNode> elements) {
        super(t);
        evalType = tVECTOR;

        for (ExprNode e : elements) {
            addChild(e);
        }
    }
}
