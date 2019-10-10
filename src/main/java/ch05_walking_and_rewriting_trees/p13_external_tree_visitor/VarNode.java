package ch05_walking_and_rewriting_trees.p13_external_tree_visitor;

public class VarNode extends ExprNode {
    public VarNode(Token t) { super(t); }
    public void visit(VecMathVisitor visitor) { visitor.visit(this); }    
}
