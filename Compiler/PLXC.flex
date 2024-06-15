import java_cup.runtime.*;

%%


%cup
//%debug

%{
    String variable = "";
    String aux = "";
%}

%%
"("                                                   { return new Symbol(sym.AP); }
")"                                                   { return new Symbol(sym.CP); }
"{"                                                   { return new Symbol(sym.ALL); }
"}"                                                   { return new Symbol(sym.CLL); }
"["                                                   { return new Symbol(sym.AC); }
"]"                                                   { return new Symbol(sym.CC); }

","                                                   { return new Symbol(sym.COMA); }
"."                                                   { return new Symbol(sym.PUNTO); }
"\'"                                                  { return new Symbol(sym.COMILLAS_SIMPLES); }
";"                                                   { return new Symbol(sym.PYC); }

"="                                                   { return new Symbol(sym.ASIG); }
"+"                                                   { return new Symbol(sym.MAS); }
"-"                                                   { return new Symbol(sym.MENOS); }
"*"                                                   { return new Symbol(sym.POR); }
"/"                                                   { return new Symbol(sym.DIV); }

"=="                                                  { return new Symbol(sym.IGUALDAD); }
"!="                                                  { return new Symbol(sym.NO_IGUALDAD); }
"<"                                                   { return new Symbol(sym.MENOR); }
"<="                                                  { return new Symbol(sym.MENOR_IGUAL); }
">"                                                   { return new Symbol(sym.MAYOR); }
">="                                                  { return new Symbol(sym.MAYOR_IGUAL); }
"&&"                                                  { return new Symbol(sym.AND); }
"||"                                                  { return new Symbol(sym.OR); }
"!"                                                   { return new Symbol(sym.NOT); }
"<-->"                                                { return new Symbol(sym.DIMPLICA); }

"if"                                                  { return new Symbol(sym.IF, yytext() ); }
"else"                                                { return new Symbol(sym.ELSE, yytext() ); }
"while"                                               { return new Symbol(sym.WHILE, yytext() ); }
"do"                                                  { return new Symbol(sym.DO, yytext() ); }
"for"                                                 { return new Symbol(sym.FOR, yytext() ); }
"print"                                               { return new Symbol(sym.PRINT, yytext() ); }
"length"                                              { return new Symbol(sym.LENGTH, yytext() ); }
"int"                                                 { return new Symbol(sym.INT, yytext() ); }
"float"                                               { return new Symbol(sym.FLOAT, yytext() ); }
"char"                                                { return new Symbol(sym.CHAR, yytext() ); }
"String"                                              { return new Symbol(sym.STRING, yytext() ); }
"boolean"                                             { TablaSimbolos.setIsBoolean("true"); return new Symbol(sym.BOOLEAN, yytext() ); }
"true"                                                { return new Symbol(sym.TRUE, yytext() ); }
"false"                                               { return new Symbol(sym.FALSE, yytext() ); }


'\\.'|'[^\\\']'                                       { return new Symbol(sym.CARACTER, yytext()  ); }

// [a-zA-Z][a-zA-Z0-9]*\[(0|[1-9][0-9]*)\]               { return new Symbol(sym.ARRAY, yytext()  ); }
\\u[0-9a-fA-F]{4}                                     { return new Symbol(sym.UNICODE, yytext()  ); }
[a-zA-Z][a-zA-Z0-9]*                                  {
                                                        variable = yytext();
                                                        aux = TablaSimbolos.getIsBoolean();
                                                        // System.out.println("ISBOOLEAN: "+aux);
                                                        //TablaSimbolos.printTabla();
                                                        if(aux.equals("true") || TablaSimbolos.contieneVariable(variable) && TablaSimbolos.getTipo(variable).equals("boolean")){
                                                            //System.out.println(" *********** DEVUELVO UN BOOLEANO");
                                                            return new Symbol(sym.VAR_BOOLEAN, yytext() );
                                                        }
                                                        else {
                                                            //System.out.println(" *********** DEVUELVO UA VARIABLE NORMAL");
                                                            return new Symbol(sym.VAR, yytext() );
                                                        }
                                                      }

/*"boolean "[a-zA-Z][a-zA-Z0-9]*                        {
                                                        aux = yytext();
                                                        //System.out.println(" *********** ENTRA U BOOLEANO: "+aux);
                                                        int indiceEspacio = aux.indexOf(" ");

                                                        variable = aux.substring(indiceEspacio+1);
                                                        //System.out.println(" *********** DEVUELVO UN BOOLEANO: "+variable);
                                                        return new Symbol(sym.VAR_BOOLEAN, variable ); 
                                                      }
*/

 //(‘\b’,’\n’,’\f’,’\r’,’\t’,’\”’,’\\’,’\’’).   
//[a-zA-Z&] | \\[bfnrt\"\\\']                           { return new Symbol(sym.CARACTER, yytext()  ); }
(0|[1-9][0-9]*)			                              { return new Symbol(sym.NUM_ENTERO, yytext() ); }
(([0-9]*\.[0-9]+|[0-9]+\.[0-9]*)([eE][+-]?[0-9]+)?)|([0-9]*)([eE][+-]?[0-9]+)    { return new Symbol(sym.NUM_FLOAT, yytext() ); }
\/\/.*											      {  }
\r|\n                                                 {  }
\ |\t|\f                                              {  }
[^]                                                   { throw new Error("Illegal character <"+yytext()+">"); }

