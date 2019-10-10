package ch05_walking_and_rewriting_trees.p13_external_tree_visitor;


public class AssignNode extends StatNode {
    VarNode id;
    ExprNode value;
    public AssignNode(VarNode id, Token t, ExprNode value) {
        super(t);
        this.id = id;
        this.value = value;
    }
    public void visit(VecMathVisitor visitor) { visitor.visit(this); }
}
