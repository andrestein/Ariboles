/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author LENOVO
 */
public class Inicial {

    public static void main( String args[] ) {
        Proceso proceso = new Proceso( "Texto" );
        for ( ;; ) {
            println( "### Arboles" );
            Scanner read = new Scanner( System.in );

            char op = '\0';
            do {
                println( "1) Leer archivo\n2) Leer cadena\n" );
                print( "opcion: > " );
                op = read.nextLine().charAt( 0 );
                List<String> words = null;

                switch ( op ) {
                case '1':
                    words = readFile();
                    proceso.crearArbol( words );
                    break;
                case '2':
                    print( "> " );
                    words = readConsole();
                    proceso.crearArbol( words );
                    break;
                default:
                    op = '\0';
                }
            } while ( op == '\0' );
            println( "\nArbol creado exitosamente." );
            do {
                println( "\n\n### Operaciones" );
                println( "a) Muestra cuantas palabras lo componen.\n"
                        + "b) Muestra las palabras diferentes que lo componen\n"
                        + "   y las veces que se repite cada palabra.\n"
                        + "c) Muestra el elemento con menor campo-clave\n"
                        + "d) Muestra la palabra que mas se repite\n"
                        + "e) Muestra las palabras del texto en orden alfabetico\n"
                        + "s) Salir.\n"
                );

                print( "opcion: > " );
                op = read.nextLine().charAt( 0 );
                List<String> words = null;
                
                switch (op) {
                    case 'a':
                        print( proceso.cantidadPalabras() + " palabras" );
                    break;
                    case 'b':
                        // Punto b usar print() por favor
                        
                    break;
                    case 'c':
                        // Punto c usar print() por favor
                    break;
                    case 'd':
                        // Punto d usar print() por favor
                    break;
                    case 'e':
                        words = proceso.ordenarTexto();
                        for ( String word : words ) {
                            print( word + " " );
                        }
                    break;
                    case 's':
                        println( "Saliendo..." );
                        return;
                    default: 
                        op = '\0';
                }
                
            } while ( op != '\0' );
        }
    }

    public static List<String> readFile() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter( "Text plain", "txt" );
        chooser.setFileFilter( filter );
        chooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
        int status = chooser.showOpenDialog( null );

        List<String> words = new LinkedList<>();
        File file = null;

        if ( status == JFileChooser.APPROVE_OPTION )
            file = chooser.getSelectedFile().getAbsoluteFile();
        else
            return words;

        if ( file != null && file.isFile() )
            try {
                BufferedReader buff = new BufferedReader( new FileReader( file ) );
                for ( String w = buff.readLine(); w != null; w = buff.readLine() ) {
                    String[] ws = w.split( "\\b+" );
                    words.addAll( Arrays.asList( ws ) );
                }
            } catch ( IOException e ) {
                println( "File I/O rrror" );
            }
        return words;
    }

    public static List<String> readConsole() {
        Scanner read = new Scanner( System.in );
        List<String> words = new LinkedList<>();
        String line = null;
        line = read.nextLine();
        words.addAll( Arrays.asList( line.split( "\\b+" ) ) );
        return words;
    }

    public static <T extends Object> void print( T str ) {
        System.out.print( str );
    }

    public static <T extends Object> void println( T str ) {
        System.out.println( str );
    }

}
