package ch05_walking_and_rewriting_trees.p13_external_tree_visitor;

public class IntNode extends ExprNode {
    public IntNode(Token t) { super(t); }
    public void visit(VecMathVisitor visitor) { visitor.visit(this); }
}
