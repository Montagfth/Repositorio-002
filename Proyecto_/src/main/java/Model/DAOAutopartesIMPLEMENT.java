package Model;

import Database.*;
import DatabaseModels.Autopartes;
import Interfaces.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOAutopartesIMPLEMENT extends Database implements DAOAutopartes {

@Override
public List<Autopartes> Listar(String categoria) throws Exception {
    List<Autopartes> listaAutopartes = new ArrayList<>();

    try {
        this.Conectar();
        String Query = categoria.isEmpty() 
            ? "SELECT * FROM Autopartes" 
            : "SELECT * FROM Autopartes WHERE Categoria_Autoparte LIKE ?";
        
        PreparedStatement st = this.Conexion.prepareStatement(Query);
        if (!categoria.isEmpty()) {
            st.setString(1, "%" + categoria + "%");
        }

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Autopartes autopartes = new Autopartes();
            autopartes.setID_Autoparte(rs.getInt("ID_Autoparte"));
            autopartes.setNombre_Autoparte(rs.getString("Nombre_Autoparte"));
            autopartes.setCategoria_Autoparte(rs.getString("Categoria_Autoparte"));
            autopartes.setStock_Autoparte(rs.getInt("Stock_Autoparte"));
            autopartes.setPrecio_Autoparte(rs.getInt("Precio_Autoparte"));
            autopartes.setImagen_Autoparte(rs.getBytes("Imagen_Autoparte"));

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