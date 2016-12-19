list     : '[' elements ']';  // Match bracketed list
elements : element (',' element)*; // Match comma separated list
element  : NAME | list; // element is NAME or nested list
