package ch05_walking_and_rewriting_trees.p13_external_tree_visitor;

public class PrintVisitor implements VecMathVisitor {
    @Override
    public void visit(AssignNode n) {
        n.id.visit(this);
        System.out.print("=");
        n.value.visit(this);
        System.out.println();
    }

    @Override
    public void visit(StatListNode n) {
        for (StatNode p : n.elements) p.visit(this);
    }

    @Override
    public void visit(PrintNode n) {
        System.out.print("print ");
        n.value.visit(this);
        System.out.println();
    }

    public void visit(AddNode n) {
        n.left.visit(this);
        System.out.print("+");
        n.right.visit(this);
    }

    public void visit(DotProductNode n) {
        n.left.visit(this);
        System.out.print(".");
        n.right.visit(this);
    }

    public void visit(MultNode n) {
        n.left.visit(this);
        System.out.print("*");
        n.right.visit(this);
    }

    public void visit(IntNode n) {
        System.out.print(n.toString());
    }

    public void visit(VarNode n) {
        System.out.print(n.toString());
    }

    public void visit(VectorNode n) {
        System.out.print("[");
        if ( n.elements!=null ) {
            for (int i=0; i<n.elements.size(); i++) {
                ExprNode child = n.elements.get(i);
                if ( i>0 ) System.out.print(", ");
                child.visit(this);
            }
        }
        System.out.print("]");
    }
}
