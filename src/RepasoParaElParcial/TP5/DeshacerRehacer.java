/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepasoParaElParcial.TP5;

/**
 *
 * @author orlando
 */
public class DeshacerRehacer {

    private Pila acciones;
    private Pila deshacer;

    public DeshacerRehacer() {
        this.acciones = new Pila();
        this.deshacer = new Pila();
    }

    public void registrarAccion(Integer accion) {
        deshacer = new Pila();
        acciones.push(accion);
    }

    public Integer deshacer() {
        Integer dato = (Integer) acciones.top();
        if (dato == null) {
            return null;
        } else {
            deshacer.push(dato);
            acciones.pop();
            return (Integer) dato;
        }
    }

    public Integer rehacer() {
        Integer dato = (Integer) deshacer.top();
        if (dato == null) {
            return null;
        } else {
            acciones.push(dato);
            deshacer.pop();
            return (Integer) dato;
        }
    }
}
