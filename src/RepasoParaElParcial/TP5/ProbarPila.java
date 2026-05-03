/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepasoParaElParcial.TP5;

import static RepasoParaElParcial.TP5.Pila.pilaVacia;

/**
 *
 * @author orlando
 */
public class ProbarPila {

    public static void main(String[] args) {
        Pila p = pilaVacia();
        Object objeto1 = new Object();
        Object objeto2 = new Object();
        Object objeto3 = new Object();
        Object objeto4 = new Object();

        p.push(objeto1);
        p.push(objeto2);
        p.push(objeto3);

        p.mostrar();
        p.pop();
        p.mostrar();

        System.out.println("Probando deshacer re hacer");

        DeshacerRehacer miUndo = new DeshacerRehacer();

        miUndo = new DeshacerRehacer();
        miUndo.registrarAccion(1);
        miUndo.registrarAccion(2);
        miUndo.registrarAccion(3);
        System.out.println(miUndo.deshacer() + " Deberia dar: " + 3);
        System.out.println(miUndo.deshacer() + " Deberia dar: " + 2);
        System.out.println(miUndo.rehacer() + " Deberia dar: " + 2);
        System.out.println(miUndo.rehacer() + " Deberia dar: " + 3);
        System.out.println(miUndo.rehacer() + " Deberia dar: " + null);
        System.out.println(miUndo.deshacer() + " Deberia dar: " + 3);
        miUndo.registrarAccion(4);
        System.out.println(miUndo.rehacer() + " Deberia dar: " + null);
        System.out.println(miUndo.deshacer() + " Deberia dar: " + 4);
        System.out.println(miUndo.deshacer() + " Deberia dar: " + 2);
        System.out.println(miUndo.deshacer() + " Deberia dar: " + 1);
        System.out.println(miUndo.deshacer() + " Deberia dar: " + null);
    }

}
