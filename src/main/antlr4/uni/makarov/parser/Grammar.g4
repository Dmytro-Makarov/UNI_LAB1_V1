grammar Grammar;

//В7
//1,2,4,7
//+,-.*,/
//mod,div
//^
//mmax,mmin

/*
* Parser Rules
*/



parse
: string
| expression
;


string
: WORD+
| ANY+
;


expression
: LPAREN expression RPAREN                                                  #parenthesisExpr
| <assoc=right> expression EXP expression                                   #expExpr
| expression operatorToker=(MULTIPLY|DIVIDE) expression                     #mulDivExpr
| expression operatorToker=(MOD|DIV) expression                             #modDivExpr
| expression operatorToker=(ADD|SUB) expression                             #addSumExpr
| operatorToker=(MMIN|MMAX) LPAREN (expression (',' expression)+)? RPAREN      #functionExpr
| NUMBER                                                                    #numericExpr
| ID                                                                        #cellIDExpr
;


/*
* Lexer Rules
*/

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
fragment SYMBOLS: [!?"'.`;:];
NUMBER : ('-')? ( DIGIT * '.' )? DIGIT+;
EXP : '^';
MULTIPLY : '*';
DIVIDE : '/';
SUB : '-';
ADD : '+';
MOD : 'mod';
DIV : 'div';
MMAX : 'mmax';
MMIN : 'mmin';
WORD : LETTER+ | SYMBOLS;
CELL_COL : [A-Z]+;
CELL_ROW : DIGIT+;
ID : CELL_COL CELL_ROW;
LPAREN : '(';
RPAREN : ')';
WS : [ \t\r\n] -> channel(HIDDEN);
ANY : . ;