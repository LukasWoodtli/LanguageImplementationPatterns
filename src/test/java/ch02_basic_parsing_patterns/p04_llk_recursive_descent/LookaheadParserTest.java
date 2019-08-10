package ch02_basic_parsing_patterns.p04_llk_recursive_descent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LookaheadParserTest {

    @Test
    public void testOk() {
        LookaheadLexer lexer = new LookaheadLexer("[a,b=c,[d,e]]");
        LookaheadParser parser = new LookaheadParser(lexer, 2);

        parser.list();

    }

    @Test
    public void testFail() {
        LookaheadLexer lexer = new LookaheadLexer("[a,b=c,,[d,e]]");
        LookaheadParser parser = new LookaheadParser(lexer, 2);

        Assertions.assertThrows(java.lang.Error.class, () -> {
            parser.list();
        });


    }

}
