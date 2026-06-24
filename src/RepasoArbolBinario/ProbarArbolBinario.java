/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepasoArbolBinario;

import static RepasoArbolBinario.ArbolBinario.armarAB;

/**
 *
 * @author orlando
 */
public class ProbarArbolBinario {

    public static void main(String[] args) {
        String item1 = "1";
        String item2 = "2";
        String item3 = "3";
        String item4 = "4";
        String item5 = "5";
        String item6 = "6";
        String item7 = "7";
        String item8 = "8";

        ArbolBinario arbol1 = armarAB(null, item1, null);
        ArbolBinario arbol2 = armarAB(null, item2, null);
        ArbolBinario arbol3 = armarAB(null, item3, null);
        ArbolBinario arbol4 = armarAB(null, item4, null);
        ArbolBinario arbol5 = armarAB(null, item5, null);
        ArbolBinario arbol6 = armarAB(null, item6, null);
        ArbolBinario arbol7 = armarAB(null, item7, null);
        ArbolBinario arbol8 = armarAB(null, item8, null);

        arbol2 = armarAB(arbol4, item2, arbol5);
        arbol1 = armarAB(arbol2, item1, arbol3);
        arbol1.imprimirVertical();

    }

    public static int suma(ArbolBinario a){
        
    }
    //3) Diseñar funciones como usuario para cada caso
    //a) suma: Calcula la suma de los valores de los nodos
    //b) nodosNivel: devuelve la cantidad de nodos en un nivel dado
    //c) espejo: Dado un árbol binario, devuelve un nuevo árbol del de entrada
    //(hijos izquierdo y derecho intercambiados en cada nodo). Para el árbol de
    //la figura 1 el espejo será:
}
