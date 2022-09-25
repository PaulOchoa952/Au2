
import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);}
%}
/*Variables basicas de comentarios y espacios */
    TerminadorDeLinea = \r|\n|\r\n
    EntradaDeCaracter = [^\r\n]
    EspacioEnBlanco     = {TerminadorDeLinea} | [ \t\f]
    ComentarioTradicional   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
    FinDeLineaComentario     = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
    ContenidoComentario       = ( [^*] | \*+ [^/*] )*
    ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

    /* Comentario */
    Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

   
    /* Identificador */
    Letra = [A-Za-zÑñ_áéíóú]
    Digito = [0-9]
    Identificador = {Letra}({Letra}|{Digito})*
    
    /* Numero */
    Numero = 0 | [1-9][0-9]*

    /* Numero_deci */
    Numero_deci = [1-9][0-9]* "." [0-9]* | 0 "." [0-9] [0-9]*

    /* Temperatura */
    Temperatura =  {Numero} | {Numero_deci}

    /*cad*/
    cad= {Letra}{Letra}*

%%
{Comentario}|{EspacioEnBlanco} { /* Ignorar */ }

/* Identificador */
"&"{Identificador} { return token(yytext(), "IDENTIFICADOR", yyline, yycolumn); }


/* Numero */
{Numero} { return token(yytext(), "N_ENTERO", yyline, yycolumn);}

/* Numero_deci */
Numero_deci { return token(yytext(), "N_DECIMAL", yyline, yycolumn);}

/*cad*/
"K_"{cad} { return token(yytext(), "CADENA", yyline, yycolumn);}
    
/*TIPO DATO*/
ENT |
DECI { return token(yytext(), "TIPO_DATO", yyline, yycolumn);} 

/*TIPO DE DATO CADENA*/
CADENA { return token(yytext(), "TIPO_CADENA", yyline, yycolumn);}

/*TIPO DE DATO LOGICO*/
LOGICO { return token(yytext(), "TIPO_LOGICO", yyline, yycolumn);}

/*PALABRA DE VERDADERO Y F*/
VERDADERO { return token(yytext(), "LOGICO_V", yyline, yycolumn);}
FALSO { return token(yytext(), "LOGICO_F", yyline, yycolumn);}


/////////////////////////////////////////////////////////////////////////////
/* Operadores de agrupacion */
"(" { return token(yytext(), "PARENTESIS_A", yyline, yycolumn);}
")" { return token(yytext(), "PARENTESIS_C", yyline, yycolumn);}
"{" { return token(yytext(), "LLAVE_A", yyline, yycolumn);}
"}" { return token(yytext(), "LLAVE_C", yyline, yycolumn);}
"[" { return token(yytext(), "CORCHETE_A", yyline, yycolumn);}
"]" { return token(yytext(), "CORCHETE_C", yyline, yycolumn);}

/* Signos de apuntuacion */
"," { return token(yytext(), "COMA", yyline, yycolumn);}
"." { return token(yytext(), "PUNTO", yyline, yycolumn);}
";" { return token(yytext(), "PUNTOyCOMA", yyline, yycolumn);}
":" { return token(yytext(), "DOBLE_PUNTO", yyline, yycolumn);}

/* Operdador de asignacion */
"-." { return token(yytext(), "Op_Asig", yyline, yycolumn);}


/* Operador Aritmetico */
"<" { return token(yytext(), "MENOR_QUE", yyline, yycolumn);}
">" { return token(yytext(), "MAYOR_QUE", yyline, yycolumn);}
"<=" { return token(yytext(), "MENOR_IGUAL_QUE", yyline, yycolumn);}
">=" { return token(yytext(), "MAYOR_IGUAL_QUE", yyline, yycolumn);}
"==" { return token(yytext(), "IGUAL_QUE", yyline, yycolumn);}
"!=" { return token(yytext(), "DIFERENTE_DE", yyline, yycolumn);}

/*OPERADORES DE MATEMATICAS */
"+" { return token(yytext(), "SUMA", yyline, yycolumn);}
"-" { return token(yytext(), "RESTA", yyline, yycolumn);}
"/" { return token(yytext(), "DIVISION", yyline, yycolumn);}
"*" { return token(yytext(), "MULTIPLICACION", yyline, yycolumn);}

/* OPERADOR LOGICO */
"&" |
"|" |
"!" { return token(yytext(), "OP_LOGICO", yyline, yycolumn);}
////////////////////////////////////////////////////////////////////////////
/* ciclos WHILE */
repetir |
repetirMientras { return token(yytext(), "REPETIR", yyline, yycolumn);}

/* detener */ 
interrumpir { return token(yytext(), "DETENER_REPETIR", yyline, yycolumn);}

/* Estructura Si IF */
si |
sino { return token(yytext(), "ESTRUCTURA_SI", yyline, yycolumn);}

/* Final */
final { return token(yytext(), "FINAL_W", yyline, yycolumn);}

////////////////////////////////////////////////////////////////////////////////
/*FUNCIONES PARA EL SISTEMA*/

//FUNCION PARA MUTAR
mutar { return token(yytext(), "FUNCION_MUTAR", yyline, yycolumn);}

//FUNCION PARA EVALUAR
evaluar { return token(yytext(), "EVALUAR", yyline, yycolumn);}

//PALABRAS RESERVADAS PARA EVALUAR
fase1 |
fase2 |
fase3 |
fase4 |
fase5 |
fase6 { return token(yytext(), "FASES", yyline, yycolumn);}

//TEMPERATURA
"T"{Temperatura} { return token(yytext(), "TEMPERATURA", yyline, yycolumn);}

//FUNCION PARA FIJAR ORIGEN
fijar_Origen { return token(yytext(), "FIJAR_ORIGEN", yyline, yycolumn);}

//FUNCION PARA EXPANDIR
expandir { return token(yytext(), "EXPANDIR", yyline, yycolumn);}

//FUNCION PARA GENERAR GRAFICA
generar_graf { return token(yytext(), "GENERAR_GRAF", yyline, yycolumn);}


/* ERRORES   */////////////////////////////////////////////////////////////////////////
//NUMERO ERRONEO
0{Numero} { return token(yytext(), "ERROR_1", yyline, yycolumn);}

//IDENTIFICADOR ERRONEO
{Identificador} { return token(yytext(), "ERROR_2", yyline, yycolumn);}

. { return token(yytext(), "ERROR", yyline, yycolumn);}
