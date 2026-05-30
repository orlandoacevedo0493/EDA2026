/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteTP7;

/**
 *
 * @author orlando
 */
public class DatoHuffman implements Comparable<DatoHuffman> {

    private double frecuencia;
    private char caracter;

    public DatoHuffman(char caracter, double frecuencia) {
        this.frecuencia = frecuencia;
        this.caracter = caracter;
    }

    public double getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(double frecuencia) {
        this.frecuencia = frecuencia;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    @Override
    public String toString() {
        // Esto mostrará el dato así: "A:0.5" o "*:1.0"
        return caracter + ":" + frecuencia;
    }

    /**
     *
     * @param otro
     * @return
     */
    @Override
    public int compareTo(DatoHuffman otro) {
        // Double.compare devuelve:
        // -1 si 'this' es menor que 'otro'
        // 0 si son iguales
        // 1 si 'this' es mayor que 'otro'
        return Double.compare(this.frecuencia, otro.frecuencia);
    }

}
