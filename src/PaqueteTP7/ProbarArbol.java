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

        ArbolBinario b10 = new ArbolBinario();
        ArbolBinario b5 = new ArbolBinario();
        ArbolBinario b20 = new ArbolBinario();
        ArbolBinario b3 = new ArbolBinario();
        ArbolBinario b8 = new ArbolBinario();
        ArbolBinario b9 = new ArbolBinario();
        ArbolBinario b15 = new ArbolBinario();
        ArbolBinario vacio = new ArbolBinario();

        b3.armarAB(vacio, item3, vacio);
        b9.armarAB(vacio, item9, vacio);
        b15.armarAB(vacio, item15, vacio);
        b8.armarAB(vacio, item8, b9);
        b5.armarAB(b3, item5, b8);
        b20.armarAB(b15, item20, vacio);
        b10.armarAB(b5, item10, b20);

        b10.imprimirVertical();
        System.out.println("----------");
        int x = nodosNivel(b10, 0);
        System.out.println(x);
        ArbolBinario espejo = new ArbolBinario();
        espejo = espejo(b10);
        espejo.imprimirVertical();

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
}
