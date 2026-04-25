/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClaseTP4;

/**
 *
 * @author orlando
 */
public class Vuelo {

    private Pasajero cabeza;

    public Vuelo() {
        this.cabeza = null;
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
