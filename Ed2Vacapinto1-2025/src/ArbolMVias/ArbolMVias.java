/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ArbolMVias;

import java.util.List;

/**
 *
 * @author USER
 */
public class ArbolMVias<T extends Comparable<T> > implements IArbolMVias<T>{

    //Atributos 
    protected NodoMVias<T> raiz;
    protected int orden; //Cantidad de Hijos
    protected int POSICION_INVALIDA = -1;
    
    //Constructor 
    public ArbolMVias(int orden){
        this.orden = orden;
    }
    
    
    //Metodos 
    
    @Override
    public void insertar(T dato) {
        if(this.raiz == null){
            NodoMVias nuevoNodo = new NodoMVias(this.orden, dato);
        }
    }

  

    @Override
    public boolean verificarEsVacio() {
        return this.raiz == null;
    }

    @Override
    public List<T> recorridoInOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int obtenerAltura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
