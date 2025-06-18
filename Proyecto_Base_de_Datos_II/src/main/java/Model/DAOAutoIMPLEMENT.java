/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DatabaseModels.Auto;
import Interfaces.DAOAutos;
import java.util.List;
import Database.Database;
import DatabaseModels.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fabrizio
 */
public class DAOAutoIMPLEMENT extends Database implements DAOAutos {

    @Override
    public List<Auto> Listar(String marca) throws Exception {

        List<Auto> listarAutos = null;

        try {
            this.Conectar();
            String Query = marca.isEmpty() ? "select * from Auto" : "select * from Auto where nombre like '%" + marca + "%';";
            PreparedStatement st = this.Conexion.prepareStatement(Query);
            listarAutos = new ArrayList();
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Auto autos = new Auto();

                autos.setID_Auto(rs.getInt("ID_Auto"));
                autos.setMarca_Auto(rs.getString("Marca_Auto"));
                autos.setModelo_Auto(rs.getString("Modelo_Auto"));
                autos.setAnio_Auto(rs.getString("Anio_Auto"));
                autos.setPrecio_Auto(rs.getInt("Precio_Auto"));
                
                listarAutos.add(autos);
            }
            rs.close();
            st.close();
            
        } catch (Exception e) {
            System.out.println("Error al listar autos: " + e.getMessage());
        }
        return listarAutos;
    }

    @Override
    public List<Auto> listarFiltrado(String anio, String modelo, String rangoPrecio) throws Exception {
        
        List<Auto> lista = new ArrayList<>();
        
        List<String> condiciones = new ArrayList<>();
        
        if (anio != null && !anio.isBlank()) condiciones.add("Anio_Auto = ?");
        if (modelo != null && !modelo.isBlank()) condiciones.add("Modelo_Auto like ?");
        if (rangoPrecio != null && !rangoPrecio.isBlank()) {
            switch (rangoPrecio) {
                case "MENOS DE 15,000", "MENOS DE 15000" -> condiciones.add("Precio_Auto < 15000");
                case "15,000 - 25,000", "15000 - 25000" -> condiciones.add("Precio_Auto between 15000 and 25000");
                case "MAS DE 25,000", "MAS DE 25000" -> condiciones.add("Precio_Auto > 25000");
                
            }
        }
        
        String sql = "select * from Auto" + (condiciones.isEmpty() ? "" : " where " + String.join(" and ", condiciones));
        
        try {
            this.Conectar();
            PreparedStatement st = this.Conexion.prepareStatement(sql);
            
            int idx = 1;
            
            if (anio != null && !anio.isBlank()) st.setString(idx++, anio);
            if (modelo != null && !modelo.isBlank()) st.setString(idx++, "%" + modelo + "%");
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                Auto a = new Auto();
                
                a.setID_Auto(rs.getInt("ID_Auto"));
                a.setMarca_Auto(rs.getString("Marca_Auto"));
                a.setModelo_Auto(rs.getString("Modelo_Auto"));
                a.setAnio_Auto(rs.getString("Anio_Auto"));
                a.setPrecio_Auto(rs.getInt("Precio_Auto"));
                lista.add(a);
            }
                
            rs.close();
            st.close();
            this.CerrarConexion();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        /*
        String anio = CbxAnioVehiculo.getSelectedItem().toString();
        String modelo = CbxModeloVehiculo.getSelectedItem().toString();
        String precio = CbxPrecioVehiculo.getSelectedItem().toString();
        
        List<String> condiciones = new ArrayList<>();
        
        if(!anio.equals("TODOS")) {
            condiciones.add("Anio_Auto = ?");
        }
        
        if (!modelo.equals("TODOS")) {
            condiciones.add("Modelo_Auto llke ?");
        }
        
        if (!precio.equals("TODOS")) {
            switch (precio) {
                case "MENOS DE 15,000":
                    condiciones.add("Precio_Auto < 15,000");
                    break;
                    
                case "15,000 - 25,000":
                    condiciones.add("Precio_Auto between 15,000 and 25,000");
                    break;
                    
                case "MAS DE 25,000":
                    condiciones.add("Precio_Auto > 25,000");
                default:
                    throw new AssertionError();
            }
        }
        
        String sql = "select * from Auto;";
        
        if (!condiciones.isEmpty()) {
            sql += " where " + String.join(" and ", condiciones);
        }
        
        try {
            this.Conectar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        */
  
        return lista;
    }
}
