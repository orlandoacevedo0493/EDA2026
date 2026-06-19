/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepasoFila;

import static RepasoFila.Fila.filaVacia;
import java.util.ArrayList;

/**
 *
 * @author orlando
 */
public class ProbarFila {

    public static void main(String[] args) {
        String objeto1 = "Objeto 1";
        String objeto2 = "Objeto 2";
        String objeto3 = "Objeto 3";
        String objeto4 = "Objeto 4";
        String objeto5 = "Objeto 5";
        String objeto6 = "Objeto 6";
        String objeto7 = "Objeto 7";
        String objeto8 = "Objeto 8";

        Fila f = filaVacia();
        Fila f2 = filaVacia();

        f.enfila(objeto1);
        f.enfila(objeto2);
        f.enfila(objeto3);
        f.enfila(objeto4);
        f.enfila(objeto5);
        f.mostrarFila();

        f2.enfila(objeto6);
        f2.enfila(objeto7);
        f2.enfila(objeto8);
        
        f=invertir(f);
        f.mostrarFila();
        

    }
    
    
    public static Fila invertir(Fila f){
        if(f.esFilaVacia()){
            return filaVacia();
        }
        Object aux=f.frente();
        f.defila();
        return invertir(f.enfila(aux));
    }
            
}
