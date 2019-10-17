grammar VecMath;
options {output=AST;}

// define imaginary token for vector literal
tokens { VEC; }

@lexer::header {
package ch05_walking_and_rewriting_trees.p14_tree_grammar;
}

@parser::header {
package ch05_walking_and_rewriting_trees.p14_tree_grammar;
}


prog:	stat+ ;                         // build list of stat trees
stat:	ID '=' expr  -> ^('=' ID expr)  // '=' is operator subtree root
    |	'print' expr -> ^('print' expr) // 'print' is subtree root
    ;

expr:	multExpr ('+'^ multExpr)* ;     // '+' is root node

multExpr
    :   primary (('*'^|'.'^) primary)*  // '*', '.' are roots
    ;
    
primary
    :   INT
    |   ID
    |   '[' expr (',' expr)* ']' -> ^(VEC expr+)
    ;

ID  :   'a'..'z'+ ;
INT :   '0'..'9'+ ;
WS  :   (' '|'\r'|'\n')+ {skip();} ;
