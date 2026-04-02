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
        l1.insertarEnPosicion(4, 0);
        l1.mostrar();
        System.out.println(l1.valorEnPosicion(-1));
    }
}
