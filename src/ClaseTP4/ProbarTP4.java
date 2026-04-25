/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClaseTP4;

/**
 *
 * @author orlando
 */
public class ProbarTP4 {

//    c) Como usuario del ADT VUELO escriba una Función REPROGRAMAR que dados 2
//    VUELOS devuelva un nuevo VUELO con todos los pasajeros de los dos vuelos.
    public Vuelo reprogramar(Vuelo v1, Vuelo v2) {

        int cantidad2 = v2.cantidad();
        Vuelo aux = v2;
        for (int i = 0; i < cantidad2; i++) {
            v1.registrar(aux.ultimoPasajero());
            aux.baja(aux.ultimoPasajero());
        }
        return v1;
    }

    public static void main(String[] args) {
        ProbarTP4 probador = new ProbarTP4();
        Vuelo v1 = Vuelo.crearVueloVacio();
        Vuelo v2 = Vuelo.crearVueloVacio();
        Vuelo vReprogramado = Vuelo.crearVueloVacio();

        Pasajero p1 = new Pasajero("Orlando", 45515645);
        Pasajero p2 = new Pasajero("flor", 461132414);
        Pasajero p3 = new Pasajero("martin", 47838956);
        Pasajero p4 = new Pasajero("sofia lodi", 46832019);
        Pasajero p5 = new Pasajero("prueba", 12345567);
        Pasajero p6 = new Pasajero("prueba 2", 98765432);

        v1.registrar(p1);
        v1.registrar(p2);
        v1.registrar(p3);
        v2.registrar(p4);
        v2.registrar(p5);
        v2.registrar(p6);

        v1.mostrar();
        v2.mostrar();
        System.out.println(v1.esta(p1));
        v1.mostrar();
        System.out.println(v1.cantidad());
        vReprogramado = probador.reprogramar(v1, v2);
        vReprogramado.mostrar();
        v2.mostrar();
    }
}
