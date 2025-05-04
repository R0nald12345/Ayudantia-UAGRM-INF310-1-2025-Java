/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author USER
 */
public class Main {
    
    public static void main(String[] args) {
        
        ClaseArbolBinario objetoarbol = new ClaseArbolBinario();
        objetoarbol.insertarNodoRecursivo(45);
        objetoarbol.insertarNodoRecursivo(23);
        objetoarbol.insertarNodoRecursivo(65);
        objetoarbol.insertarNodoRecursivo(2);
        objetoarbol.insertarNodoRecursivo(52);
        
//        objetoarbol.recorridoInOrden();
//        System.out.println("");
//        System.out.println("Cantidad de Nodos: " + objetoarbol.cantidadNodos());
//        objetoarbol.recorridoPreOrden();
//        System.out.println("");
//        objetoarbol.recorridoPostOrden();
//        System.out.println("");
//        System.out.println("Cantidad de Nodos pares: " + objetoarbol.contarNodosPares());
        objetoarbol.recorridoPorNivel();
        System.out.println("Contar Nodos pares Iterativo: " + objetoarbol.contarNodosParesIterativo());
        System.out.println("Cantidad de Hijos Vacios: " + objetoarbol.contarCantidadHijosVaciosInOrdenIterativo());
    }
    
}
