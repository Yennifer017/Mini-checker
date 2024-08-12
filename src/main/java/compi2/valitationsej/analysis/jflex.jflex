/* codigo de usuario */
package compi2.valitationsej.analysis;

import java_cup.runtime.*;
import java.util.*;

%% //separador de area

/* opciones y declaraciones de jflex */

%public
%unicode
%class Lexer
%cup
%line
%column
%init{
    errorsList = new LinkedList<>();
    string = new StringBuilder();
%init}

%state STRING

LineTerminator = \r|\n|\r\n 

WhiteSpace = {LineTerminator} | [ \t\f]
Identifier = [:jletter:] [:jletterdigit:]*
DecIntegerLiteral = [0-9]+
DecFloatLiteral = {DecIntegerLiteral}\.{DecIntegerLiteral}

%{
    StringBuilder string;
  /*--------------------------------------------
    CODIGO PARA EL MANEJO DE ERRORES
  ----------------------------------------------*/
    private List<String> errorsList;

    public List<String> getErrors(){
        return this.errorsList;
    }

    /*--------------------------------------------
        CODIGO PARA EL PARSER
    ----------------------------------------------*/
    private Symbol symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }

    private void error(String message, Object value) {
        errorsList.add("Error en la linea: " + (yyline+1) + ", columna: " + (yycolumn+1) + " : "+message);
    }

%}

%% // separador de areas

/* reglas lexicas */

    /*simbolos reservados*/
    ";"             { return symbol(sym.FIN); }
    ","             { return symbol(sym.COMA); }
    "["             { return symbol(sym.CORCHETE_L); }
    "]"             { return symbol(sym.CORCHETE_R); }
    "+"             { return symbol(sym.MAS); }
    "*"             { return symbol(sym.POR); }
    "="             { return symbol(sym.IGUAL); }

    /* keywords */
    <YYINITIAL> "true"              { return symbol(sym.BTRUE);      }
    <YYINITIAL> "false"             { return symbol(sym.BFALSE);     }
    <YYINITIAL> "int"               { return symbol(sym.INT_I);       }
    <YYINITIAL> "decimal"           { return symbol(sym.DEC_I);   }
    <YYINITIAL> "string"            { return symbol(sym.CADENA);    }
    <YYINITIAL> "boolean"           { return symbol(sym.BOOL_I);   }

    <YYINITIAL> {
      /* identifiers */ 
      {Identifier}                   { return symbol(sym.ID, yytext()); }
     
      /* literals */
      {DecIntegerLiteral}            { return symbol(sym.INTEGER_LIT, Integer.parseInt(yytext())); }
      {DecFloatLiteral}              { return symbol(sym.FLOAT_LIT, Float.parseFloat(yytext()));}


      \"                             { string.setLength(0); yybegin(STRING); }
    }

    <STRING> {
      \"                             { yybegin(YYINITIAL); 
                                       return symbol(sym.STRING_LIT, 
                                       string.toString()); }
      [^\n\r\"\\]+                   { string.append( yytext() ); }
      \\t                            { string.append('\t'); }
      \\n                            { string.append('\n'); }

      \\r                            { string.append('\r'); }
      \\\"                           { string.append('\"'); }
      \\                             { string.append('\\'); }
    }


    /*lo ignorado*/
    {WhiteSpace} 	      {/* ignoramos */}

    /* error fallback */
    .               { error("Simbolo invalido <"+ yytext()+">", yytext());}
    <<EOF>>         { return symbol(sym.EOF); }

