/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

import java.util.ArrayList;

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
    
    public void crearArbol(){
        String palabra = "";
        int cont = 0;
        if(texto.charAt(texto.length()-1) != ' '){
            texto = texto + " ";
        }
        for(int i = 0;i<texto.length();i++){
            texto.trim();
            if(texto.charAt(i) != ' '){
                palabra = palabra+texto.charAt(i);
            }else{
                arbol.add(palabra);
                palabras.add(palabra);
                palabra="";
                cont++;
            }
        }
    }
    
    public int cantidadPalabras(){
        return arbol.cantidadDePalabras();
    }
    
    public int masRepetida(){
        return arbol.masRepetida();
    }
    
    public ArrayList<String> desigualdad(){
        return arbol.desiguales();
    }
    
}
