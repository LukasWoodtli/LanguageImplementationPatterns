package ch05_walking_and_rewriting_trees.p13_external_tree_visitor;

public class MultNode extends ExprNode {
    ExprNode left, right; // named, node-specific, irregular children
    public MultNode(ExprNode left, Token t, ExprNode right) {
        super(t);
        this.left = left;
        this.right = right;
    }
    public void visit(VecMathVisitor visitor) { visitor.visit(this); }
}
