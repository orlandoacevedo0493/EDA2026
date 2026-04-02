
import java.util.Scanner;
import java.util.Vector;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Orlando
 */
public class ClaseTP2 {

    int leer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese n");
        return sc.nextInt();
    }

    int[][] llenarMatriz(int n) {
        int matriz[][] = new int[n][n];
        int indicex = 0;
        int indicey = 0;
        while (indicey < n) {
            indicex = 0;

            while (indicex < n) {
                matriz[indicey][indicex] = (int) (Math.random() * 10);
                indicex++;
            }
            System.out.println();
            indicey++;
        }
        return matriz;
    }

    int[][] multiplicarMatrices(int matriz1[][], int matriz2[][], int n) {
        int indicex = 0;
        int indicey = 0;
        int[][] matrizMultiplicada = new int[n][n];
        int suma = 0;
        while (indicey < n) {
            while (indicex < n) {
                int indiceMultiplicador = 0;

                while (indiceMultiplicador < n) {
                    suma += matriz1[indicey][indiceMultiplicador] * matriz2[indiceMultiplicador][indicex];
                    indiceMultiplicador++;
                }
                matrizMultiplicada[indicey][indicex] = suma;
                indicex++;
                suma = 0;
            }
            indicex = 0;
            indicey++;
        }
        return matrizMultiplicada;
    }

    void mostrarMatriz(int matriz[][], int n) {
        int indicex = 0;
        int indicey = 0;
        while (indicey < n) {
            indicex = 0;

            while (indicex < n) {
                System.out.print(matriz[indicey][indicex] + " ");
                indicex++;
            }
            System.out.println();
            indicey++;
        }
    }

    public static void main() {
        ClaseTP2 tp = new ClaseTP2();
        int n = tp.leer();
        int matriz1[][] = new int[n][n];
        matriz1 = tp.llenarMatriz(n);
        int matriz2[][] = new int[n][n];
        matriz2 = tp.llenarMatriz(n);
        int repeticiones = 5;
        long total = 0;
        tp.multiplicarMatrices(matriz1, matriz2, n);
        
        for (int i = 0; i < repeticiones; i++) {
            long inicio = System.nanoTime();

            tp.multiplicarMatrices(matriz1, matriz2, n);

            long fin = System.nanoTime();

            total += (fin - inicio);
        }

        long promedio = total / repeticiones;
        double tiempoMs = promedio / 1_000_000.0;
        double tiempoSeg = promedio / 1_000_000_000.0;

        System.out.printf("n = %d → %.3f ms (%.6f s)%n", n, tiempoMs, tiempoSeg);
    }
}
