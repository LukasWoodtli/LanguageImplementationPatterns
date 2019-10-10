package ch05_walking_and_rewriting_trees.p13_external_tree_visitor;

public abstract class VecMathNode extends HeteroAST {
    public VecMathNode() {}
    public VecMathNode(Token t) { this.token = t; }
    public abstract void visit(VecMathVisitor visitor); // dispatcher
}
