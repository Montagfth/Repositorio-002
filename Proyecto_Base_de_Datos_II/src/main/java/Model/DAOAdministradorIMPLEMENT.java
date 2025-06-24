/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.Database;
import DatabaseModels.Administrador;
import Interfaces.DAOAdministrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Fabrizio
 */
public class DAOAdministradorIMPLEMENT extends Database implements DAOAdministrador {

    @Override
    public Administrador buscarAdministradorPorDNI(String dni) throws Exception {

        Administrador admin = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            this.Conectar();
            String sql = "select * from Administrador where TRIM(DNI_Admin) = ?";
            st = this.Conexion.prepareStatement(sql);
            st.setString(1, dni.trim());
            
            rs = st.executeQuery();
            
            if (rs.next()) {
                admin = new Administrador();
                admin.setId((rs.getInt("ID_Admin")));
                admin.setNombre(rs.getString("Nombre_Admin"));
                admin.setCorreo(rs.getString("Correo_Admin"));
                admin.setDni(rs.getString("DNI_Admin"));
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                this.CerrarConexion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return admin;
    }
}
