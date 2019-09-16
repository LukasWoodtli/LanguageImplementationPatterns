package ch04_building_intermediate_form_trees.p11_irregular_heterogeneous_ast;

public class AddNode extends ExprNode {
    ExprNode left, right;

    public AddNode(ExprNode left, Token addToken, ExprNode right) {
        super(addToken);
        this.left = left;
        this.right = right;
    }

    public String toStringTree() {
        if (left == null || right == null)
            return this.toString();

        StringBuilder buf = new StringBuilder();
        buf.append("(");
        buf.append(this.toString());
        buf.append(" ");
        buf.append(left.toString());
        buf.append(" ");
        buf.append(right.toString());
        buf.append(")");
        return buf.toString();
    }

}
