/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.*;
import DatabaseModels.Autopartes;
import Model.*;
import Interfaces.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public class DAOAutopartesIMPLEMENT extends Database implements DAOAutopartes {

    @Override
    public List<Autopartes> Listar(String categoria) throws Exception {

        List<Autopartes> listaAutopartes = null;

        try {
            this.Conectar();
            String Query = categoria.isEmpty() ? "select * from Autopartes" : "select * from Autopartes where Categoria_Autoparte like '%" + categoria + "%';"; //Por evaluar la consulta, aplica mejoras
            PreparedStatement st = this.Conexion.prepareStatement(Query);
            listaAutopartes = new ArrayList();
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Autopartes autopartes = new Autopartes();

                autopartes.setID_Autoparte(rs.getInt("ID_Autoparte"));
                autopartes.setNombre_Autoparte(rs.getString("Nombre_Autoparte"));
                autopartes.setCategoria_Autoparte(rs.getString("Categoria_Autoparte"));
                autopartes.setStock_Autoparte(rs.getInt("Stock_Autoparte"));
                autopartes.setPrecio_Autoparte(rs.getInt("Precio_Autoparte"));

                listaAutopartes.add(autopartes);
            }

            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.CerrarConexion();
        }
        return listaAutopartes;
    }
}
