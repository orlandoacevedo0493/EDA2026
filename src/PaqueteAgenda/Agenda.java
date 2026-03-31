package PaqueteAgenda;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Orlando
 */
public class Agenda {

    private Nodo cabeza;

    public Agenda() {
        this.cabeza = null;
    }

    private class Nodo {

        Contacto dato;
        Nodo siguiente;

        public Nodo(Contacto dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    static Agenda crearAgenda() {
        return new Agenda();
    }

    void listar() {
        Nodo aux = this.cabeza;

        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
        System.out.println("-----");
    }

    boolean esVacia() {
        return this.cabeza == null;
    }

    Agenda agregar(Contacto c) {
        Nodo n1 = new Nodo(c);

        if (this.cabeza == null) {
            this.cabeza = n1;
            return this;
        }
        Nodo aux = this.cabeza;

        while (aux.siguiente != null) {
            aux = aux.siguiente;
        }
        aux.siguiente = n1;
        return this;
    }

    Contacto buscar(String nombre) {
        if (!this.esVacia()) {
            Nodo aux = this.cabeza;
            while (aux != null) {
                if (aux.dato.nombre.equalsIgnoreCase(nombre)) {
                    return aux.dato;
                }
                aux = aux.siguiente;
            }
            return null;
        }
        return null;
    }

    Agenda borrar(String telefono) {
        if (!this.esVacia()) {

            if (cabeza.dato.telefono.equals(telefono)) {
                cabeza = cabeza.siguiente;
                return this;
            }
            Nodo aux = this.cabeza;

            while (aux.siguiente != null) {
                if (aux.siguiente.dato.telefono.equals(telefono)) {
                    aux.siguiente = aux.siguiente.siguiente;
                    return this;
                }
                aux = aux.siguiente;
            }
            return this;
        }
        return this;
    }

    int cantidad() {
        int contador = 0;
        if (!this.esVacia()) {
            Nodo aux = this.cabeza;
            while (aux != null) {
                aux = aux.siguiente;
                contador++;
            }
            return contador;
        }
        return 0;
    }

    Contacto enPosicion(int posicion) {
        int contador=0;
        if (!this.esVacia()) {
            if (posicion == 0) {
                return this.cabeza.dato;
            }
            Nodo aux = this.cabeza;
            while (aux != null && contador < posicion) {
                aux = aux.siguiente;
                contador++;
            }
            if (aux != null) { 
                return aux.dato;
            } else {
                return null;
            }
        }
        return null;
    }
}
