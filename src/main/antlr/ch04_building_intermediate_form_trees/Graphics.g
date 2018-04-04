// START: grammar
grammar Graphics;

@lexer::header {
    package ch04_building_intermediate_form_trees;
}

@parser::header {
    package ch04_building_intermediate_form_trees;
}

file : command+; // a file is a  list of commands
command : 'line' 'from' point 'to' point;

point : INT ',' INT;
// END: grammar

// START: lex

INT : '0'..'9'+;

/** Skip whitespace */
WS : (' ' | '\t' | '\r' | '\n') {skip();};
// END: lex
