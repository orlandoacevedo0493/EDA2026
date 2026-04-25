/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteTP5;

import static PaqueteTP5.Pila.pilaVacia;

/**
 *
 * @author orlando
 */
public class ProbarTP5Punto2 {

    public static void main(String[] args) {
        Pila p = pilaVacia();

        Object objeto1 = new Object();
        Object objeto2 = new Object();
        Object objeto3 = new Object();

        p.push(objeto1);
        p.push(objeto2);
        System.out.println(p.esPilaVacia());

        p.mostrar();
                System.out.println("Esto1 "+p.top());

        p.pop();
        p.mostrar();
        System.out.println("Esto2 "+p.top());
        
    }
}
