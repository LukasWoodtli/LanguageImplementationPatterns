package ch04_building_intermediate_form_trees.p08_parse_tree;

import java.util.ArrayList;
import java.util.List;

public abstract class ParseTree {
    public List<ParseTree> children; // normalized child list

    public RuleNode addChild(String value) {
        RuleNode r = new RuleNode(value);
        addChild(r);
        return r;
    }

    public void addChild(ParseTree t) {
        if (children == null) {
            children = new ArrayList<ParseTree>();
        }
        children.add(t);
    }
}
