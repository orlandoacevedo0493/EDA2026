package ClaseTP3;


import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author orlando
 */
public class ClaseTP3 {

    public static void main(String[] args) {
        Optimizador op = new Optimizador();
        Actividad a1 = new Actividad(8, 10);
        Actividad a2 = new Actividad(9, 11);
        Actividad a3 = new Actividad(10, 12);
        Actividad a4 = new Actividad(13, 16);
        Actividad a5 = new Actividad(15, 18);
        ArrayList<Actividad> l1 = new ArrayList<>();
        ArrayList<Actividad> organizadas = new ArrayList<>();

        l1.add(a1);
        l1.add(a2);
        l1.add(a3);
        l1.add(a4);
        l1.add(a5);

        System.out.println("Antes de optimizar las actividades");
        for (Actividad a : l1) {
            a.mostrar();
        }

        organizadas = op.Organizar(l1);
        System.out.println("habiendo optimizado");
        for (Actividad a : organizadas) {
            a.mostrar();
        }
    }

}
