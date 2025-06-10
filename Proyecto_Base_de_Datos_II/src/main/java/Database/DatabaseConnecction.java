/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabrizio
 */
public class DatabaseConnecction {

    protected Connection Conexion;
    //NOTA: Buscar el JDBC correspondiente para su implementacion en el campo:
    private final String ConexionJDBCDriver = "(CAMBIAR AQUI)"; //com.mysql.jdbc.Driver
    private final String ConexionURL = "(CAMBIAR AQUI)"; // jdbc:mysql://localhost:3306/basededatosiiproyecto

    private final String Usuario = "root";
    private final String Contraseña = "123456";

    public void Conectar() throws ClassNotFoundException {
        
        try {

            Conexion = DriverManager.getConnection(ConexionURL, Usuario, Contraseña);

            Class.forName(ConexionJDBCDriver);

        } catch (SQLException sqlex) {
            Logger.getLogger(DatabaseConnecction.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    public void CerrarConexion() throws SQLException {
        if (Conexion != null) {
            if (!Conexion.isClosed()) {
                Conexion.close();
            }
        }
    }
}
