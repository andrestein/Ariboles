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
    
    public Proceso(String texto){
        this.texto = texto;
        arbol = new ABB();
    }
    
    public void crearArbol(){
        String palabra = "";
        for(int i = 0;i<texto.length();i++){
            if(texto.charAt(i) != ' '){
                palabra = palabra+texto.charAt(i);
            }else{
                arbol.add(palabra);
                palabra="";
            }
        }
    }
    
    public int cantidadPalabras(){
        return arbol.cantidadDePalabras();
    }
}
