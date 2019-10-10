package ch05_walking_and_rewriting_trees.p13_external_tree_visitor;

import java.util.ArrayList;
import java.util.List;

public class VectorNode extends ExprNode {
    List<ExprNode> elements = new ArrayList<ExprNode>();
    public VectorNode(Token t, List<ExprNode> elements) {
        super(t); // track vector token; most likely it's an imaginary token
        this.elements = elements;
    }
    public void visit(VecMathVisitor visitor) { visitor.visit(this); }
}
