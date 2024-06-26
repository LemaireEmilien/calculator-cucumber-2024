/*
BSD License

Copyright (c) 2013, Tom Everett
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. Neither the name of Tom Everett nor the names of its contributors
   may be used to endorse or promote products derived from this software
   without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

// $antlr-format alignTrailingComments true, columnLimit 150, minEmptyLines 1, maxEmptyLinesToKeep 1, reflowComments false, useTab false
// $antlr-format allowShortRulesOnASingleLine false, allowShortBlocksOnASingleLine true, alignSemicolons hanging, alignColons hanging

grammar Calculator;

init
    : expression EOF
    | postfix_expression EOF
    | prefix_expression EOF
    | boolean_expression EOF
    ;

// infix expression
expression
    : multiplyingExpression
    | expression ((PLUS | MINUS) multiplyingExpression)
    ;

multiplyingExpression
    : powExpression
    | multiplyingExpression ((TIMES | DIV) powExpression)
    | LPAREN expression RPAREN (LPAREN expression RPAREN)+
    ;

powExpression
    : signedAtom (POW powExpression)?
    ;

// postfix expression
postfix_expression
    : LPAREN (postfix_expression COMMA?)+ RPAREN (PLUS | MINUS | TIMES | DIV)
    | signedAtom
    ;


// prefix expression
prefix_expression
    : (PLUS | MINUS | TIMES | DIV) LPAREN (prefix_expression COMMA?)+ RPAREN
    | signedAtom
    ;

// boolean expression
boolean_expression: implication;
implication: orExpression (IMPLIES orExpression)*;
orExpression: xorExpression (OR xorExpression)*;
xorExpression: andExpression (XOR andExpression)*;
andExpression: notExpression (AND notExpression)*;
notExpression: (NOT)? batom;
batom: LPAREN boolean_expression RPAREN | BOOLEAN;

AND: '&';
OR: '|';
XOR: '^';
NOT: '!';
IMPLIES: '=>';
BOOLEAN: 'true' | 'false';

// Atom
signedAtom
    : PLUS atom
    | MINUS atom
    | func_
    | atom
    ;

atom
    : scientific
    | constant
    | rational
    | LPAREN expression RPAREN
    ;

rational
    : scientific FRAC scientific
    ;

scientific
    : SCIENTIFIC_NUMBER
    ;

constant
    : PI
    | EULER
    ;

func_
    : funcname LPAREN expression (COMMA expression)* RPAREN
    ;

funcname
    : COS
    | TAN
    | SIN
    | ACOS
    | ATAN
    | ASIN
    | LOG
    | LN
    | SQRT
    | MOD
    | RAND
    ;

COS
    : 'cos'
    ;

SIN
    : 'sin'
    ;

TAN
    : 'tan'
    ;

ACOS
    : 'acos'
    ;

ASIN
    : 'asin'
    ;

ATAN
    : 'atan'
    ;

LN
    : 'ln'
    ;

LOG
    : 'log'
    ;

SQRT
    : 'sqrt'
    ;

MOD
    : 'mod'
    ;

RAND
    : 'rand'
    ;

LPAREN
    : '('
    ;

RPAREN
    : ')'
    ;

PLUS
    : '+'
    ;

MINUS
    : '-'
    ;

TIMES
    : '*'
    ;

DIV
    : '/'
    ;

COMMA
    : ','
    ;

POINT
    : '.'
    ;

POW
    : '**'
    ;

PI
    : 'pi'
    ;

EULER
    : E2
    ;

FRAC
    : '⁄'
    ;

SCIENTIFIC_NUMBER
    : NUMBER ((E1 | E2) SIGN? NUMBER)?
    ;

fragment NUMBER
    : '0' ..'9'+ ('.' '0' ..'9'+)?
    ;

fragment E1
    : 'E'
    ;

fragment E2
    : 'e'
    ;

fragment SIGN
    : '+'
    | '-'
    ;

WS
    : [ \r\n\t]+ -> skip
    ;