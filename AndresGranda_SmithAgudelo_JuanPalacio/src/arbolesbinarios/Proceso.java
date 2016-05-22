/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Proceso {
    
    private String texto;
    private ABB arbol;
    
    public Proceso(String texto){
        this.texto = texto;
        arbol = new ABB();
    }
    
    public void crearArbol(List<String> palabras){
        for(String palabra: palabras) {
            palabra = palabra.trim();
            if ( palabra.matches( "\\w+") ) {
                System.out.print( palabra + "," );
                arbol.add( palabra );
            }
        }
    }
    
    public int cantidadPalabras(){
        return arbol.cantidadDePalabras();
    }
}
