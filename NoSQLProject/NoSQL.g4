grammar NoSQL;
//parser rules
//compilationUnit : ( variable | output ) EOF; //root rule - globally code consist only of variables and prints (see definition below)
//expression : listit CREATE_TUPLE block output group+ order+ export+ EOF; // real
//listattr : attribute | attribute listattr;
start: expression*;
expression : listit CREATE_TUPLE block output EOF;
variable : SQL_WORD;
relation : SQL_WORD;
attribute: SQL_WORD
         | variable POINT SQL_WORD;
listattr : (attribute COMMA)* attribute;

iteration : FOREACH variable IN relation;
listit : iteration+;

block : selection listexcl?
      | listexcl;
selection : SELECT_IF condition;
listexcl : exclusion+;
exclusion : EXCLUDE_IF condition;

condition : logical 
          | (logical AND)+ logical
          | (logical OR)+ logical;
logical : comparaison;
data: INT | FLOAT | STRING ;
comparaison: attribute OPERATOR data | attribute OPERATOR attribute | data OPERATOR attribute; 
output : OUTPUT (listattr | variable);

/*

logical : jointure | comparaison; // real
jointure : relation PAROUVR listmatch listagrega PARFERM;
listmatch : attribute MATCHES attribute | attribute MATCHES attribute listmatch;
listagrega : attribute AS attribute | attribute AS attribute listmatch; 



group : PER listattr;
order : ORDER_BY listattr (FETCH_FIRST_ROWS (WITH_SAME listattr | WITHIN attribute));
export : INTO_TABLE relation;
*/

//lexer rules (tokens)

FOREACH : 'foreach';
IN : 'in';
CREATE_TUPLE : 'create_tuple';
SELECT_IF : 'select_if';
POINT : '.';
EXCLUDE_IF : 'exclude_if';
PAROUVR : '(';
PARFERM : ')';
AND : 'and';
OR : 'or';
AS : 'as';
MATCHES : 'matches';
OUTPUT : 'output';
COMMA: ',';


/*
PER : 'per';
ORDER_BY : 'order_by';
FETCH_FIRST_ROWS : 'fetch_first_rows';
WITH_SAME : 'with_same';
WITHIN : 'within';
INTO_TABLE : 'into_table';
*/

fragment PARENTHESIS: '"' | '\'';
fragment NUMERIC: '0'..'9';
fragment LETTER: ('a'..'z' | 'A'..'Z');
fragment CHAR: . ;


SQL_WORD : LETTER (LETTER | '_' | NUMERIC)*;



OPERATOR : '==' | '<' | '>' | '<=' | '>=' | '!=';

STRING : PARENTHESIS CHAR* PARENTHESIS ;   //must be anything in quotes
FLOAT : '-'? NUMERIC+ '.' NUMERIC+;

INT : '-'? NUMERIC+;



WHITESPACE : (' ' | '\t' | '\n' | '\r') -> skip;








