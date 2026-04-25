/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClaseTP4;

import java.util.Objects;

/**
 *
 * @author orlando
 */
public class Pasajero {

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
