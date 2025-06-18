/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import DatabaseModels.Auto;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public interface DAOAutos {
    
    //Para el listado de los autos
    public List<Auto> Listar(String marca) throws Exception;
    
    //Filtrado dinamico de autos:
    public List<Auto> listarFiltrado (String anio, String modelo, String rangoPrecio) throws Exception;
}
