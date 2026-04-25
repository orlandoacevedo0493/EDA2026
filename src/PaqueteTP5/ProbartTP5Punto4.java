/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteTP5;

/**
 *
 * @author orlando
 */
public class ProbartTP5Punto4 {

    public static void main(String[] args) {
        DeshacerRehacer miUndo = new DeshacerRehacer();

        miUndo = new DeshacerRehacer();
        miUndo.registrarAccion(1);
        miUndo.registrarAccion(2);
        miUndo.registrarAccion(3);
        System.out.println(miUndo.deshacer()+" Deberia dar: "+ 3); 
        System.out.println(miUndo.deshacer()+" Deberia dar: "+ 2); 
        System.out.println(miUndo.rehacer()+" Deberia dar: "+ 2);
        System.out.println(miUndo.rehacer()+" Deberia dar: "+ 3); 
        System.out.println(miUndo.rehacer()+" Deberia dar: "+ null); 
        System.out.println(miUndo.deshacer()+" Deberia dar: "+ 3);
        miUndo.registrarAccion(4);
        System.out.println(miUndo.rehacer()+" Deberia dar: "+ null); 
        System.out.println(miUndo.deshacer()+" Deberia dar: "+ 4); 
        System.out.println(miUndo.deshacer()+" Deberia dar: "+ 2); 
        System.out.println(miUndo.deshacer()+" Deberia dar: "+ 1); 
        System.out.println(miUndo.deshacer()+" Deberia dar: "+ null); 
    }
}
