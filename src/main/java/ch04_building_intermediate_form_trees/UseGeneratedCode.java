package ch04_building_intermediate_form_trees;

import org.antlr.runtime.*;


public class UseGeneratedCode {

	public static void run() throws Exception {
		CharStream input = new ANTLRFileStream("src/main/java/ch04_building_intermediate_form_trees/files/box");
		GraphicsLexer lex = new GraphicsLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lex);
		GraphicsParser p = new GraphicsParser(tokens);
		p.file(); // start parsing at file rule

	}

}
