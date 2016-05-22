/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeRegExp.source;

/**
 *
 * @author LENOVO
 */
public class Inicial {
    
    public static void main(String args[]) {
        System.out.println("ingrese la cadena de texto");
        Scanner sc =new Scanner(System.in);
        Proceso proceso=new Proceso(sc.nextLine());
        proceso.crearArbol();
        int numeroPalabras =proceso.cantidadPalabras();
        System.out.println("el numero de palabras es : "+numeroPalabras);        
        System.out.println(" La palabra mas repetida es : "+proceso.masRepetida());
    }
}
