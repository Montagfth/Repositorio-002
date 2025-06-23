/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseModels;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author Fabrizio
 */
public class ReservaServTres {

    private int ID_ReservaServTres;
    private String DNI_Cliente;
    private String TipoVehiculo;          // TESLA / OTRO
    private String ServicioSolicitado;
    private String Observacion_Adicional;
    private Timestamp Fecha_ReservaServTres;
    private BigDecimal Precio;

    /* TESLA */
    private String NumeroMotor_Tesla;
    private String NumeroSerie_Tesla;
    private Integer Kilometraje_Tesla;

    /* OTRO */
    private String Marca_Otro;
    private String Modelo_Otro;
    private Integer Anio_Otro;
    private String Placa_Otro;
    private Integer Kilometraje_Otro;

    public int getID_ReservaServTres() {
        return ID_ReservaServTres;
    }

    public void setID_ReservaServTres(int ID_ReservaServTres) {
        this.ID_ReservaServTres = ID_ReservaServTres;
    }

    public String getDNI_Cliente() {
        return DNI_Cliente;
    }

    public void setDNI_Cliente(String DNI_Cliente) {
        this.DNI_Cliente = DNI_Cliente;
    }

    public String getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(String TipoVehiculo) {
        this.TipoVehiculo = TipoVehiculo;
    }

    public String getServicioSolicitado() {
        return ServicioSolicitado;
    }

    public void setServicioSolicitado(String ServicioSolicitado) {
        this.ServicioSolicitado = ServicioSolicitado;
    }

    public String getObservacion_Adicional() {
        return Observacion_Adicional;
    }

    public void setObservacion_Adicional(String Observacion_Adicional) {
        this.Observacion_Adicional = Observacion_Adicional;
    }

    public Timestamp getFecha_ReservaServTres() {
        return Fecha_ReservaServTres;
    }

    public void setFecha_ReservaServTres(Timestamp Fecha_ReservaServTres) {
        this.Fecha_ReservaServTres = Fecha_ReservaServTres;
    }

    public BigDecimal getPrecio() {
        return Precio;
    }

    public void setPrecio(BigDecimal Precio) {
        this.Precio = Precio;
    }

    public String getNumeroMotor_Tesla() {
        return NumeroMotor_Tesla;
    }

    public void setNumeroMotor_Tesla(String NumeroMotor_Tesla) {
        this.NumeroMotor_Tesla = NumeroMotor_Tesla;
    }

    public String getNumeroSerie_Tesla() {
        return NumeroSerie_Tesla;
    }

    public void setNumeroSerie_Tesla(String NumeroSerie_Tesla) {
        this.NumeroSerie_Tesla = NumeroSerie_Tesla;
    }

    public Integer getKilometraje_Tesla() {
        return Kilometraje_Tesla;
    }

    public void setKilometraje_Tesla(Integer Kilometraje_Tesla) {
        this.Kilometraje_Tesla = Kilometraje_Tesla;
    }

    public String getMarca_Otro() {
        return Marca_Otro;
    }

    public void setMarca_Otro(String Marca_Otro) {
        this.Marca_Otro = Marca_Otro;
    }

    public String getModelo_Otro() {
        return Modelo_Otro;
    }

    public void setModelo_Otro(String Modelo_Otro) {
        this.Modelo_Otro = Modelo_Otro;
    }

    public Integer getAnio_Otro() {
        return Anio_Otro;
    }

    public void setAnio_Otro(Integer Anio_Otro) {
        this.Anio_Otro = Anio_Otro;
    }

    public String getPlaca_Otro() {
        return Placa_Otro;
    }

    public void setPlaca_Otro(String Placa_Otro) {
        this.Placa_Otro = Placa_Otro;
    }

    public Integer getKilometraje_Otro() {
        return Kilometraje_Otro;
    }

    public void setKilometraje_Otro(Integer Kilometraje_Otro) {
        this.Kilometraje_Otro = Kilometraje_Otro;
    }

}
