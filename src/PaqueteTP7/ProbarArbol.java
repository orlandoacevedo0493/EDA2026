/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteTP7;

import static PaqueteTP7.ArbolBinario.arbolBinarioVacio;

/**
 *
 * @author orlando
 */
public class ProbarArbol {

    public static void main(String[] args) {
        Object item10 = 10;
        Object item5 = 5;
        Object item20 = 20;
        Object item3 = 3;
        Object item8 = 8;
        Object item9 = 9;
        Object item15 = 15;
        Object item12 = 12;
        Object item16 = 16;

        ArbolBinario b10 = arbolBinarioVacio();
        ArbolBinario b5 = arbolBinarioVacio();
        ArbolBinario b20 = arbolBinarioVacio();
        ArbolBinario b3 = arbolBinarioVacio();
        ArbolBinario b8 = arbolBinarioVacio();
        ArbolBinario b9 =arbolBinarioVacio();
        ArbolBinario b15 = arbolBinarioVacio();
        ArbolBinario b16 = arbolBinarioVacio();
        ArbolBinario b10Espejo = arbolBinarioVacio();
        ArbolBinario vacio = arbolBinarioVacio();

        b3.armarAB(vacio, item3, vacio);
        b9.armarAB(vacio, item9, vacio);
        b15.armarAB(vacio, item15, vacio);
        b8.armarAB(vacio, item8, b9);
        b5.armarAB(b3, item5, b8);
        b16.armarAB(vacio, item16, vacio);

        b20.armarAB(b15, item8, b16);
        b10.armarAB(b5, item10, b20);
        b10.imprimirVertical();
//        b10.preOrden();
        
        
        System.out.println(b10.nivelDe(item8));
        
    }

    public static int suma(ArbolBinario b) {
        if (b.esABVacio()) {
            return 0;
        }
        return (int) b.raiz() + (int) suma(b.izquierdo()) + (int) suma(b.derecho());
    }

    public static int nodosNivel(ArbolBinario b, int nivel) {
        if (b.esABVacio()) {
            return 0;
        }
        if (nivel == 0) {
            return 1;
        }
        return nodosNivel(b.izquierdo(), nivel - 1) + nodosNivel(b.derecho(), nivel - 1);
    }

    public static ArbolBinario espejo(ArbolBinario b) {
        ArbolBinario aux = arbolBinarioVacio();
        if (b.esABVacio()) {
            return b;
        }
        aux.armarAB(espejo(b.derecho()), b.raiz(), espejo(b.izquierdo()));
        return aux;
    }

    public static int maxValor(ArbolBinario a) {
        // 1. Caso base: si el árbol está vacío, devolvemos el valor más chico posible.
        if (a.esABVacio()) {
            return Integer.MIN_VALUE;
        }

        // 2. Extraemos el valor del nodo actual
        int valorActual = (int) a.raiz();

        // 3. Buscamos el máximo de cada rama delegando el trabajo (Paso recursivo)
        int maxIzq = maxValor(a.izquierdo());
        int maxDer = maxValor(a.derecho());

        // 4. El ganador absoluto es el máximo entre nuestro valor actual y los ganadores de cada rama
        return Math.max(valorActual, Math.max(maxIzq, maxDer));
    }
    
    public static int sumaHojas(ArbolBinario a){
        if(a.esABVacio()){
            return 0;
        }
        if(a.izquierdo().esABVacio()&&a.derecho().esABVacio()){
            return (int)a.raiz();
        }
        return sumaHojas(a.izquierdo())+sumaHojas(a.derecho());
    }
}
