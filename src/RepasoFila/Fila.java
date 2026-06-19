/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package RepasoFila;

import java.util.ArrayList;

/**
 *
 * @author orlando
 */
public class Fila {

    private Nodo frente;
    private Object dato;
    private int cantidad = 0;
    private Nodo ultimo;

    private class Nodo {

        private Object item;
        private Nodo siguiente;

        public Nodo(Object item) {
            this.item = item;
            this.siguiente = null;
        }

        public Object getItem() {
            return item;
        }

        public void setItem(Object item) {
            this.item = item;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

    }

    public Fila() {
        this.frente = null;
    }

    public static Fila filaVacia() {
        return new Fila();
    }

    public boolean esFilaVacia() {
        return this.frente == null;
    }

    public void mostrarFila() {
        Nodo aux = this.frente;
        while (aux != null) {
            System.out.println(aux.item);
            aux = aux.getSiguiente();
        }
        System.out.println("--------------------------");
    }

    public Object frente() {
        return this.getFrente().getItem();
    }

    public Fila enfila(Object item) {
        Nodo nuevo = new Nodo(item);

        if (esFilaVacia()) {
            frente = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }

        cantidad++;
        return this;
    }

    public Fila defila() {
        if (this.esFilaVacia()) {
            return null;
        }
        this.setFrente(this.getFrente().siguiente);
        cantidad--;
        return this;
    }

    public Object ultimo() {
        if (this.esFilaVacia()) {
            return null;
        }
        return ultimo.getItem();
    }

    public int cantidad() {
        return cantidad;
    }

    public Fila reenfilar() {
        if (this.esFilaVacia()) {
            return this;
        }
        this.enfila(this.getFrente().item);
        this.defila();
        return this;
    }

    public Fila defilarN(int n) {
        if (this.esFilaVacia()) {
            return null;
        }

        if (n == 0) {
            return this;
        }

        while (n != 0 && !(this.esFilaVacia())) {
            this.defila();
            n--;
        }
        return this;
    }

    public ArrayList toArray() {
        if (this.esFilaVacia()) {
            return null;
        }
        Nodo aux = this.getFrente();
        ArrayList arreglo = new ArrayList<>();

        while (aux != null) {
            arreglo.add(aux.getItem());
            aux = aux.getSiguiente();
        }
        return arreglo;
    }

    public Fila fromArray(ArrayList arreglo) {
        if (arreglo.isEmpty()) {
            return this;
        }
        for (Object i : arreglo) {
            this.enfila(i);
        }
        return this;
    }

    public Fila merge(Fila aMezclar) {
        if (this.esFilaVacia()) {
            return aMezclar;
        }
        if (aMezclar == null || aMezclar.esFilaVacia()) {
            return this;
        }
        Nodo aux = aMezclar.getFrente();
        while (aux != null) {
            this.enfila(aux.getItem());
            aux = aux.getSiguiente();
        }
        return this;
    }

    public Fila copiar() {

        Fila copia = filaVacia();
        Nodo aux = this.frente;

        while (aux != null) {
            copia.enfila(aux.getItem());
            aux = aux.getSiguiente();
        }

        return copia;
    }

    public Nodo getFrente() {
        return frente;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    public Object getCantidad() {
        return dato;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public void setCantidad(int cantidad) {
        this.dato = cantidad;
    }
}

//FILAVACIA :  FILA
//ESFILAVACIA : FILA  BOOL
//FRENTE : FILA  ITEM U {indefinido}
//ENFILA : FILA X ITEM  FILA
//DEFILA : FILA  FILA
