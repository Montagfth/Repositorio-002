/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import DatabaseModels.Administrador;

/**
 *
 * @author Fabrizio
 */
public interface DAOAdministrador {
    public Administrador buscarAdministradorPorDNI (String dni) throws Exception;
}
