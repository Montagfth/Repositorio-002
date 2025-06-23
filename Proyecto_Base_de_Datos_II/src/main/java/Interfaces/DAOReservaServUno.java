/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import DatabaseModels.ReservaServUno;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public interface DAOReservaServUno {
    
    //Registro de operacion con el boton "Hacer una reserva" 
    public void registrar(ReservaServUno rsu) throws Exception;
    
    //Listado de las operaciones en el panel:
    List<ReservaServUno> listarReservaServUno() throws Exception;
    
}
