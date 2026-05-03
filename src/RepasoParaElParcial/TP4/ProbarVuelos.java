/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepasoParaElParcial.TP4;

import static RepasoParaElParcial.TP4.Vuelo.vueloVacio;

/**
 *
 * @author orlando
 */
public class ProbarVuelos {

    public static void main(String[] args) {
        Vuelo v1 = vueloVacio();
        v1.registrar("Orlando", 45515645);
        v1.mostrar();
        v1.registrar("Ana", 47818957);
        v1.mostrar();
        v1.registrar("Roberto", 40069214);
        v1.mostrar();
        v1.baja(40069214);
        v1.mostrar();
        System.out.println(v1.ultimoRegistrado());
        System.out.println(v1.cantidad());
    }
}
