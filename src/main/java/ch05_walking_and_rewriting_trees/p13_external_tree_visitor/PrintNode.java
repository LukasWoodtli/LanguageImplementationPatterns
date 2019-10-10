package ch05_walking_and_rewriting_trees.p13_external_tree_visitor;

public class PrintNode extends StatNode {
    ExprNode value;
    public PrintNode(Token t, ExprNode value) {
        super(t); this.value = value;
    }
    public void visit(VecMathVisitor visitor) { visitor.visit(this); }
}
