/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseModels;

/**
 *
 * @author Fabrizio
 */
public class Cliente {

    //Campos de captura de informacion: First Name, Second Name, Surname
    
    public int ID_Cliente;
    public String Nombre_Cliente;
    public String SegundoNombre_Cliente; //Agregados 08/06/25
    public String Apellido_Cliente; //Agregados 08/06/25
    public int DNI_Cliente;
    public String Correo_Cliente;
    public int Telefono_Cliente;
    public int SegundoTelefono_Cliente; //Agregados 08/06/25

    public Cliente(int ID_Cliente, String Nombre_Cliente, int DNI_Cliente, String Correo_Cliente, int Telefono_Cliente) {
        this.ID_Cliente = ID_Cliente;
        this.Nombre_Cliente = Nombre_Cliente;
        this.DNI_Cliente = DNI_Cliente;
        this.Correo_Cliente = Correo_Cliente;
        this.Telefono_Cliente = Telefono_Cliente;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public String getSegundoNombre_Cliente() {
        return SegundoNombre_Cliente;
    }

    public void setSegundoNombre_Cliente(String SegundoNombre_Cliente) {
        this.SegundoNombre_Cliente = SegundoNombre_Cliente;
    }

        public String getApellido_Cliente() {
        return Apellido_Cliente;
    }

    public void setApellido_Cliente(String Apellido_Cliente) {
        this.Apellido_Cliente = Apellido_Cliente;
    }
    
    public int getDNI_Cliente() {
        return DNI_Cliente;
    }

    public void setDNI_Cliente(int DNI_Cliente) {
        this.DNI_Cliente = DNI_Cliente;
    }

    public String getCorreo_Cliente() {
        return Correo_Cliente;
    }

    public void setCorreo_Cliente(String Correo_Cliente) {
        this.Correo_Cliente = Correo_Cliente;
    }

    public int getTelefono_Cliente() {
        return Telefono_Cliente;
    }

    public void setTelefono_Cliente(int Telefono_Cliente) {
        this.Telefono_Cliente = Telefono_Cliente;
    }

    public int getSegundoTelefono_Cliente() {
        return SegundoTelefono_Cliente;
    }

    public void setSegundoTelefono_Cliente(int SegundoTelefono_Cliente) {
        this.SegundoTelefono_Cliente = SegundoTelefono_Cliente;
    }
}
