
import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int)start, size, color);
    }
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
    cad= {Letra} {Letra}*
%%
{Comentario} { return textColor(yychar, yylength(), new Color(146, 146, 146));}
{EspacioEnBlanco} {/* Ignorar */ }

/* Identificador */
"&"{Identificador} { return textColor(yychar, yylength(), new Color(255, 200, 0)); }



/* Numero */
{Numero} { return textColor(yychar, yylength(), new Color(35, 120, 147));}

/* Numero_deci */
Numero_deci { return textColor(yychar, yylength(), new Color(35, 120, 147));}

/*cad*/
"K_"{cad} {return textColor(yychar, yylength(), new Color(255, 0, 255));}
    
/*TIPO DATO*/
ENT |
DECI { return textColor(yychar, yylength(), new Color(0, 0, 255));} 

/*TIPO DE DATO CADENA*/
CADENA { return textColor(yychar, yylength(), new Color(0, 0, 255));}

/*TIPO DE DATO LOGICO*/
LOGICO { return textColor(yychar, yylength(), new Color(0, 0, 255));}

/*PALABRA DE VERDADERO Y F*/
VERDADERO { return textColor(yychar, yylength(), new Color(0, 0, 255));}
FALSO { return textColor(yychar, yylength(), new Color(0, 0, 255));}

///////////////////////////////////////////////////////////////////////////////////////////////////
/* Operadores de agrupacion */
"(" |
")" |
"{" |
"}" |
"[" |
"]" { return textColor(yychar, yylength(), new Color(19, 53, 114));}

/* Signos de apuntuacion */
"," |
"." |
";" |
":" { return textColor(yychar, yylength(), new Color(0, 0, 0));}

/*OPERADORES DE MATEMATICAS*/
"+" { return textColor(yychar, yylength(), new Color(149, 37, 14));}
"-" { return textColor(yychar, yylength(), new Color(2149, 37, 14));}
"/" { return textColor(yychar, yylength(), new Color(149, 37, 14));}
"*" { return textColor(yychar, yylength(), new Color(149, 37, 14));}

/* Operdador de asignacion */
"-." { return textColor(yychar, yylength(), new Color(149, 37, 14));}

/* Operador Aritmetico */
"<" | ">" | "<=" | ">=" | "==" | "!=" { return textColor(yychar, yylength(), new Color(149, 37, 14));}

/* OPERADOR LOGICO */
"&" | "|" | "!" { return textColor(yychar, yylength(), new Color(149, 37, 14));}

///////////////////////////////////////////////////////////////////////////////////////////////////////////

/* ciclos WHILE */
repetir |
repetirMientras { return textColor(yychar, yylength(), new Color(102, 205, 170));}

/* detener */ 
interrumpir { return textColor(yychar, yylength(), new Color(102, 205, 170));}

/* Estructura Si (IF) */
si |
sino { return textColor(yychar, yylength(), new Color(102, 205, 170));}

/* Final */
final { return textColor(yychar, yylength(), new Color(255, 0, 0));}

/////////////////////////////////////////////////////////////////////////////////////////////////////
/*FUNCIONES PARA EL SISTEMA*/

//FUNCION PARA MUTAR
mutar { return textColor(yychar, yylength(), new Color(0, 144, 255));}

//FUNCION PARA EVALUAR
evaluar { return textColor(yychar, yylength(), new Color(0, 144, 255));}

//PALABRAS RESERVADAS PARA EVALUAR
fase1 |
fase2 |
fase3 |
fase4 |
fase5 |
fase6 { return textColor(yychar, yylength(), new Color(0, 144, 255));}

//TEMPERATURA
"T"{Temperatura} { return textColor(yychar, yylength(), new Color(0, 0, 255)); }

//FUNCION PARA FIJAR ORIGEN
fijar_Origen { return textColor(yychar, yylength(), new Color(0, 144, 255));}

//FUNCION PARA EXPANDIR
expandir {return textColor(yychar, yylength(), new Color(0, 144, 255));}

//FUNCION PARA GENERAR GRAFICA
generar_graf { return textColor(yychar, yylength(), new Color(0, 144, 255));}
///////////////////////////////////////////////////////////////////////////////////

//NUMERO ERRONEO
0{Numero} { /* Ignorar */ }


//IDENTIFICADOR ERRONEO
{Identificador} { /* Ignorar */ }

. { /* Ignorar */ }