grammar Oberon;

module
    : 'MODULE' ident ';' (importSection)? (declaration)* 'BEGIN' (statement)* 'END' ident '.'
    ;

importSection
    : 'IMPORT' importList ';'
    ;

importList
    : ident (',' ident)*
    ;

declaration
    : varDeclaration
    | arrayDeclaration
    | functionOrProcedure
    ;

varDeclaration
    : 'VAR' identList ':' type ';'
    ;

arrayDeclaration
    : 'VAR' identList ':' arrayType ';'
    ;

arrayType
    : 'ARRAY' '[' number ']' 'OF' type
    ;

type
    : 'INTEGER' | 'REAL' | 'BOOLEAN' | 'STRING'
    | arrayType
    ;

identList
    : ident (',' ident)*
    ;

functionOrProcedure
    : procedureDeclaration
    | functionDeclaration
    ;

procedureDeclaration
    : 'PROCEDURE' ident '(' (parameterList)? ')' ';' (procedureStatement)* 'END' ident ';'
    ;

functionDeclaration
    : 'FUNCTION' ident '(' (parameterList)? ')' ':' type ';' (procedureStatement)* 'END' ident ';'
    ;

parameterList
    : parameterDecl (';' parameterDecl)*
    ;

parameterDecl
    : ('VAR')? identList ':' type
    | ('VAR')? identList ':' 'ARRAY' '[' number ']' 'OF' type
    ;

statement
    : (assignment | procedureCall | conditional | whileLoop | forLoop | repeatLoop | returnStatement) ';'
    ;

procedureStatement
    : (assignment | procedureCall | conditional | whileLoop | forLoop | repeatLoop | returnStatement) ';'
    ;

assignment
    : ident ':=' expression
    | ident '[' expression ']' ':=' expression
    | ident multiDimensionalIndex ':=' expression
    ;

multiDimensionalIndex
    : '[' expression (',' expression)+ ']'
    ;


procedureCall
    : qualifiedIdent '(' (argumentList)? ')' ';'
    ;

qualifiedIdent
    : ident ('.' ident)*
    ;

argumentList
    : argument (',' argument)*
    ;

argument
    : expression
    ;

returnStatement
    : 'RETURN' expression
    ;

expression
    : simpleExpression (relation simpleExpression)?
    ;

simpleExpression
    : ('+' | '-')? term (('+' | '-') term)*
    ;

term
    : factor (('*' | '/') factor)*
    ;

factor
    : qualifiedIdent
    | number
    | '(' expression ')'
    | STRING
    | ident '[' expression ']'
    ;

conditional
    : 'IF' expression 'THEN' (procedureStatement)* ('ELSE' (procedureStatement)*)? 'END'
    ;

whileLoop
    : 'WHILE' expression 'DO' (procedureStatement)* 'END'
    ;

forLoop
    : 'FOR' assignment 'TO' expression 'DO' (procedureStatement)* 'END'
    ;

repeatLoop
    : 'REPEAT' (procedureStatement)* 'UNTIL' expression
    ;

relation
    : '=' | '#' | '<' | '<=' | '>' | '>='
    ;

ident
    : IDENTIFIER
    ;

number
    : NUMBER
    ;

STRING
    : '"' (~["\r\n])* '"'
    ;


IDENTIFIER
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

NUMBER
    : [0-9]+
    ;

WS
    : [ \t\r\n]+ -> skip
    ;
