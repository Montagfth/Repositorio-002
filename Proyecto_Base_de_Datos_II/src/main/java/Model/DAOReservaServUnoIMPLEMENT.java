/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.Database;
import DatabaseModels.ReservaServUno;
import Interfaces.DAOReservaServUno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public class DAOReservaServUnoIMPLEMENT extends Database implements DAOReservaServUno {

    @Override
    public void registrar(ReservaServUno rsu) throws Exception {
        try {
            this.Conectar();
            String sql = "insert into ReservaServUno(ID_Auto) values (?)";
            PreparedStatement st = this.Conexion.prepareStatement(sql);
            st.setInt(1, rsu.getID_Auto());
            st.executeUpdate();
            st.close();
            
            System.out.println("Se ha registrado correctamente la operacion.");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.CerrarConexion();
        }
    }

    @Override
    public List<ReservaServUno> listarReservaServUno() throws Exception {
        
        List<ReservaServUno> listaReservaServUno = new ArrayList<>();
        
        try {
            this.Conectar();
            PreparedStatement st = this.Conexion.prepareStatement("select * from ReservaServUno");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                ReservaServUno rsu = new ReservaServUno();
                rsu.setID_ReservaServUno(rs.getInt("ID_ReservaServUno"));
                rsu.setID_Auto(rs.getInt("ID_Auto"));
                rsu.setEstado_ReservaServUno(rs.getString("Estado_ReservaServUno"));
                rsu.setFecha_ReservaServUno(rs.getTimestamp("Fecha_ReservaServUno"));
                
                listaReservaServUno.add(rsu);
            }
           
            rs.close();
            st.close();
                    
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.CerrarConexion();
        }
        return listaReservaServUno;
    }
}
