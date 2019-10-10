package ch05_walking_and_rewriting_trees.p13_external_tree_visitor;

import java.util.ArrayList;
import java.util.List;

/** A flat tree ==  tree with nil root: (nil child1 child2 ...) */
public class StatListNode extends VecMathNode {
    List<StatNode> elements = new ArrayList<StatNode>();
    public StatListNode(List<StatNode> elements) {
        super(new Token(Token.STAT_LIST)); // create imaginary token
        this.elements = elements;
    }
    public void visit(VecMathVisitor visitor) { visitor.visit(this); }    
}
