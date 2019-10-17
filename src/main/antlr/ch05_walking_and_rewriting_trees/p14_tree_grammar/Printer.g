
tree grammar Printer;
options {
    // use token vocabulary from VecMath.g
    tokenVocab=VecMath;
    // use homogeneous CommonTree for $ID, etc.
    ASTLabelType=CommonTree;
}

@header {
package ch05_walking_and_rewriting_trees.p14_tree_grammar;
}

@members { void print(String s) { System.out.print(s); } }

prog:   stat+ ; // match list of statement subtrees
// match trees like ('=' x 1) and ('print' ('+' 3 4))
stat:   ^('=' ID  {print($ID.text+" = ");} expr) {print("\n");}
    |   ^('print' {print("print ");}       expr) {print("\n");}
    ;


expr: ^('+' expr {print("+");} expr)
    |  ^('*' expr {print("*");} expr)
    |  ^('.' expr {print(".");} expr)
    | ^(VEC {print("[");} expr ({print(", ");} expr)* {print("]");})
    | INT {print($INT.text);}
    | ID {print($ID.text);}
    ;