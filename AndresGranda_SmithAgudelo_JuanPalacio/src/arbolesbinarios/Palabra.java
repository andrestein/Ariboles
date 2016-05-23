/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

/**
 *
 * @author Juanes
 */
public class Palabra implements Comparable<Palabra> {

    String cadena;
    int repecticiones;

    public Palabra( String cadena ) {
        this.cadena = cadena;
        repecticiones = 1;
    }

    Palabra( String cadena, int repeticiones ) {
        this.cadena = cadena;
        this.repecticiones = repeticiones;
    }

    @Override
    public int compareTo( Palabra t ) {
        return cadena.compareTo( t.getCadena() );
    }

    public String getCadena() {
        return cadena;
    }

    public int getRepeticiones() {
        return repecticiones;
    }

    public void setCadena( String cadena ) {
        this.cadena = cadena;
    }

    public void setNumero( int repeticiones ) {
        this.repecticiones = repeticiones;
    }

    @Override
    public String toString() {
        return cadena;
    }

}
