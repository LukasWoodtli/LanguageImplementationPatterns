package ch04_building_intermediate_form_trees.p10_normalized_heterogeneous_ast;

import ch04_building_intermediate_form_trees.p09_homogeneous_ast.Token;

public class AddNode extends ExprNode {
    public AddNode(ExprNode left, Token addToken, ExprNode right) {
        super(addToken);
        addChild(left);
        addChild(right);
    }

    public int getEvalType() {
        ExprNode left = (ExprNode) children.get(0);
        ExprNode right = (ExprNode) children.get(1);

        if (left.getEvalType() == tINTEGER && right.getEvalType() == tINTEGER) {
            return tINTEGER;
        }

        if (left.getEvalType() == tVECTOR && right.getEvalType() == tVECTOR) {
            return tVECTOR;
        }

        return tINVALID;
    }

}
