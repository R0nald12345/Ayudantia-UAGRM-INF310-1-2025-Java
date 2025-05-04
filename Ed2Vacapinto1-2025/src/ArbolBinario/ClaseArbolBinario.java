/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author USER
 */
public class ClaseArbolBinario<T extends Comparable<T> > implements IArbolBusquedaBinaria<T>{

    protected ClaseNodo<T> raiz;
    
    @Override
    public void insertarNodoRecursivo(T dato) {
        this.raiz = insertarNodoRecursivoR(this.raiz, dato);
    }
    
    private ClaseNodo<T> insertarNodoRecursivoR(ClaseNodo<T> raizAux, T dato ){
        if( raizAux == null ){ //Caso base
            ClaseNodo<T> nuevoNodo = new ClaseNodo<>(dato);
            return nuevoNodo;
        }else{//caso General
            if(raizAux.getClave().compareTo(dato) > 0 ){
                //izquierdo
                raizAux.setHijoIzquierdo(insertarNodoRecursivoR(raizAux.getHijoIzquierdo(),dato));
            }else{
                raizAux.setHijoDerecho(insertarNodoRecursivoR(raizAux.getHijoDerecho(),dato));
            }
            return raizAux;
        }
    }

    @Override
    public int cantidadNodos() {
        return cantidadNodoRecursivo(this.raiz);
    }
    
    private int cantidadNodoRecursivo(ClaseNodo<T> raizAux){
        if(raizAux == null){
            return 0;
        }else{
            if(isHoja(raizAux)){
                return 1;
            }else{
                int i =  cantidadNodoRecursivo(raizAux.getHijoIzquierdo());
                int d =cantidadNodoRecursivo(raizAux.getHijoDerecho());
                return i+d+1;
            }
        }
    }
    
  
    

    
    @Override
    public boolean verificarVacio() {
        return this.raiz == null;
    }
    
    
    @Override
    public void recorridoInOrden() {
        recorridoInOrden(this.raiz);
    }
    
    private void recorridoInOrden(ClaseNodo<T> raizAux){
        if(raizAux == null){ //Arbol es vacio
            System.out.print("");
        }else{
            recorridoInOrden(raizAux.getHijoIzquierdo() );
            System.out.print(raizAux.getClave()+ ",");
            recorridoInOrden(raizAux.getHijoDerecho() );
        }
    }

    @Override
    public void recorridoPreOrden() {
        recorridoPreOrden(this.raiz);
    }

     private void recorridoPreOrden(ClaseNodo<T> raizAux){
        if(raizAux == null){ //Arbol es vacio
            System.out.print("");
        }else{
            System.out.print(raizAux.getClave()+ ",");
            recorridoInOrden(raizAux.getHijoIzquierdo() );
            recorridoInOrden(raizAux.getHijoDerecho() );
        }
    }
     
    @Override
    public void recorridoPostOrden() {
        recorridoPostOrden(this.raiz);
    }

    private void recorridoPostOrden(ClaseNodo<T> raizAux){
        if(raizAux == null){ //Arbol es vacio
            System.out.print("");
        }else{
            recorridoInOrden(raizAux.getHijoIzquierdo() );
            recorridoInOrden(raizAux.getHijoDerecho() );
            System.out.print(raizAux.getClave()+ ",");
        }
    }
    
    
    @Override
    public boolean isHoja(ClaseNodo<T> nodo) {
        return nodo.getHijoIzquierdo() == null && nodo.getHijoDerecho() == null;
    }

    @Override
    public int contarNodosPares() {
        return contarNodosParesRecursivo(this.raiz);
    }
    
    private int contarNodosParesRecursivo(ClaseNodo<T> raizAuxiliar){
        if(raizAuxiliar == null ){
            return 0;
        }else{
            if(isHoja(raizAuxiliar)){ //Si mi arbol tiene 1 solo Nodo
                int dato = (Integer) raizAuxiliar.getClave();
                if(dato%2 == 0 ){
                    return 1;
                }else{
                    return 0;
                }
            }
            int i = contarNodosParesRecursivo(raizAuxiliar.getHijoIzquierdo()); //2
            int d = contarNodosParesRecursivo(raizAuxiliar.getHijoDerecho());  //3
             int dato = (Integer) raizAuxiliar.getClave();  //Accedo al nodo Padre
                if(dato%2 == 0 ){
                    return i + d + 1;
                }else{
                    return i +d;
                }
        }
    }

    @Override
    public void recorridoPorNivel() {
        Queue<ClaseNodo<T>> cola = new LinkedList<ClaseNodo<T>>();
        cola.add(this.raiz);
        while(!cola.isEmpty()){
            ClaseNodo<T> auxNodo = cola.poll(); //Saco el Nodo 
            
            if(auxNodo!= null){
               System.out.print( (Integer)auxNodo.getClave() + "  ");
            
               if(auxNodo.getHijoIzquierdo() != null){
                    cola.add(auxNodo.getHijoIzquierdo());
               }
               if(auxNodo.getHijoDerecho() != null){
                   cola.add(auxNodo.getHijoDerecho()); 
               }
            }
            
        }
        System.out.println("");
    }

    @Override
    public int contarNodosParesIterativo() {
       int contador = 0;
       Queue<ClaseNodo<T>> cola = new LinkedList<ClaseNodo<T>>();
        cola.add(this.raiz);
        while(!cola.isEmpty()){
            ClaseNodo<T> auxNodo = cola.poll(); //Saco el Nodo 
            
            if(auxNodo!= null){
                int dato = (Integer)auxNodo.getClave();
                if(dato %2 == 0){
                    contador++;
                }
            
               if(auxNodo.getHijoIzquierdo() != null){
                    cola.add(auxNodo.getHijoIzquierdo());
               }
               if(auxNodo.getHijoDerecho() != null){
                   cola.add(auxNodo.getHijoDerecho()); 
               }
            }
            
        }
        return contador;
    }

    @Override
    public int contarCantidadHijosVaciosInOrdenIterativo() {
        int contador = 0;
        if(this.raiz == null){
            return 0;
        }
        Stack<ClaseNodo<T>> pila = new Stack<>();
        
        ClaseNodo<T> nodoActual = this.raiz;
        while(nodoActual!= null || !pila.empty()){
            
            //Llegar al mas izquierdo
            while(nodoActual != null){
                pila.push(nodoActual);
                
                if(nodoActual.getHijoIzquierdo() == null){
                    contador++;
                }
                
                nodoActual = nodoActual.getHijoIzquierdo();
            }
            
            nodoActual = pila.pop();
            
            if(nodoActual.getHijoDerecho() == null){
                contador++;
            }
            nodoActual= nodoActual.getHijoDerecho();
        }
        
        return contador;
        
    }
    
}
