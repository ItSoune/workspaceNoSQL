grammar NoSQL;
//parser rules
//expression : aggregate? listit block output group? order? export? EOF; // real
//listattr : attribute | attribute listattr;
start: expression* EOF;
expression : listit block output group? order?;

variable : SQL_WORD;
relation : SQL_WORD;
column : SQL_WORD;
column_num : INT;

table_identifier: variable | relation;
column_identifier: table_identifier POINT column
				 | column;
/*aggregation : AGGREGAT PAROUVR column_identifier PARFERM
			| column_identifier;*/

/*column: (variable POINT SQL_WORD)
	  | INT;*/

listattr : (column_identifier COMMA)* column_identifier;
listcolumn : ((column_identifier | column_num) COMMA)* (column_identifier | column_num);

iteration : FOREACH variable IN relation;
listit : iteration+ CREATE_TUPLE;
block : selection listexcl?
      | listexcl;
selection : SELECT_IF condition;
listexcl : exclusion+;
exclusion : EXCLUDE_IF condition;

condition : (logicaland OR)* logicaland;
logicaland : (logical AND)* logical; // modifications

logical : comparaison;

data: INT | FLOAT | STRING ;
comparaison: column_identifier OPERATOR data | column_identifier OPERATOR column_identifier | data OPERATOR column_identifier; 
output : OUTPUT (variable | listattr);
/*
logical : jointure | comparaison; // real
jointure : relation PAROUVR listmatch listagrega PARFERM;
listmatch : attribute MATCHES attribute | attribute MATCHES attribute listmatch;
listagrega : attribute AS attribute | attribute AS attribute listmatch; 
*/
group : PER listattr;
order : ORDER_BY listcolumn (FETCH_FIRST_ROWS (WITH_SAME listattr | WITHIN PERCENTAGE PERCENTAGE_SIGN column_identifier))?;
export : INTO_TABLE relation;


//lexer rules (tokens)


MAX : 'max';
MIN : 'min';
DISTINCT : 'distinct';
AVG : 'avg';
COUNT : 'count';
AGGREGAT : MAX | MIN | DISTINCT | AVG | COUNT;
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



PER : 'per';
ORDER_BY : 'order_by';
FETCH_FIRST_ROWS : 'fetch_first_rows';
WITH_SAME : 'with_same';
WITHIN : 'within';
INTO_TABLE : 'into_table';


fragment NUMERIC: '0'..'9';
fragment LETTER: ('a'..'z' | 'A'..'Z');
PERCENTAGE : NUMERIC NUMERIC?;
PERCENTAGE_SIGN : '%';

SQL_WORD : LETTER (LETTER | '_' | NUMERIC)*;

OPERATOR : '==' | '<' | '>' | '<=' | '>=' | '!=';

STRING : '"' ~["]* '"' 
	   | '\'' ~[']* '\'';   //must be anything in quotes
FLOAT : '-'? NUMERIC+ '.' NUMERIC+;

INT : '-'? NUMERIC+;

WHITESPACE : (' ' | '\t' | '\n' | '\r') -> skip;








