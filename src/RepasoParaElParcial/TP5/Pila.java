/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepasoParaElParcial.TP5;

/**
 *
 * @author orlando
 */
public class Pila {

    private Nodo tope;

    private class Nodo {

        private Nodo siguiente;
        private Object item;

        public Nodo(Object item) {
            this.item = item;
            this.siguiente = null;
        }

        @Override
        public String toString() {
            return String.valueOf(item);
        }

        public Nodo obtenerSiguiente() {
            return siguiente;
        }

        public void asignarSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        public Object obtenerDato() {
            return item;
        }

        public void asignarDato(Object item) {
            this.item = item;
        }

    }

    public Pila() {
        this.tope = null;
    }

    public static Pila pilaVacia() {
        return new Pila();
    }

    public boolean esPilaVacia() {
        return this.tope == null;
    }

    public void mostrar() {
        Nodo aux = this.tope;
        while (aux != null) {
            System.out.println(aux);
            aux = aux.obtenerSiguiente();
        }
        System.out.println("---------------");

    }

    public Pila push(Object item) {
        Nodo nuevo = new Nodo(item);
        nuevo.asignarSiguiente(tope);
        tope = nuevo;
        return this;
    }

    public Object top() {
        if (this.esPilaVacia()) {
            return null;
        } else {
            return this.tope.item;
        }
    }

    public Pila pop() {
        if (this.esPilaVacia()) {
            return this;

        } else {
            tope = tope.siguiente;
            return this;
        }
    }
}
