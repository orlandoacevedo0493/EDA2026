/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepasoArbolBinario;

/**
 *
 * @author orlando
 */
public class ArbolBinario {

    private Object raiz;
    private ArbolBinario izquierdo;
    private ArbolBinario derecho;

    private ArbolBinario() {
    }

    private ArbolBinario(ArbolBinario izquierdo, Object item, ArbolBinario derecho) {
        this.izquierdo = izquierdo;
        this.raiz = item;
        this.derecho = derecho;
    }

    public static ArbolBinario arbolBinarioVacio() {
        return new ArbolBinario();
    }

    public static ArbolBinario armarAB(ArbolBinario izquierdo, Object item, ArbolBinario derecho) {
        if (item == null) {
            return null;
        }
        if (izquierdo == null) {
            izquierdo = arbolBinarioVacio();
        }
        if (derecho == null) {
            derecho = arbolBinarioVacio();
        }
        return new ArbolBinario(izquierdo, item, derecho);
    }
    // 1. Método principal que llamas desde el main: b10.imprimirVertical();

    public void imprimirVertical() {
        int altura = obtenerAltura(this);
        if (altura == 0) {
            System.out.println("Árbol vacío.");
            return;
        }

        // Calculamos el ancho y alto necesarios para la matriz
        int ancho = (int) Math.pow(2, altura - 1) * 6;
        int alto = altura * 2;

        // Creamos nuestro "lienzo" en blanco
        String[][] matriz = new String[alto][ancho];
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                matriz[i][j] = " ";
            }
        }

        // Empezamos a dibujar desde la raíz en el centro superior
        llenarMatriz(this, matriz, 0, ancho / 2, ancho / 4);

        // Imprimimos la matriz línea por línea
        System.out.println("\n--- Árbol Vertical ---");
        for (int i = 0; i < alto; i++) {
            StringBuilder sb = new StringBuilder();
            boolean lineaVacia = true;
            for (int j = 0; j < ancho; j++) {
                sb.append(matriz[i][j]);
                if (!matriz[i][j].equals(" ")) {
                    lineaVacia = false; // Si hay algo distinto a un espacio, imprimimos la línea
                }
            }
            if (!lineaVacia) {
                System.out.println(sb.toString());
            }
        }
        System.out.println("----------------------\n");
    }

    // 2. Método auxiliar para saber qué tan profundo es el árbol
    private int obtenerAltura(ArbolBinario nodo) {
        if (nodo == null || nodo.esABVacio()) {
            return 0;
        }
        return 1 + Math.max(obtenerAltura(nodo.izquierdo), obtenerAltura(nodo.derecho));
    }

    // 3. Método recursivo que ubica cada número y ramita en la matriz
    private void llenarMatriz(ArbolBinario nodo, String[][] matriz, int fila, int col, int separacion) {
        if (nodo == null || nodo.esABVacio()) {
            return;
        }

        // Escribimos la raíz actual en su posición
        matriz[fila][col] = nodo.raiz.toString();

        // Si hay hijo izquierdo, le dibujamos su barra / y lo mandamos a ubicarse más abajo a la izquierda
        if (nodo.izquierdo != null && !nodo.izquierdo.esABVacio()) {
            matriz[fila + 1][col - separacion / 2] = "/";
            llenarMatriz(nodo.izquierdo, matriz, fila + 2, col - separacion, separacion / 2);
        }

        // Lo mismo para el derecho, pero hacia la derecha con \
        if (nodo.derecho != null && !nodo.derecho.esABVacio()) {
            matriz[fila + 1][col + separacion / 2] = "\\"; // Usamos \\ para que Java entienda la barra invertida
            llenarMatriz(nodo.derecho, matriz, fila + 2, col + separacion, separacion / 2);
        }
    }

    public boolean esABVacio() {
        return this.raiz == null;
    }

    public ArbolBinario izquierdo() {
        if (this.izquierdo == null) {
            return arbolBinarioVacio();
        }
        return this.izquierdo;
    }

    public Object raiz() {
        if (raiz == null) {
            return null;
        }
        return this.raiz;
    }

    public ArbolBinario derecho() {
        if (this.derecho == null) {
            return arbolBinarioVacio();
        }
        return this.derecho;
    }

    public void preOrden() {
        if (!this.esABVacio()) {
            System.out.println(raiz);
            this.izquierdo().preOrden();
            this.derecho().preOrden();
        }
    }

    public void simetrico() {
        if (!this.esABVacio()) {
            this.izquierdo().simetrico();
            System.out.println(raiz);

            this.derecho().simetrico();
        }
    }

    public void posOrden() {
        if (!this.esABVacio()) {
            this.izquierdo().posOrden();
            this.derecho().posOrden();
            System.out.println(raiz);
        }
    }

    public boolean pertenece(Object item) {
        if (this.esABVacio()) {
            return false;
        }
        if (this.raiz == item) {
            return true;
        }
        return (this.izquierdo.pertenece(item) && this.derecho.pertenece(item));
    }

    public int cantidad() {
        if (this.esABVacio()) {
            return 0;
        }
        return 1 + this.izquierdo.cantidad() + this.derecho.cantidad();
    }

    public int nivelde(Object item) {
        if (this.esABVacio()) {
            return -1;
        }
        if (this.raiz == item) {
            return 0;
        }

        int izquierdoNivel = this.izquierdo().nivelde(item);
        int derechoNivel = this.derecho().nivelde(item);

        if (izquierdoNivel == -1 && derechoNivel == -1) {
            return -1;
        }
        if (izquierdoNivel >= 0 && derechoNivel >= 0) {
            return 1 + Math.min(this.izquierdo.nivelde(item), this.derecho.nivelde(item));
        }
        if (izquierdoNivel == -1) {
            return 1 + derechoNivel;
        }

        return 1 + izquierdoNivel;

    }
    
    public boolean estrictamenteBinario(){
        if(this.esABVacio()){
            return true;
        }
        if(this.izquierdo().esABVacio()&&this.derecho.esABVacio()){
            return true;
        }
        if(this.izquierdo().esABVacio()||this.derecho().esABVacio()){
            return false;
        }
        return this.izquierdo().estrictamenteBinario()&&this.derecho().estrictamenteBinario();
    }
    
    public boolean iguales(ArbolBinario a){
        if(this.esABVacio()&&a.esABVacio()){
            return true;
        }
        
        if(this.esABVacio() &&!a.esABVacio()){
            return false;
        }if(!this.esABVacio() &&a.esABVacio()){
            return false;
        }
        
        return this.izquierdo.iguales(a.izquierdo())&&this.derecho.iguales(a.derecho());
    }



}
