/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Orlando
 */
public class ListaEnlazada {

    private Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    private class Nodo {

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }

        int dato;
        Nodo siguiente;
    }

    static ListaEnlazada crearLista() {
        return new ListaEnlazada();
    }

    boolean esVacia() {
        return this.cabeza == null;
    }

    ListaEnlazada insertarAlInicio(int x) {
        Nodo n1 = new Nodo(x);
        n1.siguiente = this.cabeza;
        this.cabeza = n1;
        return this;
    }

    ListaEnlazada insertarAlFinal(int x) {
        Nodo n1 = new Nodo(x);

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

    void mostrar() {
        Nodo aux = this.cabeza;

        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
        System.out.println("-----");
    }

    int cantidad() {
        int contador = 1;
        if (this.cabeza == null) {
            return 0;
        } else {
            Nodo aux = this.cabeza;
            while (aux.siguiente != null) {
                contador++;
                aux = aux.siguiente;
            }
            return contador;
        }
    }

    ListaEnlazada borrarPrimero() {
        if (!this.esVacia()) {
            this.cabeza = this.cabeza.siguiente;
        }
        return this;
    }

    ListaEnlazada borrarUltimo() {
        if (this.cabeza == null) {
            return this;
        }
        if (this.cabeza.siguiente == null) {
            this.cabeza = null;
            return this;
        }
        Nodo aux = this.cabeza;
        while (aux.siguiente.siguiente != null) {
            aux = aux.siguiente;
        }
        aux.siguiente = null;
        return this;
    }

    boolean pertenece(int buscado) {
        Nodo aux = cabeza;
        if (!this.esVacia()) {
            while (aux != null) {
                if (aux.dato == buscado) {
                    return true;
                }
                aux = aux.siguiente;
            }
            return false;
        }
        return false;
    }

    ListaEnlazada borrarConValor(int buscado) {
        if (!this.esVacia()) {

            while (cabeza != null && cabeza.dato == buscado) {
                cabeza = cabeza.siguiente;
            }
            Nodo aux = cabeza;
            while (aux != null && aux.siguiente != null) {
                if (aux.siguiente.dato == buscado) {
                    aux.siguiente = aux.siguiente.siguiente;
                } else {
                    aux = aux.siguiente;
                }
            }
            return this;
        }
        return this;
    }

    int valorEnPosicion(int posicion) {
        if (!this.esVacia()) {
            Nodo aux = this.cabeza;
            int i = 0;
            while (i < posicion && aux != null) {
                aux = aux.siguiente;
                i++;
            }
            return aux.dato;
        }
        return 0;
    }

    ListaEnlazada insertarEnPosicion(int valor, int posicion) {
        Nodo nuevo = new Nodo(valor);

        if (posicion == 0) {
            this.insertarAlInicio(valor);
            return this;
        }

        Nodo aux = this.cabeza;
        int i = 0;

        while (aux != null && i < posicion - 1) {
            aux = aux.siguiente;
            i++;
        }

        if (aux == null) {
            return this;
        }

        nuevo.siguiente = aux.siguiente;
        aux.siguiente = nuevo;

        return this;
    }
}
