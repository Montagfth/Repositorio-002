/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.Database;
import DatabaseModels.Auto;
import DatabaseModels.Empleado;
import Interfaces.DAOEmpleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public class DAOEmpleadosIMPLEMENT extends Database implements DAOEmpleado {

    @Override
    public List<Empleado> listarEmpleado(String nombreEmpleado) throws Exception {

        List<Empleado> listarEmpleados = null;

        try {
            this.Conectar();
            String Query = nombreEmpleado.isEmpty() ? "select * from Empleado" : "select * from Empleado where Nombre_Empleado like '%" + nombreEmpleado + "%';";
            PreparedStatement st = this.Conexion.prepareStatement(Query);
            listarEmpleados = new ArrayList();
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Empleado empleado = new Empleado();

                empleado.setID_Empleado(rs.getInt("ID_Empleado"));
                empleado.setNombre_Empleado(rs.getString("Nombre_Empleado"));
                empleado.setDNI_Empleado(rs.getInt("DNI_Empleado"));
                empleado.setTelefono_Empleado(rs.getInt("Telefono_Empleado"));
                empleado.setFechaContratacion_Empleado(rs.getString("FechaContratacion_Empleado"));

                listarEmpleados.add(empleado);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
        }
        return listarEmpleados;
    }
}
