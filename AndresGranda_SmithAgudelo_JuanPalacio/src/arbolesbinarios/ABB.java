/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

import java.util.ArrayList;

/**
 *
 * @author s212e19
 * @param <E>
 */
public class ABB<E extends Comparable<E>> {

    private NodoBinario<E> raiz;
    private ArrayList<String> diferentes;

    public ABB() {
        raiz = null;
    }

    public NodoBinario<E> getRaiz() {
        return raiz;
    }

    public void add( E target ) {
        if ( raiz != null )
            add( raiz, target );
        else
            raiz = new NodoBinario<>( target );
    }

    protected void add( NodoBinario<E> r, E target ) {
        if ( r.getItem().compareTo( target ) > 0 )
            if ( r.getHijoIzquierdo() == null )
                r.setHijoIzquierdo( new NodoBinario<>( target ) );
            else
                add( r.getHijoIzquierdo(), target );
        else if ( r.getItem().compareTo( target ) < 0 )
            if ( r.getHijoDerecho() == null )
                r.setHijoDerecho( new NodoBinario<>( target ) );
            else
                add( r.getHijoDerecho(), target );
    }

    public boolean contains( E target ) {
        NodoBinario<E> auxiliar = raiz;

        while ( auxiliar != null ) {
            int comparador = auxiliar.getItem().compareTo( target );

            if ( comparador == 0 )
                return true;
            else if ( comparador < 0 )
                auxiliar = auxiliar.getHijoDerecho();
            else
                auxiliar = auxiliar.getHijoIzquierdo();
        }

        return false;
    }

    public int size() {
        return size( raiz );
    }

    public int size( NodoBinario<E> r ) {
        if ( r != null )
            return size( r.getHijoIzquierdo() ) + size( r.getHijoDerecho() ) + 1;

        return 0;
    }

    public int cantidadDePalabras() {
        return cantidadDePalabras( raiz );
    }

    public int cantidadDePalabras( NodoBinario<E> r ) {
        if ( r != null )
            return cantidadDePalabras( r.getHijoIzquierdo() ) + cantidadDePalabras( r.getHijoDerecho() ) + 1;

        return 0;
    }

    public int masRepetida() {
        ArrayList<E> lista = new ArrayList<>();
        lista = masRepetida( raiz );
        int contador = 0;
        NodoBinario<E> r = raiz;
        while ( r != null ) {
            if ( lista.contains( r.getItem() ) )
                contador++;
            r = r.getHijoDerecho();
        }
        r = raiz;
        while ( r != null ) {
            if ( lista.contains( r.getItem() ) )
                contador++;
            r = r.getHijoIzquierdo();
        }
        return contador;
    }

    private ArrayList masRepetida( NodoBinario<E> r ) {
        ArrayList<E> lista = new ArrayList<>();
        while ( r != null ) {
            lista.add( r.getItem() );
            masRepetida( r.getHijoDerecho() );
            masRepetida( r.getHijoIzquierdo() );
        }
        return lista;
    }

    public ArrayList<E> desiguales() {
        ArrayList<E> list = new ArrayList<>();
        desiguales( raiz, list );
        int contador = 0;
        NodoBinario<E> r = raiz;
        while ( r != null ) {
            if ( list.contains( r.getItem() ) )
                list.remove( r.getItem() );
            r = r.getHijoDerecho();
        }
        r = raiz;
        while ( r != null ) {
            if ( list.contains( r.getItem() ) )
                list.remove( r.getItem() );
            r = r.getHijoIzquierdo();
        }
        return list;
    }

    private void desiguales( NodoBinario<E> r, ArrayList<E> lista ) {
        while ( r != null ) {
            lista.add( r.getItem() );
            desiguales( r.getHijoDerecho(), lista );
            desiguales( r.getHijoIzquierdo(), lista );
        }
    }

    //1. Escriba un método que retorne la cantidad de hojas del arbol
    //
}
