/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Orlando
 */
public class ProbarLista {

    int sumarLista(ListaEnlazada l1, int n) {
        int suma = 0;
        int tamañoLista = l1.cantidad();
        for (int i = n; i < tamañoLista; i++) {
            System.out.println(l1.valorEnPosicion(i));
            suma += l1.valorEnPosicion(i);
        }
        return suma;
    }

    int sumarListaRecursivo(ListaEnlazada l1, int n) {
        int tamaño = l1.cantidad();
        if (n >= tamaño) {
            return 0;
        } else {
            return l1.valorEnPosicion(n) + sumarListaRecursivo(l1, n + 1);
        }
    }

    public static void main() {
        ProbarLista probador = new ProbarLista();
        ListaEnlazada l1 = ListaEnlazada.crearLista();
        l1.insertarAlInicio(1);
        l1.mostrar();
        l1.insertarAlInicio(2);
        l1.insertarEnPosicion(4, 0);

        l1.mostrar();
        System.out.println("Estructurado: " + probador.sumarLista(l1, 0));
        System.out.println("Recursivo: " + probador.sumarListaRecursivo(l1, 0));
        System.out.println(l1.pertenece(2));
        l1.mostrar();
        System.out.println(l1.mayor());
        l1.insertarAlFinal(9);
        System.out.println(l1.mayor());
        l1.mostrar();

        System.out.println(probador.sumarListaRecursivo(l1, 1));

    }
}
