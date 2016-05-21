/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

/**
 *
 * @author s212e19
 * @param <E>
 */
public class ABB<E extends Comparable<E>> {

    private NodoBinario<E> raiz;

    public ABB() {
        raiz = null;
    }

    public void add(E target) {
        if (raiz != null) {
            add(raiz, target);
        } else {
            raiz = new NodoBinario<>(target);
        }
    }

    protected void add(NodoBinario<E> r, E target) {
        if (r.getItem().compareTo(target) > 0) {
            if (r.getHijoIzquierdo() == null) {
                r.setHijoIzquierdo(new NodoBinario<>(target));
            } else {
                add(r.getHijoIzquierdo(), target);
            }
        } else if (r.getItem().compareTo(target) < 0) {
            if (r.getHijoDerecho() == null) {
                r.setHijoDerecho(new NodoBinario<>(target));
            } else {
                add(r.getHijoDerecho(), target);
            }
        }
    }

    public boolean contains(E target) {
        NodoBinario<E> auxiliar = raiz;

        while (auxiliar != null) {
            int comparador = auxiliar.getItem().compareTo(target);

            if (comparador == 0) {
                return true;
            } else if (comparador < 0) {
                auxiliar = auxiliar.getHijoDerecho();
            } else {
                auxiliar = auxiliar.getHijoIzquierdo();
            }
        }

        return false;
    }

    public int size() {
        return size(raiz);
    }

    public int size(NodoBinario<E> r) {
        if (r != null) {
            return size(r.getHijoIzquierdo()) + size(r.getHijoDerecho()) + 1;
        }

        return 0;
    }

    //1. Escriba un método que retorne la cantidad de hojas del arbol
    //
}
