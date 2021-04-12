package gramatica.usuarios;

import static gramatica.usuarios.ParserUsuariosSym.*;
import java_cup.runtime.*;

%%

%public
%class LexerUsuarios
%cup
%unicode
%line
%column
%{

%}

/*Identificadores*/
TerminacionLinea = [\r|\n|\r\n]
EspacioBlanco = [ \t\f]
Ignore = {TerminacionLinea} | [ \t\f]
NUMERO = [0-9]+
HEXADECIMAL = [a-zA-Z0-9]+

%%

<YYINITIAL> {
    "{"             {return new Symbol(LLAVE_A, yyline+1, yycolumn+1, yytext());}
    "}"             {return new Symbol(LLAVE_C, yyline+1, yycolumn+1, yytext());}
    ","             {return new Symbol(COMA, yyline+1, yycolumn+1, yytext());}
    ":"             {return new Symbol(PUNTOS, yyline+1, yycolumn+1, yytext());}
    ";"             {return new Symbol(PUNTO_COMA, yyline+1, yycolumn+1, yytext());}
    {NUMERO}        {return new Symbol(NUMERO, yyline+1, yycolumn+1, yytext());}
    {HEXADECIMAL}   {return new Symbol(HEXADECIMAL, yyline+1, yycolumn+1, yytext());}
    {Ignore}        {/*IGNORAR*/}
}
[^] {


}
