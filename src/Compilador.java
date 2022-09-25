
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Carlos
 */
public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory Directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

    /**
     * Creates new form Compilador
     */
    public Compilador() {
        initComponents();
        init();
        this.setSize(1100, 550);
        this.setTitle("<KOVVID>");
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        txaErrores = new java.awt.TextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLexemas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtpEscritorio = new javax.swing.JTextPane();
        btnSimbolos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(null);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar-archivo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo);
        btnNuevo.setBounds(10, 20, 110, 39);

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carpeta.png"))); // NOI18N
        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbrir);
        btnAbrir.setBounds(120, 20, 100, 39);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disquete.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(220, 20, 108, 39);

        btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compilador.png"))); // NOI18N
        btnCompilar.setText("Compilar");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCompilar);
        btnCompilar.setBounds(470, 20, 120, 39);

        btnEjecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/corriendo.png"))); // NOI18N
        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEjecutar);
        btnEjecutar.setBounds(590, 20, 120, 40);

        btnGuardarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar-como.png"))); // NOI18N
        btnGuardarC.setText("Guardar Como");
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarC);
        btnGuardarC.setBounds(340, 20, 130, 39);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(6, 5, 740, 70);
        getContentPane().add(txaErrores);
        txaErrores.setBounds(10, 370, 720, 130);

        tblLexemas.setBackground(new java.awt.Color(204, 204, 204));
        tblLexemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Componente Lexico", "Lexema", "{Linea, Columna}"
            }
        ));
        jScrollPane3.setViewportView(tblLexemas);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(740, 100, 310, 400);

        jScrollPane2.setViewportView(jtpEscritorio);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 110, 710, 250);

        btnSimbolos.setBackground(new java.awt.Color(255, 0, 0));
        btnSimbolos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/contenido-de-la-tabla.png"))); // NOI18N
        btnSimbolos.setText("Tabla de simbolos");
        btnSimbolos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimbolosActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimbolos);
        btnSimbolos.setBounds(770, 10, 180, 60);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 13)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/virus.png"))); // NOI18N
        jLabel1.setText("KOVVID_CODE");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(950, 20, 130, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Directorio.New();
        clearFields();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (Directorio.Open()) {
            colorAnalisis();
            clearFields();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed
//public void (){

//}

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (Directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (Directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }

    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (errors.size() > 0) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el codigo ya que se encontro uno o mas errores");
            } else {

            }
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (Directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnSimbolosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimbolosActionPerformed
        T.setVisible(true);

    }//GEN-LAST:event_btnSimbolosActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Informacion I = new Informacion();
        I.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */
    private void init() {
        title = "KOVVID";
        setLocationRelativeTo(null);
        setTitle(title);
        Directorio = new Directory(this, jtpEscritorio, title, ".kov");
        addWindowListener(new WindowAdapter() {
            public void windwClosing(WindowEvent e) {
                Directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpEscritorio);
        timerKeyReleased = new Timer(300, ((e) -> {
            timerKeyReleased.stop();
            colorAnalisis();
        }));
        Functions.insertAsteriskInName(this, jtpEscritorio, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{"hola", "numero", "este"}, jtpEscritorio, () -> {
            timerKeyReleased.restart();
        });

    }

    private void colorAnalisis() {
        LexerColor lexer;
        textsColor.clear();

        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpEscritorio.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF-8"));
            lexer = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexer.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }
        Functions.colorTextPane(textsColor, jtpEscritorio, new Color(40, 40, 40));
    }

    private void clearFields() {
        Functions.clearDataInTable(tblLexemas);
        txaErrores.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    private void compile() {
        clearFields();
        LexicalAnalisis();
        fillTableTokens();
        SintacticAnalisis();
        SemanticAnalisis();
        ImprimirConsola();
        codeHasBeenCompiled = true;
    }

    private void LexicalAnalisis() {
        Lexer lexer;

        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpEscritorio.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF-8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(),
                "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblLexemas, data);
        });
    }

    private void SintacticAnalisis() {
        Grammar gramatica = new Grammar(tokens, errors);
              
        /* ELIMINACION DE ERRORES*/
        gramatica.delete(new String[]{"ERROR", "ERROR_1", "ERROR_2"}, 1);
        
             /*GENERACION DE INICIO*/
        //gramatica.group("INICIO", "SENTENCIAS FINAL");
       // gramatica.group("INICIO", "SENTENCIAS", true, 43, "ERROR SINTACTICO {}: FALTA EL FINAL DEL PROGRAMA, FAVOR DE VERIFICAR CODIGO[#,%]");

        
        
        /*AGRUPACION DE VALORES*/
        gramatica.group("VALOR", "(N_ENTERO | N_DECIMAL)", true);
        gramatica.group("VALOR_CAD", "(CADENA)");
        gramatica.group("VALOR_LOG", "(LOGICO_V | LOGICO_F)");

        /*DECLARACION DE VARIABLES*/
        gramatica.group("VARIABLE", "TIPO_DATO IDENTIFICADOR Op_Asig VALOR", true);
        gramatica.group("VARIABLE2", "TIPO_CADENA IDENTIFICADOR Op_Asig VALOR_CAD", true);
        gramatica.group("VARIABLE3", "TIPO_LOGICO INDETIFICADOR LOGICO_V", true);

        gramatica.group("VARIABLE2", "TIPO_CADENA IDENTIFICADOR CADENA", true, 40, "ERROR SINTACTICO {}: FALTA EL OPERADOR DE ASIGNACION[#,%]");
        gramatica.group("VARIABLE3", "TIPO_LOGICO VALOR_LOG", true, 41, "ERROR SINTACTICO {}: FALTA EL IDENTIFICADOR [#,%]");

        gramatica.group("VARIABLE", "TIPO_DATO Op_Asig VALOR", true, 2, "ERROR SINTACTICO {}: FALTA EL IDENTIFICADOR EN LA VARIABLE[#,%]");
        gramatica.group("VARIABLE_TEMP", "TIPO_DATO IDENTIFICADOR Op_Asig TEMPERATURA");
        gramatica.group("VARIABLE_TEMP", "TIPO_DATO Op_Asig TEMPERATURA", true, 9, "ERROR SINTACTICO {}: FALTA EL IDENTIFICADOR EN LA VARIABLE TEMPERATURA[#,%]");

        gramatica.finalLineColumn();

        gramatica.group("VARIABLE", "TIPO_DATO IDENTIFICADOR Op_Asig", 3, "ERROR SINTACTICO {}: FALTA EL VALOR EN LA DECLARACION [#, %]");

        gramatica.initialLineColumn();

        //AQUI SE AGREGAN MAS CONBINACIONES DESAPARECIENDO UN TOKEN,
        //AGREGAR MAS VARIABLES O LO QUE SE NECESITE PARA LAS GRAMATICAS.
        /* ELIMINACION DE TIPOS DE DATO Y OPERADORES DE ASIGNACION*/
        gramatica.delete("TIPO_DATO", 4, "ERROR SINTACTICO {}: EL TIPO DE DATO NO ESTA EN UNA DECLARACION [#, %]");
        gramatica.delete("Op_Asig", 42, "ERROR SINTACTICO{}: EL OPERADOR DE ASIGNACION NO ESTA EN UNA DELCARACION [#, %]");

        /* AGRUPACION DE IDENTIFICADORES Y DEFINICION DE PARAMETROS */
        //gramatica.group("VALOR", "IDENTIFICADOR", true);
        //gramatica.group("PARAMETROS", "VALOR (COMA VALOR)+");
        /**/
//mutar NUMERO(NUM.DE FASE,CANTIDAD DE PAISES,TEMPERATURA)

        /*agrupacion de funciones*/
        //FUNCION MUTAR
        gramatica.group("FUNCION_COMP_MUT", "EVALUAR PARENTESIS_A (FASES COMA VALOR COMA TEMPERATURA)+ PARENTESIS_C", true);
        //FUNCON evaluar
        gramatica.group("FUNCION_COMP_EV", "FUNCION_MUTAR PARENTESIS_A (FASES)+ PARENTESIS_C", true);

        //FUNCION fijar_origen
        gramatica.group("FUNCION_COMP_FIJAR", "FIJAR_ORIGEN PARENTESIS_A (VALOR COMA VALOR)+ PARENTESIS_C", true);
        //FUNCION EXPANDIR
        gramatica.group("FUNCION_COMP_EXPANDIR", "EXPANDIR PARENTESIS_A (VALOR)+ PARENTESIS_C", true);

        gramatica.group("FUNCION_COMP_GENERAR_GRAF", "GENERAR_GRAF PARENTESIS_A (VALOR COMA VALOR COMA VALOR COMA VALOR)+ PARENTESIS_C", true);

        //ERRORES FUNCION EVALUAR
        gramatica.group("FUNCION_COMP_MUT", " PARENTESIS_A (FASES COMA VALOR COMA TEMPERATURA)+ PARENTESIS_C", true, 18, "ERROR SINTATICO ,FALTA LA PALABRA RESERVADA EVALUAR");
        gramatica.group("FUNCION_COMP_MUT", "EVALUAR (FASES COMA VALOR COMA TEMPERATURA)+ PARENTESIS_C", true, 19, "ERROR SINTATICO ,FALTA PARENTESIS QUE ABRE");
        gramatica.group("FUNCION_COMP_MUT", "EVALUAR PARENTESIS_A (COMA VALOR COMA TEMPERATURA)+ PARENTESIS_C", true, 20, "ERROR SINTATICO ,FALTA LA FASE");
        gramatica.group("FUNCION_COMP_MUT", "EVALUAR PARENTESIS_A (FASES VALOR COMA TEMPERATURA)+ PARENTESIS_C", true, 21, "ERROR SINTATICO ,FALTA LA COMA DESPUES DE FASE");
        gramatica.group("FUNCION_COMP_MUT", "EVALUAR PARENTESIS_A (FASES COMA COMA TEMPERATURA)+ PARENTESIS_C", true, 22, "ERROR SINTATICO ,FALTA EL VALOR DE CANTIDAD DE PAISES");
        gramatica.group("FUNCION_COMP_MUT", "EVALUAR PARENTESIS_A (FASES COMA VALOR TEMPERATURA)+ PARENTESIS_C", true, 23, "ERROR SINTATICO ,FALTA LA COMA ANTES DE TEMPERATURA");
        gramatica.group("FUNCION_COMP_MUT", "EVALUAR PARENTESIS_A (FASES COMA VALOR COMA )+ PARENTESIS_C", true, 24, "ERROR SINTATICO ,FALTA EL VALOR DE LA TEMPERATURA");
        //ERRORES FUNCION MUTAR
        gramatica.group("FUNCION_COMP_EV", "PARENTESIS_A (FASES)+ PARENTESIS_C", true, 25, "ERROR SINTACTICO, FALTA LA PALABRA RESERVADA MUTAR");
        gramatica.group("FUNCION_COMP_EV", "FUNCION_MUTAR (FASES)+ PARENTESIS_C", true, 26, "ERROR SINTACTICO, FALTA EL PARENTESIS DE APERTURA");
        gramatica.group("FUNCION_COMP_EV", "FUNCION_MUTAR PARENTESIS_A PARENTESIS_C", true, 27, "ERROR SINTACTICO, FALTA LA FASE");
        //ERROES FUNCION_FIJAR
        gramatica.group("FUNCION_COMP_FIJAR", "PARENTESIS_A (VALOR COMA VALOR)+ PARENTESIS_C", true, 28, "ERROR SINTACTICO, FALTA LA PALABRA RESERVADA fijar_origen");
        gramatica.group("FUNCION_COMP_FIJAR", "FIJAR_ORIGEN (VALOR COMA VALOR)+ PARENTESIS_C", true, 29, "ERROR SINTACTICO, FALTA EL PARENTESIS QUE ABRE");
        gramatica.group("FUNCION_COMP_FIJAR", "FIJAR_ORIGEN PARENTESIS_A (COMA VALOR)+ PARENTESIS_C", true, 30, "ERROR SINTACTICO, FALTA LA LATITUD");
        gramatica.group("FUNCION_COMP_FIJAR", "FIJAR_ORIGEN PARENTESIS_A (VALOR VALOR)+ PARENTESIS_C", true, 31, "ERROR SINTACTICO, FALTA COMA DESPUES LATITUD");
        gramatica.group("FUNCION_COMP_FIJAR", "FIJAR_ORIGEN PARENTESIS_A (VALOR COMA)+ PARENTESIS_C", true, 32, "ERROR SINTACTICO, FALTA LA ALTITUD");

        //errores
        //ERRORES EXPANDIR
       // gramatica.group("FUNCION_COMP_EXPANDIR", "PARENTESIS_A (VALOR)+ PARENTESIS_C", true, 36, "ERROR SINTACTICO FALTA LA PALABRA RESERVADA EXPANDIR");
        gramatica.group("FUNCION_COMP_EXPANDIR", "EXPANDIR PARENTESIS_A (VALOR)+ PARENTESIS_C", true, 37, "ERROR SINTACTICO FALTA EL PARENTESIS QUE ABRE");
        gramatica.group("FUNCION_COMP_EXPANDIR", "EXPANDIR PARENTESIS_A PARENTESIS_C", true, 38, "ERROR SINTACTICO FALTA EL VALOR");
        gramatica.group("FUNCION_COMP_EXPANDIR", "EXPANDIR PARENTESIS_A (VALOR)+", true, 39, "ERROR SINTACTICO FALTA EL PARENTESIS QUE CIERRA");

        gramatica.group("FUNCION_COMP", "FUNCION (VALOR | PARAMETROS)? PARENTESIS_C", true, 6, "ERROR SINTACTICO{}:FALTA EL PARENTESIS QUE ABRE EN LA FUNCION[#, %]");
        gramatica.finalLineColumn();
        gramatica.group("FUNCION_COMP", "FUNCION PARENTESIS_A (VALOR | PARAMETROS)", true, 7, "ERROR SINTACTICO{}:FALTA EL PARENTESIS QUE CIERRA EN LA FUNCION[#, %]");
        //error final de funcion evaluar
        gramatica.group("FUNCION_COMP_MUT", "EVALUAR PARENTESIS_A (FASES COMA VALOR COMA )+ ", true, 33, "ERROR SINTATICO ,FALTA EL PARENTESIS QUE CIERRA");
        gramatica.group("FUNCION_COMP_EV", "FUNCION_MUTAR PARENTESIS_A (FASES)+", true, 34, "ERROR SINTACTICO, FALTA EL PARENTESIS QUE CIERRA");
        gramatica.group("FUNCION_COMP_FIJAR", "FIJAR_ORIGEN PARENTESIS_A (VALOR COMA VALOR)+ ", true, 35, "ERROR SINTACTICO, FALTA EL PARENTESIS QUE CIERRA LA FUNCION");
        gramatica.group("FUNCION_COMP_EXPANDIR", "EXPANDIR PARENTESIS_A (VALOR)+", true, 39, "ERROR SINTACTICO FALTA EL PARENTESIS QUE CIERRA");
        //FUNCIONES EVALUAR
        gramatica.group("FUNCION_COMP_GENERAR_GRAF", "PARENTESIS_A (VALOR COMA VALOR COMA VALOR COMA VALOR)+ PARENTESIS_C", true, 40, "ERROR SINTACTICO,FALTA LA PALABRA RESERVADA generar_graf");
        gramatica.group("FUNCION_COMP_GENERAR_GRAF", "GENERAR_GRAF (VALOR COMA VALOR COMA VALOR COMA VALOR)+ PARENTESIS_C", true, 41, "ERROR SINTACTICO,FALTA EL PARENTESIS QUE ABRE");
        gramatica.group("FUNCION_COMP_GENERAR_GRAF", "GENERAR_GRAF PARENTESIS_A ( COMA VALOR COMA VALOR COMA VALOR)+ PARENTESIS_C", true, 40, "ERROR SINTACTICO,FALTA LA CANTIDAD DE PAISES");
        gramatica.group("FUNCION_COMP_GENERAR_GRAF", "GENERAR_GRAF PARENTESIS_A (VALOR COMA COMA VALOR COMA VALOR)+ PARENTESIS_C", true, 41, "ERROR SINTACTICO,FALTA EL NUMERO DE INFECTADOS ");
        gramatica.group("FUNCION_COMP_GENERAR_GRAF", "GENERAR_GRAF PARENTESIS_A (VALOR COMA VALOR COMA COMA VALOR)+ PARENTESIS_C", true, 42, "ERROR SINTACTICO,FALTA LA FECHA DE INICIO ");
        gramatica.group("FUNCION_COMP_GENERAR_GRAF", "GENERAR_GRAF PARENTESIS_A (VALOR COMA COMA VALOR COMA VALOR)+ PARENTESIS_C", true, 43, "ERROR SINTACTICO,FALTA LA FECHA DE FIN ");

//NUMERO(CANTIDAD DE PAISES,NUMERO DE INFECTADOS,FECHA INICIO,FECHA ACTUAL)
        gramatica.initialLineColumn();

        /*FUNCIONES DE EVALUAR*/
        // gramatica.group("FUNCION_ACTIVAR", "(ACTIVAR)", true);
        //   gramatica.group("FUNCION_ACTIVAR", "FUNCION_ACTIVAR PARENTESIS_A(VERDADERO| FALSE) PARENTESIS_C", true);
        // gramatica.group("FUNCION_ACTIVAR", "FUNCION_ACTIVAR PARENTESIS_A ");

        /*ELIMINACION DE FUNCIONES INCOMPLETAS*/
        gramatica.delete("FUNCION", 8, "ERROR SINTACTICO{}: LA FUNCION NO ESTA DECLARADA CORRECTAMENTE[#, %]");

        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("EXP_LOGICA", "(FUNCION_COMP | EXP_LOGICA) (OP_LOGICO (FUNCION_COMP | EXP_LOGICA))+");

            gramatica.group("EXP_LOGICA", "PARENTESIS_A (EXP_LOGICA | FUNCION_COMP) PARENTESIS_C");

        });
        //gramatica.group("EXP_LOGICA", "(FUNCION_COMP) (OP_LOGICO FUNCION_COMP)+");
        //gramatica.group("EXP_LOGICA", "PARENTESIS_A EXP_LOGICA PARENTESIS_C");
        //gramatica.group("EXP_LOGICA", "(FUNCION_COMP | EXP_LOGICA) (OP_LOGICO (FUNCION_COMP| EXP_LOGICA))+");

        /* ELIMINACION DE OPERADORES LOGICOS */
        gramatica.delete("OP_LOGICO", 10, "ERROR SINTACTICO {}: EL OPERADOR LOGICO NO ESTA CONTENIDO EN UNA EXPRESION");

        /*AGRUPACION DE EXP. LOGICAS COMO VALOR Y PARAMETROS*/
        gramatica.group("VALOR", "EXP_LOGICA");
        gramatica.group("PARAMETROS", "VALOR (COMA VALOR)+");       /*
         gramatica.group("FUNCION", "(EVALUAR | FUNCION_MUTAR | FUNCION_FIJAR_ORIGEN | EXPANDIR | GENERAR_GRAF)", true);
        gramatica.group("FUNCION_COMP", "FUNCION PARENTESIS_A (VALOR | PARAMETROS)? PARENTESIS_C", true);
        gramatica.group("FUNCION_COMP", "FUNCION (VALOR | PARAMETROS)? PARENTESIS_C", true, 6, "ERROR SINTACTICO{}:FALTA EL PARENTESIS QUE ABRE EN LA FUNCION[#, %]");
        gramatica.finalLineColumn();
        gramatica.group("FUNCION_COMP", "FUNCION PARENTESIS_A (VALOR | PARAMETROS)", true, 7, "ERROR SINTACTICO{}:FALTA EL PARENTESIS QUE CIERRA EN LA FUNCION[#, %]");

        gramatica.initialLineColumn();
         */
/*RESERVADAS PARA INICIO Y FIN*/
//INICIO ::= INICIO_ER | FIN_ER | Reservada_Inicio SENTENCIA Reservada_Fin | Reservada_Inicio Reservada_Fin ;
gramatica.group("FIN", "FINAL_W");
 /*AGRUPACION DE ESTRUCTURAS DE CONTROL*/
        gramatica.group("ESTRUC_CONTROL", "(REPETIR | ESTRUCTURA_SI)");
        // gramatica.group("ESTRUC_CONTROL_COMP", "ESTRUC_CONTROL PARENTESIS_A PARENTESIS_C");
        // gramatica.group("ESTRUC_CONTROL", "(VALOR | PARAMETROS)");
        gramatica.group("ESTRUC_CONTROL_COMP", "ESTRUC_CONTROL PARENTESIS_A (VALOR | PARAMETROS) PARENTESIS_C");

        /*ELIMINACION DE ESTRUCTURAS DE CONTROL INCOMPLETAS*/
        gramatica.delete("ESTRUC_CONTROL", 11, "ERROR SINTACTICO {}: La estructura de control no esta declarada correctamente [#,%]");

        /*ELIMINACION DE PARENTESIS*/
        gramatica.delete(new String[]{"PARENTESIS_A", "PARENTESIS_C"}, 12, "ERROR SINTACTICO{}: El parentesis [] no esta conetenido en una agrupacion [#,%]");

        gramatica.finalLineColumn();
        /*VERIFICACION DE PUNTO Y COMA AL FINAL DE LA SENTENCIA.*/

        ////idenficador o variables
        gramatica.group("VARIABLE_PC", "VARIABLE PUNTOyCOMA", true);
        gramatica.group("VARIABLE2_PC","VARIABLE2 PUNTOyCOMA",true);
        gramatica.group("VARIABLE3_PC","VARIABLE3 PUNTOyCOMA",true);
        gramatica.group("VARIABLE_PC", "VARIABLE ", true, 13, "ERROR SINTACTICO{}: Falta el punto y coma al final de la variable[#,%]");
        gramatica.group("FUNCION_COMP_EVA_PC", "FUNCION_COMP_EV PUNTOyCOMA", true);
        gramatica.group("FUNCION_COMP_MUT_PC", "FUNCION_COMP_MUT PUNTOyCOMA", true);
        gramatica.group("FUNCION_COMP_FIJAR_PC", "FUNCION_COMP_FIJAR PUNTOyCOMA", true);
        gramatica.group("FUNCION_COMP_EXPANDIR_PC", "FUNCION_COMP_EXPANDIR PUNTOyCOMA", true);
        gramatica.group("FUNCION_COMP_GENERAR_GRAF_PC", "FUNCION_COMP_GENERAR_GRAF PUNTOyCOMA", true);
//REPETIR
        gramatica.group("FUNCION_COMP_EVA_PC", "FUNCION_COMP_EV", 14, "ERROR SINTACTICO{}: Falta el punto y coma al final de la declaracion de funcion [#,%]");
        gramatica.group("FUNCION_COMP_MUT_PC", "FUNCION_COMP_MUT", 15, "ERROR SINTACTICO{}: Falta el punto y coma al final de la declaracion de funcion [#,%]");
        gramatica.group("FUNCION_COMP_FIJAR_PC", "FUNCION_COMP_FIJAR", 16, "ERROR SINTACTICO{}: Falta el punto y coma al final de la declaracion de funcion [#,%]");
        gramatica.group("FUNCION_COMP_EXPANDIR_PC", "FUNCION_COMP_EXPANDIR", 17, "ERROR SINTACTICO{}: Falta el punto y coma al final de la declaracion de funcion [#,%]");
        gramatica.group("FUNCION_COMP_EXPANDIR_PC", "FUNCION_COMP_GENERAR_GRAF", 18, "ERROR SINTACTICO{}: Falta el punto y coma al final de la declaracion de funcion [#,%]");

        gramatica.initialLineColumn();

        //eliminacion del el punto y coma
        gramatica.delete("PUNTOyCOMA", 15, "ERROR SINTACTICO{}: El punto y coma no esta al final de una sentencia");
        gramatica.group("SENTENCIAS", "(VARIABLE_PC | FUNCION_COMP_PC | FUNCION_MUT_PC)+");

        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("ESTRUC_CONTROL_COMP_LASLC", "ESTRUC_CONTROL_COMP LLAVE_A (SENTENCIAS)? LLAVE_C", true);
            gramatica.group("SENTENCIAS", "(SENTENCIAS | ESTRUC_CONTROL_COMP_LASLC)+");
        });

        /* ESTRUCTURAS DE FUNCION IMCOMPLETAS*/
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.initialLineColumn();

            gramatica.group("ESTRUC_CONTROL_COMP_LASLC", "ESTRUC_CONTROL_COMP (SENTENCIAS)? LLAVE_C", true, 16, "ERRROR SINTACTICO{}: Falta la llave que abre en la estructura de control");

            gramatica.finalLineColumn();
            gramatica.group("ESTRUC_CONTROL_COMP_LASLC", "ESTRUC_CONTROL_COMP LLAVE_A SENTENCIAS", true, 16, "ERRROR SINTACTICO{}: Falta la llave que cierra en la estructura de control");

            gramatica.group("SENTENCIAS", "(SENTENCIAS | ESTRUC_CONTROL_COMP_LASLC) FIN", true);
            
            //gramatica.group("SENTENCIAS", "(SENTENCIAS | ESTRUC_CONTROL_COMP_LASLC)", true, 44, "ERROR SINTACTICO {}: FALTA EL FIN DEL PROGRAMA, FAVOR DE VERIFICAR EL CODIGO [#,%]");

        });
        gramatica.initialLineColumn();
        //gramatica.group("SENTENCIAS", "(SENTENCIAS | ESTRUC_CONTROL_COMP_LASLC)", true, 44, "ERROR SINTACTICO {}: FALTA EL FIN DEL PROGRAMA, FAVOR DE VERIFICAR EL CODIGO [#,%]");
        gramatica.delete(new String[]{"LLAVE_A", "LLAVE_C"}, 17, "ERROR SINTACTICO{}: La llave [] no esta contenida en una agrupacion[#,%]");

        gramatica.show();

    }

    private void SemanticAnalisis() {

    }

    private void ImprimirConsola() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErro = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(errors);
                strErro += strError + "\n";

            }
            txaErrores.setText("Compilacion terminada...\n" + strErro + "\nLa compilacion termino con errores");
        } else {
            txaErrores.setText("Compilacion terminada");
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());

                new Compilador().setVisible(true);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        );
    }
    Tablass T = new Tablass();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSimbolos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jtpEscritorio;
    private javax.swing.JTable tblLexemas;
    private java.awt.TextArea txaErrores;
    // End of variables declaration//GEN-END:variables
}
