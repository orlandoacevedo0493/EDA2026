/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepasoParaElParcial.TP1;

import static RepasoParaElParcial.TP1.ListaEnlazada.crearLista;

/**
 *
 * @author orlando
 */
public class ProbarLista {

    public static void main(String[] args) {
        ListaEnlazada l1 = ListaEnlazada.crearLista();
        l1.insertarAlFinal(1);
        l1.insertarAlFinal(2);
        l1.insertarAlFinal(3);
        l1.mostrar();

        l1.insertarAlFinal(6);
        l1.mostrar();
        
        // 1. Guardamos el tiempo de inicio
        long tiempoInicio = System.currentTimeMillis();

        for (int i = 0; i < 25000; i++) {
            l1.insertarAlFinal(i);
        }

        // 2. Guardamos el tiempo de fin
        long tiempoFin = System.currentTimeMillis();
        
        // 3. Calculamos la diferencia
        long tiempoTotal = tiempoFin - tiempoInicio;

        System.out.println("Cantidad de elementos: " + l1.cantidad());
        System.out.println("Tiempo de inserción: " + tiempoTotal + " milisegundos");
    }
}
