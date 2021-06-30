package ch06_tracking_and_identifying_program_symbols.p17_symbol_table_for_nested_scope;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NestedScopeTest {

        @Test
        public void testPrinter() throws RecognitionException {
                var input = "// global scope\n" +
                        "float f(int x)\n" +
                        "{ \n" +
                        "    float i; \n" +
                        "    { float z = x+y; i = z; } \n" +
                        "}\n";

                var stream = new ANTLRStringStream(input);
                var lex = new CymbolLexer(stream);
                var tokens = new CommonTokenStream(lex);
                var p = new CymbolParser(tokens);

                RuleReturnScope r = p.compilationUnit();
                var t = (CommonTree)r.getTree();
                assertThat(t.toStringTree(),
                        equalTo("(METHOD_DECL float f (ARG_DECL int x) " +
                                "(BLOCK (VAR_DECL float i) (BLOCK (VAR_DECL float z " +
                                "(EXPR (+ x y))) (= i (EXPR z)))))"));

                var nodes = new CommonTreeNodeStream(t);
                nodes.setTokenStream(tokens);

                var symtab = new SymbolTable();
                DefRef def = new DefRef(nodes, symtab);
                def.downup(t);

                var globals = symtab.globals.toString();
                assertThat(globals, equalTo("[int, float, void, f]"));
        }
}
