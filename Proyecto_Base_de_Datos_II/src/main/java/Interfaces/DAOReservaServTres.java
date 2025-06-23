/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import DatabaseModels.ReservaServTres;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public interface DAOReservaServTres {
    
    //Accionamiento con el boton
    public void registrar(ReservaServTres r) throws Exception;
    
    //Listado de reporte de registro de citas:
    List<ReservaServTres> listarReservaServTres() throws Exception;
}
