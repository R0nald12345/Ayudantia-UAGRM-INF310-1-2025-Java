/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author Ronald
 */
public interface IArbolBusquedaBinaria<T extends Comparable<T>>{
    
    void insertarNodoRecursivo(T dato);
    public int cantidadNodos();
    public boolean verificarVacio();
    public void recorridoInOrden();
    public void recorridoPreOrden();
    public void recorridoPostOrden();
    public boolean isHoja(ClaseNodo<T> Nodo);
    public int contarNodosPares();
    public void recorridoPorNivel();
    public int contarNodosParesIterativo();
    public int contarCantidadHijosVaciosInOrdenIterativo();
    
    
}
