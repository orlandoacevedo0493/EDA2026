/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepasoParaElParcial.TP1;

/**
 *
 * @author orlando
 */
public class ListaEnlazada {

    private Nodo cabeza;

    private class Nodo {

        private int dato;
        private Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }

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

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public static ListaEnlazada crearLista() {
        return new ListaEnlazada();
    }

    public boolean esVacia() {
        return this.cabeza == null;
    }

    public ListaEnlazada insertarAlInicio(int x) {
        Nodo nuevo = new Nodo(x);
        if (this.esVacia()) {
            this.cabeza = nuevo;
        } else {
            nuevo.asignarSiguiente(cabeza);
            this.cabeza = nuevo;

        }
        return this;
    }

    public ListaEnlazada insertarAlFinal(int x) {
        Nodo nuevo = new Nodo(x);

        if (this.esVacia()) {
            this.cabeza = nuevo;
        } else {
            Nodo aux = this.cabeza;
            while (aux.obtenerSiguiente() != null) {
                aux = aux.obtenerSiguiente();
            }
            aux.asignarSiguiente(nuevo);
        }
        return this;
    }

    public void mostrar() {
        Nodo aux = this.cabeza;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.obtenerSiguiente();
        }
        System.out.println("-----------");
    }

    public int cantidad() {
        if (this.esVacia()) {
            return 0;
        } else {
            int cantidad = 0;
            Nodo aux = this.cabeza;
            while (aux != null) {
                cantidad++;
                aux = aux.obtenerSiguiente();
            }
            return cantidad;
        }
    }

    public ListaEnlazada borrarPrimero() {
        if (this.esVacia()) {
            return this;
        } else {
            this.cabeza = this.cabeza.siguiente;
            return this;
        }
    }

    public ListaEnlazada borrarUltimo() {
        if (this.esVacia()) {
            return this;
        } else {
            Nodo aux = this.cabeza;

            if (aux.obtenerSiguiente() == null) {
                this.cabeza = null;
                return this;
            } else {
                while (aux.obtenerSiguiente().obtenerSiguiente() != null) {

                    aux = aux.obtenerSiguiente();
                }
                aux.asignarSiguiente(null);
                return this;
            }
        }
    }

    public boolean pertenece(int x) {
        if (this.esVacia()) {
            return false;
        } else {
            Nodo aux = this.cabeza;
            return perteneceRecursivo(x, aux);
        }
    }

    private boolean perteneceRecursivo(int x, Nodo aux) {
        if (aux.obtenerDato() == x) {
            return true;
        } else {
            if (aux.obtenerSiguiente() == null) {
                return false;
            }
            return perteneceRecursivo(x, aux.obtenerSiguiente());
        }
    }

    public ListaEnlazada borrarConValor(int x) {
        if (this.esVacia()) {
            return this;
        } else {
            Nodo aux = this.cabeza;

            if (this.cabeza.dato == x) {
                this.cabeza = this.cabeza.siguiente;
            }

            while (aux.obtenerSiguiente() != null) {
                if (aux.obtenerSiguiente().obtenerDato() == x) {
                    if (aux.obtenerSiguiente().obtenerSiguiente() == null) {
                        aux.asignarSiguiente(null);
                        return this;
                    }
                    aux.asignarSiguiente(aux.obtenerSiguiente().obtenerSiguiente());
                }
                aux = aux.obtenerSiguiente();
            }
            return this;
        }
    }

    public int valorEnPosicion(int posicion) {
        if (this.esVacia()) {
            return -1;
        } else {
            Nodo aux = this.cabeza;
            int contador = 0;
            while (aux != null) {
                if (contador == posicion) {
                    return aux.dato;
                }
                aux = aux.obtenerSiguiente();
                contador++;
            }
            return -1;
        }
    }

    public ListaEnlazada insertarEnPosicion(int valor, int posicion) {

        if (posicion == 0) {
            this.insertarAlInicio(valor);
            return this;
        }
        Nodo aux = this.cabeza;
        Nodo nuevo = new Nodo(valor);
        int contador = 0;
        while (aux != null) {
            if (contador == posicion - 1) {
                nuevo.asignarSiguiente(aux.obtenerSiguiente());
                aux.asignarSiguiente(nuevo);
                return this;
            }
            contador++;
            aux = aux.obtenerSiguiente();
        }
        return this;
    }

    public int mayor() {
        if (this.esVacia()) {
            return -999;
        } else {
            Nodo aux = this.cabeza;
            return mayorRecursivo(aux.dato, aux);

        }
    }

    public int mayorRecursivo(int mayor, Nodo aux) {
        if (mayor < aux.obtenerDato()) {
            mayor = aux.obtenerDato();
        }
        if (aux.obtenerSiguiente() == null) {
            return mayor;
        }
        return mayorRecursivo(mayor, aux.obtenerSiguiente());
    }
}
