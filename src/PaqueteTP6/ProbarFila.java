/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteTP6;

import static PaqueteTP6.Fila.filaVacia;
import java.util.Arrays;

/**
 *
 * @author orlando
 */
public class ProbarFila {

    public static void main(String[] args) {
        String objeto1 = "Elemento 1";
        String objeto2 = "Elemento 2";
        String objeto3 = "Elemento 3";
        String objeto4 = "Elemento 4";
        String objeto5 = "Elemento 5";
        String objeto6 = "Elemento 6";
        String objeto7 = "Elemento 7";

        Fila f1 = filaVacia();
        Fila f2 = filaVacia();
                Fila f3 = filaVacia();


        f1.enfila(objeto1);
        f1.enfila(objeto2);
        f1.enfila(objeto3);

        f1.mostrar();
        f1.defilarn(1);
        f1.mostrar();

        f2.enfila(objeto4);
        f2.enfila(objeto5);
        f2.enfila(objeto6);

//        Object[] arreglo = f1.toArray();
//        System.out.println(Arrays.toString(arreglo));
//        Object[] arregloAImportar = new Object[3];
//        arregloAImportar[0] = objeto5;
//        arregloAImportar[1] = objeto6;
//        arregloAImportar[2] = objeto7;
//        f1.fromArray(arregloAImportar);
        f1.merge(f2);
        f1.mostrar();
        f3=f1.copiar();
        f3.mostrar();
    }
}
