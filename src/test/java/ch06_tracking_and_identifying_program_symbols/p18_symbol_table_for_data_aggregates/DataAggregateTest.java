package ch06_tracking_and_identifying_program_symbols.p18_symbol_table_for_data_aggregates;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DataAggregateTest {

    @Test
    public void testDataAggregates() throws RecognitionException {
        String input =
                "struct A {" +
                "int x;" +
                "   float y;" +
                "};" +
                "void f() {" +
                "   A a;" +
                "   a.x = 1;" +
                "}\n";

        var stream = new ANTLRStringStream(input);
        var lex = new CymbolLexer(stream);
        var tokens = new CommonTokenStream(lex);
        var p = new CymbolParser(tokens);

        var r = p.compilationUnit();   // launch parser
        var t = (CommonTree)r.getTree();    // get tree result
        assertThat(t.toStringTree(),
                equalTo("(struct A (FIELD_DECL int x) (FIELD_DECL float y)) " +
                        "(METHOD_DECL void f (BLOCK (VAR_DECL A a) (= (. a x) (EXPR 1))))"));

        var nodes = new CommonTreeNodeStream(t);
        nodes.setTokenStream(tokens);

        var symtab = new SymbolTable();
        var def = new DefRef(nodes, symtab); // use custom constructor
        def.downup(t); // trigger symtab actions upon certain subtrees

        var globals = symtab.globals.toString();
        assertThat(globals, equalTo("[int, float, void]"));
    }
}
