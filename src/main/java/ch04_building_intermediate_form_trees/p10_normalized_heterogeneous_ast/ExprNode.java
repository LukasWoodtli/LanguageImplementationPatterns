package ch04_building_intermediate_form_trees.p10_normalized_heterogeneous_ast;

import ch04_building_intermediate_form_trees.p09_homogeneous_ast.AST;
import ch04_building_intermediate_form_trees.p09_homogeneous_ast.Token;

public abstract class ExprNode extends AST {
    static final int tINVALID = 0;
    static final int tINTEGER = 1;
    static final int tVECTOR = 2;

    int evalType;

    ExprNode(Token payload) {
        super(payload);
    }

    public int getEvalType() {
        return evalType;
    }

    public String toString() {
        if (evalType != tINVALID) {
            return super.toString() + "<type=" +
                    (evalType == tINTEGER ? "tINTEGER" : "tVECTOR") + ">";
        }

        return super.toString();
    }
}
