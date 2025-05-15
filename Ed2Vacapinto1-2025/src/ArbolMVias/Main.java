/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolMVias;

/**
 *
 * @author USER
 */
public class Main {

    public static void main(String[] args) {
        ArbolMVias arbolMVias = new ArbolMVias(3);
        arbolMVias.insertar(80);
        arbolMVias.insertar(90);
        arbolMVias.insertar(70);
        arbolMVias.insertar(78);

        arbolMVias.insertar(85);
        arbolMVias.insertar(100);
        arbolMVias.insertar(60);

        System.out.println(arbolMVias.recorridoInOrden());
        System.out.println("Cantidade de hijos no vacios antes de nivel:2 =>" + arbolMVias.contarCantidadHijosNoVacios(2));
    }
}
