/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.Database;
import DatabaseModels.ReservaServTres;
import Interfaces.DAOReservaServTres;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public class DAOReservaServTresIMPLEMENT extends Database implements DAOReservaServTres {

    @Override
    public void registrar(ReservaServTres r) throws Exception {

        PreparedStatement ps = null;

        try {
            this.Conectar();
            String sql = "insert into ReservaServTres(DNI_Cliente,TipoVehiculo,ServicioSolicitado,Observacion_Adicional,Precio,NumeroMotor_Tesla,NumeroSerie_Tesla,Kilometraje_Tesla,Marca_Otro,Modelo_Otro,Anio,Otro,Placa_Otro,Kilometraje_Otro) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = this.Conexion.prepareStatement(sql);

            ps.setString(1, r.getDNI_Cliente());
            ps.setString(2, r.getTipoVehiculo());
            ps.setString(3, r.getServicioSolicitado());
            ps.setString(4, r.getObservacion_Adicional());
            ps.setBigDecimal(5, r.getPrecio());

            /*─ Tesla ─*/
            ps.setString(6, r.getNumeroMotor_Tesla());
            ps.setString(7, r.getNumeroSerie_Tesla());
            ps.setObject(8, r.getKilometraje_Tesla());

            /*─ Otros ─*/
            ps.setString(9, r.getMarca_Otro());
            ps.setString(10, r.getModelo_Otro());
            ps.setObject(11, r.getAnio_Otro());
            ps.setString(12, r.getPlaca_Otro());
            ps.setObject(13, r.getKilometraje_Otro());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {
                /* log opcional */ }
            try {
                this.CerrarConexion();
            } catch (Exception ex) {
                /* log opcional */ }
        }
    }

    @Override
    public List<ReservaServTres> listarReservaServTres() throws Exception {

        List<ReservaServTres> listaReservServTres = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            this.Conectar();

            String sql = "select * from ReservaServTres";
            ps = this.Conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ReservaServTres r = new ReservaServTres();
                r.setID_ReservaServTres(rs.getInt("ID_ReservaServTres"));
                r.setDNI_Cliente(rs.getString("DNI_Cliente"));
                r.setTipoVehiculo(rs.getString("TipoVehiculo"));
                r.setServicioSolicitado(rs.getString("ServicioSolicitado"));
                r.setObservacion_Adicional(rs.getString("Observacion_Adicional"));
                r.setFecha_ReservaServTres(rs.getTimestamp("Fecha_ReservaServTres"));
                r.setPrecio(rs.getBigDecimal("Precio"));

                r.setNumeroMotor_Tesla(rs.getString("NumeroMotor_Tesla"));
                r.setNumeroSerie_Tesla(rs.getString("NumeroSerie_Tesla"));
                r.setKilometraje_Tesla(rs.getObject("Kilometraje_Tesla") != null ? rs.getInt("Kilometraje_Tesla") : null);

                r.setMarca_Otro(rs.getString("Marca_Otro"));
                r.setModelo_Otro(rs.getString("Modelo_Otro"));
                r.setAnio_Otro(rs.getObject("Anio_Otro") != null ? rs.getInt("Anio_Otro") : null);
                r.setPlaca_Otro(rs.getString("Placa_Otro"));
                r.setKilometraje_Otro(rs.getObject("Kilometraje_Otro") != null ? rs.getInt("Kilometraje_Otro") : null);

                listaReservServTres.add(r);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.CerrarConexion();
        }

        return listaReservServTres;
    }
}
