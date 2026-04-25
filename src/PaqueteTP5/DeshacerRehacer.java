/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteTP5;

/**
 *
 * @author orlando
 */
public class DeshacerRehacer {

    private Pila acciones;
    private Pila rehacer;

    public DeshacerRehacer() {
        this.acciones = new Pila();
        this.rehacer = new Pila();
    }

    void registrarAccion(Integer accion) {
        System.out.println("agrego" + accion);
        this.rehacer = new Pila();
        this.acciones.push(accion);
    }

    Integer deshacer() {
        Integer dato = (Integer) acciones.top();
        if (dato == null) {
            return null;
        }
        rehacer.push(dato);
        acciones.pop();
        return (Integer) dato;

    }

    Integer rehacer() {
        Integer dato = (Integer) rehacer.top();
        if (dato == null) {
            return null;
        }
        acciones.push(dato);
        rehacer.pop();
        return (Integer) dato;

    }
}
