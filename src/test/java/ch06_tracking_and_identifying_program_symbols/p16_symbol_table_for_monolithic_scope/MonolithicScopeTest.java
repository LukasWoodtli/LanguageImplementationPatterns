package ch06_tracking_and_identifying_program_symbols.p16_symbol_table_for_monolithic_scope;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MonolithicScopeTest {

        @Test
        public void testPrinter() throws RecognitionException {
                var input = "int i = 9;\n" +
                        "float j;\n" +
                        "int k = i+2;";

                var stream = new ANTLRStringStream(input);
                var lex = new CymbolLexer(stream);
                var tokens = new CommonTokenStream(lex);
                var p = new CymbolParser(tokens);
                var symbolTable = new SymbolTable();
                p.compilationUnit(symbolTable);
                final var globals = "globals: " + symbolTable.symbols;
                assertThat(globals, equalTo("globals: {i=<i:int>, j=<j:float>, k=<k:int>, float=float, int=int}"));
        }
}
