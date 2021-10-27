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
| number
| id
;


string
: WORD+
;

/*
expression
: number
| id
;
*/

number
: LPAREN number RPAREN                                              #parenthesisExpr
| number operatorToker=(MULTIPLY|DIVIDE) number                     #mulDivExpr
| number operatorToker=(ADD|SUB) number                             #addSumExpr
| <assoc=right> number EXP number                                   #expExpr
| number operatorToker=(MOD|DIV) number                             #modDivExpr
| operatorToker=(MMIN|MMAX) LPAREN (number( ',' number)*)? RPAREN   #functionExpr
| NUMBER                                                            #numericExpr
;

id
: LPAREN id RPAREN                                          #parenthesisCellExpr
| id operatorToker=(MULTIPLY|DIVIDE) id                     #mulDivCellExpr
| id operatorToker=(ADD|SUB) id                             #addSumCellExpr
| <assoc=right> id EXP id                                   #expCellExpr
| id operatorToker=(MOD|DIV) id                             #modDivCellExpr
| operatorToker=(MMIN|MMAX) LPAREN (id( ',' id)*)? RPAREN   #functionCellExpr
| ID                                                        #cellIDExpr
;


/*
arguments
: number( ',' number)*                      #funcArgExpr
| id( ',' id)*                              #funcArgCellExpr
;
*/

/*
* Lexer Rules
*/

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
NUMBER : ( DIGIT * '.' )? DIGIT+;
EXP : '^';
MULTIPLY : '*';
DIVIDE : '/';
SUB : '-';
ADD : '+';
MOD : 'mod';
DIV : 'div';
MMAX : 'mmax';
MMIN : 'mmin';
WORD : LETTER+;
CELL_COL : [A-Z]+;
CELL_ROW : DIGIT+;
ID : CELL_COL CELL_ROW;
LPAREN : '(';
RPAREN : ')';
WS : [ \t\r\n] -> channel(HIDDEN);
ANY : . ;