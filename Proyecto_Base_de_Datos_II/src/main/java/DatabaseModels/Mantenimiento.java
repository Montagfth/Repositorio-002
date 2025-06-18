/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseModels;

/**
 *
 * @author Fabrizio
 */
public class Mantenimiento {
    
    public String Fecha_Mantenimiento;
    public String Descripcion_Mantenimiento;
    public int Costo_Mantenimiento;
    
    public String getFecha_Mantenimiento() {
        return Fecha_Mantenimiento;
    }

    public void setFecha_Mantenimiento(String Fecha_Mantenimiento) {
        this.Fecha_Mantenimiento = Fecha_Mantenimiento;
    }

    public String getDescripcion_Mantenimiento() {
        return Descripcion_Mantenimiento;
    }

    public void setDescripcion_Mantenimiento(String Descripcion_Mantenimiento) {
        this.Descripcion_Mantenimiento = Descripcion_Mantenimiento;
    }

    public int getCosto_Mantenimiento() {
        return Costo_Mantenimiento;
    }

    public void setCosto_Mantenimiento(int Costo_Mantenimiento) {
        this.Costo_Mantenimiento = Costo_Mantenimiento;
    }
}
