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
public interface IArbolMVias<T extends Comparable<T>> {
    void insertar(T ClaveInsertar);
    int obtenerAltura();
    int size(); //Contar la cantidad de Nodos
    boolean verificarEsVacio();
    List<T> recorridoInOrden();
    boolean esArbolVacio();
    int contarCantidadHijosNoVacios(int n);
    
}
