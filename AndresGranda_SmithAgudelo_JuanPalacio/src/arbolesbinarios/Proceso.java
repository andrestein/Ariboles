/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Proceso {
    
    private String texto;
    private ABB arbol;
    private ArrayList<String> palabras;
    private ArrayList<String> palabrasIguales;
    
    public Proceso(String texto){
        this.texto = texto;
        arbol = new ABB();
        palabras = new ArrayList<>();
        palabrasIguales = new ArrayList<>();
    }
    
    public void crearArbol(List<String> palabras){
        for(String palabra: palabras) {
            palabra = palabra.trim();
            if ( palabra.matches( "\\w+") ) {
                arbol.add( palabra );
            }
        }
    }
    
    public ArrayList<String> palabrasDesiguales(){
        return arbol.desiguales();
    }
    
    public int cantidadPalabras(){
        return arbol.cantidadDePalabras();
    }
    
    public ArrayList<String> palabrasIguales(){
        return arbol.desiguales();
    }
    
    public List<String> ordenarTexto() {
        List<String> list = new LinkedList<>();
        NodoBinario<String> raiz = arbol.getRaiz();
        list = raiz.inordem();
        return list;
    }
    
}
