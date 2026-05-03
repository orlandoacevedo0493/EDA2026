/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepasoParaElParcial.TP4;

/**
 *
 * @author orlando
 */
public class Vuelo {

    private Pasajero cabeza;

    private class Pasajero {

        private int dni;
        private String nombre;
        private Pasajero siguiente;

        public Pasajero(String nombre, int dni) {
            this.dni = dni;
            this.nombre = nombre;
            this.siguiente = null;
        }

        public int obtenerDni() {
            return dni;
        }

        public void asignarDni(int dni) {
            this.dni = dni;
        }

        public String obtenerNombre() {
            return nombre;
        }

        public void asignarNombre(String nombre) {
            this.nombre = nombre;
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
            hash = 29 * hash + this.dni;
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
            return this.dni == other.dni;
        }

    }

    public Vuelo() {
        this.cabeza = null;
    }

    public static Vuelo vueloVacio() {
        return new Vuelo();
    }

    public boolean esVacio() {
        return this.cabeza == null;
    }

    public void mostrar() {
        Pasajero aux = this.cabeza;
        while (aux != null) {
            System.out.println("Nombre: " + aux.nombre + " DNI: " + aux.dni);
            aux = aux.obtenerSiguiente();
        }
        System.out.println("-----------");
    }

    public Vuelo registrar(String nombre, int dni) {
        Pasajero nuevo = new Pasajero(nombre, dni);
        if (this.esVacio()) {
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

    public boolean esta(int dni) {
        if (this.esVacio()) {
            return false;
        } else {
            Pasajero aux = this.cabeza;
            return estaRecursivo(dni, aux);
        }
    }

    private boolean estaRecursivo(int dni, Pasajero aux) {
        if (aux == null) {
            return false;
        }
        if (aux.obtenerDni() == dni) {
            return true;
        } else {
            return estaRecursivo(dni, aux.siguiente);
        }
    }

    public Vuelo baja(int dni) {
        if (this.esVacio()) {
            return this;
        } else {
            while (this.cabeza.dni == dni) {
                this.cabeza = this.cabeza.siguiente;
            }
            Pasajero aux = this.cabeza;

            while (aux.obtenerSiguiente() != null) {
                if (aux.obtenerSiguiente().obtenerDni() == dni && aux.obtenerSiguiente().obtenerSiguiente() == null) {
                    aux.asignarSiguiente(null);
                    return this;
                }
                if (aux.obtenerSiguiente().obtenerDni() == dni) {
                    aux.asignarSiguiente(aux.obtenerSiguiente().obtenerSiguiente());
                }

                aux = aux.obtenerSiguiente();
            }
            return this;
        }
    }

    public String ultimoRegistrado() {
        if (this.esVacio()) {
            return null;
        } else {
            Pasajero aux = this.cabeza;
            while (aux.obtenerSiguiente() != null) {
                aux = aux.obtenerSiguiente();
            }
            return "Ultimo: Nombre: " + aux.nombre + " DNI: " + aux.dni;
        }
    }

    public int cantidad() {
        if (this.esVacio()) {
            return 0;
        } else {
            Pasajero aux = this.cabeza;
            return cantidadRecursivo(aux.obtenerSiguiente());
        }
    }

    private int cantidadRecursivo(Pasajero aux) {
        if (aux == null) {
            return 1;
        } else {
            return 1 + cantidadRecursivo(aux.obtenerSiguiente());
        }
    }
}
