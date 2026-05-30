/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteTP7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author orlando
 */
public class GeneradorHuffmanManual {

    public static void main(String[] args) {

        // 1. Preparamos una lista vacía para nuestros datos
        List<DatoHuffman> listaDatos = new ArrayList<>();

        // 2. Agregamos caracteres y sus frecuencias (ejemplo clásico)
        // Puedes imaginar que estos son los porcentajes de aparición de cada letra
        listaDatos.add(new DatoHuffman('a', 0.45));
        listaDatos.add(new DatoHuffman('b', 0.13));
        listaDatos.add(new DatoHuffman('c', 0.12));
        listaDatos.add(new DatoHuffman('d', 0.16));
        listaDatos.add(new DatoHuffman('e', 0.09));
        listaDatos.add(new DatoHuffman('f', 0.05));

        System.out.println("Generando Árbol de Huffman...");

        // 3. Llamamos a nuestra función para que construya el árbol
        // (Asegúrate de usar el nombre correcto de la clase donde pusiste el método)
        ArbolBinario arbolHuffman = GeneradorHuffmanManual.ABHUFFMAN(listaDatos);

        // 4. Usamos el método que ya tienes programado para visualizarlo
        arbolHuffman.imprimirVertical();

        // 5. Opcional: Probar el preOrden que también tienes en tu clase
        System.out.println("Recorrido PreOrden:");
        arbolHuffman.preOrden();
    }

    public static ArbolBinario ABHUFFMAN(List<DatoHuffman> datos) {
        if (datos == null || datos.isEmpty()) {
            return ArbolBinario.arbolBinarioVacio();
        }

        List<ArbolBinario> bosque = new ArrayList<>();

        // 2. Convertimos cada dato inicial en una hoja y la metemos al bosque
        for (DatoHuffman dato : datos) {
            ArbolBinario hoja = new ArbolBinario();
            hoja.armarAB(ArbolBinario.arbolBinarioVacio(), dato, ArbolBinario.arbolBinarioVacio());
            bosque.add(hoja);
        }

        while (bosque.size() > 1) {
            ArbolBinario menor1 = extraerMenor(bosque);
            ArbolBinario menor2 = extraerMenor(bosque);

            DatoHuffman dato1 = (DatoHuffman) menor1.raiz();
            DatoHuffman dato2 = (DatoHuffman) menor2.raiz();

            double sumaFrecuencias = dato1.getFrecuencia() + dato2.getFrecuencia();
            DatoHuffman datoPadre = new DatoHuffman('*', sumaFrecuencias);

            ArbolBinario padre = new ArbolBinario();
            padre.armarAB(menor1, datoPadre, menor2);

            bosque.add(padre);
        }
        return bosque.get(0);
    }

    private static ArbolBinario extraerMenor(List<ArbolBinario> bosque) {
        int indiceDelMenor = 0;

        DatoHuffman datoMenor = (DatoHuffman) bosque.get(0).raiz();
        double minFrecuencia = datoMenor.getFrecuencia();

        // Recorremos el resto del bosque buscando si hay alguno más pequeño
        for (int i = 1; i < bosque.size(); i++) {
            DatoHuffman datoActual = (DatoHuffman) bosque.get(i).raiz();
            if (datoActual.getFrecuencia() < minFrecuencia) {
                minFrecuencia = datoActual.getFrecuencia();
                indiceDelMenor = i;
            }
        }

        return bosque.remove(indiceDelMenor);
    }
}
