/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteTP4;

import java.util.Objects;

/**
 *
 * @author orlando
 */
public class Vuelo {

    private Pasajero cabeza;

    public Vuelo() {
        this.cabeza = null;
    }

    public static class Pasajero {

        private String nombre;
        private int dni;
        private Pasajero siguiente;

        public Pasajero(String nombre, int dni) {
            this.nombre = nombre;
            this.dni = dni;
            this.siguiente = null;
        }

        public String obtenerNombre() {
            return nombre;
        }

        public void asignarNombre(String nombre) {
            this.nombre = nombre;
        }

        public int obtenerDni() {
            return dni;
        }

        public void asignarDni(int dni) {
            this.dni = dni;
        }

        public Pasajero obtenerSiguiente() {
            return siguiente;
        }

        public void asignarSiguiente(Pasajero siguiente) {
            this.siguiente = siguiente;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 43 * hash + Objects.hashCode(this.nombre);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Pasajero other = (Pasajero) obj;
            return Objects.equals(this.nombre, other.nombre);
        }

        @Override
        public String toString() {
            return "Pasajero{" + "nombre=" + nombre + ", dni=" + dni + ", siguiente=" + siguiente + '}';
        }

    }

    static Vuelo crearVueloVacio() {
        return new Vuelo();
    }

    public void mostrar() {
        Pasajero aux = this.cabeza;
        while (aux != null) {
            System.out.println("Nombre: " + aux.obtenerNombre() + " DNI: " + aux.obtenerDni());
            aux = aux.obtenerSiguiente();
        }
        System.out.println("--------------");

    }

    public Vuelo registrar(Pasajero p) {

        Pasajero nuevo = new Pasajero(p.obtenerNombre(), p.obtenerDni());

        if (this.cabeza == null) {
            this.cabeza = nuevo;
        } else {
            Pasajero aux = this.cabeza;
            while (aux.obtenerSiguiente() != null) {
                aux = aux.obtenerSiguiente();
            }
            aux.asignarSiguiente(nuevo);
        }

        return this;
    }

    public boolean esVueloVacio() {
        return this.cabeza == null;
    }

    public boolean esta(Pasajero p) {
        return estaRecursivo(this.cabeza, p);
    }

    public boolean estaRecursivo(Pasajero p, Pasajero comparar) {
        Pasajero aux = p;
        if (aux == null) {
            return false;
        }
        if (aux.equals(comparar)) {
            return true;
        } else {
            return estaRecursivo(aux.obtenerSiguiente(), comparar);
        }
    }

    public Vuelo baja(Pasajero p) {

        if (!this.esVueloVacio()) {

            while (cabeza != null && cabeza.equals(p)) {
                System.out.println("aca");
                cabeza = cabeza.obtenerSiguiente();
            }
            if (cabeza == null) {
                return null;

            } else {
                Pasajero aux = cabeza;
                while (aux.obtenerSiguiente() != null) {
                    if (aux.obtenerSiguiente().obtenerSiguiente() != null && aux.obtenerSiguiente().equals(p)) {
                        aux.asignarSiguiente(aux.obtenerSiguiente().obtenerSiguiente());
                    }
                    if (aux.obtenerSiguiente().obtenerSiguiente() == null && aux.obtenerSiguiente().equals(p)) {
                        aux.asignarSiguiente(null);
                        return this;
                    }
                    aux = aux.obtenerSiguiente();
                }

            }
        }
        return this;
    }

    public Pasajero ultimoPasajero() {
        if (this.esVueloVacio()) {
            return null;
        } else {
            Pasajero aux = this.cabeza;
            while (aux.obtenerSiguiente() != null) {
                aux = aux.obtenerSiguiente();
            }
            return aux;
        }
    }

    public int cantidad() {
        int cantidad = 0;
        if (this.esVueloVacio()) {
            return cantidad;
        } else {
            Pasajero aux = this.cabeza;
            while (aux != null) {
                cantidad++;
                aux = aux.obtenerSiguiente();
            }
        }
        return cantidad;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "cabeza=" + cabeza + '}';
    }

}
