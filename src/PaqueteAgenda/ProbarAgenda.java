package PaqueteAgenda;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Orlando
 */
public class ProbarAgenda {

    Agenda trasladarContactos(Agenda a, Agenda b) {
        int contador = 0;
        while (contador < b.cantidad()) {
            Contacto c = b.enPosicion(contador);
            if (c != null && a.buscar(c.nombre) == null) {
                a.agregar(c);
            }
            contador++;
        }
        return a;
    }

    public static void main() {
        Agenda a1 = Agenda.crearAgenda();
        Agenda a2 = Agenda.crearAgenda();
        ProbarAgenda p = new ProbarAgenda();
        Contacto c1 = new Contacto("Orlando", "3814676649", "orlandoacevedo0493@gmail.com");
        Contacto c2 = new Contacto("omar", "381462349", "hpo34@gmail.com");
        Contacto c3 = new Contacto("sofia", "381465359", "asd55@gmail.com");
        Contacto c4 = new Contacto("alan", "3814256249", "vbcvb6@gmail.com");
        Contacto c5 = new Contacto("arnold", "381124549", "ujuyjyu56@gmail.com");

        a1.agregar(c1);
        a1.agregar(c2);
        a1.agregar(c3);
        a1.listar();
        System.out.println("intento borrar");
        a1.borrar("3814676649");
        a1.listar();
        a1.listar();
        System.out.println("busco");
        System.out.println(a1.enPosicion(1));
        a2.agregar(c4);
        a2.agregar(c2);
        System.out.println("listo a2");
        a2.listar();
        System.out.println("intento agregar los contactos de la agenda 2 en la agenda 1");
        System.out.println("");
        a1 = p.trasladarContactos(a1, a2);
        a1.listar();
    }
}
