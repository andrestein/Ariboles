/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Proceso {

    private String texto;
    private ABB arbol;
    //  private ArrayList<String> palabras;
    // private ArrayList<String> palabrasIguales;

    public Proceso( String texto ) {
        this.texto = texto;
        arbol = new ABB();
    }

    public void crearArbol( List<Palabra> palabras ) {
        for ( Palabra palabra : palabras ) {
            if ( palabra.cadena.matches( "\\w+" ) )
                arbol.add( palabra );
        }
    }

    public ArrayList<Palabra> palabrasDesiguales() {
        return arbol.desiguales();
    }

    public int cantidadPalabras() {
        return arbol.cantidadDePalabras();
    }

    public List<Palabra> ordenarTexto() {
        NodoBinario<Palabra> raiz = arbol.getRaiz();
        List<Palabra> list = raiz.inordem();
        return list;
    }

    private int cantidadDePalabras( NodoBinario<Palabra> arbol ) {
        if ( arbol != null )
            return cantidadDePalabras( arbol.getHijoIzquierdo() ) + cantidadDePalabras( arbol.getHijoDerecho() ) + 1;
        return 0;
    }

    public int cantidadDePalabras() {
        return cantidadDePalabras( arbol.getRaiz() );
    }

    private Palabra palabraRepetida( NodoBinario<Palabra> nodo, Palabra palabra ) {
        if ( nodo != null ) {
            if ( nodo.getItem().getRepeticiones() > palabra.getRepeticiones() )
                palabra = nodo.getItem();
            palabra = palabraRepetida( nodo.getHijoIzquierdo(), palabra );
            palabra = palabraRepetida( nodo.getHijoDerecho(), palabra );
        }
        return palabra;
    }

    public Palabra palabraRepetida() {
        return palabraRepetida( arbol.getRaiz(), (Palabra) arbol.getRaiz().getItem() );
    }

    private Palabra palabraMenorCampoClave( NodoBinario<Palabra> arbol ) {
        if ( arbol.getHijoIzquierdo() != null )
            return palabraMenorCampoClave( arbol.getHijoIzquierdo() );
        return arbol.getItem();
    }

    public Palabra palabraMenorCampoClave() {
        return palabraMenorCampoClave( arbol.getRaiz() );
    }

}
