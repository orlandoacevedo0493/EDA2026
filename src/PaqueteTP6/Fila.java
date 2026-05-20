/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteTP6;

/**
 *
 * @author orlando
 */
public class Fila {

    private Nodo frente;
    private int cantidad;

    private class Nodo {

        public Object item;
        public Nodo siguiente;

        public Nodo(Object item) {
            this.item = item;
            this.siguiente = null;
        }
    }

    public Fila() {
        this.cantidad = 0;
        this.frente = null;
    }

    public static Fila filaVacia() {
        return new Fila();
    }

    public boolean esFilaVacia() {
        return this.frente == null;
    }

    public Object frente() {
        return this.frente.item;
    }

    public Fila enfila(Object item) {
        Nodo nuevo = new Nodo(item);

        if (this.frente == null) {
            this.frente = nuevo;
            cantidad++;

            return this;
        }
        Nodo aux = this.frente;
        while (aux.siguiente != null) {
            aux = aux.siguiente;
        }
        aux.siguiente = nuevo;
        cantidad++;
        return this;
    }

    public Fila defila() {
        if (this.frente == null) {
            return null;
        }
        if (this.frente.siguiente == null) {
            this.frente = null;
            cantidad--;

            return this;
        }

        this.frente = this.frente.siguiente;
        cantidad--;

        return this;
    }

    public Object finalDeFila() {
        if (this.esFilaVacia()) {
            return null;
        }
        Nodo aux = this.frente;

        while (aux.siguiente != null) {
            aux = aux.siguiente;
        }
        return aux.item;
    }

    public Fila reenfilar() {
        if (this.esFilaVacia()) {
            return null;
        }
        Object aux = this.frente.item;
        this.enfila(aux);
        this.defila();
        return this;
    }

    public Fila defilarn(int numero) {
        for (int i = 0; i < numero; i++) {
            if (this.esFilaVacia()) {
                return null;
            }
            this.defila();

        }
        return this;
    }

    public Object[] toArray() {
        Object[] arreglo = new Object[cantidad];
        Nodo aux = this.frente;
        int contador = 0;
        while (contador <= cantidad && aux != null) {
            arreglo[contador] = aux.item;
            aux = aux.siguiente;
            contador++;
        }
        return arreglo;
    }

    public Fila fromArray(Object[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                this.enfila(arreglo[i]);

            }
        }
        return this;
    }

    public Fila merge(Fila aFusionar) {
        Nodo aux = aFusionar.frente;
        while (aux != null) {
            this.enfila(aux.item);
            aux = aux.siguiente;
        }
        return this;
    }

    public Fila copiar() {
        Fila copia = filaVacia();
        Nodo aux = this.frente;

        while (aux != null) {
            copia.enfila(aux.item);
            aux = aux.siguiente;
        }

        return copia;
    }

    public void mostrar() {
        Nodo aux = this.frente;
        while (aux != null) {
            System.out.println(aux.item);
            aux = aux.siguiente;
        }
        System.out.println("Tiene: " + cantidad);
        System.out.println("---------------------");
    }

    @Override
    public String toString() {
        return "Fila{" + "frente=" + frente + '}';
    }

}
