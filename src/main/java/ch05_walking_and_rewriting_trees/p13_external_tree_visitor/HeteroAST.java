package ch05_walking_and_rewriting_trees.p13_external_tree_visitor;

public class HeteroAST {// Heterogeneous AST node type
    Token token;        // This node created from which token?
    public HeteroAST()        { ; }
    public HeteroAST(Token t) { this.token = t; }
    public String toString()  { return token.toString(); }
}
