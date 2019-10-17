package ch05_walking_and_rewriting_trees.p14_tree_grammar;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

public class UseGeneratedTreeGrammar {
    public static void run() throws Exception {
        VecMathLexer lex = new VecMathLexer(new ANTLRStringStream("x = 3+4\n" +
                "print x * [2, 3, 4]"));
        CommonTokenStream tokens = new CommonTokenStream(lex);
        VecMathParser p = new VecMathParser(tokens);
        RuleReturnScope r = p.prog(); // calling start rule

        // get result
        CommonTree tree = (CommonTree)r.getTree();
        System.out.println(tree.toString());

        CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
        Printer tp = new Printer(nodes);
        tp.prog();
    }
}
