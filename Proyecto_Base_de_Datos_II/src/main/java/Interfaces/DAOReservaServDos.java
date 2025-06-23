/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import DatabaseModels.ReservaServDos;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public interface DAOReservaServDos {
    
    //Asociacion de registro de operacion: Servicio 2 (Boton SOLICITAR)
    public void registrar(ReservaServDos rsd) throws Exception;
    
    //Listado de operaciones para el administrador:
    List<ReservaServDos> listarReservasServDos() throws Exception;
}
