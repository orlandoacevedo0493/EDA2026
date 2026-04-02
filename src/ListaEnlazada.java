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

        public int obtenerDato() {
            return dato;
        }

        public void asignarDato(int dato) {
            this.dato = dato;
        }

        public Nodo obtenerSiguiente() {
            return siguiente;
        }

        public void asignarSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }

    static ListaEnlazada crearLista() {
        return new ListaEnlazada();
    }

    boolean esVacia() {
        return this.cabeza == null;
    }

    ListaEnlazada insertarAlInicio(int x) {
        Nodo n1 = new Nodo(x);
        n1.asignarSiguiente(this.cabeza);
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

        while (aux.obtenerSiguiente() != null) {
            aux = aux.obtenerSiguiente();
        }

        aux.asignarSiguiente(n1);

        return this;
    }

    void mostrar() {
        Nodo aux = this.cabeza;

        while (aux != null) {
            System.out.println(aux.obtenerDato());
            aux = aux.obtenerSiguiente();
        }
        System.out.println("-----");
    }

    int cantidad() {
        int contador = 1;
        if (this.cabeza == null) {
            return 0;
        } else {
            Nodo aux = this.cabeza;
            while (aux.obtenerSiguiente() != null) {
                contador++;
                aux = aux.obtenerSiguiente();
            }
            return contador;
        }
    }

    ListaEnlazada borrarPrimero() {
        if (!this.esVacia()) {
            this.cabeza = this.cabeza.obtenerSiguiente();
        }
        return this;
    }

    ListaEnlazada borrarUltimo() {
        if (this.cabeza == null) {
            return this;
        }
        if (this.cabeza.obtenerSiguiente() == null) {
            this.cabeza = null;
            return this;
        }
        Nodo aux = this.cabeza;
        while (aux.obtenerSiguiente().obtenerSiguiente() != null) {
            aux = aux.obtenerSiguiente();
        }
        aux.asignarSiguiente(null);
        return this;
    }

    boolean pertenece(int buscado) {
        Nodo aux = cabeza;
        if (!this.esVacia()) {
            while (aux != null) {
                if (aux.obtenerDato() == buscado) {
                    return true;
                }
                aux = aux.obtenerSiguiente();
            }
            return false;
        }
        return false;
    }

    ListaEnlazada borrarConValor(int buscado) {
        if (!this.esVacia()) {

            while (cabeza != null && cabeza.obtenerDato() == buscado) {
                cabeza = cabeza.obtenerSiguiente();
            }
            Nodo aux = cabeza;
            while (aux != null && aux.obtenerSiguiente() != null) {
                if (aux.obtenerSiguiente().obtenerDato() == buscado) {
                    aux.asignarSiguiente(aux.obtenerSiguiente().obtenerSiguiente());
                } else {
                    aux = aux.obtenerSiguiente();
                }
            }
            return this;
        }
        return this;
    }

    int valorEnPosicion(int posicion) {
        if (!this.esVacia() && posicion < this.cantidad() && posicion >= 0) {
            Nodo aux = this.cabeza;
            int i = 0;
            while (i < posicion && aux != null) {
                aux = aux.obtenerSiguiente();
                i++;
            }
            return aux.obtenerDato();
        }
        return -1; //Retorna -1 si se supero la cantidad de nodos
    }

    ListaEnlazada insertarEnPosicion(int valor, int posicion) {
        Nodo nuevo = new Nodo(valor);

        if (posicion == 0) {
            this.insertarAlInicio(valor);
            return this;
        }

        if (posicion < 0) {
            return this;
        }

        Nodo aux = this.cabeza;
        int i = 0;

        while (aux != null && i < posicion - 1) {
            aux = aux.obtenerSiguiente();
            i++;
        }

        if (aux == null) {
            return this;
        }

        nuevo.asignarSiguiente(aux.obtenerSiguiente());
        aux.asignarSiguiente(nuevo);

        return this;
    }
}
