package ClaseTP3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author orlando
 */
public class Actividad {
    private int hora_inicio;
    private int hora_fin;

    public Actividad(int hora_inicio, int hora_fin) {
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }
    
    public void mostrar(){
        System.out.println("Horario: "+this.hora_inicio+"-"+this.hora_fin);
    }
    
    public int getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(int hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(int hora_fin) {
        this.hora_fin = hora_fin;
    }

    @Override
    public String toString() {
        return "Actividad{" + "hora_inicio=" + hora_inicio + ", hora_fin=" + hora_fin + '}';
    }
    
}
