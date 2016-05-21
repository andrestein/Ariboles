/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arbolesbinarios;

/**
 *
 * @author s212e19
 */

/**
 *
 * @author Oscar Arenas
 * @param <E>
 */
public class NodoBinario<E> {

    private NodoBinario<E> hijoIzquierdo;
    private E item;
    private NodoBinario<E> hijoDerecho;

    public NodoBinario(E item) {
        this.item = item;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public NodoBinario(NodoBinario<E> hijoIzquierdo, E item, NodoBinario<E> hijoDerecho) {
        this.hijoIzquierdo = hijoIzquierdo;
        this.item = item;
        this.hijoDerecho = hijoDerecho;
    }

    public NodoBinario<E> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoBinario<E> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public NodoBinario<E> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoBinario<E> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public void setHijos(NodoBinario<E> hijoIzquierdo, NodoBinario<E> hijoDerecho) {
        this.hijoIzquierdo = hijoIzquierdo;
        this.hijoDerecho = hijoDerecho;
    }

    public String toStringPreorder() {
        String resultado = "";
        resultado += item;

        if (hijoIzquierdo != null) {
            resultado += hijoIzquierdo.toStringPreorder();
        }
        if (hijoDerecho != null) {
            resultado += hijoDerecho.toStringPreorder();
        }
        return resultado;
    }

    public String preorder() {
        return preorder(this);
    }

    protected String preorder(NodoBinario<E> nodo) {
        String resultado = "";

        if (nodo != null) {
            resultado += nodo.item + " ";
            resultado += preorder(nodo.hijoIzquierdo);
            resultado += preorder(nodo.hijoDerecho);
        }

        return resultado;
    }

    public boolean esHoja() {
        return hijoIzquierdo == null && hijoDerecho == null;
    }
}