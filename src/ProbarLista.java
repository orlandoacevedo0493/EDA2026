/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Orlando
 */
public class ProbarLista {

    public static void main() {
        ListaEnlazada l1 = ListaEnlazada.crearLista();
        l1.insertarAlInicio(1);
        l1.mostrar();
        l1.insertarAlInicio(2);
        l1.insertarAlInicio(2);
        System.out.println("pueba cantidad");
        System.out.println(l1.cantidad());
        System.out.println("----------");
        l1.mostrar();
        l1.insertarAlInicio(3);
        l1.mostrar();
        l1.insertarAlFinal(4);
        l1.mostrar();
        l1.insertarAlFinal(5);
        l1.mostrar();
        System.out.println("borrando primero");
        l1.borrarPrimero();
        l1.mostrar();
        System.out.println("borrando ultimo");
        l1.borrarUltimo();
        l1.mostrar();
        System.out.println(l1.pertenece(1));
        l1.insertarAlFinal(4);
        l1.mostrar();
        l1.borrarConValor(2);
        l1.mostrar();
        l1.insertarEnPosicion(100, 0);
        l1.mostrar();
    }
}
