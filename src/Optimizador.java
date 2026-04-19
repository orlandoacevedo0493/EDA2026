
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author orlando
 */
public class Optimizador {

    public ArrayList<Actividad> Organizar(ArrayList<Actividad> actividades) {
        int ultimaFin = 8;
        ArrayList<Actividad> s = new ArrayList<>();
        ordenarPorFin(actividades);

        for (Actividad a : actividades) {

            if (a.getHora_inicio() >= ultimaFin && a.getHora_fin() <= 18) {
                s.add(a);
                ultimaFin = a.getHora_fin();
            }

        }
        return s;
    }

    public static void ordenarPorFin(ArrayList<Actividad> a) {
        Collections.sort(a, Comparator.comparingInt(Actividad::getHora_fin));
    }
}
