/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteTP5;

/**
 *
 * @author orlando
 */
public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    private class Nodo {

        private Object dato;
        private Nodo siguiente;

        public Nodo(Object dato) {
            this.dato = dato;
            this.siguiente = null;
        }

    }

    public static Pila pilaVacia() {
        return new Pila();
    }

    public boolean esPilaVacia() {
        return this.tope == null;
    }

    public Pila push(Object dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = this.tope;
        this.tope = nuevo;
        return this;
    }

    public void mostrar() {
        Nodo aux = this.tope;
        while (aux != null) {
            System.out.println(aux.dato.toString());
            aux = aux.siguiente;
        }
        System.out.println("--------------");
    }

    public Pila pop() {
        this.tope = this.tope.siguiente;
        return this;

    }

    public Object top() {
        if (!this.esPilaVacia()) {
            return this.tope.dato;
        } else {
            return null;
        }

    }
}
