/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolMVias;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//import sun.misc.Queue;
import java.util.Queue;
/**
 *
 * @author USER
 */
public class ArbolMVias<T extends Comparable<T>> implements IArbolMVias<T> {

    //Atributos 
    protected NodoMVias<T> raiz;
    protected int orden; //Cantidad de Hijos
    protected int POSICION_INVALIDA = -1;

    //Constructor 
    public ArbolMVias(int orden) {
        this.orden = orden;
    }

    //Metodos 
    @Override
    public void insertar(T ClaveInsertar) {
        //Si mi arbol esta vacio
        if (this.esArbolVacio() == true) {
            NodoMVias nuevoNodo = new NodoMVias(this.orden, ClaveInsertar);
            this.raiz = nuevoNodo;
        } else {
            this.insertarRecursivo(this.raiz, ClaveInsertar);
        }
    }

    private void insertarRecursivo(NodoMVias<T> raizAuxiliar, T ClaveInsertar) {
        int posicionClaveExistente = this.getPosicionDeClave(raizAuxiliar, ClaveInsertar);
        //Si mi arbol es Hoja
        if (raizAuxiliar.esHoja()) {
            //Verifico si mi arbol es hoja y ademas esa hoja esta lleno sus claves
            if (raizAuxiliar.estanClaveLlenas()) {
                int posicionPorDondeBajar = this.getPosicionPorDondeBajar(raizAuxiliar, ClaveInsertar);
                NodoMVias<T> nuevoHijo = new NodoMVias<>(this.orden, ClaveInsertar);
                raizAuxiliar.setHijo(posicionPorDondeBajar, nuevoHijo);
            } else {
                this.insertarClaveEnNodo(raizAuxiliar, ClaveInsertar);
            }
        } else {
            //Que pasa si mi arbol no es Hoja
            int posicionPorDondebajar = this.getPosicionPorDondeBajar(raizAuxiliar, ClaveInsertar);
            if (raizAuxiliar.esHijoVacio(posicionPorDondebajar)) {
                NodoMVias<T> nuevoHijo = new NodoMVias<>(this.orden, ClaveInsertar);
                raizAuxiliar.setHijo(posicionPorDondebajar, nuevoHijo);
            } else {
                this.insertarRecursivo(raizAuxiliar.getHijo(posicionPorDondebajar), ClaveInsertar);
            }
        }
    }

    private int getPosicionDeClave(NodoMVias<T> nodoActual, T claveInsertar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            T claveActual = nodoActual.getClave(i);
            if (claveInsertar.compareTo(claveActual) == 0) {
                return i;
            }
        }
        return nodoActual.cantidadDeClavesNoVacias();
    }

    private int getPosicionPorDondeBajar(NodoMVias<T> nodoActual, T claveABuscar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            T claveActual = nodoActual.getClave(i);
            if (claveABuscar.compareTo(claveActual) < 0) {
                return i;
            }
        }
        return nodoActual.cantidadDeClavesNoVacias();
    }

    private void insertarClaveEnNodo(NodoMVias<T> nodoActual, T claveAInsertar) {
//        int posicionClaveExistente = this.getPosicionDeClave(raizAuxiliar, ClaveInsertar);
        int posicionDondeInsertar = getPosicionDondeInsertar(nodoActual, claveAInsertar);
        int posicionActual = nodoActual.cantidadDeClavesNoVacias();
        while (posicionActual > posicionDondeInsertar) {
            T claveActual = nodoActual.getClave(posicionActual - 1);
            nodoActual.setClave(posicionActual, claveActual);
            posicionActual--;
        }
        nodoActual.setClave(posicionDondeInsertar, claveAInsertar);
    }

    private int getPosicionDondeInsertar(NodoMVias<T> nodoActual, T claveAInsertar) {
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            T claveActual = nodoActual.getClave(i);
            if (claveAInsertar.compareTo(claveActual) < 0) {
                return i;
            }
        }
        return nodoActual.cantidadDeClavesNoVacias();
    }

    @Override
    public boolean verificarEsVacio() {
        return this.raiz == null;
    }

    @Override
    public List<T> recorridoInOrden() {
        List<T> recorrido = new ArrayList<>();
        this.recorridoEnInOrden(this.raiz, recorrido);
        return recorrido;

    }

    private void recorridoEnInOrden(NodoMVias<T> nodoActual, List<T> recorrido) {
        //n == 0
        if (NodoMVias.esNodoVacio(nodoActual)) {
            return;
        }
        for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
            recorridoEnInOrden(nodoActual.getHijo(i), recorrido);
            recorrido.add(nodoActual.getClave(i));
        }
        recorridoEnInOrden(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()), recorrido);
    }

    @Override
    public int obtenerAltura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean esArbolVacio() {
        return this.raiz == null;
    }

    @Override
    public int contarCantidadHijosNoVacios(int nivelLimite) {
        if (this.raiz == null || nivelLimite <= 0) {
            return 0;
        }
        int contador=0;
        int nivelActual=0;
        Queue<NodoMVias<T>> cola = new LinkedList<>();
        
        cola.add(this.raiz);        
        while(!cola.isEmpty() && nivelActual<nivelLimite){
            //sacamos el nodo de mi Cola
            NodoMVias<T> nodo = cola.poll();
            contador= contador + nodo.cantidadDeHijosNoVacios(); //3
            
            for (int i = 0; i <  nodo.cantidadDeHijosNoVacios(); i++) {
                NodoMVias<T> hijo = nodo.getHijo(i);
                cola.add(hijo);
            }
            nivelActual++;
        }
        return contador;
        
    }

}
